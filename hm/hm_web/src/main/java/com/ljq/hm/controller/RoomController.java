package com.ljq.hm.controller;

import com.ljq.hm.entity.InRoom;
import com.ljq.hm.entity.Log;
import com.ljq.hm.entity.Member;
import com.ljq.hm.entity.Room;
import com.ljq.hm.service.InRoomService;
import com.ljq.hm.service.LogService;
import com.ljq.hm.service.MemberService;
import com.ljq.hm.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller("roomController")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private InRoomService inRoomService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private LogService logService;

    //显示所有房间
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Room> list = roomService.getAll();
        request.setAttribute("LIST", list);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    //按类型查看空闲房间
    public void type(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取房间类型
        String roomType = request.getParameter("roomType");
        String state = "空闲";
        List<Room> list = roomService.getByState(roomType, state);
        HttpSession session = request.getSession();
        session.setAttribute("roomType", roomType);
        request.setAttribute("LIST", list);
        Member member = (Member) session.getAttribute("USER");
        //判断用户身份
        if (member.getIdentity().equals("管理员")) {
            request.getRequestDispatcher("type.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("../member/typeYd.jsp").forward(request, response);
        }
    }

    //按楼层与类型查看空闲房间
    public void floor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String roomType = request.getParameter("roomType");
        String state = "空闲";
        String floor = request.getParameter("floor");
        List<Room> list = roomService.getByFloor(roomType, state, floor);
        request.setAttribute("LIST", list);
        HttpSession session = request.getSession();
        Member member = (Member) session.getAttribute("USER");
        if (member.getIdentity().equals("管理员")) {
            request.getRequestDispatcher("type.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("../member/typeYd.jsp").forward(request, response);
        }
    }

    //搜索房间，不同状态的房间有特定的页面，存在特定的功能
    public void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Room room = roomService.getById(id);
        if (room == null) {
            request.getSession().setAttribute("message", "不存在该房间");
            response.sendRedirect("list.do");
        } else {
            request.setAttribute("LIST", room);
            if (room.getState().equals("有客")) {
                request.getRequestDispatcher("search.jsp").forward(request, response);
            } else if (room.getState().equals("预定")) {
                request.getRequestDispatcher("search_yd.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("search_kx.jsp").forward(request, response);
            }
        }
    }

    //按状态查找房间
    public List find(String state) {
        List<Room> list = roomService.getByYd(state);
        return list;
    }

    //查找预定的房间
    public void yd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String state = "预定";
        request.setAttribute("LIST", find(state));
        request.getRequestDispatcher("yd.jsp").forward(request, response);
    }


    //跳转到添加页面
    public void toAddRoom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("add.jsp").forward(request, response);
    }


    //增加房间
    public void addRoom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String roomId = request.getParameter("roomId");
        List<Room> rooms = roomService.getAll();
        for (Room r : rooms) {
            if ((r.getRoomId().equals(roomId))) {
                request.setAttribute("message1", "已存在房间编号");
                request.getRequestDispatcher("add.jsp").forward(request, response);
            }
        }
        Room room = new Room();
        room.setRoomId(roomId);
        room.setRoomType(request.getParameter("roomType"));
        room.setDiction(request.getParameter("diction"));
        String p = request.getParameter("price");
        room.setState("空闲");
        if (room.getRoomId().equals("")|| p.equals("")){
            request.setAttribute("message1", "房间号或者价格不能为空");
            request.getRequestDispatcher("add.jsp").forward(request, response);
        }else {
            Integer price = Integer.parseInt(p);
            room.setPrice(price);
            roomService.add(room);
            request.getSession().setAttribute("message2", "添加成功");
            response.sendRedirect("editList.do");
        }
    }

    //查看空闲的房间，并转到编辑房间页面
    public void editList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String state = "空闲";
        request.setAttribute("LIST", find(state));
        request.getRequestDispatcher("edit_list.jsp").forward(request, response);
    }

    //搜索并且跳转到编辑页面
    public void searchEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Room room = roomService.getById(id);
        if (room == null) {
            request.getSession().setAttribute("message1", "不存在该房间");
            response.sendRedirect("editList.do");
        } else {
            if (room.getState().equals("空闲")) {
                request.setAttribute("LIST", room);
                request.getRequestDispatcher("search_edit.jsp").forward(request, response);
            } else {
                request.getSession().setAttribute("message1", "只能搜索空闲房间");
                response.sendRedirect("editList.do");
            }
        }
    }

    //点击编辑按钮后转发到编辑页面
    public void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String roomId = request.getParameter("roomId");
        Room room = roomService.getById(roomId);
        request.setAttribute("LIST", room);
        request.getRequestDispatcher("edit.jsp").forward(request, response);
    }

    //修改信息
    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String roomId = request.getParameter("roomId");
        String roomType = request.getParameter("roomType");
        String p = request.getParameter("price");
        if (p.equals("")){
            request.setAttribute("message","价格不能为空");
            request.getRequestDispatcher("toEdit.do").forward(request, response);
        }else {
            Integer price = Integer.parseInt(p);
            String diction = request.getParameter("diction");
            String state = "空闲";

            Room room = new Room();
            room.setRoomId(roomId);
            room.setState(state);
            room.setRoomType(roomType);
            room.setDiction(diction);
            room.setPrice(price);

            roomService.edit(room);
            response.sendRedirect("editList.do");
        }
    }

    //删除房间
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String roomId = request.getParameter("roomId");
        roomService.remove(roomId);
        response.sendRedirect("editList.do");
    }


    //入住
    public void toIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String roomId = request.getParameter("roomId");
        request.setAttribute("roomId", roomId);
        request.getRequestDispatcher("in.jsp").forward(request, response);
    }

    //登记
    private void in(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        InRoom i = inRoomService.get(id);
        if (i != null) {
            request.setAttribute("message", "该身份证号码已存在");
            request.getRequestDispatcher("toIn.do").forward(request, response);
        } else if (id.length() != 18) {
            request.setAttribute("message3", "身份证号码输入错误");
            request.getRequestDispatcher("toIn.do").forward(request, response);
        } else {
            String name = request.getParameter("name");
            String sex = request.getParameter("sex");
            String diction = request.getParameter("diction");
            String roomId = request.getParameter("roomId");
            String name2 = request.getParameter("name2");
            InRoom inRoom = new InRoom();
            inRoom.setId(id);
            inRoom.setName(name);
            inRoom.setSex(sex);
            inRoom.setDiction(diction);
            inRoom.setRoomId(roomId);
            inRoom.setState("入住");
            Log log = new Log();
            log.setId(id);
            log.setName(name);
            log.setInTime(new Date());
            log.setRoomId(roomId);
            Room room = roomService.getById(roomId);

            if (name2.equals("")) {
                inRoomService.add(inRoom);
                logService.add(log);
                room.setState("有客");
                roomService.edit(room);
            } else {
                String id2 = request.getParameter("id2");

                InRoom i2 = inRoomService.get(id2);
                if (i2 != null) {
                    request.setAttribute("message2", "该身份证号码已存在");
                    request.getRequestDispatcher("toIn.do").forward(request, response);
                } else if (id.equals(id2) || id2.length() != 18) {
                    request.setAttribute("message3", "身份证号码输入错误");
                    request.getRequestDispatcher("toIn.do").forward(request, response);
                } else {
                    String sex2 = request.getParameter("sex2");
                    String diction2 = request.getParameter("diction2");
                    InRoom inRoom2 = new InRoom();
                    inRoom2.setId(id2);
                    inRoom2.setName(name2);
                    inRoom2.setSex(sex2);
                    inRoom2.setDiction(diction2);
                    inRoom2.setRoomId(roomId);
                    inRoom2.setState("入住");
                    inRoomService.add(inRoom);
                    inRoomService.add(inRoom2);

                    logService.add(log);
                    Log log2 = new Log();
                    log2.setId(id2);
                    log2.setName(name2);
                    log2.setInTime(new Date());
                    log2.setRoomId(roomId);
                    logService.add(log2);

                    room.setState("有客");
                    roomService.edit(room);
                }
            }
        }
    }



    //入住登记
    public void inRoom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        in(request, response);
        response.sendRedirect("list.do");
    }

    //跳转到预定入住
    public void toInYd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String roomId = request.getParameter("roomId");
        request.setAttribute("roomId", roomId);
        Member member = memberService.getByRoomId(roomId);
        request.setAttribute("LIST", member);
        request.getRequestDispatcher("inYd.jsp").forward(request, response);
    }

    //预定登记入住
    public void inRoomYd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        in(request, response);
        String id = request.getParameter("id");
        Member member = memberService.getById(id);
        member.setRoomId(null);
        memberService.edit(member);
        response.sendRedirect("list.do");
    }

    //取消预定
    public void outYd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String roomId = request.getParameter("roomId");
        Room room = roomService.getById(roomId);
        room.setState("空闲");
        roomService.edit(room);
        Member member = memberService.getByRoomId(roomId);
        member.setRoomId(null);
        memberService.edit(member);
        response.sendRedirect("list.do");
    }

    //退房
    public void out(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String roomId = request.getParameter("roomId");
        Room room = roomService.getById(roomId);
        room.setState("空闲");
        roomService.edit(room);
        inRoomService.remove(roomId);
        List<Log> logs = logService.getByRoomId(roomId);
        for (Log log : logs) {
            log.setOutTime(new Date());
            logService.edit(log);
        }
        response.sendRedirect("list.do");
    }

    //to换房
    public void toChange(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("roomId", request.getParameter("roomId"));
        request.getRequestDispatcher("change.jsp").forward(request, response);
    }

    //换房
    public void change(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String roomId = request.getParameter("roomId"); //获取换房后的房间号
        String roomId2 = request.getParameter("roomId2");//获取换房前的房间号
        Room room = roomService.getById(roomId);//获取新房间
        if (room == null) {
            request.setAttribute("roomId", roomId2);
            request.setAttribute("message", "房间不存在");
            request.getRequestDispatcher("change.jsp").forward(request, response);
        } else if (room.getState().equals("空闲")) {
            //获取旧房间
            Room room2 = roomService.getById(roomId2);
            room2.setState("空闲");
            roomService.edit(room2);
            room.setState("有客");
            roomService.edit(room);
            List<InRoom> list = inRoomService.getById(roomId2);
            for (InRoom i : list) {
                i.setRoomId(roomId);
                inRoomService.edit(i);
            }
            List<Log> logs = logService.getByRoomId(roomId2);
            for (Log log : logs) {
                log.setRoomId(roomId);
                logService.edit(log);
            }
            response.sendRedirect("list.do");
        } else {
            request.setAttribute("roomId", roomId2);
            request.setAttribute("message", "房间已有客");
            request.getRequestDispatcher("change.jsp").forward(request, response);
        }

    }
}
