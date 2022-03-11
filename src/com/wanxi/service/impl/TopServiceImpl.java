package com.wanxi.service.impl;

import com.wanxi.dao.TopDao;
import com.wanxi.dao.impl.TopImpl;
import com.wanxi.model.TopModel;
import com.wanxi.service.TopService;

public class TopServiceImpl implements TopService {
    @Override
    public TopModel getTopModel() {
        TopDao topDao=new TopImpl();
        return topDao.getTopModel();
    }
}
