package com.jiading.dao;

<<<<<<< HEAD
import com.jiading.model.Post;
import com.jiading.model.Reply;
=======
import com.jiading.domain.Post;
import com.jiading.domain.Reply;
import com.sun.xml.internal.bind.v2.TODO;
>>>>>>> origin/Laojieduo
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostDao {
<<<<<<< HEAD
    @Select("select count(*) from posts where bid=#{bid} and title like #{title}")
=======

    // TODO: 2020/7/20  select count(*) from posts where bid=1 and title like %'好吃的'%;
    // 注意百分号和引号位置
    // 下同理

    @Select("select count(*) from posts where bid=#{bid} and title like %#{title}%")
>>>>>>> origin/Laojieduo
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

<<<<<<< HEAD
    @Insert("insert into posts(`UID`, `PID`, `TITLE`, `ABSTRACT`, `CONTENT`, `TIME`,  `VIEW`, `LIKED`)values(#{uid},#{pid},#{title},#{abstract},#{content},#{time},0,0)")
    void writePost(@Param("uid") int uid, @Param("pid") Integer bid, @Param("title") String title, @Param("abstract") String summary, @Param("content") String content, @Param("time") String TimeNow);

    @Insert("insert into reply(`UID`, `PID`,`CONTENT`, `TIME`) values(#{uid},#{pid},#{text},#{time})")
=======
    /**
     * @Description: 默认show设置为1，也就是显示该文章，已在sql中设置
     * @Param: [uid, bid, title, summary, content, stringTimeNow]
     * @return: void
     * @Author: JiaDing
     * @Date: 2020/7/19
     */
    @Insert("insert into posts('UID','BID','TITLE','ABSTRACT','CONTENT','TIME','VIEW','LIKED')values(#{uid},#{bid},#{title},#{abstract},#{content},#{time},0,0)")
    void writePost(@Param("uid") int uid, @Param("bid") Integer bid, @Param("title") String title, @Param("summary") String summary, @Param("content") String content, @Param("time") String TimeNow);

    @Insert("insert into reply('UID','PID','CONTENT','TIME') values (#{uid},#{pid},#{text},#{time})")
>>>>>>> origin/Laojieduo
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
