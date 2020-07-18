package com.jiading.dao;


import com.jiading.domain.Block;
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
}
