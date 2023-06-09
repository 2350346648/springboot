package com.it.service.impl;

import com.it.mapper.QueMapper;
import com.it.pojo.Que;
import com.it.service.QueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class QueServiceImpl implements QueService {
    @Autowired
    private QueMapper queMapper;
    @Override
    public List<Que> findAllQue() {
        List<Que> list = queMapper.findAllQue();
        Collections.reverse(list);
        return list;
    }

    @Override
    public List<Que> findQueByUid(Que que) {

        return queMapper.findQueByUid(que);
    }

    @Override
    public Boolean add(Que que){
        que.setTime(LocalDateTime.now());
        return queMapper.add(que);
    }

    @Override
    public Que findQueByQid(Que que) {
        System.out.println(que);
        return queMapper.findQueByQid(que);
    }

    @Override
    public List<Que> findQueByQue(String que) {
        List<Que> queByQue = queMapper.findQueByQue(que);
        return queByQue;
    }

    @Override
    public Que addGood(Que que) {
        Que queByQid = queMapper.findQueByQid(que);
        System.out.println("初始good"+queByQid);
        queByQid.setGood(queByQid.getGood()+1);
        System.out.println("+1 good"+queByQid);
        queMapper.addGood(queByQid);

        return queByQid;
    }

    @Override
    public Boolean like(Que que) {
        Que like = queMapper.findLike(que);
        if(like==null){
            queMapper.addLike(que);
            Que que1 = queMapper.findQueByQid(que);
            que1.setLikes(que1.getLikes()+1);
            System.out.println("like+1"+que1);
            queMapper.addQueLike(que1);
            return true;
        }
        else {
            queMapper.deleteLike(que);
            Que que1 = queMapper.findQueByQid(que);
            que1.setLikes(que1.getLikes()-1);
            System.out.println("like-1"+que1);
            queMapper.addQueLike(que1);
            return false;
        }

    }
}
