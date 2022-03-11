package com.wanxi.dao.impl;

import com.wanxi.dao.ServiceDao;
import com.wanxi.model.ServiceModel;
import com.wanxi.util.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceImpl implements ServiceDao {
    @Override
    public List<ServiceModel> getServiceModelList(){
        String sql="select * from lv_shi_home_sevice where enable=1";
        List<ServiceModel> list=new ArrayList<>();
        ResultSet resultSet= JDBC.getRs(sql);
        try {
            while (resultSet.next()){
                ServiceModel model=new ServiceModel();
                model.setId(resultSet.getInt("id"));
                model.setTitles(resultSet.getString("title"));
                model.setImg_href(resultSet.getString("img_href"));
                list.add(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
