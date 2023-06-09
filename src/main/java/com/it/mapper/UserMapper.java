package com.it.mapper;

import com.it.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Insert("insert user(uid,uname,password) values (#{uid},#{uname},#{password})")
    public boolean register(User user);

    @Select("select * from user where uid=#{uid} and password=#{password}")
    public User findByUidAndPassword(User user);

    @Select("select * from user")
    public List<User> findAllUser();

}
