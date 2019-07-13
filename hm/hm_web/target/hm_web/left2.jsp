<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=8" >
    <title>左边导航</title>
    <link rel="stylesheet" type="text/css" href="css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
    <!--框架高度设置-->
    <script type="text/javascript">
        $(function(){
            $('.sidenav li').click(function(){
                $(this).siblings('li').removeClass('now');
                $(this).addClass('now');
            });

            $('.erji li').click(function(){
                $(this).siblings('li').removeClass('now_li');
                $(this).addClass('now_li');
            });

            var main_h = $(window).height();
            $('.sidenav').css('height',main_h+'px');
        })
    </script>
    <!--框架高度设置-->
</head>

<body>
<div id="left_ctn">
    <ul class="sidenav">
        <li>
            <div class="nav_m">
                <span><a>预定系统</a></span>
                <i>&nbsp;</i>
            </div>
            <ul class="erji">
                <li>
                    <span><a href="member/dc.jsp" target="main">大床预览</a></span>
                </li>
                    <li>
                        <span><a href="room/type.do?roomType=大床房" target="main">预定大床</a></span>
                    </li>
                <li>
                    <span><a href="member/tf.jsp" target="main">套房预览</a></span>
                </li>
                    <li>
                        <span><a href="room/type.do?roomType=标间" target="main">预定套房</a></span>
                    </li>
                <li>
                    <span><a href="member/toShowYd.do" target="main">已预定</a></span>
                </li>
            </ul>
        </li>
        <li class="now">
            <div class="nav_m">
                <span><a>个人中心</a></span>
                <i>&nbsp;</i>
            </div>
            <ul class="erji">
                <li>
                    <span><a href="self/info.do" target="main">个人信息</a></span>
                </li>
                <li>
                    <span><a href="member/toEdit.do" target="main">修改信息</a></span>
                </li>
                <li>
                    <span><a href="self/toChangePassword.do" target="main">修改密码</a></span>
                </li>
            </ul>
        </li>
        <li>
            <div class="nav_m">
                <span><a href="logout.do" target="_top">退出系统</a></span>
            </div>
        </li>
    </ul>
</div>
</body>
</html>
