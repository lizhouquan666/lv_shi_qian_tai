package com.wanxi.dao.impl;

import com.wanxi.dao.TopDao;
import com.wanxi.model.TopModel;
import com.wanxi.util.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TopImpl implements TopDao {
    @Override
    public TopModel getTopModel() {
        String sql="SELECT * FROM lv_shi_title where enable=1;";
        TopModel topModel = new TopModel();
        ResultSet rs = JDBC.getRs(sql);
        try {
            while (rs.next()) {
                topModel.setTitle(rs.getString("title"));
                topModel.setTitle1(rs.getString("titles"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return topModel;
    }
}
