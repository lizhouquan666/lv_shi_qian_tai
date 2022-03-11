package com.wanxi.service.impl;

import com.wanxi.dao.ProductDao;
import com.wanxi.dao.impl.ProductDaoImpl;
import com.wanxi.model.ProductModel;
import com.wanxi.result.ResultModel;
import com.wanxi.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Override
    public List<ProductModel> getProductModelList(ProductModel model) {
        ProductDao productDao=new ProductDaoImpl();
        return productDao.getProductModelList(model);
    }
    @Override
    public ResultModel findById(ProductModel model) {
        ProductDao productDao = new ProductDaoImpl();
        return ResultModel.getModel(productDao.findById(model));
    }

    @Override
    public ResultModel findProductById(ProductModel productModel) {
        ProductDao productDao = new ProductDaoImpl();
        return ResultModel.getModel(productDao.findByProductId(productModel));
    }

    @Override
    public ResultModel findAll(ProductModel productModel) {
        ProductDao productDao = new ProductDaoImpl();
        return ResultModel.getModel(productDao.findAll(productModel));
    }

    @Override
    public ResultModel getCount(ProductModel productModel) {
        ProductDao productDao = new ProductDaoImpl();
        return ResultModel.getModel(productDao.getCount(productModel));
    }
}
