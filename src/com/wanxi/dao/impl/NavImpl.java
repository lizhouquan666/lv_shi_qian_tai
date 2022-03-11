package com.wanxi.dao.impl;

import com.wanxi.dao.NavDao;
import com.wanxi.model.NavModel;
import com.wanxi.util.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NavImpl implements NavDao {
    @Override
    public List<NavModel> getNavModelList() {
        String sql="select * from lv_shi_nav where enable=1";
        List<NavModel> list = new ArrayList<>();
        ResultSet resultSet = JDBC.getRs(sql);
        try {
            while (resultSet.next()){
                NavModel model = new NavModel();
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
