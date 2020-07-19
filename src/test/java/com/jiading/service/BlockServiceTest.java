package com.jiading.service;

import com.jiading.domain.Block;
import com.jiading.service.impl.BlockServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @program: bbs
 * @description: 测试BlockService
 * @author: JiaDing
 * @create: 2020-07-18 14:30
 **/
public class BlockServiceTest {
    @Autowired
    static BlockServiceImpl block;

    @Test
    public static void main(String[] args) {
        List<Block> all = block.findAll();
        Iterator<Block> iterator = all.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
