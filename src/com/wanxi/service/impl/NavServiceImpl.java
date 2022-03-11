package com.wanxi.service.impl;

import com.wanxi.dao.NavDao;
import com.wanxi.dao.impl.NavImpl;
import com.wanxi.model.NavModel;
import com.wanxi.service.NavService;

import java.util.List;

public class NavServiceImpl implements NavService {

    @Override
    public List<NavModel> getNavModelList() {
        NavDao navDao = new NavImpl();
        return navDao.getNavModelList();
    }
}
