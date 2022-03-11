package com.wanxi.servlet;

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

@WebServlet("/findProductById")
public class FindProductByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //         1.如果前端传递中文时，可以会出现乱码
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        //        2.要得到前端的数据
        String id = req.getParameter("id");
        String limit = req.getParameter("limit");
        String page = req.getParameter("page");

        ProductModel productModel = new ProductModel();
        productModel.setId(Tool.stringToInt(id));
        productModel.setPage(Tool.stringToInt(page));
        productModel.setLimit(Tool.stringToInt(limit));
        ProductService productService = new ProductServiceImpl();
        ResultModel resultModel =productService.findProductById(productModel);
        resp.getWriter().println(JSON.toJSONString(resultModel));
    }
}
