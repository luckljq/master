package com.ljq.hm.controller;

import com.ljq.hm.entity.InRoom;
import com.ljq.hm.service.InRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller("inRoomController")
public class InRoomController {

    @Autowired
    private InRoomService inRoomService;

    //显示所有入住人员
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<InRoom> inRoom = inRoomService.getAll();
        request.setAttribute("LIST",inRoom);
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }

    //搜索查看某个房间的客人
    public void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        List<InRoom> inRoom = inRoomService.getById(id);
        request.setAttribute("LIST",inRoom);
        request.getRequestDispatcher("search.jsp").forward(request,response);
    }
}
