package com.wanxi.service.impl;

import com.wanxi.dao.SboxDao;
import com.wanxi.dao.impl.SboxDaoImpl;
import com.wanxi.model.SboxModel;
import com.wanxi.service.SboxService;

import java.util.List;

public class SboxServiceImpl implements SboxService {
    @Override
    public List<SboxModel> getSboxModelList() {
        SboxDao sboxDao = new SboxDaoImpl();
        return sboxDao.getSboxModelList();
    }
}
