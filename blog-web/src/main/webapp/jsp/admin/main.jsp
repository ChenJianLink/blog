<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>局外人之个人空间后台管理页面</title>
    <link href="${pageContext.request.contextPath}/static/images/favicon.ico" rel="SHORTCUT ICON">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/atom.css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">

        var url;

        function openTab(text, url, iconCls) {
            if ($("#tabs").tabs("exists", text)) {
                $("#tabs").tabs("select", text);
            } else {
                var content = "<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='${pageContext.request.contextPath}/admin/" + url + "'></iframe>";
                $("#tabs").tabs("add", {
                    title: text,
                    iconCls: iconCls,
                    closable: true,
                    content: content
                });
            }
        }


        function openPasswordModifyDialog() {
            $("#dlg").dialog("open").dialog("setTitle", "修改密码");
            url = "${pageContext.request.contextPath}/admin/blogger/modifyPassword.do?id=${currentUser.id}";
        }

        function modifyPassword() {
            $("#fm").form("submit", {
                url: url,
                onSubmit: function () {
                    var newPassword = $("#newPassword").val();
                    var newPassword2 = $("#newPassword2").val();
                    if (!$(this).form("validate")) {
                        return false;
                    }
                    if (newPassword != newPassword2) {
                        $.messager.alert("系统提示", "确认密码输入错误！");
                        return false;
                    }
                    return true;
                },
                success: function (result) {
                    var result = eval('(' + result + ')');
                    if (result.success) {
                        $.messager.alert("系统提示", "密码修改成功，下一次登录生效！");
                        resetValue();
                        $("#dlg").dialog("close");
                    } else {
                        $.messager.alert("系统提示", "密码修改失败！");
                        return;
                    }
                }
            });
        }

        function closePasswordModifyDialog() {
            resetValue();
            $("#dlg").dialog("close");
        }

        function resetValue() {
            $("#oldPassword").val("");
            $("#newPassword").val("");
            $("#newPassword2").val("");
        }

        function logout() {
            $.messager.confirm("系统提示", "您确定要退出系统吗？", function (r) {
                if (r) {
                    window.location.href = '${pageContext.request.contextPath}/admin/blogger/logout.do';
                }
            });
        }

        function refreshSystem() {
            $.post("${pageContext.request.contextPath}/admin/system/refreshSystem.do", {}, function (result) {
                if (result.success) {
                    $.messager.alert("系统提示", "已成功刷新系统缓存！");
                } else {
                    $.messager.alert("系统提示", "刷新系统缓存失败！");
                }
            }, "json");
        }

    </script>
</head>
<body class="easyui-layout">
<div region="north" style="height: 78px;background-color: #E0ECFF;overflow:hidden">
    <table style="padding: 5px" width="100%">
        <tr>
            <td width="50%">
                <img style="margin-top: -20px;" alt="logo"
                     src="${pageContext.request.contextPath}/static/images/logo-admin.png">
            </td>
            <td style="padding-bottom: 176px" valign="bottom" align="right" width="50%">
                <font size="3">&nbsp;&nbsp;<strong>欢迎：</strong>${currentUser.userName }</font>
            </td>
        </tr>
    </table>
</div>
<div region="center">
    <div class="easyui-tabs" fit="true" border="false" id="tabs">
        <div title="首页" data-options="iconCls:'icon-home'" style="background: #1A2A3A">
            <div style="width: 500px; height: 500px;position: absolute;left: 28%">
                <svg class="atom"  viewBox="0 0 100 100">
                    <defs>
                        <filter id="blur" x="-10" y="-10" width="120" height="120">
                            <feGaussianBlur in="SourceGraphic" stdDeviation=".4" />
                        </filter>
                        <filter id="blur2" x="-10" y="-10" width="120" height="120">
                            <feGaussianBlur in="SourceGraphic" stdDeviation="3" />
                        </filter>
                    </defs>
                    <g filter="url(#blur2)">
                        <circle class="kern" cx="50" cy="50" r="2" />
                    </g>
                    <circle class="kern" cx="50" cy="50" r="2" />
                    <g class="lines">
                        <path class="" d="M  57.5,50 57.39,55.21 57.05,60.26 56.5,65 55.75,69.28 54.82,72.98 53.75,75.98 52.57,78.19 51.3,79.54 50,80 48.7,79.54 47.43,78.19 46.25,75.98 45.18,72.98 44.25,69.28 43.5,65 42.95,60.26 42.61,55.21 42.5,50 42.61,44.79 42.95,39.74 43.5,35 44.25,30.72 45.18,27.02 46.25,24.02 47.43,21.81 48.7,20.46 50,20 51.3,20.46 52.57,21.81 53.75,24.02 54.82,27.02 55.75,30.72 56.5,35 57.05,39.74 57.39,44.79 57.5,50"></path>
                        <path class="" d="M  53.75,56.5 49.18,59 44.64,61.23 40.26,63.13 36.17,64.62 32.51,65.67 29.38,66.24 26.87,66.32 25.07,65.9 24.02,65 23.76,63.64 24.3,61.87 25.63,59.74 27.69,57.32 30.43,54.67 33.76,51.88 37.59,49.03 41.8,46.21 46.25,43.5 50.82,41 55.36,38.77 59.74,36.88 63.83,35.38 67.49,34.33 70.62,33.76 73.13,33.68 74.93,34.1 75.98,35 76.24,36.36 75.7,38.13 74.38,40.26 72.31,42.68 69.57,45.33 66.24,48.12 62.41,50.97 58.2,53.79 53.75,56.5"></path>
                        <path class="" d="M  53.75,43.5 58.2,46.21 62.41,49.03 66.24,51.88 69.57,54.67 72.31,57.32 74.38,59.74 75.7,61.87 76.24,63.64 75.98,65 74.93,65.9 73.13,66.32 70.63,66.24 67.49,65.67 63.83,64.62 59.74,63.13 55.36,61.23 50.82,59 46.25,56.5 41.8,53.79 37.59,50.97 33.76,48.13 30.43,45.33 27.69,42.68 25.63,40.26 24.3,38.13 23.76,36.36 24.02,35 25.07,34.1 26.87,33.68 29.37,33.76 32.51,34.33 36.17,35.38 40.26,36.87 44.64,38.77 49.18,41 53.75,43.5"></path>
                    </g>
                    <g class="electronTails"  filter="url(#blur)" >
                        <path class="tail tail1" d="M  57.5,50 57.39,55.21 57.05,60.26 56.5,65 55.75,69.28 54.82,72.98 53.75,75.98 52.57,78.19 51.3,79.54 50,80 48.7,79.54 47.43,78.19 46.25,75.98 45.18,72.98 44.25,69.28 43.5,65 42.95,60.26 42.61,55.21 42.5,50 42.61,44.79 42.95,39.74 43.5,35 44.25,30.72 45.18,27.02 46.25,24.02 47.43,21.81 48.7,20.46 50,20 51.3,20.46 52.57,21.81 53.75,24.02 54.82,27.02 55.75,30.72 56.5,35 57.05,39.74 57.39,44.79 57.5,50"></path>
                        <path class="tail tail2" d="M  53.75,56.5 49.18,59 44.64,61.23 40.26,63.13 36.17,64.62 32.51,65.67 29.38,66.24 26.87,66.32 25.07,65.9 24.02,65 23.76,63.64 24.3,61.87 25.63,59.74 27.69,57.32 30.43,54.67 33.76,51.88 37.59,49.03 41.8,46.21 46.25,43.5 50.82,41 55.36,38.77 59.74,36.88 63.83,35.38 67.49,34.33 70.62,33.76 73.13,33.68 74.93,34.1 75.98,35 76.24,36.36 75.7,38.13 74.38,40.26 72.31,42.68 69.57,45.33 66.24,48.12 62.41,50.97 58.2,53.79 53.75,56.5"></path>
                        <path class="tail tail3" d="M  53.75,43.5 58.2,46.21 62.41,49.03 66.24,51.88 69.57,54.67 72.31,57.32 74.38,59.74 75.7,61.87 76.24,63.64 75.98,65 74.93,65.9 73.13,66.32 70.63,66.24 67.49,65.67 63.83,64.62 59.74,63.13 55.36,61.23 50.82,59 46.25,56.5 41.8,53.79 37.59,50.97 33.76,48.13 30.43,45.33 27.69,42.68 25.63,40.26 24.3,38.13 23.76,36.36 24.02,35 25.07,34.1 26.87,33.68 29.37,33.76 32.51,34.33 36.17,35.38 40.26,36.87 44.64,38.77 49.18,41 53.75,43.5"></path>
                    </g>
                    <g class="electrons">
                        <path class="electron electron1" d="M  57.5,50 57.39,55.21 57.05,60.26 56.5,65 55.75,69.28 54.82,72.98 53.75,75.98 52.57,78.19 51.3,79.54 50,80 48.7,79.54 47.43,78.19 46.25,75.98 45.18,72.98 44.25,69.28 43.5,65 42.95,60.26 42.61,55.21 42.5,50 42.61,44.79 42.95,39.74 43.5,35 44.25,30.72 45.18,27.02 46.25,24.02 47.43,21.81 48.7,20.46 50,20 51.3,20.46 52.57,21.81 53.75,24.02 54.82,27.02 55.75,30.72 56.5,35 57.05,39.74 57.39,44.79 57.5,50"></path>
                        <path class="electron electron2" d="M  53.75,56.5 49.18,59 44.64,61.23 40.26,63.13 36.17,64.62 32.51,65.67 29.38,66.24 26.87,66.32 25.07,65.9 24.02,65 23.76,63.64 24.3,61.87 25.63,59.74 27.69,57.32 30.43,54.67 33.76,51.88 37.59,49.03 41.8,46.21 46.25,43.5 50.82,41 55.36,38.77 59.74,36.88 63.83,35.38 67.49,34.33 70.62,33.76 73.13,33.68 74.93,34.1 75.98,35 76.24,36.36 75.7,38.13 74.38,40.26 72.31,42.68 69.57,45.33 66.24,48.12 62.41,50.97 58.2,53.79 53.75,56.5">
                        </path>
                        <path class="electron electron3" d="M  53.75,43.5 58.2,46.21 62.41,49.03 66.24,51.88 69.57,54.67 72.31,57.32 74.38,59.74 75.7,61.87 76.24,63.64 75.98,65 74.93,65.9 73.13,66.32 70.63,66.24 67.49,65.67 63.83,64.62 59.74,63.13 55.36,61.23 50.82,59 46.25,56.5 41.8,53.79 37.59,50.97 33.76,48.13 30.43,45.33 27.69,42.68 25.63,40.26 24.3,38.13 23.76,36.36 24.02,35 25.07,34.1 26.87,33.68 29.37,33.76 32.51,34.33 36.17,35.38 40.26,36.87 44.64,38.77 49.18,41 53.75,43.5"></path></g>
                </svg>
            </div>
            <div align="center" style="padding-top: 400px"><font color="#ff8c00" size="10">欢迎使用</font></div>
        </div>
    </div>
</div>
<div region="west" style="width: 200px" title="导航菜单" split="true">
    <div class="easyui-accordion" data-options="fit:true,border:false">
        <div title="常用操作" data-options="selected:true,iconCls:'icon-item'" style="padding: 10px">
            <a href="javascript:openTab('写博客','writeBlog.html','icon-writeblog')" class="easyui-linkbutton"
               data-options="plain:true,iconCls:'icon-writeblog'" style="width: 150px">写博客</a>
            <a href="javascript:openTab('评论审核','commentReview.html','icon-review')" class="easyui-linkbutton"
               data-options="plain:true,iconCls:'icon-review'" style="width: 150px">评论审核</a>
        </div>
        <div title="博客管理" data-options="iconCls:'icon-bkgl'" style="padding:10px;">
            <a href="javascript:openTab('写博客','writeBlog.html','icon-writeblog')" class="easyui-linkbutton"
               data-options="plain:true,iconCls:'icon-writeblog'" style="width: 150px;">写博客</a>
            <a href="javascript:openTab('博客信息管理','blogManage.html','icon-bkgl')" class="easyui-linkbutton"
               data-options="plain:true,iconCls:'icon-bkgl'" style="width: 150px;">博客信息管理</a>
        </div>
        <div title="博客类别管理" data-options="iconCls:'icon-bklb'" style="padding:10px">
            <a href="javascript:openTab('博客类别信息管理','blogTypeManage.html','icon-bklb')" class="easyui-linkbutton"
               data-options="plain:true,iconCls:'icon-bklb'" style="width: 150px;">博客类别信息管理</a>
        </div>
        <div title="评论管理" data-options="iconCls:'icon-plgl'" style="padding:10px">
            <a href="javascript:openTab('评论审核','commentReview.html','icon-review')" class="easyui-linkbutton"
               data-options="plain:true,iconCls:'icon-review'" style="width: 150px">评论审核</a>
            <a href="javascript:openTab('评论信息管理','commentManage.html','icon-plgl')" class="easyui-linkbutton"
               data-options="plain:true,iconCls:'icon-plgl'" style="width: 150px;">评论信息管理</a>
        </div>
        <div title="个人信息管理" data-options="iconCls:'icon-grxx'" style="padding:10px">
            <a href="javascript:openTab('修改个人信息','modifyInfo.html','icon-grxxxg')" class="easyui-linkbutton"
               data-options="plain:true,iconCls:'icon-grxxxg'" style="width: 150px;">修改个人信息</a>
        </div>
        <div title="系统管理" data-options="iconCls:'icon-system'" style="padding:10px">
            <a href="javascript:openTab('友情链接管理','linkManage.html','icon-link')" class="easyui-linkbutton"
               data-options="plain:true,iconCls:'icon-link'" style="width: 150px">友情链接管理</a>
            <a href="javascript:openPasswordModifyDialog()" class="easyui-linkbutton"
               data-options="plain:true,iconCls:'icon-modifyPassword'" style="width: 150px;">修改密码</a>
            <a href="javascript:refreshSystem()" class="easyui-linkbutton"
               data-options="plain:true,iconCls:'icon-refresh'" style="width: 150px;">刷新系统缓存</a>
            <a href="javascript:logout()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-exit'"
               style="width: 150px;">安全退出</a>
        </div>
    </div>
</div>
<div region="south" style="height: 25px;padding: 5px" align="center">

</div>

<div id="dlg" class="easyui-dialog" style="width:400px;height:200px;padding: 10px 20px"
     closed="true" buttons="#dlg-buttons">

    <form id="fm" method="post">
        <table cellspacing="8px">
            <tr>
                <td>用户名：</td>
                <td><input type="text" id="userName" name="userName" readonly="readonly"
                           value="${currentUser.userName }" style="width: 200px"/></td>
            </tr>
            <tr>
                <td>新密码：</td>
                <td><input type="password" id="newPassword" name="newPassword" class="easyui-validatebox"
                           required="true" style="width: 200px"/></td>
            </tr>
            <tr>
                <td>确认新密码：</td>
                <td><input type="password" id="newPassword2" name="newPassword2" class="easyui-validatebox"
                           required="true" style="width: 200px"/></td>
            </tr>
        </table>
    </form>
</div>

<div id="dlg-buttons">
    <a href="javascript:modifyPassword()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
    <a href="javascript:closePasswordModifyDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>

</body>
</html>