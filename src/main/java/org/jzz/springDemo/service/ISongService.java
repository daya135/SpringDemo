package org.jzz.springDemo.service;
import org.jzz.springDemo.domain.Song;
import org.springframework.stereotype.Service;;

@Service
public interface ISongService {
	
	public void addSong(Song song);
	
	/* 初始化 读取本地音乐列表写入数据库 */
	public void initLocalSongs(String dirName);
	
	/* 读取虾米列表,与本地同步  */
	public void xiamiSynchronize();
}
