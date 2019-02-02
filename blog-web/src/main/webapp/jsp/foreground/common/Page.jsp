<%--
  Created by IntelliJ IDEA.
  User: chenjian
  Date: 19-2-1
  Time: 上午11:43
  分页页面.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<li><a href="${page.url}&page=1">首页</a></li>
<li class="button"><a
        <c:if test="${page.currentPage <= 1 }">class="disabled"</c:if>
        href="${page.url}&page=${page.currentPage-1}">上一页</a></li>
<%--计算begin和end --%>
<c:choose>
    <%--总页数不足10 --%>
    <c:when test="${page.totalPage<=10 }">
        <c:set var="begin" value="1"/>
        <c:set var="end" value="${page.totalPage }"/>
    </c:when>
    <%--总页数大于10 --%>
    <c:otherwise>
        <c:set var="begin" value="${page.currentPage - 5 }"/>
        <c:set var="end" value="${page.currentPage + 4 }"/>
        <%--头溢出处理 --%>
        <c:if test="${begin < 1}">
            <c:set var="begin" value="1"/>
            <c:set var="end" value="10"/>
        </c:if>
        <%--尾溢出处理 --%>
        <c:if test="${end > page.totalPage }">
            <c:set var="begin" value="${page.totalPage-9}"/>
            <c:set var="end" value="${page.totalPage}"/>
        </c:if>
    </c:otherwise>
</c:choose>
<%--循环遍历页码列表 --%>
<c:forEach var="i" begin="${begin}" end="${end}">
    <c:choose>
        <c:when test="${i eq page.currentPage}">
            <li><a class="current">${i}</a></li>
        </c:when>
        <c:otherwise>
            <li><a href="${page.url}&page=${i}">${i}</a></li>
        </c:otherwise>
    </c:choose>
</c:forEach>
<li class="button"><a
        <c:if test="${page.currentPage >= page.totalPage }">class="disabled"</c:if>
        href="${page.url }&page=${page.currentPage + 1}">下一页</a>
</li>
<%--totalPage若为0，则totalPage为1--%>
<c:choose>
    <c:when test="${page.totalPage > 0}">
        <li><a href="${page.url }&page=${page.totalPage}">尾页</a></li>
    </c:when>
    <c:otherwise>
        <li><a href="${page.url }&page=1">尾页</a></li>
    </c:otherwise>
</c:choose>