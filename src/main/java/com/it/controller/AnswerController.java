package com.it.controller;

import com.it.pojo.Answer;
import com.it.pojo.Result;
import com.it.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 */
@RestController
public class AnswerController {

    @Autowired
    public AnswerService answerService;

    @RequestMapping("findAnswerByQid")
    public Result findAnswerByQid(Answer answer){
        System.out.println(answer.getQid());
        List<Answer> answerByQid = answerService.findAnswerByQid(answer.getQid());
        System.out.println(answerByQid);

        return Result.success(answerByQid);
    }
    @RequestMapping("addAnswer")
    public Result addAnswer(Answer answer){
        answerService.addAnswer(answer);
        return Result.success();
    }
}
