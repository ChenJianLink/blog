<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>日志管理页面</title>
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

        function formatBlogType(val, row) {
            return val.typeName;
        }

        function formatBlogState(val, row) {
            if (val == 2) {
                return "已发表";
            } else {
                return "草稿";
            }
        }

        function formatTitle(val, row) {
            if (row.state == 2) {
                return "<a target='_blank' href='${pageContext.request.contextPath}/blog/articles/" + row.id + ".html'>" + val + "</a>";
            } else {
                return val;
            }
        }

        function searchBlog() {
            $("#dg").datagrid('load', {
                "title": $("#s_title").val()
            });
        }

        function deleteBlog() {
            var selectedRows = $("#dg").datagrid("getSelections");
            if (selectedRows.length == 0) {
                $.messager.alert("系统提示", "请选择要删除的日志！");
                return;
            }
            var strIds = [];
            for (var i = 0; i < selectedRows.length; i++) {
                strIds.push(selectedRows[i].id);
            }
            var ids = strIds.join(",");
            $.messager.confirm("系统提示", "您确定要删除这<font color=red>" + selectedRows.length + "</font>篇日志吗？", function (r) {
                if (r) {
                    $.post("${pageContext.request.contextPath}/admin/blog/delete.do", {ids: ids}, function (result) {
                        if (result.success) {
                            $.messager.alert("系统提示", "日志已成功删除！");
                            $("#dg").datagrid("reload");
                        } else {
                            $.messager.alert("系统提示", "日志删除失败！");
                        }
                    }, "json");
                }
            });
        }


        function openBlogModifyTab() {
            var selectedRows = $("#dg").datagrid("getSelections");
            if (selectedRows.length != 1) {
                $.messager.alert("系统提示", "请选择一个要修改的日志！");
                return;
            }
            var row = selectedRows[0];
            window.parent.openTab('修改日志', 'modifyBlog.html?id=' + row.id, 'icon-writeblog');
        }

    </script>
</head>
<body style="margin: 1px">
<table id="dg" title="日志管理" class="easyui-datagrid"
       fitColumns="true" pagination="true" rownumbers="true"
       url="${pageContext.request.contextPath}/admin/blog/list.do" fit="true" toolbar="#tb">
    <thead>
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="id" width="30" align="center">编号</th>
        <th field="title" width="200" align="center" formatter="formatTitle">标题</th>
        <th field="releaseDate" width="50" align="center" formatter="BLOG.formatDateTime">发布日期</th>
        <th field="state" width="50" align="center" formatter="formatBlogState">日志状态</th>
        <th field="blogType" width="50" align="center" formatter="formatBlogType">日志类别</th>
    </tr>
    </thead>
</table>
<div id="tb">
    <div>
        <a href="javascript:openBlogModifyTab()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
        <a href="javascript:deleteBlog()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
    </div>
    <div>
        &nbsp;标题：&nbsp;<input type="text" id="s_title" size="20" onkeydown="if(event.keyCode==13) searchBlog()"/>
        <a href="javascript:searchBlog()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
    </div>
</div>
</body>
</html>