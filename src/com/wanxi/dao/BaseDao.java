package com.wanxi.dao;

import java.util.List;

public interface BaseDao<T> {
    List<T> findAll(T t);

    int getCount(T t);

    int add(T t);

    int update(T t);

    int del(T t);

    List<T> findById(T t);
}
