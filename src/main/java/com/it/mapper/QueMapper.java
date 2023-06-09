package com.it.mapper;

import com.it.pojo.Answer;
import com.it.pojo.Que;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface QueMapper {
    @Select("select * from question")
    public List<Que> findAllQue();
    @Insert("insert into question(uid,que,time,uname) values (#{uid},#{que},#{time},#{uname})")
    public Boolean add(Que que);
    @Select("select * from question where uid = #{uid}")
    public List<Que> findQueByUid(Que que);
    @Select("select * from question where qid = #{qid}")
    public Que findQueByQid(Que que);
    @Select("SELECT * FROM question WHERE que LIKE '%${que}%'")
    public List<Que> findQueByQue(String que);
    @Update("update question set good=#{good} where qid=#{qid}")
    public void addGood(Que queByQid);
    @Select("select * from likes where qid = #{qid} AND uid=#{uid}")
    public Que findLike(Que que);
    @Insert("insert into likes(qid,uid) values (#{qid},#{uid})")
    public void addLike(Que que);
    @Update("update question set likes=#{likes} where qid=#{qid}")
    public void addQueLike(Que que);
    @Delete("DELETE FROM likes WHERE qid = #{qid}")
    public void deleteLike(Que que);
}
