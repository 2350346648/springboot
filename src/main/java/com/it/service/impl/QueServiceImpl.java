package com.it.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.mapper.LikesMapper;
import com.it.mapper.QueMapper;
import com.it.pojo.Likes;
import com.it.pojo.Que;
import com.it.service.QueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class QueServiceImpl extends ServiceImpl<QueMapper,Que> implements QueService {
    @Autowired
    private LikesMapper likesMapper;
    @Autowired
    private QueMapper queMapper;
    @Override
    public void likes(Likes likes) {
        LambdaQueryWrapper<Likes> wrapper = new LambdaQueryWrapper();
        wrapper.eq(Likes::getUid,likes.getUid()).eq(Likes::getQid,likes.getQid());

        LambdaQueryWrapper<Que> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Que::getQid,likes.getQid());
        Que oneQue = queMapper.selectOne(queryWrapper);
        Likes one = likesMapper.selectOne(wrapper);
        if (one==null){
            likesMapper.insert(likes);
            oneQue.setLikes(oneQue.getLikes()+1);
            queMapper.update(oneQue,queryWrapper);
            return;
        }
        else {
            likesMapper.delete(wrapper);
            oneQue.setLikes(oneQue.getLikes()-1);
            queMapper.update(oneQue,queryWrapper);
        }
    }
}
