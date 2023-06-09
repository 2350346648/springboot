package com.it.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.it.pojo.User;

public interface UserService extends IService<User> {
    public boolean register(User user);
    public User logon(User user);

}
