package com.wanxi.dao.impl;

import com.wanxi.dao.PowerDao;
import com.wanxi.model.PowerModel;
import com.wanxi.util.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PowerImpl implements PowerDao {
    @Override
    public List<PowerModel> getPowerModel() {
        String sql = "SELECT * FROM lv_shi_power where enable=1";
        List<PowerModel> list = new ArrayList<>();
        ResultSet resultSet= JDBC.getRs(sql);
        try{
            while (resultSet.next()){
                PowerModel model = new PowerModel();

                model.setNumb(resultSet.getString("numb"));
                model.setTitle(resultSet.getString("title"));
                list.add(model);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
