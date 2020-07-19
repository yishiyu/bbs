package com.jiading.dao;


import com.jiading.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    @Select("select * from user where username=#{user}")
    public User findByUsername(@Param("user") String username);

    @Insert("insert into user(username,password,head_portrait,admin_admin,email,status,code)values(#{username},#{password},#{head_portrait},#{admin_admin},#{email},#{status},#{code})")
    public void saveUser(User user);

    @Select("select * from user where code=#{code}")
    User findByCode(@Param("code") String code);

    @Update("update user set status ='Y' where uid=#{uid}")
    void updateStatus(User user);

    @Select("select * from user where username=#{username} and password=#{password}")
    User findByUsernameAndPassword(User user);

    @Select("select * from user where code=#{code} and username=#{username}")
    User findByCodeAndUsername(@Param("code") String code, @Param("username") String username);
}
