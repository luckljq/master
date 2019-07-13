package com.ljq.hm.controller;

import com.ljq.hm.entity.Member;
import com.ljq.hm.service.MemberService;
import com.ljq.hm.service.SelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller("selfController")
public class SelfController {

    @Autowired
    private SelfService selfService;
    @Autowired
    private MemberService memberService;

    public void main(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    public void main2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index2.jsp").forward(request,response);
    }

    public void toLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }

    //登录
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account =request.getParameter("account");
        String password = request.getParameter("password");
        HttpSession session=request.getSession();
        session.setAttribute("s1",null);
        session.setAttribute("s2",null);

        Member member = selfService.login(account,password);
        if(member==null){

            String message1="密码或用户名不正确";
            session.setAttribute("s2",message1);
            response.sendRedirect("toLogin.do");
        }else{
            session.setAttribute("USER",member);
            if(member.getIdentity().equals("管理员")){
                response.sendRedirect("main.do");
            }else{
                response.sendRedirect("main2.do");
            }
        }
    }

    //退出
    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("USER", null);
        session.setAttribute("s1",request.getParameter("s1"));

        response.sendRedirect("toLogin.do");
    }

    //个人信息
    public void info(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("info.jsp").forward(request,response);
    }

    public void toChangePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("change_password.jsp").forward(request,response);
    }

    //修改密码
    public void changePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password = request.getParameter("password");
        String password1 = request.getParameter("password1");
        HttpSession session = request.getSession();
        Member member = (Member)session.getAttribute("USER");
        if(!member.getPassword().equals(password)){
            request.getSession().setAttribute("message3","原始密码错误");
            response.sendRedirect("toChangePassword.do");
        }else{
            selfService.changePassword(member.getId(),password1);
            response.getWriter().print("<script type=\"text/javascript\">parent.location.href=\"../logout.do?s1=修改密码成功\"</script>");
        }
    }

    //注册
    public void loginAdd(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        String account = request.getParameter("account");
        Member m = memberService.getById(id);
        Member m2 = memberService.getByAccount(account);
        if (id.length()!=18){
            request.setAttribute("message","身份证错误");
            request.getRequestDispatcher("login_1.jsp").forward(request,response);
        }else if (m!=null || m2!=null){
            request.setAttribute("message","该用户已存在");
            request.getRequestDispatcher("login_1.jsp").forward(request,response);
        }else {
            String name = request.getParameter("name");
            String sex = request.getParameter("sex");
            String password = request.getParameter("password");

            if (name.equals("") || password.equals("") || account.equals("")){
                request.setAttribute("message","文本框不能为空");
                request.getRequestDispatcher("login_1.jsp").forward(request,response);
            }else {
                Member member = new Member();
                member.setId(id);
                member.setName(name);
                member.setSex(sex);
                member.setAccount(account);
                member.setPassword(password);
                member.setIdentity("会员");
                member.setRoomId(null);
                memberService.add(member);

                response.sendRedirect("login.jsp");
            }
        }
    }
}
