package com.it.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.it.pojo.Likes;
import com.it.pojo.Que;

import java.util.List;

public interface QueService extends IService<Que> {
    public int likes(Likes likes);
}

