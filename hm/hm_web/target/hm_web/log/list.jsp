<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>记录列表</title>
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
                <span class="name">记录列表</span>
            </div>
            <div class="space_hx">&nbsp;</div>
            <!--列表-->
            <form action="searchById.do" method="post" name="addForm">
                <span class="title">身份证号</span>
                <input class="chang" name="id" type="text"/>
                <a href="javascript:addForm.submit();" class="btn">搜索</a>
            </form>
            <table cellpadding="0" cellspacing="0" class="list_hy">
                <tr>
                    <th scope="col">身份证</th>
                    <th scope="col">姓名</th>
                    <th scope="col">房间</th>
                    <th scope="col">入住时间</th>
                    <th scope="col">离开时间</th>
                </tr>
                <c:forEach items="${LIST}" var="dep">
                    <tr>
                        <td>${dep.id}</td>
                        <td>${dep.name}</td>
                        <td>${dep.roomId}</td>
                        <td><fmt:formatDate value="${dep.inTime}" pattern="yyyy-MM-dd HH:mm"/> </td>
                        <td><fmt:formatDate value="${dep.outTime}" pattern="yyyy-MM-dd HH:mm"/> </td>
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
