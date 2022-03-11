package com.wanxi.dao.impl;

import com.wanxi.dao.NewDao;
import com.wanxi.model.NewModel;
import com.wanxi.util.JDBC;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NewDaoImpl implements NewDao {
    @Override
    public List<NewModel> getNewModelList() {
        String sql = "SELECT * FROM lv_shi_new where enable=1";
        List<NewModel> list = new ArrayList<>();
        ResultSet resultSet = JDBC.getRs(sql);
        try{
            while (resultSet.next()){
                NewModel newModel= new NewModel();
                newModel.setImg_href(resultSet.getString("img_href"));
                newModel.setTitle(resultSet.getString("title"));
                newModel.setDate(resultSet.getString("date"));
                newModel.setContent(resultSet.getString("content"));
                list.add(newModel);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
