package com.it.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.mapper.LikesMapper;
import com.it.mapper.QueMapper;
import com.it.pojo.Likes;
import com.it.pojo.Que;
import com.it.service.LikesServive;
import com.it.service.QueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class QueServiceImpl extends ServiceImpl<QueMapper,Que> implements QueService {
    @Autowired
    private LikesServive likesService;


    /**
     *
     * 收藏
     * @param likes
     * @return
     */
    @Override
    public int likes(Likes likes) {
        //查询是否已经收藏
        LambdaQueryWrapper<Likes> wrapper = new LambdaQueryWrapper();
        wrapper.eq(Likes::getUid,likes.getUid()).eq(Likes::getQid,likes.getQid());
        Likes one = likesService.getOne(wrapper);

        if (one==null){
            likesService.save(likes);
            LambdaQueryWrapper<Que> likesLambdaQueryWrapper = new LambdaQueryWrapper<>();
            likesLambdaQueryWrapper.eq(Que::getId,likes.getQid());
            Que que = this.getOne(likesLambdaQueryWrapper);
            que.setLikes(que.getLikes()+1);
            this.updateById(que);
            return 1;
        }
        else {
            likesService.remove(wrapper);
            LambdaQueryWrapper<Que> likesLambdaQueryWrapper = new LambdaQueryWrapper<>();
            likesLambdaQueryWrapper.eq(Que::getId,likes.getQid());
            Que que = this.getOne(likesLambdaQueryWrapper);
            que.setLikes(que.getLikes()-1);
            this.updateById(que);
            return 0;
        }

    }
}
