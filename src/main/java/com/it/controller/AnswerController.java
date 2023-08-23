package com.it.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.it.pojo.Answer;
import com.it.pojo.Good;
import com.it.pojo.Likes;
import com.it.pojo.Result;
import com.it.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnswerController {

    @Autowired
    public AnswerService answerService;

    /**
     * 查询问题详情的回答
     * @param answer
     * @return
     */
    @RequestMapping("findAnswer")
    public Result findAnswerByQid(Answer answer){
        LambdaQueryWrapper<Answer> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Answer::getQid,answer.getQid());
        List<Answer> list = answerService.list(wrapper);
        return Result.success(list);
    }

    /**
     * 发布回答
     * @param answer
     * @return
     */
    @RequestMapping("addAnswer")
    public Result addAnswer(Answer answer){
        answerService.save(answer);
        return Result.success();
    }
    /**
     * 点赞
     * @param good
     * @return
     */
    @RequestMapping("good")
    public Result good(Good good){
        int good1 = answerService.good(good);
        //1为增加，0为删除
        return Result.success(good1);
    }
}
