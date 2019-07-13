<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=8" >
    <title>预定房间</title>
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

            var main_w = $(window).width();
            $('.xjhy').css('width',main_w-40+'px');

        });
    </script>
</head>

<body onLoad="Resize();">
<div id="right_ctn">
    <div class="right_m">
        <div class="hy_list">
            <div class="box_t">
                <span class="name">预定房间</span>
            </div>
            <div class="space_hx">&nbsp;</div>
            <form action="yd.do" method="post" name="addForm">
                <div class="xjhy">
                    <!--高级配置-->
                    <ul class="hypz gjpz clearfix">
                    <c:if test="${USER.roomId==null}">
                        <li class="clearfix">
                            <h1 style="color: red">${requestScope.message}</h1>
                            <h1 style="color: red">${requestScope.message1}</h1>
                        </li>
                        <li class="clearfix">
                            <span class="title">房间：</span>
                            <div class="li_r">${requestScope.roomId}</div>
                            <input class="chang" name="roomId" type="hidden" value="${requestScope.roomId}"/>
                        </li>

                        <li class="clearfix">
                            <span class="title">姓名：</span>
                            <div class="li_r">${USER.name}</div>
                        </li>
                        <li class="clearfix">
                            <span class="title">身份证号：</span>
                            <div class="li_r">${USER.id}</div>
                        </li>
                        <li class="clearfix">
                            <span class="title">性别：</span>
                            <div class="li_r">${USER.sex}</div>
                        </li>
                        <li class="tj_btn">
                            <a href="javascript:history.go(-1);" class="back">返回</a>
                            <a href="javascript:addForm.submit();">确认</a>
                        </li>
                    </c:if>
                    <c:if test="${USER.roomId!=null}">
                        <li>
                        <h1>您已预定房间:${USER.roomId}</h1>
                        </li>
                    </c:if>
                    </ul>
                    <!--高级配置-->
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
