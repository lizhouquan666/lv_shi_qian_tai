package com.wanxi.dao.impl;

import com.wanxi.dao.CustomerDao;
import com.wanxi.model.CustomerModel;
import com.wanxi.util.JDBC;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerImpl implements CustomerDao {
    @Override
    public List<CustomerModel> getCustomerModelList() {
        String sql = "SELECT * FROM lv_shi_customer where enable=1";
        List<CustomerModel> list =new ArrayList<>();
        ResultSet resultSet = JDBC.getRs(sql);
        try {
            while (resultSet.next()){
                CustomerModel customerModel = new CustomerModel();
                customerModel.setImg_href(resultSet.getString("img_href"));
                list.add(customerModel);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
