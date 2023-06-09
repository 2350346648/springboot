package com.it.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.it.pojo.Likes;
import com.it.pojo.Que;
import com.it.pojo.Result;
import com.it.service.AnswerService;
import com.it.service.QueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class QueController {

    @Autowired
    private QueService queService;

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
        one.setGood(one.getGood()+1);
        queService.update(one,wrapper);
        return Result.success();
    }

    /**
     * 收藏
     * @param likes
     * @return
     */
    @RequestMapping("like")
    public Result like(Likes likes){
        queService.likes(likes);
        return Result.success();
    }
}
