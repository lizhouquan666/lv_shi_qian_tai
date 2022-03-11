package com.wanxi.dao.impl;

import com.wanxi.dao.AboutDao;
import com.wanxi.model.AboutModel;
import com.wanxi.util.JDBC;

import java.sql.ResultSet;

public class AboutDaoImpl implements AboutDao {
    @Override
    public AboutModel getAboutModel() {
        String sql ="SELECT * FROM lv_shi_about where enable=1";
        AboutModel aboutModel=new AboutModel();
        ResultSet resultSet= JDBC.getRs(sql);
        try{
            while (resultSet.next()){
                aboutModel.setTitle(resultSet.getString("title"));
                aboutModel.setTitles(resultSet.getString("titles"));
                aboutModel.setContent(resultSet.getString("content"));
                aboutModel.setImg_href(resultSet.getString("img_href"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return aboutModel;
    }
}
