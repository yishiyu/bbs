package com.jiading.dao;

import com.jiading.domain.Post;
import com.jiading.domain.Reply;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostDao {
    @Select("select count(*) from posts where bid=#{bid} and title like %#{title}%")
    int findTotalCountByTitleKeyWordAndBlock(Post post);

    @Select("select * from posts where bid=#{bid} and title like %#{title}% limit #{start},#{pageSize}")
    List<Post> findByPageInSearch(Post post, @Param("start") int start, @Param("pageSize") int pageSize);

    @Select("select * from posts where bid=#{bid}  limit #{start},#{pageSize}")
    List<Post> findByPageInBlockView(@Param("bid") int bid, @Param("start") int start, @Param("pageSize") int pageSize);

    @Select("select * from posts where pid=#{pid}")
    Post findOne(Post post);

    @Select("select * from posts where uid=#{uid}")
    List<Post> findAllByUid(@Param("uid") String uid);

    @Select("select * from posts where uid=#{uid}  limit #{start},#{pageSize}")
    List<Post> findAllByUidInPages(@Param("uid") int uid, @Param("start") int start, @Param("pageSize") int pageSize);

    @Select("select count(*) from posts where uid=#{uid}")
    int countAllByUid(@Param("uid") int uid);

    @Select("select count(*) from posts where bid=#{bid}")
    int findTotalCountByBlock(@Param("bid") int bid);

    /**
     * @Description: 默认show设置为1，也就是显示该文章，已在sql中设置
     * @Param: [uid, bid, title, summary, content, stringTimeNow]
     * @return: void
     * @Author: JiaDing
     * @Date: 2020/7/19
     */
    @Insert("insert into posts('UID','BID','TITLE','ABSTRACT','CONTENT','TIME','VIEW')values(#{uid},#{bid},#{title},#{abstract},#{content},#{time},0)")
    void writePost(@Param("uid") int uid, @Param("bid") Integer bid, @Param("title") String title, @Param("summary") String summary, @Param("content") String content, @Param("time") String TimeNow);

    @Insert("insert into reply('UID','PID','CONTENT','TIME') values(#{uid},#{pid},#{text},#{time})")
    void writeComment(@Param("uid") int uid, @Param("pid") int pid, @Param("text") String text, @Param("time") String time);

    @Select("select * from reply where pid=#{pid} order by time")
    List<Reply> allCommentsInThisPost(@Param("pid") String pid);

    @Update("update posts set view=view+1 where pid=#{pid}")
    void viewAddOne(@Param("pid") String pid);

    @Update("update posts set liked=liked-1 where pid=#{pid}")
    void likedSubOne(@Param("pid") String pid);

    @Update("update posts set liked=liked+1 where pid=#{pid}")
    void likedAddOne(@Param("pid") String pid);
}
