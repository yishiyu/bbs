package com.jiading.dao;


import com.jiading.domain.FavoritePost;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FavouritePostDao {
    @Select("select * from FAVORITE_PID where uid=#{uid}")
    public List<FavoritePost> findByUid(@Param("uid") Integer uid);


    @Select("select count(*) from FAVORITE_PID where uid=#{uid}")
    public int findCount(@Param("uid") Integer uid);

    /**
     * @Description: date的格式要求是yyyy-mm-dd hour:minute:second
     * @Param: [uid, rid, date]
     * @return: void
     * @Author: JiaDing
     * @Date: 2020/7/18
     */
    @Update("insert into FAVORITE_PID('UID','PID','TIME') values(#{uid},#{pid},#{date})")
    void add(@Param("uid") Integer uid, @Param("pid") Integer pid, @Param("date") String date);

    @Select("select * from FAVORITE_PID where uid=#{uid} and pid=#{pid}")
    public FavoritePost findByPidAndUid(@Param("uid") int uid, @Param("pid") int pid);
}
