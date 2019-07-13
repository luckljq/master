<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=8" >
    <title>编辑房间</title>
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
                <span class="name">编辑房间</span>
            </div>
            <div class="space_hx">&nbsp;</div>
            <form action="edit.do" method="post" name="addForm">
                <div class="xjhy">
                    <!--高级配置-->
                    <ul class="hypz gjpz clearfix">
                        <li class="clearfix">
                            <span class="title"></span>
                            <div class="li_r">
                                <h1 style="color: red">${requestScope.message}</h1>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">编号：</span>
                            <div class="li_r">
                                ${LIST.roomId}
                                <input class="chang" name="roomId" type="hidden" value="${LIST.roomId}"/>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">类型：</span>
                            <div class="li_r">
                                <select name="roomType">
                                    <c:if test="${LIST.roomType=='大床房'}">
                                        <option value="大床房" selected="selected">大床房</option>
                                        <option value="标间">标间</option>
                                    </c:if>
                                    <c:if test="${LIST.roomType=='标间'}">
                                        <option value="大床房" selected="selected">大床房</option>
                                        <option value="标间"  selected="selected">标间</option>
                                    </c:if>
                                </select>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">价格：</span>
                            <div class="li_r">
                                <input class="chang" name="price" type="text" value="${LIST.price}"/>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">描述：</span>
                            <div class="li_r">
                                <input class="chang" name="diction" type="text"value="${LIST.diction}"/>
                            </div>
                        </li>
                        <li class="tj_btn">
                            <a href="javascript:history.go(-1);" class="back">返回</a>
                            <a href="javascript:addForm.submit();">保存</a>
                        </li>
                    </ul>
                    <!--高级配置-->
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
