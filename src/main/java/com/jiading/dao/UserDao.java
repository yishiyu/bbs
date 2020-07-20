package com.jiading.dao;


import com.jiading.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    @Select("select * from user where uid=#{uid}")
    public User findByUserId(@Param("uid") Integer uid);

    @Select("select * from user where username=#{user}")
    public User findByUsername(@Param("user") String username);

    @Insert("insert into user(username,password,head_portrait,admin_admin,email,status,code,comment)values(#{username},#{password},#{head_portrait},#{admin_admin},#{email},#{status},#{code},#{comment})")
    public void saveUser(User user);

    @Update("update set " +
            "username=#{username} " +
            "password=#{password} " +
            "head_portrait=#{head_portrait} " +
            "admin_admin=#{admin_admin} where uid=#{uid} " +
            "comment=#{comment};")
    public void updateUser(User user);

    @Select("select * from user where code=#{code}")
    User findByCode(@Param("code") String code);

    @Update("update user set status ='Y' where uid=#{uid}")
    void updateStatus(User user);

    @Select("select * from user where username=#{username} and password=#{password}")
    User findByUsernameAndPassword(User user);

    @Select("select * from user where code=#{code} and username=#{username}")
    User findByCodeAndUsername(@Param("code") String code, @Param("username") String username);
}
