package com.it.controller;

import com.it.pojo.Que;
import com.it.pojo.Result;
import com.it.service.QueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QueController {

    @Autowired
    private QueService queService;

   @RequestMapping("findAllQue")
   public Result findAllQue(){
       List<Que> all = queService.findAllQue();
       return Result.success(all);
   }
    @RequestMapping("findQueByUid")
    public Result findQueByUid(Que que){
        List<Que> all = queService.findQueByUid(que);
        return Result.success(all);
    }
   @RequestMapping("addQue")
   public Result add(Que que){
       System.out.println(que);
       queService.add(que);
       return Result.success();
   }
    @RequestMapping("findQueByQid")
    public Result findQueByQid(Que que){
        Que all = queService.findQueByQid(que);
        System.out.println(all);
        return Result.success(all);
    }
    @RequestMapping("findQueByQue")
    public Result findQueByQue(String que){
        List<Que> queByQue = queService.findQueByQue(que);
        return Result.success(queByQue);
    }
    @RequestMapping("addGood")
    public Result addGood(Que que){
        System.out.println(que);
        return Result.success(queService.addGood(que));
    }
    @RequestMapping("like")
    public Result like(Que que){
        System.out.println("controll"+que);
        Boolean like = queService.like(que);
        return Result.success(like);
    }
}
