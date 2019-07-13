package com.ljq.hm.controller;

import com.ljq.hm.entity.InRoom;
import com.ljq.hm.entity.Member;
import com.ljq.hm.entity.Room;
import com.ljq.hm.service.InRoomService;
import com.ljq.hm.service.MemberService;
import com.ljq.hm.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller("memberController")
public class MemberController {
    @Autowired
    private RoomService roomService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private InRoomService inRoomService;

    //member/toEdit.do
    public void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("member_edit.jsp").forward(request, response);
    }

    public void editE(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String account = request.getParameter("account");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        Member member = memberService.getByAccount(account);
        member.setId(id);
        member.setName(name);
        member.setSex(sex);
        memberService.edit(member);
        request.getSession().setAttribute("USER", member);
        response.sendRedirect("../self/info.do");
    }

    //编辑会员信息
    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String id2 =request.getParameter("id2");
        if (id.equals(id2)){
            editE(request,response);
        }else {
            Member member2 = memberService.getById(id);
            //判断身份证号码是不是18位
            if (id.length() != 18) {
                request.setAttribute("message", "身份证号码不正确");
                request.getRequestDispatcher("member_edit.jsp").forward(request, response);
            //判断该身份证号码是否正确
            } else if (member2 == null) {
                editE(request,response);
            } else {
                request.setAttribute("message", "已存在该身份证号码的会员");
                request.getRequestDispatcher("member_edit.jsp").forward(request, response);
            }
        }

    }

    //获取房间号，跳转到预定页面
    public void toYd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("roomId", request.getParameter("roomId"));
        request.getRequestDispatcher("in.jsp").forward(request, response);
    }

    //预定房间，确认个人信息
    public void yd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Member member = (Member) request.getSession().getAttribute("USER");
        InRoom inRoom = inRoomService.get(member.getId());
        if (inRoom==null) {
            String roomId = request.getParameter("roomId");
            member.setRoomId(roomId);
            memberService.edit(member);
            Room room = roomService.getById(roomId);
            room.setState("预定");
            roomService.edit(room);
            response.sendRedirect("../self/info.jsp");
        }else {
            request.setAttribute("message","您已入住本酒店，无需预定房间");
            request.getRequestDispatcher("in.jsp").forward(request,response);
        }
    }

    //查看已预定房间，可以取消预定
    public void toShowYd(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        Member member = (Member) request.getSession().getAttribute("USER");
        String roomId = member.getRoomId();
        if (roomId==null){
            request.getRequestDispatcher("yd2.jsp").forward(request,response);
        }else {
            Room room = roomService.getById(roomId);
            request.setAttribute("LIST",room);
            request.getRequestDispatcher("yd.jsp").forward(request,response);
        }
    }

    //取消预定方法
    public void outYd(HttpServletRequest request,HttpServletResponse response) throws IOException {
        Member member = (Member) request.getSession().getAttribute("USER");
        String roomId = member.getRoomId();
        member.setRoomId(null);
        memberService.edit(member);
        Room room = roomService.getById(roomId);
        room.setState("空闲");
        roomService.edit(room);
        response.sendRedirect("../self/info.do");
    }
}
