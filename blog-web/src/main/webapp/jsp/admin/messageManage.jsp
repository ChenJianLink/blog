<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>留言管理页面</title>
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


        function deleteMessage() {
            var selectedRows = $("#dg").datagrid("getSelections");
            if (selectedRows.length == 0) {
                $.messager.alert("系统提示", "请选择要删除的留言！");
                return;
            }
            var strIds = [];
            for (var i = 0; i < selectedRows.length; i++) {
                strIds.push(selectedRows[i].id);
            }
            var ids = strIds.join(",");
            $.messager.confirm("系统提示", "您确定要删除这<font color=red>" + selectedRows.length + "</font>条留言吗？", function (r) {
                if (r) {
                    $.post("${pageContext.request.contextPath}/admin/message/delete.do", {ids: ids}, function (result) {
                        if (result.success) {
                            $.messager.alert("系统提示", "留言已成功删除！");
                            $("#dg").datagrid("reload");
                        } else {
                            $.messager.alert("系统提示", "留言删除失败！");
                        }
                    }, "json");
                }
            });
        }

        function formatState(val, row) {
            if (val == 0) {
                return "待审核";
            } else if (val == 1) {
                return "审核通过";
            } else if (val == 2) {
                return "审核未通过";
            }
        }

    </script>
</head>
<body style="margin: 1px">
<table id="dg" title="留言管理" class="easyui-datagrid"
       fitColumns="true" pagination="true" rownumbers="true"
       url="${pageContext.request.contextPath}/admin/message/list.do" fit="true" toolbar="#tb">
    <thead>
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="id" width="20" align="center">编号</th>
        <th field="userIp" width="100" align="center">用户IP</th>
        <th field="userName" width="100" align="center">留言者名称</th>
        <th field="content" width="220" align="center">留言内容</th>
        <th field="leaveMessageDate" width="80" align="center" formatter="BLOG.formatDateTime">留言日期</th>
        <th field="state" width="50" align="center" formatter="formatState">留言状态</th>
    </tr>
    </thead>
</table>
<div id="tb">
    <div>
        <a href="javascript:deleteMessage()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
    </div>
</div>


</body>
</html>