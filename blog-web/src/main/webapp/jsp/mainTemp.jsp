<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title id="blog-title">${pageTitle }</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/blog.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/pagestyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/background.css">
    <link href="${pageContext.request.contextPath}/static/images/favicon.ico" rel="SHORTCUT ICON">
    <script src="${pageContext.request.contextPath}/static/bootstrap3/js/jquery-1.11.2.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/bootstrap3/js/bootstrap.min.js"></script>

    <style type="text/css">
        body {
            color: #0E2D5F;
            font-family: 'Quicksand', sans-serif;
        }
    </style>
</head>
<body>
<div class="father">
    <div class="container child">
        <jsp:include page="/jsp/foreground/common/head.jsp"/>
        <jsp:include page="/jsp/foreground/common/menu.jsp"/>
        <div class="row">
            <div class="col-sm-9">
                <jsp:include page="${mainPage }"></jsp:include>
            </div>
            <div class="col-sm-3">

                <div class="data_list">
                    <div class="data_list_title">
                        <img src="${pageContext.request.contextPath}/static/images/user_icon.png"/>
                        Master信息
                    </div>
                    <div class="user_image">
                        <img src="${pageContext.request.contextPath}/static/userImages/${blogger.imageName }"/>
                    </div>
                    <div class="nickName">${blogger.nickName }</div>
                    <div class="userSign">(${blogger.sign })</div>
                </div>

                <div class="data_list">
                    <div class="data_list_title">
                        <img src="${pageContext.request.contextPath}/static/images/byType_icon.png"/>
                        按日志类别
                    </div>
                    <div class="datas">
                        <ul>
                            <c:forEach var="blogTypeCount" items="${blogTypeCountList }">
                                <li><span><a
                                        href="${pageContext.request.contextPath}/index.html?typeId=${blogTypeCount.id }">${blogTypeCount.typeName }(${blogTypeCount.blogCount })</a></span>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>

                <div class="data_list">
                    <div class="data_list_title">
                        <img src="${pageContext.request.contextPath}/static/images/byDate_icon.png"/>
                        按日志日期
                    </div>
                    <div class="datas">
                        <ul>
                            <c:forEach var="blogCount" items="${blogCountList }">
                                <li><span><a
                                        href="${pageContext.request.contextPath}/index.html?releaseDateStr=${blogCount.releaseDateStr }">${blogCount.releaseDateStr }(${blogCount.blogCount })</a></span>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>

                <div class="data_list">
                    <div class="data_list_title">
                        <img src="${pageContext.request.contextPath}/static/images/link_icon.png"/>
                        友情链接
                    </div>
                    <div class="datas">
                        <ul>
                            <c:forEach var="link" items="${linkList }">
                                <li><span><a href="${link.linkUrl }" target="_blank">${link.linkName }</a></span></li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>

            </div>

        </div>
        <div style="width:300px;margin:0 auto;" align="center">

        </div>
        <div align="center"><p style="color:#939393;margin-bottom:0px;">Copyright &copy; 2019 chenjianlink All Rights Reserved.</p>
            <a href="https://www.revolvermaps.com/livestats/0hyct6rs8lt/" target="_blank"><img
                    src="//ra.revolvermaps.com/w/3/s/a/10/0/2/ffffff/010020/aa0000/0hyct6rs8lt.png" alt="Stats"
                    style="border:0;"></a>
        </div>
    </div>

</div>

<div class="slideshow">
    <div class="slideshow-image"
         style="background-image: url('${pageContext.request.contextPath}/static/images/background/background.jpg')"></div>
    <div class="slideshow-image"
         style="background-image: url('${pageContext.request.contextPath}/static/images/background/background2.jpg')"></div>
    <div class="slideshow-image"
         style="background-image: url('${pageContext.request.contextPath}/static/images/background/background3.jpg')"></div>
    <div class="slideshow-image"
         style="background-image: url('${pageContext.request.contextPath}/static/images/background/background4.jpg')"></div>
</div>

</body>
</html>