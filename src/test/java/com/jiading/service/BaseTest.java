package com.jiading.service;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @program: bbs 测试类
 * @description: 测试类基类,其他测试类继承此基类即可获得Spring框架的支持
 * @author: Yishiyu
 * @create: 2020-07-20 09:00
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml","classpath:springmvc.xml"})
public class BaseTest {
}
