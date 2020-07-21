package com.jiading.dao;


import com.jiading.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    @Select("select * from user where uid=#{uid}")
    public User findByUserId(@Param("uid") Integer uid);

    @Select("select * from user where username=#{username}")
    public User findByUsername(@Param("username") String username);

    @Insert("insert into user(`username`,`password`,`head_portrait`,`ADMIN_PERMISSION`,`email`,`status`,`code`,`comment`)values(#{username},#{password},#{head_portrait},#{admin_permission},#{email},#{status},#{code},#{comment})")
    public void saveUser(User user);

    @Update("update user set username=#{username},password=#{password},head_portrait=#{head_portrait},admin_permission=#{admin_permission},comment=#{comment} where uid=#{uid}")
    public void updateUser(User user);

    @Select("select * from user where code=#{code}")
    User findByCode(@Param("code") String code);

    @Update("update user set status ='Y' where uid=#{uid}")
    void updateStatus(User user);

    @Select("select * from user where username=#{username} and password=#{password}")
    User findByUsernameAndPassword(User user);

    @Select("select * from user where code=#{code} and username=#{username}")
    User findByCodeAndUsername(@Param("code") String code, @Param("username") String username);

    @Update("update user set myPostLikedTime=myPostLikedTime+1 where uid=(select uid from posts where pid=#{pid})")
    void likedPostAddOneToUserBean(@Param("pid") Integer pid);

    @Update("update user set myPostLikedTime=myPostLikedTime-1 where uid=(select uid from posts where pid=#{pid})")
    void likedPostSubOneToUserBean(@Param("pid")Integer pid);

    @Update("update user set likedTime=likedTime-1 where uid=#{uid}")
    void likedUserSubOneToUserBean(@Param("uid") Integer uid);

    @Update("update user set likedTime=likedTime+1 where uid=#{uid}")
    void likedUserAddOneToUserBean(@Param("uid") Integer uid);
}
