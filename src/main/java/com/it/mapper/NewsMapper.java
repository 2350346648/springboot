package com.it.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.pojo.News;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NewsMapper extends BaseMapper<News> {
    @Insert("insert into news(uid,sid,sname,head,text,time) values (#{uid},#{sid},#{sname},#{head},#{text},#{time})")
    public void sendNews(News news);

    @Select("select * from news where uid = #{uid}")
    public List<News> findAllNewsByUid(String uid);
}
