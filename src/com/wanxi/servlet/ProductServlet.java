package com.wanxi.servlet;

import com.alibaba.fastjson.JSONObject;
import com.wanxi.model.ProductModel;
import com.wanxi.model.SboxModel;
import com.wanxi.service.ProductService;
import com.wanxi.service.SboxService;
import com.wanxi.service.impl.ProductServiceImpl;
import com.wanxi.service.impl.SboxServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.如果前端传递中文时，可能会出现乱码
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        ProductModel model = new ProductModel();
        Map map =new HashMap();
        //box
        SboxService sboxService = new SboxServiceImpl();
        List<SboxModel> sboxModels =sboxService.getSboxModelList();
        map.put("sboxModels",sboxModels);
        //查找商品
        ProductService productService = new ProductServiceImpl();
        List<ProductModel> productModels=productService.getProductModelList(model);
        map.put("productModels",productModels);
        resp.getWriter().println(JSONObject.toJSONString(map));
    }
}
