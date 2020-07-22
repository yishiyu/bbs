package com.jiading.dao;


import com.jiading.model.Post;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FavouritePostDao {



    @Select("select * from posts where pid in (select pid from FAVORITE_PID where uid=#{uid}) limit #{currentPage},#{pageSize}")
    public List<Post> findByUidInPages(@Param("uid") Integer uid, @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    //查询该uid用户总共喜欢的人数
    @Select("select count(*) from FAVORITE_PID where uid=#{uid}")
    public int findTotalCountByUser(@Param("uid") Integer uid);

    /**
     * @Description: date的格式要求是yyyy-mm-dd hour:minute:second
     * @Param: [uid, rid, date]
     * @return: void
     * @Author: JiaDing
     * @Date: 2020/7/18
     */
    @Insert("insert into FAVORITE_PID(`UID`,`PID`,`TIME`) values (#{uid},#{pid},#{date})")
    void add(@Param("uid") Integer uid, @Param("pid") Integer pid, @Param("date") String date);

    @Select("select * from FAVORITE_PID where uid=#{uid} and pid=#{pid}")
    public Post findByPidAndUid(@Param("uid") int uid, @Param("pid") int pid);

    @Delete("delete from FAVORITE_PID where pid=#{pid} and uid=#{uid}")
    void cancelLike(@Param("pid") Integer pid, @Param("uid") int uid);

}
