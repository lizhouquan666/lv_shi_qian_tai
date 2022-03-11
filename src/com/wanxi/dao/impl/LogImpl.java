package com.wanxi.dao.impl;

import com.wanxi.dao.LogDao;
import com.wanxi.model.LogModel;
import com.wanxi.util.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LogImpl implements LogDao {
    @Override
    public LogModel getLogModel(){
        String sql="SELECT * FROM lv_shi_logo where enable=1;";
        LogModel logModel = new LogModel();
        ResultSet rs = JDBC.getRs(sql);
        try {
            while (rs.next()) {
                logModel.setName(rs.getString("name"));
                logModel.setTitle(rs.getString("title"));
                logModel.setImg_href(rs.getString("img_href"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return logModel;
    }
}
