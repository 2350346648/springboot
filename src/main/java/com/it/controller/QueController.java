package com.it.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.it.pojo.Likes;
import com.it.pojo.Que;
import com.it.pojo.Result;
import com.it.pojo.User;
import com.it.service.LikesServive;
import com.it.service.QueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class QueController {

    @Autowired
    private QueService queService;
    @Autowired
    private LikesServive likesServive;

    /**
     * 查询所有问题
     * @return
     */
   @RequestMapping("findAllQue")
   public Result findAllQue(){
       List<Que> list = queService.list(null);
       return Result.success(list);
   }

    /**
     * 查询用户发布的问题
     * @param que
     * @return
     */
    @RequestMapping("findQueByUid")
    public Result findQueByUid(Que que){
        LambdaQueryWrapper<Que> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(Que::getUid,que.getUid());
        List<Que> list = queService.list(queryWrapper);
        return Result.success(list);
    }

    /**
     * 发布问题
     * @param que
     * @return
     */
   @RequestMapping("addQue")
   public Result add(Que que){
       queService.save(que);
       return Result.success();
   }

    /**
     * 点开问题详情时，回显问题信息
     * @param que
     * @return
     */
    @RequestMapping("findQueByQid")
    public Result findQueByQid(Que que){
        LambdaQueryWrapper<Que> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(Que::getQid,que.getQid());
        Que one = queService.getOne(queryWrapper);
        return Result.success(one);
    }

    /**
     * 搜索框搜索问题
     * @param que
     * @return
     */
    @RequestMapping("findQueByQue")
    public Result findQueByQue(String que){
        LambdaQueryWrapper<Que> wrapper = new LambdaQueryWrapper();
        wrapper.like(Que::getQue,que);
        List<Que> list = queService.list(wrapper);
        return Result.success(list);
    }

    /**
     * 点赞
     * @param que
     * @return
     */
    @RequestMapping("addGood")
    public Result addGood(Que que){
        LambdaQueryWrapper<Que> wrapper = new LambdaQueryWrapper();
        wrapper.eq(Que::getQid,que.getQid());
        Que one = queService.getOne(wrapper);
        int good = one.getGood()+1;
        one.setGood(good);
        queService.update(one,wrapper);
        return Result.success(good);
    }

    /**
     * 收藏
     * @param likes
     * @return
     */
    @RequestMapping("likes")
    public Result like(Likes likes){
        int likes1 = queService.likes(likes);
        return Result.success(likes1);
    }

    /**
     * 查询收藏列表
     * @param user
     * @return
     */
    @RequestMapping("findLikes")
    public Result findLikes(User user){
        LambdaQueryWrapper<Likes> wrapper = new LambdaQueryWrapper();
        wrapper.eq(Likes::getUid,user.getUid());
        List<Likes> list = likesServive.list(wrapper);
        List<Que> queList = new ArrayList<>();
        for (Likes likes : list) {
            LambdaQueryWrapper<Que> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(Que::getQid,likes.getQid());
            queList.add(queService.getOne(queryWrapper));
        }
        return Result.success(queList);
    }
}
