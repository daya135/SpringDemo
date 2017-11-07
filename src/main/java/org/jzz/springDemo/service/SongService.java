package org.jzz.springDemo.service;
import java.util.List;

import org.jzz.springDemo.dao.SongMapper;
import org.jzz.springDemo.domain.Song;
import org.jzz.springDemo.domain.SongExample;
import org.jzz.webUtils.LocalFile;
import org.jzz.webUtils.MP3Analysis;
import org.jzz.webUtils.XiamiCatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.jzz.springDemo.domain.Song;

//@Service("UserService")
//不指定名称默认为类名的小写开头作为id!!!
@Service
public class SongService implements ISongService{

	@Autowired
	private SongMapper songMapper;
	@Autowired
	private LocalFile fileCompare;
	@Autowired
	private XiamiCatch xiamiCatch;

	
	public SongService() {
		//this.fileCompare = new FileCompare(new MP3Analysis());
	}
	
	public void addSong(Song song) {
		
		if (songMapper.insert(song) > 0) {
			System.out.println("addSong [" + song.getTitle() + "] success!");
		}
	}
	
	
	public void initLocalSongs(String dirName) {
		String downSite = "";
		/* 根据本地目录名判断下载渠道 */
		if (dirName.contains("虾米") || dirName.contains("xiami")) {
			downSite = "虾米下载";
		} else if(dirName.contains("网易") || dirName.contains("wangyi")){
			downSite = "网易下载";	
		} else {
			downSite = "补漏";
		}
		System.out.println("解析目录[" + dirName +  "] downSite = " + downSite);
		
		List<Song> songs = fileCompare.readLocalMP3(dirName);
		for (Song song:songs) {
			song.setDownsite(downSite);
			song.setIsdownload("1");
			songMapper.insert(song);
		}
	}
	
	public void xiamiSynchronize() {
		SongExample example = new SongExample();
		List<Song> songDBList = songMapper.selectByExample(example);
		List<Song> songXiamiList= xiamiCatch.postForm();
		
		System.out.println("虾米收藏数: " + songXiamiList.size() + "  数据库条目: " + songDBList.size() + " 开始同步...");
		int processFlag = 0;
		for (Song songXiami : songXiamiList) {
			System.out.println("处理歌曲 [" + songXiami.getTitle() + "]");
			//是否已经为当前歌曲更改数据库标志, 1代表已经插入或更新, 0代表未进行插入或更新
			processFlag = 0;
			for (Song songDB : songDBList) {
				if (songXiami.getTitle().equals(songDB.getTitle())) {
					System.out.print("匹配 [" + songDB.getTitle() + "]");
					/* 匹配艺术家, 虾米网页显示的不全, 歌曲文件的艺术家列表包含网页艺术家,则认为是同一个艺术家 */
					if (songDB.getArtist().contains(songXiami.getArtist())) {
						//本地存在, 更新上架信息
						System.out.println(" 成功!!更新下架信息");
						songDB.setOnsale(songXiami.getOnsale());
						songMapper.updateByPrimaryKey(songDB);
						processFlag = 1;
						break;
					} else {
						System.out.println(" 失败,艺术家不同 ["+ songXiami.getArtist() + "]  [" + songDB.getArtist() + "]");
						songXiami.setIsdownload("0");
						songXiami.setDownsite("xiami");
						songMapper.insert(songXiami);
					}
				}
			}
			if (processFlag == 0) {
				//艺术家不同,入库
				System.out.println("未找到相同歌名!!入库 ");
				songXiami.setIsdownload("0");
				songXiami.setDownsite("xiami");
				songMapper.insert(songXiami);
			}
		}
		
	}
}
