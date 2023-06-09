package com.it.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.pojo.Answer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface AnswerMapper extends BaseMapper<Answer> {
    @Select("select * from answer where qid = #{qid}")
    public List<Answer> findAnswerByQid(int qid);

    @Insert("insert into answer(qid,uid,uname,head,time,answer) values (#{qid},#{uid},#{uname},#{head},#{time},#{answer})")
    public boolean addAnswer(Answer answer);


}
