package org.jzz.springDemo.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.jzz.springDemo.domain.Song;
import org.jzz.springDemo.domain.SongExample;

public interface SongMapper {
    int countByExample(SongExample example);

    int deleteByExample(SongExample example);

    int deleteByPrimaryKey(Integer songid);

    int insert(Song record);

    int insertSelective(Song record);

    List<Song> selectByExample(SongExample example);

    Song selectByPrimaryKey(Integer songid);

    int updateByExampleSelective(@Param("record") Song record, @Param("example") SongExample example);

    int updateByExample(@Param("record") Song record, @Param("example") SongExample example);

    int updateByPrimaryKeySelective(Song record);

    int updateByPrimaryKey(Song record);
}