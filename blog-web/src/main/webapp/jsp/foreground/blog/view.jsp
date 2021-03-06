<script type="text/javascript"
        src="${pageContext.request.contextPath}/static/ueditor/third-party/SyntaxHighlighter/shCore.js"></script>
<link rel="stylesheet"
      href="${pageContext.request.contextPath}/static/ueditor/third-party/SyntaxHighlighter/shCoreDefault.css">
<link rel="stylesheet"
      href="${pageContext.request.contextPath}/static/css/emoji.css">
<link rel="stylesheet"
      href="${pageContext.request.contextPath}/static/css/jquery.emoji.css">
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
        var userName = $("#userName").val().replace(/(^\s*)|(\s*$)/g, "");
        var content = $("#editor").html();
        var imageCode = $("#imageCode").val();
        if (userName == null || userName == '') {
            alert("请输入您的名称！");
        } else if (content == null || content == '') {
            alert("请输入评论内容！");
        } else if (imageCode == null || imageCode == '') {
            alert("请填写验证码！");
        } else {
            $.post("${pageContext.request.contextPath}/comment/save.do", {
                'userName': userName,
                'content': content,
                'imageCode': imageCode,
                'blog.id': '${blog.id}'
            }, function (result) {
                if (result.success) {
                    resetValue();
                    alert("评论已提交成功，审核通过后显示！");
                } else {
                    alert(result.errorInfo);
                    loadimage();
                }
            }, "json");
        }
    }

    // 重置数据
    function resetValue() {
        $("#userName").val("");
        $("#imageCode").val("");
        $("#editor").html("");
    }

    function showOtherComment() {
        $('.otherComment').show();
    }
</script>
<div class="data_list">
    <div class="data_list_title">
        <img src="${pageContext.request.contextPath}/static/images/blog_show_icon.png"/>
        日志信息
    </div>
    <div style="padding-left:6%;padding-right:6%">
        <div class="blog_title"><h3><strong>${blog.title }</strong></h3></div>
        <div style="padding: 10px 33% 20px 35%;">
            <div class="bdsharebuttonbox"><a href="#" class="bds_more" data-cmd="more"></a><a href="#"
                                                                                              class="bds_weixin"
                                                                                              data-cmd="weixin"
                                                                                              title="分享到微信"></a><a
                    href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a><a href="#" class="bds_tsina"
                                                                                       data-cmd="tsina"
                                                                                       title="分享到新浪微博"></a><a href="#"
                                                                                                              class="bds_sqq"
                                                                                                              data-cmd="sqq"
                                                                                                              title="分享到QQ好友"></a><a
                    href="#" class="bds_tieba" data-cmd="tieba" title="分享到百度贴吧"></a></div>
            <script>window._bd_share_config = {
                "common": {
                    "bdSnsKey": {},
                    "bdText": "",
                    "bdMini": "2",
                    "bdMiniList": false,
                    "bdPic": "",
                    "bdStyle": "1",
                    "bdSize": "24"
                },
                "share": {},
                "image": {
                    "viewList": ["weixin", "qzone", "tsina", "sqq", "tieba"],
                    "viewText": "分享到：",
                    "viewSize": "24"
                },
                "selectShare": {
                    "bdContainerClass": null,
                    "bdSelectMiniList": ["weixin", "qzone", "tsina", "sqq", "tieba"]
                }
            };
            with (document) 0[(getElementsByTagName('head')[0] || body).appendChild(createElement('script')).src = 'https://www.chenjianlink.cn/static/api/js/share.js?v=89860593.js?cdnversion=' + ~(-new Date() / 36e5)];</script>
        </div>
        <div class="blog_info">
            发布时间：『 <fmt:formatDate value="${blog.releaseDate }" type="date" pattern="yyyy-MM-dd HH:mm"/>』&nbsp;&nbsp;日志类别：${blog.blogType.typeName}&nbsp;&nbsp;阅读(${blog.clickHit})
            评论(${blog.replyHit})
        </div>
        <div class="blog_keyWord">
            <font><strong>关键字：</strong></font>
            <c:choose>
                <c:when test="${keyWords==null}">
                    &nbsp;&nbsp;无
                </c:when>
                <c:otherwise>
                    <c:forEach var="keyWord" items="${keyWords }">
                        &nbsp;&nbsp;<a href="${pageContext.request.contextPath}/blog/query.html?query=${keyWord}" target="_blank">${keyWord }</a>&nbsp;&nbsp;
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </div>
        <div class="blog_content">
            ${blog.content }
        </div>
        <div class="blog_lastAndNextPage" style="font-size: 0.8em">
            <div>
                上一篇:<c:choose>
                <c:when test="${empty pre}">木有了</c:when>
                <c:otherwise><a
                        href="${pageContext.request.contextPath}/blog/articles/${pre.id}.html"
                        target="_blank">${pre.title}</a></c:otherwise>
            </c:choose>
            </div>
            <div>
                下一篇:<c:choose>
                <c:when test="${empty next}">木有了</c:when>
                <c:otherwise><a
                        href="${pageContext.request.contextPath}/blog/articles/${next.id}.html"
                        target="_blank">${next.title}</a></c:otherwise>
            </c:choose>
            </div>
        </div>
    </div>
</div>
<div class="data_list">
    <div class="data_list_title">
        <img src="${pageContext.request.contextPath}/static/images/publish_comment_icon.png"/>
        发表评论
    </div>
    <div class="publish_comment">
        <div style="padding-top: 10px;padding-left: 10px;">
            您的名称:<input type="text" id="userName" name="userName" size="20" placeholder="请填写您的昵称...">
        </div>
        <div style="padding-top: 10px;padding-left: 10px;">
            您的评论:
            <div id="editor" name="editor" contenteditable="true" data-placeholder="来吐槽两句吧"></div>
            <button id="btn" class="btn btn-sm btn-default">:)</button>
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
            <button class="btn btn-primary" type="button" onclick="submitData()">发表评论</button>
        </div>
        </form>
    </div>
</div>
<div class="data_list">
    <div class="data_list_title">
        <img src="${pageContext.request.contextPath}/static/images/comment_icon.png"/>
        评论信息
        <c:if test="${commentList.size()>10}">
            <a href="javascript:showOtherComment()" style="float: right;padding-right: 40px;">显示所有评论</a>
        </c:if>
    </div>
    <div class="commentDatas">
        <c:choose>
            <c:when test="${commentList.size()==0}">
                还没有评论,快来抢沙发
            </c:when>
            <c:otherwise>
                <c:forEach var="comment" items="${commentList }" varStatus="status">
                    <c:choose>
                        <c:when test="${status.index<10 }">
                            <div class="comment">
                                <span><font>${status.index+1 }楼&nbsp;&nbsp;&nbsp;&nbsp;${comment.userName }：</font>${comment.content }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[&nbsp;<fmt:formatDate
                                        value="${comment.commentDate }" type="date" pattern="yyyy-MM-dd HH:mm"/>&nbsp;]</span>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="otherComment">
                                <div class="comment">
                                    <span><font>${status.index+1 }楼&nbsp;&nbsp;&nbsp;&nbsp;${comment.userName }：</font>${comment.content }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[&nbsp;<fmt:formatDate
                                            value="${comment.commentDate }" type="date" pattern="yyyy-MM-dd HH:mm"/>&nbsp;]</span>
                                </div>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </div>
</div>
<script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery.emoji.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/emoji.list.js"></script>
<script>
    window.onload = function () {
        $("#editor").emoji({
            button: "#btn",
            showTab: false,
            animation: 'slide',
            basePath: '${pageContext.request.contextPath}/static/images/emoji',
            icons: emojiLists   // 注：详见 js/emoji.list.js
        })
    }
</script>