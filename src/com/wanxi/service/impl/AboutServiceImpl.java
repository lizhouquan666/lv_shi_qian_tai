package com.wanxi.service.impl;

import com.wanxi.dao.AboutDao;
import com.wanxi.dao.impl.AboutDaoImpl;
import com.wanxi.model.AboutModel;
import com.wanxi.service.AboutService;

public class AboutServiceImpl implements AboutService {
    @Override
    public AboutModel getAboutModel() {
        AboutDao aboutDao = new AboutDaoImpl();
        return aboutDao.getAboutModel();

    }
}
