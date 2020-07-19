package com.jiading.service;

import com.jiading.domain.Block;
import java.util.List;

public interface BlockService {
    public List<Block> findAll();
    public Block findByBid(int bid);
    public Block findByName(String name);
}
