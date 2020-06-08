package com.example.demo.controller;

import com.example.demo.pojo.Context;
import com.example.demo.service.ContextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ContextController {
    @Autowired
    private ContextService contextService;
    @GetMapping("/parse/{keyword}")
    public String parse(@PathVariable("keyword") String keyword)throws Exception{
       return   contextService.parseContext(keyword).toString();

    }
    @GetMapping("/search/{keyword}/{pageNo}/{pageSize}")
    public List<Map<String,Object>> search(@PathVariable("keyword") String keyword,
                                           @PathVariable("pageNo")int pageNo,
                                           @PathVariable("pageSize")int pageSize)throws  Exception{

           return    contextService.searchPageHighLightBuilder(keyword,pageNo,pageSize);
    }
}
