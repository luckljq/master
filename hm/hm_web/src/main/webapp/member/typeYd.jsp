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
            <table cellpadding="0" cellspacing="0" class="list_hy">
                <tr>
                    <th><a href="type.do?roomType=${sessionScope.roomType}" class="btn">所有空房</a></th>
                    <th><a href="floor.do?floor=1&roomType=${sessionScope.roomType}" class="btn">一楼空房</a></th>
                    <th><a href="floor.do?floor=2&roomType=${sessionScope.roomType}" class="btn">二楼空房</a></th>
                    <th><a href="floor.do?floor=3&roomType=${sessionScope.roomType}" class="btn">三楼空房</a></th>
                    <th><a href="floor.do?floor=4&roomType=${sessionScope.roomType}" class="btn">四楼空房</a></th>
                    <th><a href="floor.do?floor=5&roomType=${sessionScope.roomType}" class="btn">五楼空房</a>
                    </th>
                </tr>
            </table>
            <table cellpadding="0" cellspacing="0" class="list_hy">
                <tr>
                    <th scope="col">编号</th>
                    <th scope="col">状态</th>
                    <th scope="col">类型</th>
                    <th scope="col">价格</th>
                    <th scope="col">详情</th>
                    <th scope="col">操作</th>
                </tr>
                <c:forEach items="${LIST}" var="dep">
                    <tr>
                        <td>${dep.roomId}</td>
                        <td>${dep.state}</td>
                        <td>${dep.roomType}</td>
                        <td>${dep.price}</td>
                        <td>${dep.diction}</td>
                        <td><a href="../member/toYd.do?roomId=${dep.roomId}" class="btn">预定</a></td>
                    </tr>
                </c:forEach>
            </table>
            <!--列表-->
        </div>
        <!--会议列表-->
    </div>
</div>
</body>
</html>
