package com.wanxi.dao.impl;

import com.wanxi.dao.FootDao;
import com.wanxi.model.FootModel;
import com.wanxi.util.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FootDaoImpl implements FootDao {
    @Override
    public FootModel getFootModel() {
        String sql="SELECT * FROM lv_shi_foot where enable=1;";
        FootModel footModel = new FootModel();
        ResultSet rs = JDBC.getRs(sql);
        try {
            while (rs.next()) {
                footModel.setTitle(rs.getString("title"));
                footModel.setPhone(rs.getString("phone"));
                footModel.setChuanzhen(rs.getString("chuanzhen"));
                footModel.setSj(rs.getString("sj"));
                footModel.setNumb(rs.getString("numb"));
                footModel.setEmail(rs.getString("e-mail"));
                footModel.setAddress(rs.getString("address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return footModel;
    }
}
