<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>房间列表</title>
    <link rel="stylesheet" type="text/css" href="../css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../css/thems.css">
    <script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function(){
            //自适应屏幕宽度
            window.onresize=function(){ location=location };

            var main_h = $(window).height();
            $('.hy_list').css('height',main_h-45+'px');

            var search_w = $(window).width()-40;
            $('.search').css('width',search_w+'px');
            //$('.list_hy').css('width',search_w+'px');
        });
    </script>
    <!--框架高度设置-->
</head>

<body onLoad="Resize();">
<div id="right_ctn">
    <div class="right_m">
        <div class="hy_list">
            <div class="box_t">
                <span class="name">房间列表</span>
            </div>
            <div class="space_hx">&nbsp;</div>
            <!--列表-->
            <h1 style="font-size: 25px">商务套房</h1>

            <img src="../images/taofang.png" height="500" width="700">
            <br>
            <h1 style="font-size: 25px">简约套房</h1>
            <img src="../images/taofang2.png" height="500" width="700">
            <br>
            <h1 style="font-size: 25px">大窗套房</h1>
            <img src="../images/taofang3.png" height="500" width="700">
            <!--列表-->
        </div>
        <!--会议列表-->
    </div>
</div>
</body>
</html>
