package com.wanxi.servlet.product;

import com.alibaba.fastjson.JSON;
import com.wanxi.model.ProductModel;
import com.wanxi.result.ResultModel;
import com.wanxi.service.ProductService;
import com.wanxi.service.impl.ProductServiceImpl;
import com.wanxi.util.Tool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/back/productId/count")
public class ProductGetCountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //         1.如果前端传递中文时，可以会出现乱码
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        //        2.要得到前端的数据
        String page = req.getParameter("page");
        String limit = req.getParameter("limit");
        String name = req.getParameter("name");
        String service_id = req.getParameter("service_id");
        String price = req.getParameter("price");
        String normalPrice = req.getParameter("normalPrice");
        String serviceTypeName = req.getParameter("serviceTypeName");
        String content = req.getParameter("content");
        String imgHref = req.getParameter("imgHref");
        String enable = req.getParameter("enable");
//        String start = req.getParameter("start");
//        String end = req.getParameter("end");

        //        3.封装model
        ProductModel productModel = new ProductModel();
        productModel.setName(Tool.nullToString(name));
        productModel.setService_id(Tool.stringToInt(service_id));
        productModel.setPrice(Tool.nullToString(price));
        productModel.setNormal_price(Tool.nullToString(normalPrice));
        productModel.setContent(Tool.nullToString(content));
        productModel.setImg_href(Tool.nullToString(imgHref));
        productModel.setEnable(Tool.enableToInt(enable));
        productModel.setPage(Tool.pageToInt(page));
        productModel.setLimit(Tool.limitToInt(limit));
        productModel.setServiceTypeName(Tool.nullToString(serviceTypeName));
//        productModel.setStart(Tool.nullToString(start));
//        productModel.setEnd(Tool.nullToString(end));
//        4.调用服务逻辑层
        ProductService productService = new ProductServiceImpl();
        //        5.得到统一的返回值对象
        ResultModel resultModel = productService.getCount(productModel);
        //       6.将数据返回给前端页面
        resp.getWriter().println(JSON.toJSONString(resultModel));
    }
}