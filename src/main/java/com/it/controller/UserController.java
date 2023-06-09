package com.it.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.it.pojo.Result;
import com.it.pojo.User;
import com.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.MulticastChannel;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Value("${fei.path}")
    private String basePath;

    /**
     * 上传头像
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
        String name = uid+".jpg";
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

    /**
     * 获取头像
     * @param uid
     * @param response
     */
    @RequestMapping("getHead")
    public void getHead(String uid,HttpServletResponse response){
        try {
            //是否上传头像
            File dir = new File(basePath+uid+".jpg");
            //若无，返回默认头像
            if (!dir.exists()){
                //输入流读取文件内容
                FileInputStream fileInputStream = new FileInputStream(new File(basePath+"moren.jpg"));
                //输出流写回浏览器
                ServletOutputStream outputStream = response.getOutputStream();

                int len = 0;
                byte[] bytes = new byte[1024];
                while ((len=fileInputStream.read(bytes))!=-1){
                    outputStream.write(bytes,0,len);
                    outputStream.flush();
                }

                outputStream.close();
                fileInputStream.close();
                return;
            }
            //若有，返回用户头像
            else {
                //输入流读取文件内容
                FileInputStream fileInputStream = new FileInputStream(new File(basePath+uid+".jpg"));
                //输出流写回浏览器
                ServletOutputStream outputStream = response.getOutputStream();

                int len = 0;
                byte[] bytes = new byte[1024];
                while ((len=fileInputStream.read(bytes))!=-1){
                    outputStream.write(bytes,0,len);
                    outputStream.flush();
                }

                outputStream.close();
                fileInputStream.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 注册
     * @param user
     * @return
     */
    @RequestMapping("register")
    public Result register(User user){
        LambdaQueryWrapper<User> wrapper =  new LambdaQueryWrapper<>();
        wrapper.eq(User::getUid,user.getUid());
        List<User> list = userService.list(wrapper);
        if(list==null)
            return Result.success("注册成功");
        else
            return Result.error("账号重复");
    }

    /**
     * 登录
     * @param user
     * @return
     */
    @RequestMapping("logon")
    public Result logon( User user){
        LambdaQueryWrapper<User> wrapper =  new LambdaQueryWrapper<>();
        wrapper.eq(User::getUid,user.getUid()).eq(User::getPassword,user.getPassword());
        List<User> list = userService.list(wrapper);

        if(list ==null) return Result.error("账号密码错误");
        return Result.success(list);
    }

}
