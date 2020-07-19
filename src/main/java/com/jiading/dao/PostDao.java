package com.jiading.dao;

import com.jiading.domain.Post;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PostDao {
    @Select("select count(*) from posts where bid=#{bid} and title like %#{title}%")
    int findTotalCount(Post post);
    @Select("select * from posts where bid=#{bid} and title like %#{title}% limit #{start},#{pageSize}")
    List<Post> findByPage(Post post, @Param("start")int start, @Param("pageSize")int pageSize);
    @Select("select * from posts where pid=#{pid}")
    Post findOne( Post post);
    @Select("select * from posts where uid=#{uid}")
    List<Post> findAllByUid(@Param("uid") String uid);
}
