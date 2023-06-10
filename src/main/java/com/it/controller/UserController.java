package com.it.controller;

import com.it.pojo.Result;
import com.it.pojo.User;
import com.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    @Value("${fei.path}")
    private String basePath;

    /**
     * 上传头像
     * @param uid
     * @param file
     * @return
     */
    @RequestMapping("head")
    public Result head(String uid,MultipartFile file){
        //获取原始文件名
        String originalFilename = file.getOriginalFilename();
        //获取后缀
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        //以uid重命名
        String name = uid+suffix;
        //创建目录
        File dir = new File(basePath);
        if (!dir.exists()){
            //若目录为空则新建目录
            dir.mkdirs();
        }
        //转存
        try {
            file.transferTo(new File(basePath+name));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result.success();
    }

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

}
