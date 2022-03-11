package com.wanxi.dao.impl;

import com.wanxi.dao.SboxDao;
import com.wanxi.model.SboxModel;
import com.wanxi.util.JDBC;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SboxDaoImpl implements SboxDao {
    @Override
    public List<SboxModel> getSboxModelList() {
        String sql="SELECT * FROM lv_shi_service where is_show=1";
        List<SboxModel> list=new ArrayList<>();
        ResultSet resultSet = JDBC.getRs(sql);
        try{
            while (resultSet.next()){
                SboxModel sboxModel = new SboxModel();
                sboxModel.setId(resultSet.getString("id"));
                sboxModel.setName(resultSet.getString("name"));
                sboxModel.setIs_show(resultSet.getString("is_show"));
                sboxModel.setService_id(resultSet.getString("id"));
                list.add(sboxModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
