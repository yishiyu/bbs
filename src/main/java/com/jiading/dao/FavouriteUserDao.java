package com.jiading.dao;


import com.jiading.domain.Favorite;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface FavouriteUserDao {
    @Select("select * from tab_favorite where rid=#{rid} and uid=#{uid}")
    public Favorite findByRidAndUid(@Param("uid") Integer uid, @Param("rid") Integer rid);

    @Select("select count(*) from tab_favorite where rid=#{rid}")
    public int findCount(@Param("rid") Integer rid);

    @Update("insert into tab_favorite values(#{rid},#{date},#{uid})")
    void add(@Param("rid") Integer rid, @Param("date") Date date, @Param("uid") Integer uid);
}
