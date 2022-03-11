package com.wanxi.servlet;


import com.alibaba.fastjson.JSONObject;
import com.wanxi.model.AboutModel;
import com.wanxi.service.AboutService;
import com.wanxi.service.impl.AboutServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/about")
public class AboutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.如果前端传递中文时，可能会出现乱码
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        Map map = new HashMap();
        //关于我们
        AboutService aboutService = new AboutServiceImpl();
        AboutModel aboutModel= aboutService.getAboutModel();
        map.put("aboutModel",aboutModel);
        resp.getWriter().println(JSONObject.toJSONString(map));

    }
}
