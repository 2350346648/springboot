package com.it.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.it.pojo.Answer;
import com.it.pojo.Good;
import com.it.pojo.Likes;

import java.util.List;

public interface AnswerService extends IService<Answer> {

    public int good(Good good);
}
