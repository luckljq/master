<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=8" >
    <title>人员登记</title>
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
                <span class="name">人员登记</span>
            </div>
            <div class="space_hx">&nbsp;</div>
            <form action="inRoom.do" method="post" name="addForm">
                <div class="xjhy">
                    <!--高级配置-->
                    <ul class="hypz gjpz clearfix">
                        <li class="clearfix">
                            <span class="title"></span>
                            <div class="li_r">
                                <h1 style="color: red">${requestScope.message3}</h1>
                            </div>
                        </li>

                        <li class="clearfix">
                            <span class="title">房间：</span>
                            <div class="li_r">${requestScope.roomId}</div>
                            <input class="chang" name="roomId" type="hidden" value="${requestScope.roomId}"/>
                        </li>

                        <li class="clearfix">
                            <span class="title">姓名：</span>
                            <div class="li_r">
                                <input class="chang" name="name" type="text"/>
                                <i>*</i>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">身份证号：</span>
                            <div class="li_r">
                                <input class="chang" name="id" type="text"/><i>*</i>
                                <h1 style="color: red">${requestScope.message}</h1>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">性别：</span>
                            <div class="li_r">
                                <span class="radio">
                                <input name="sex" type="radio" value="男" checked="checked"/>
                                <em>男</em>
                                </span>
                                <span class="radio">
                                <input name="sex" type="radio" value="女"/>
                                <em>女</em>
                                </span>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">备注：</span>
                            <div class="li_r">
                                <input class="chang" name="diction" type="text"/>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title"></span>
                            <div class="li_r">
                                <h1 style="color: red">客人2，一人入住可不填</h1>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">姓名：</span>
                            <div class="li_r">
                                <input class="chang" name="name2" type="text"/>
                                <i>*</i>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">身份证号：</span>
                            <div class="li_r">
                                <input class="chang" name="id2" type="text"/><i>*</i>
                                <h1 style="color: red">${requestScope.message2}</h1>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">性别：</span>
                            <div class="li_r">
                                <span class="radio">
                                <input name="sex2" type="radio" value="男" checked="checked"/>
                                <em>男</em>
                                </span>
                                <span class="radio">
                                <input name="sex2" type="radio" value="女"/>
                                <em>女</em>
                                </span>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">备注：</span>
                            <div class="li_r">
                                <input class="chang" name="diction2" type="text"/>
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
