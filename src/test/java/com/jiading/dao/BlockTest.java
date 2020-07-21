package com.jiading.dao;

import com.jiading.domain.Block;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: bbs
 * @description: BlockDao的测试类
 * @author: Yishiyu
 * @create: 2020-07-20 15:32
 **/
public class BlockTest extends BaseTest{

    @Autowired
    BlockDao blockDao;

    @Test
    public void testFindAll(){
        for (Block block : blockDao.findAll()) {
            System.out.println(block);
        }
    }

    @Test
    public void testFindByBid(){
        // 查找 bid == 1
        int bid = 1;
        System.out.println(
                blockDao.findByBid(bid)
        );
    }

    @Test
    public void testFindByName(){
        String blockName = "美食";
        System.out.println(
                blockDao.findByName(blockName)
        );
    }
}
