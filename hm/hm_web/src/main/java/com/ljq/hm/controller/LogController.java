package com.ljq.hm.controller;

import com.ljq.hm.entity.Log;
import com.ljq.hm.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller("logController")
public class LogController {

    @Autowired
    private LogService logService;

    //显示所有入住记录
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Log> list = logService.getAll();
        request.setAttribute("LIST",list);
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }

    //输入身份证号码查看此人的入住记录
    public void searchById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id.length()!=18){
            request.setAttribute("message","身份证号码错误");
            request.getRequestDispatcher("list.do").forward(request,response);
        }else {
            List<Log> list = logService.getById(id);
            request.setAttribute("LIST",list);
            request.getRequestDispatcher("search_list.jsp").forward(request,response);
        }
    }
}
