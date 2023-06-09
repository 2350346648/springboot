package com.it.service.impl;

import com.it.mapper.NewsMapper;
import com.it.pojo.News;
import com.it.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsMapper newsMapper;
    @Override
    public void sendNews(News news) {
        news.setTime(LocalDateTime.now());
        newsMapper.sendNews(news);
    }

    @Override
    public List<News> findAllNewsByUid(News news) {

        return newsMapper.findAllNewsByUid(news.getUid());
    }
}
