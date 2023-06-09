package com.it.controller;

import com.it.pojo.Result;
import com.it.pojo.User;
import com.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.channels.MulticastChannel;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("register")
    public Result register(User user){
        System.out.println(user);
        boolean register = userService.register(user);
        if(register)
            return Result.success();
        else
            return Result.error("账号重复");
    }
    @RequestMapping("logon")
    public Result logon( User user){
        User logon = userService.logon(user);
        if(logon ==null) return Result.error("账号密码错误");
        return Result.success(logon);
    }
    @RequestMapping("head")
    public Result head(MultipartFile ima,User user) throws IOException {
        ima.transferTo(new File("D:\\微信开发者工具\\项目\\springboot\\ima"+user.getUid()+".jpg"));
        return Result.success();
    }
}
