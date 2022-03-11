package com.wanxi.dao.impl;

import com.wanxi.dao.ProductDao;
import com.wanxi.model.ProductModel;
import com.wanxi.util.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    @Override
    public List<ProductModel> getProductModelList(ProductModel model) {
        String sql = "SELECT * FROM lv_shi_service_product where enable=1";
        List<ProductModel> list=new ArrayList<>();
        ResultSet resultSet = JDBC.getRs(sql);
        try {
            while (resultSet.next()){
                ProductModel productModel = new ProductModel();
                productModel.setId(resultSet.getInt("id"));
                productModel.setName(resultSet.getString("name"));
                productModel.setImg_href(resultSet.getString("imgHref"));
                productModel.setPrice(resultSet.getString("price"));
                productModel.setNormal_price(resultSet.getString("normalPrice"));
                productModel.setService_id(resultSet.getInt("service_id"));
                list.add(productModel);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }


    @Override
    public List<ProductModel> findById(ProductModel model) {
        String sql = "SELECT * FROM lv_shi_service_product where service_id=" + model.getService_id();
        sql += " order by id desc";
        sql+=" limit " + (model.getPage() + -1) * +model.getLimit() + ", " + model.getLimit();
        //        2.得到结果集，
        ResultSet rs = JDBC.getRs(sql);
//        3.解析结果集
        return getList(rs);
    }
    @Override
    public List<ProductModel> findByProductId(ProductModel model) {
        String sql = "SELECT * FROM lv_shi_service_product where id=" + model.getId();
        sql += " order by id desc";
        sql+=" limit " + (model.getPage() + -1) * +model.getLimit() + ", " + model.getLimit();
        //        2.得到结果集，
        ResultSet rs = JDBC.getRs(sql);
//        3.解析结果集
        return getList(rs);
    }

    @Override
    public List<ProductModel> findAll(ProductModel productModel) {
        String sql = "SELECT p.*,c.name serviceTypeName FROM lv_shi_service_product p left join lv_shi_service c\n" +
                "on  p.service_id=c.id   where 1=1 ";
        if (!"".equals(productModel.getName())) {
            sql += " and name like '%" + productModel.getName() + "%'";
        }
        sql += " order by id desc";
        sql += " limit " + (productModel.getPage() + -1) * +productModel.getLimit() + ", " + productModel.getLimit();
        ResultSet rs = JDBC.getRs(sql);
        return getList(rs);
    }

    @Override
    public int getCount(ProductModel model) {
        //        1.编写sql语句，
        String sql = "select count(*) count from lv_shi_service_product where service_id="+model.getService_id()+" ";
//        2.得到结果集，
        ResultSet rs = JDBC.getRs(sql);
//        3.解析结果集
        int count = 0;
        try {
            while (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        4.返回数据
        return count;
    }

    @Override
    public int add(ProductModel model) {
        return 0;
    }

    @Override
    public int update(ProductModel model) {
        return 0;
    }

    @Override
    public int del(ProductModel model) {
        return 0;
    }

    private List<ProductModel> getList(ResultSet rs) {
        List<ProductModel> list = new ArrayList<>();
        try {
            while (rs.next()) {
//                注意：密码永远不要查询出来
                ProductModel model = new ProductModel();
                model.setId(rs.getInt("id"));
                model.setName(rs.getString("name"));
                model.setPrice(rs.getString("price"));
                model.setNormal_price(rs.getString("normalPrice"));
                model.setImg_href(rs.getString("imgHref"));
                model.setContent(rs.getString("content"));
                model.setService_id(rs.getInt("service_id"));
                model.setCreateTime(rs.getString("create_time"));
                model.setUpdateTime(rs.getString("update_time"));
                model.setEnable(rs.getInt("enable"));
                list.add(model);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        4.返回数据
        return list;
    }
}
