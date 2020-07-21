package com.jiading.dao;


import com.jiading.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavouriteUserDao {
    @Select("select * from user where uid in (select LIKEDUID from FAVORITE_UID where uid=#{uid})")
    public List<User> findByUid(@Param("uid") Integer uid);

    @Select("select count(*) from FAVORITE_UID where uid=#{uid}")
    public int findCount(@Param("uid") Integer uid);

    @Update("insert into FAVORITE_UID('UID','LINKEDUID','TIME') values(#{uid},#{linkedUid},#{date})")
    void add(@Param("uid") Integer uid, @Param("date") String date, @Param("linkedUid") Integer linkedUid);

    @Delete("delete * from favourite_uid where uid=#{uid} and linkeduid=#{linkedUid}")
    void delete(@Param("uid") Integer uid , @Param("linkedUid") Integer linkedUid);

//    @Select("select * from FAVORITE_UID where uid=#{uid} and linkeduid=#{linkedUid}")
//    public User findByLinkedUidAndUid(@Param("uid") int uid, @Param("linkedUid") int likedUid);
}
