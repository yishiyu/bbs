package com.jiading.dao;


import com.jiading.model.Block;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: 查询论坛版块
 * @Param:
 * @return:
 * @Author: JiaDing
 * @Date: 2020/7/16
 */
@Repository
public interface BlockDao {
    @Select("select * from blocks")
    public List<Block> findAll();

    @Select("select * from blocks where bid=#{bid}")
    public Block findByBid(@Param("int") int bid);

    @Select("select * from blocks where blockname=#{name}")
    public Block findByName(@Param("name") String name);
}
