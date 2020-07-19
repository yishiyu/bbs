package com.jiading.controller;


import com.jiading.domain.Block;
import com.jiading.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/block")
public class BlockServlet extends BaseServlet {
    @Autowired
    BlockService service;
    List<Block> all;

    /**
     * 因为使用了springMVC框架，每个方法有自己的映射，所以不再需要之前的那种
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/findAll")
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {

        all = service.findAll();
        writeValue(all, response);
    }

    @RequestMapping("/findOne")
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String bid = request.getParameter("bid");
        int bidInt = Integer.parseInt(bid);
        writeValue(all.get(bidInt - 1), response);
    }

}
