<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>已预定房间</title>
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
                <span class="name">已预定房间</span>
            </div>
            <div class="space_hx">&nbsp;</div>
            <!--列表-->
            <table cellpadding="0" cellspacing="0" class="list_hy">
                <tr>
                    <th scope="col">房间</th>
                    <th scope="col">类型</th>
                    <th scope="col">价格</th>
                    <th scope="col">详情</th>
                    <th scope="col">操作</th>
                </tr>
                    <tr>
                        <td>${LIST.roomId}</td>
                        <td>${LIST.roomType}</td>
                        <td>${LIST.price}</td>
                        <td>${LIST.diction}</td>
                        <th><a href="javascript:history.go(-1);" class="btn">返回</a>
                            <a href="outYd.do?" class="btn">取消预定</a>
                    </tr>
            </table>
            <!--列表-->
        </div>
        <!--会议列表-->
    </div>
</div>
</body>
</html>
