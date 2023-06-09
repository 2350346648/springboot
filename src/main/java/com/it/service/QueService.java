package com.it.service;

import com.it.pojo.Que;

import java.util.List;

public interface QueService {
    public List<Que> findAllQue();
    public List<Que> findQueByUid(Que que);
    public Boolean add(Que que);

    public Que findQueByQid(Que que);

    public List<Que> findQueByQue(String que);

    public Que addGood(Que que);

    public Boolean like(Que que);
}

