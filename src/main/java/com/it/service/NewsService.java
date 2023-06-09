package com.it.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.it.pojo.News;

import java.util.List;

public interface NewsService extends IService<News> {
    public void sendNews(News news);
    public List<News> findAllNewsByUid(News news);

}
