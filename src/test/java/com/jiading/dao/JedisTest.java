package com.jiading.dao;

import com.jiading.dao.impl.JedisClientSingle;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @program: bbs
 * @description: Jedis的测试类
 * @author: JiaDing
 * @create: 2020-07-21 17:21
 **/
public class JedisTest extends BaseTest{
    /*
    TODO
    远程服务器的redis有time-out错误
     */
    @Autowired
    JedisClient client;
    @Test
    public void testAdd(){
        client.set("name","jiading");
        System.out.println(client.get("name"));
    }
}
