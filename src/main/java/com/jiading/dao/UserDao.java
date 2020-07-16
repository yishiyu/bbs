package com.jiading.dao;


import com.jiading.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    @Select("select * from tab_user where username=#{user}")
    public User findByUsername(User user);

    @Insert("insert into tab_user(username,password,name,birthday,sex,telephone,email,status,code)values(#{username},#{password},#{name},#{birthday},#{sex},#{telephone},#{email},#{status},#{code})")
    public void saveUser(User user);

    @Select("select * from tab_user where code=#{code}")
    User findByCode(@Param("code") String code);

    @Update("update tab_user set status ='Y' where uid=#{uid}")
    void updateStatus(User user);

    @Select("select * from tab_user where username=#{username} and password=#{password}")
    User findByUsernameAndPassword(User user);
}
