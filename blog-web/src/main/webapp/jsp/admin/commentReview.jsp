<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>评论审核管理页面</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/js/common.js"></script>
    <script type="text/javascript">

        function commentReview(state) {
            var selectedRows = $("#dg").datagrid("getSelections");
            if (selectedRows.length == 0) {
                $.messager.alert("系统提示", "请选择要审核的评论！");
                return;
            }
            var strIds = [];
            for (var i = 0; i < selectedRows.length; i++) {
                strIds.push(selectedRows[i].id);
            }
            var ids = strIds.join(",");
            $.messager.confirm("系统提示", "您确定要审核这<font color=red>" + selectedRows.length + "</font>条评论吗？", function (r) {
                if (r) {
                    $.post("${pageContext.request.contextPath}/admin/comment/review.do", {
                        ids: ids,
                        state: state
                    }, function (result) {
                        if (result.success) {
                            $.messager.alert("系统提示", "提交成功！");
                            $("#dg").datagrid("reload");
                        } else {
                            $.messager.alert("系统提示", "提交失败！");
                        }
                    }, "json");
                }
            });
        }


        function formatBlogTitle(val, row) {
            if (val == null) {
                return "<font color='red'>该日志已被删除！</font>";
            } else {
                return "<a target='_blank' href='${pageContext.request.contextPath}/blog/articles/" + val.id + ".html'>" + val.title + "</a>";
            }
        }

        function closeCommentDialog() {
            $("#dlg").dialog("close");
        }

        function openCommentViewDialog() {
            var selectedRows = $("#dg").datagrid("getSelections");
            if (selectedRows.length != 1) {
                $.messager.alert("系统提示", "请选择一条要查看的评论！");
                return;
            }
            var row = selectedRows[0];
            $("#dlg").dialog("open").dialog("setTitle", "查看评论");
            $("#fm").form("load", row);
        }

    </script>
</head>
<body style="margin: 1px">
<table id="dg" title="评论审核管理" class="easyui-datagrid"
       fitColumns="true" pagination="true" rownumbers="true"
       url="${pageContext.request.contextPath}/admin/comment/list.do?state=0" fit="true" toolbar="#tb">
    <thead>
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="id" width="20" align="center">编号</th>
        <th field="blog" width="100" align="center" formatter="formatBlogTitle">日志标题</th>
        <th field="userIp" width="100" align="center">用户IP</th>
        <th field="userName" width="50" align="center">评论者名称</th>
        <th field="content" width="220" align="center">评论内容</th>
        <th field="commentDate" width="80" align="center" formatter="BLOG.formatDateTime">评论日期</th>
    </tr>
    </thead>
</table>
<div id="tb">
    <div>
        <a href="javascript:openCommentViewDialog()" class="easyui-linkbutton" iconCls="icon-search"
           plain="true">查看评论</a>
        <a href="javascript:commentReview(1)" class="easyui-linkbutton" iconCls="icon-ok" plain="true">审核通过</a>
        <a href="javascript:commentReview(2)" class="easyui-linkbutton" iconCls="icon-no" plain="true">审核不通过</a>
    </div>
</div>

<div id="dlg" class="easyui-dialog" style="width:450px;height:260px;padding: 10px 20px"
     closed="true" buttons="#dlg-buttons">

    <form id="fm">
        <table cellspacing="8px">
            <tr>
                <td>评论者名称：</td>
                <td><input type="text" id="userName" name="userName" class="easyui-validatebox"
                           readonly="readonly"/></td>
            </tr>
            <tr>
                <td>评论内容：</td>
                <td><textarea style="width: 100%;resize: none;" rows="5" id="content" name="content"
                              class="easyui-validatebox"
                              readonly="readonly"></textarea></td>
            </tr>
        </table>
    </form>
</div>

<div id="dlg-buttons">
    <a href="javascript:closeCommentDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>

</body>
</html>