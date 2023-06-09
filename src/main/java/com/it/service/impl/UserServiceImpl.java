package com.it.service.impl;

import com.it.mapper.UserMapper;
import com.it.pojo.User;
import com.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean register(User user) {
        List<User> allUser = userMapper.findAllUser();
        for(User u : allUser){
            if(u.getUid()==user.getUid())
                return false;
        }

        return userMapper.register(user);

    }

    @Override
    public User logon(User user) {
        return  userMapper.findByUidAndPassword(user);
    }
}
