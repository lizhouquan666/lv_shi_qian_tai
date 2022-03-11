package com.wanxi.dao;

import com.wanxi.model.ProductModel;

import java.util.List;

public interface ProductDao extends BaseDao<ProductModel> {
    List<ProductModel> getProductModelList(ProductModel model);

    List<ProductModel> findByProductId(ProductModel model);

    List<ProductModel> findAll(ProductModel productModel);
}
