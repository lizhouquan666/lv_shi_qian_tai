package com.wanxi.service.impl;

import com.wanxi.dao.FootDao;
import com.wanxi.dao.impl.FootDaoImpl;
import com.wanxi.model.FootModel;
import com.wanxi.service.Footservice;

public class FootserviceImpl implements Footservice {
    @Override
    public FootModel getFootModel() {
        FootDao footDao= new FootDaoImpl();
        return footDao.getFootModel();
    }
}
