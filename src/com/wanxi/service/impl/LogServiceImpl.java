package com.wanxi.service.impl;

import com.wanxi.dao.LogDao;
import com.wanxi.dao.impl.LogImpl;
import com.wanxi.model.LogModel;
import com.wanxi.service.LogService;

public class LogServiceImpl implements LogService {
    @Override
    public LogModel getLogModel() {
        LogDao logDao=new LogImpl();
        return logDao.getLogModel();
    }
}
