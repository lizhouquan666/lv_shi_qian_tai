package com.wanxi.service.impl;

import com.wanxi.dao.ServiceDao;
import com.wanxi.dao.impl.ServiceImpl;
import com.wanxi.model.ServiceModel;
import com.wanxi.service.ServiceService;

import java.util.List;

public class ServiceServiceImpl implements ServiceService {
    @Override
    public List<ServiceModel> getServiceModelList() {
        ServiceDao serviceDao=new ServiceImpl();
        return serviceDao.getServiceModelList();
    }
}
