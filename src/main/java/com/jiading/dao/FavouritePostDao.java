package com.jiading.dao;



import com.jiading.domain.FavoritePost;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface FavouritePostDao {
    @Select("select * from FAVORITE_RID where and uid=#{uid}")
    public FavoritePost findByRidAndUid(@Param("uid") Integer uid);

    @Select("select count(*) from FAVORITE_RID where uid=#{uid}")
    public int findCount(@Param("uid") Integer uid);

    @Update("insert into FAVORITE_RID values(#{uid},#{rid},#{date})")
    void add(@Param("uid") Integer uid,@Param("rid") Integer rid, @Param("date") String date);
}
