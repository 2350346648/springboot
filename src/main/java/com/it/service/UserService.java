package com.it.service;

import com.it.pojo.User;

public interface UserService {
    public boolean register(User user);
    public User logon(User user);

}
