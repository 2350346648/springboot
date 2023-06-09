package com.it.controller;

import com.it.pojo.News;
import com.it.pojo.Result;
import com.it.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsController {
    @Autowired
    private NewsService newsService;
    @RequestMapping("sendNews")
    public Result sendNews(News news){
        newsService.sendNews(news);
        return  Result.success();
    }
    @RequestMapping("findNewsByUid")
    public Result findNewsByUid(News news){

        return  Result.success(newsService.findAllNewsByUid(news));
    }

}
