package com.wanxi.service.impl;

import com.wanxi.dao.NewDao;
import com.wanxi.dao.impl.NewDaoImpl;
import com.wanxi.model.NewModel;
import com.wanxi.service.NewService;

import java.util.List;

public class NewServiceImpl implements NewService {
    @Override
    public List<NewModel> getNewModelList() {
        NewDao newDao = new NewDaoImpl();
        return newDao.getNewModelList();
    }
}
