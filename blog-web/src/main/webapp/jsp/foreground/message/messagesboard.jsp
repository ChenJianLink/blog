<script type="text/javascript"
        src="${pageContext.request.contextPath}/static/ueditor/third-party/SyntaxHighlighter/shCore.js"></script>
<link rel="stylesheet"
      href="${pageContext.request.contextPath}/static/ueditor/third-party/SyntaxHighlighter/shCoreDefault.css">
<script type="text/javascript">
    SyntaxHighlighter.all();
</script>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<script type="text/javascript">
    function loadimage() {
        document.getElementById("randImage").src = "${pageContext.request.contextPath}/image.html?" + Math.random();
    }

    function submitData() {
        var userName = $("#userName").val();
        var content = $("#content").val();
        var imageCode = $("#imageCode").val();
        if (userName == null || userName == '') {
            alert("请输入您的名称！");
        } else if (content == null || content == '') {
            alert("请输入留言内容！");
        } else if (imageCode == null || imageCode == '') {
            alert("请填写验证码！");
        } else {
            $.post("${pageContext.request.contextPath}/message/save.do", {
                'userName': userName,
                'content': content,
                'imageCode': imageCode
            }, function (result) {
                if (result.success) {
                    window.location.reload();
                    alert("留言成功,审核后显示");
                } else {
                    alert(result.errorInfo);
                    loadimage();
                }
            }, "json");
        }
    }

</script>
<div class="data_list">
    <div class="data_list_title">
        <img src="${pageContext.request.contextPath}/static/images/leavemessage.png"/>
        留言
    </div>
    <div class="publish_comment">
        <div style="padding-top: 10px;padding-left: 10px;">
            您的名称:<input type="text" id="userName" name="userName" size="20" placeholder="请填写您的昵称...">
        </div>
        <div style="padding-top: 10px;padding-left: 10px;">
            您的留言:<textarea style="width: 100%;resize: none;" rows="3" id="content" name="content"
                           placeholder="来说两句吧..."></textarea>
        </div>
        <div class="verCode">
            验证码：<input type="text" value="${imageCode }" name="imageCode" id="imageCode" size="10"
                       onkeydown="if(event.keyCode==13)form1.submit()"/>&nbsp;<img onclick="javascript:loadimage();"
                                                                                   title="换一张试试" name="randImage"
                                                                                   id="randImage"
                                                                                   src="${pageContext.request.contextPath}/image.html"
                                                                                   width="60" height="20" border="1"
                                                                                   align="absmiddle">
        </div>
        <div class="publishButton">
            <button class="btn btn-primary" type="button" onclick="submitData()">发表</button>
        </div>
        </form>
    </div>
</div>
<div class="data_list">
    <div class="data_list_title">
        <img src="${pageContext.request.contextPath}/static/images/messages.png"/>
        留言板
    </div>
    <div class="commentDatas">
        <c:choose>
            <c:when test="${messageList.size()==0}">
                暂无留言
            </c:when>
            <c:otherwise>
                <c:forEach var="message" items="${messageList }" varStatus="status">
                    <div class="comment">
                        <span><font>${status.index+1 }楼&nbsp;&nbsp;&nbsp;&nbsp;${message.userName }：</font>${message.content }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[&nbsp;<fmt:formatDate
                                value="${message.leaveMessageDate }" type="date"
                                pattern="yyyy-MM-dd HH:mm"/>&nbsp;]</span>
                    </div>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </div>
</div>