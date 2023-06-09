package com.it.service;

import com.it.pojo.Answer;

import java.util.List;

public interface AnswerService {
    public List<Answer> findAnswerByQid(int qid);
    public List<Answer> addAnswer(Answer answer);
}
