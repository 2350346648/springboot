package com.it.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.it.pojo.Answer;

import java.util.List;

public interface AnswerService extends IService<Answer> {
    public List<Answer> findAnswerByQid(int qid);
    public List<Answer> addAnswer(Answer answer);
}
