package com.jiading.dao;


import com.jiading.model.Post;
import com.jiading.model.Reply;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostDao {

    @Select("select count(*) from posts where bid=#{bid} and title like #{title}")
    int findTotalCountByTitleKeyWordAndBlock(Post post);

    @Select("select * from posts where bid=#{bid} and title like #{title} limit #{start},#{pageSize}")
    List<Post> findByPageInSearch(@Param("bid")int bid, @Param("title")String title,@Param("start") int start, @Param("pageSize") int pageSize);

    @Select("select * from posts where bid=#{bid} limit #{start},#{pageSize}")
    List<Post> findByPageInBlockView(@Param("bid") int bid, @Param("start") int start, @Param("pageSize") int pageSize);

    @Select("select * from posts where pid=#{pid}")
    Post findOne(Post post);

    @Select("select * from posts where uid=#{uid}")
    List<Post> findAllByUid(@Param("uid") String uid);

    @Select("select * from posts where uid=#{uid} limit #{start},#{pageSize}")
    List<Post> findAllByUidInPages(@Param("uid") int uid, @Param("start") int start, @Param("pageSize") int pageSize);

    @Select("select count(*) from posts where uid=#{uid}")
    int countAllByUid(@Param("uid") int uid);

    @Select("select count(*) from posts where bid=#{bid}")
    int findTotalCountByBlock(@Param("bid") int bid);


    @Insert("insert into posts(`UID`,`BID`, `TITLE`, `ABSTRACT`, `CONTENT`, `TIME`,  `VIEW`, `LIKED`)values(#{uid},#{bid},#{title},#{abstract},#{content},#{time},0,0)")
    void writePost(@Param("uid") int uid, @Param("bid")Integer bid, @Param("title") String title, @Param("abstract") String summary, @Param("content") String content, @Param("time") String TimeNow);

    @Insert("insert into reply(`UID`, `PID`,`CONTENT`, `TIME`) values(#{uid},#{pid},#{text},#{time})")
    void writeComment(@Param("uid") int uid, @Param("pid") int pid, @Param("text") String text, @Param("time") String time);

    @Select("select * from reply where pid=#{pid} order by time")
    List<Reply> allCommentsInThisPost(@Param("pid") Integer pid);

    @Update("update posts set view=view+1 where pid=#{pid}")
    void viewAddOne(@Param("pid") Integer pid);

    @Update("update posts set liked=liked-1 where pid=#{pid}")
    void likedSubOne(@Param("pid") Integer pid);

    @Update("update posts set liked=liked+1 where pid=#{pid}")
    void likedAddOne(@Param("pid") Integer pid);

    @Select("select * from posts order by posts.`liked` desc limit 0,#{n}")
    List<Post> nMostPopularPosts(@Param("n")Integer n);

}
