package com.wanxi.service.impl;

import com.wanxi.dao.PowerDao;
import com.wanxi.dao.impl.PowerImpl;
import com.wanxi.model.PowerModel;
import com.wanxi.service.Powerservice;

import java.util.List;

public class PowerserviceImpl implements Powerservice {
    @Override
    public List<PowerModel> getPowerModelList() {
        PowerDao powerDao = new PowerImpl();
        return powerDao.getPowerModel();
    }
}
