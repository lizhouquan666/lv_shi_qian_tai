//package com.wanxi.servlet.serviceid;
//
//
//import com.wanxi.model.ServiceIdModel;
//import com.wanxi.util.Tool;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet("/service_id/FindAll")
//public class ServiceIdServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //         1.如果前端传递中文时，可以会出现乱码
//        req.setCharacterEncoding("UTF-8");
//        resp.setCharacterEncoding("UTF-8");
//        //        2.要得到前端的数据
//        String service_id = req.getParameter("service_id");
//        String page = req.getParameter("page");
//        String limit = req.getParameter("limit");
//        String name = req.getParameter("name");
//        String enable=req.getParameter("enable");
//
//        //        3.封装model
//        ServiceIdModel serviceIdModel = new ServiceIdModel();
//        serviceIdModel.setService_id(Tool.stringToInt(service_id));
//        serviceIdModel.setName(Tool.nullToString(name));
//        serviceIdModel.setPage(Tool.pageToInt(page));
//        serviceIdModel.setLimit(Tool.limitToInt(limit));
//        serviceIdModel.setEnable(Tool.stringToInt(enable));
////        4.调用服务逻辑层
//        ServiceIdService serviceIdService = new ServiceIdServiceImpl();
//        //        5.得到统一的返回值对象
//        ResultModel resultModel = serviceIdService.findAll(serviceIdModel);
//        //       6.将数据返回给前端页面
//        resp.getWriter().println(JSON.toJSONString(resultModel));
//    }
//}
