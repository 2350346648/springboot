package com.it.service;

import com.it.pojo.News;

import java.util.List;

public interface NewsService {
    public void sendNews(News news);
    public List<News> findAllNewsByUid(News news);

}
