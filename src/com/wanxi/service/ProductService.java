package com.wanxi.service;

import com.wanxi.model.ProductModel;
import com.wanxi.result.ResultModel;

import java.util.List;

public interface ProductService {

    List<ProductModel> getProductModelList(ProductModel model);

    ResultModel findById(ProductModel productModel);

    ResultModel findProductById(ProductModel productModel);

    ResultModel findAll(ProductModel productModel);

    ResultModel getCount(ProductModel productModel);
}
