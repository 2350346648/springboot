package com.it.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.mapper.AnswerMapper;
import com.it.pojo.Answer;
import com.it.pojo.Good;
import com.it.pojo.Likes;
import com.it.pojo.Que;
import com.it.service.AnswerService;
import com.it.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AnswerServiceImpl extends ServiceImpl<AnswerMapper,Answer> implements AnswerService {

    @Autowired
    private AnswerMapper answerMapper;
    @Autowired
    private GoodService goodService;




    /**
     *
     * 点赞
     * @param good
     * @return
     */
    @Override
    public int good(Good good) {
        LambdaQueryWrapper<Good> wrapper = new LambdaQueryWrapper();
        wrapper.eq(Good::getAid,good.getAid()).eq(Good::getUid,good.getUid());
        Good one = goodService.getOne(wrapper);
        if(one==null){
            goodService.save(good);
            LambdaQueryWrapper<Answer> goodLambdaQueryWrapper = new LambdaQueryWrapper<>();
            goodLambdaQueryWrapper.eq(Answer::getId,good.getAid());
            Answer a = this.getOne(goodLambdaQueryWrapper);
            a.setGood(a.getGood()+1);
            this.updateById(a);
            return 1;
        }
        else {
            goodService.remove(wrapper);
            LambdaQueryWrapper<Answer> goodLambdaQueryWrapper = new LambdaQueryWrapper<>();
            goodLambdaQueryWrapper.eq(Answer::getId,good.getAid());
            Answer a = this.getOne(goodLambdaQueryWrapper);
            a.setGood(a.getGood()-1);
            this.updateById(a);
            return 0;
        }

    }



}
