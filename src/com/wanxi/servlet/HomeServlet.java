package com.wanxi.servlet;

import com.alibaba.fastjson.JSONObject;
import com.wanxi.model.*;
import com.wanxi.service.*;
import com.wanxi.service.impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.如果前端传递中文时，可能会出现乱码
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        Map map = new HashMap();
        //logo
        LogService logService = new LogServiceImpl();
        LogModel logModels= logService.getLogModel();
        map.put("logModels",logModels);

        //Home 导航Nav
        NavService navService =new NavServiceImpl();
        List<NavModel> navModels = navService.getNavModelList();
        map.put("navModels",navModels);

        //Home TOP-img
        TopService topService = new TopServiceImpl();
        TopModel topModel=topService.getTopModel();
        map.put("topModel",topModel);

        //serviceModelList Home 页面法律服务
        ServiceService serviceService =new ServiceServiceImpl();
        List<ServiceModel> serviceModelList = serviceService.getServiceModelList();
        map.put("serviceModelList",serviceModelList);

        //实力页面
        Powerservice powerservice=new PowerserviceImpl();
        List<PowerModel> powerModels =powerservice.getPowerModelList();
        map.put("powerModels",powerModels);

        //客户
        CustomerService customerService=new CustomerServiceImpl();
        List<CustomerModel> customerModels = customerService.getCustomerModelList();
        map.put("customerModels",customerModels);

        //团队
        TeamService teamService = new TeamServiceImpl();
        List<TeamModel> teamModels = teamService.getTeamModelList();
        map.put("teamModels",teamModels);

        //新闻
        NewService newService = new NewServiceImpl();
        List<NewModel> newModels = newService.getNewModelList();
        map.put("newModels",newModels);

        //foot
        Footservice footservice = new FootserviceImpl();
        FootModel footModels = footservice.getFootModel();
        map.put("footModels",footModels);

        resp.getWriter().println(JSONObject.toJSONString(map));

    }
}
