<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <li class="now">
            <div class="nav_m">
                <span><a>登记入住</a></span>
                <i>&nbsp;</i>
            </div>
            <ul class="erji">
                <li>
                    <span><a href="room/type.do?roomType=大床房" target="main">大床</a></span>
                </li>
                <li>
                    <span><a href="room/type.do?roomType=标间" target="main">套房</a></span>
                </li>
                <li>
                    <span><a href="room/yd.do" target="main">已预定</a></span>
                </li>
                <li>
                    <span><a href="room/list.do" target="main">所有房间</a></span>
                </li>
            </ul>
        </li>
        <li>
            <div class="nav_m">
                <span><a>信息管理</a></span>
                <i>&nbsp;</i>
            </div>
            <ul class="erji">
                <li>
                    <span><a href="inRoom/list.do" target="main">客人列表</a></span>
                </li>
                <li>
                    <span><a href="log/list.do" target="main">历史记录</a></span>
                </li>
            </ul>
        </li>
        <li>
            <div class="nav_m">
                <span><a>房间管理</a></span>
                <i>&nbsp;</i>
            </div>
            <ul class="erji">
                <li>
                    <span><a href="room/editList.do" target="main">编辑房间</a></span>
                </li>
                <li>
                    <span><a href="room/toAddRoom.do" target="main">增加房间</a></span>
                </li>
            </ul>
        </li>
        <li>
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
