package com.jiading.service;

import com.jiading.model.Block;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: bbs
 * @description: BlockService的测试类
 * @author: Yishiyu
 * @create: 2020-07-21 10:03
 **/
public class BlockServiceTest extends BaseTest {

    @Autowired
    BlockService blockService;

    @Test
    public void testFindAll(){
        List<Block> blocks = blockService.findAll();
        for (Block block : blocks) {
            System.out.println(block);
        }
    }

    @Test
    public void testFindByBid(){
        for (int bid = 0; bid < 3; bid++) {
            Block block = blockService.findByBid(bid);
            System.out.println(block);
        }
    }

    @Test
    public void testFindByName(){
        List<String> names = new ArrayList<>();
        names.add("美食");
        names.add("书籍");   // 成功查找
        names.add("妙妙妙"); // 失败查找

        for (String name : names) {
            System.out.println(name + ":" + blockService.findByName(name));
        }
    }
}
