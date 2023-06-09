package com.it.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.mapper.AnswerMapper;
import com.it.pojo.Answer;
import com.it.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AnswerServiceImpl extends ServiceImpl<AnswerMapper,Answer> implements AnswerService {

    @Autowired
    private AnswerMapper answerMapper;

    public List<Answer> findAnswerByQid(int qid){

        return answerMapper.findAnswerByQid(qid);
    }

    @Override
    public List<Answer> addAnswer(Answer answer) {
        answer.setTime(LocalDateTime.now());
        answerMapper.addAnswer(answer);
        return null;
    }
}
