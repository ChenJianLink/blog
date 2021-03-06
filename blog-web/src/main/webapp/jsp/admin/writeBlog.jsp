<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>写日志页面</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath}/static/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath}/static/ueditor/ueditor.all.min.js"> </script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath}/static/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">
	
	function submitData(state){
		var title=$("#title").val();
		var blogTypeId=$("#blogTypeId").combobox("getValue");
		var content=UE.getEditor('editor').getContent();
		var keyWord=$("#keyWord").val().replace(/\s*/g,"");
		
		if(title==null || title==''){
			alert("请输入标题！");
		}else if(blogTypeId==null || blogTypeId==''){
			alert("请选择日志类别！");
		}else if(content==null || content==''){
			alert("请输入内容！");
		}else{
			$.post("${pageContext.request.contextPath}/admin/blog/save.do",{'title':title,'blogType.id':blogTypeId,'content':content,'searchContent':UE.getEditor('editor').getContentTxt(),'summary':UE.getEditor('editor').getContentTxt().substr(0,150),'keyWord':keyWord,'state':state},function(result){
				if (state == 2){
                    if(result.success){
                        alert("日志发布成功！");
                        resetValue();
                    }else{
                        alert("日志发布失败！");
                    }
				}else {
                    if(result.success){
                        alert("草稿保存成功！");
                        resetValue();
                    }else{
                        alert("草稿保存失败！");
                    }
				}

			},"json");
		}
	}
	
	// 重置数据
	function resetValue(){
		$("#title").val("");
		$("#blogTypeId").combobox("setValue","");
		UE.getEditor('editor').setContent("");
		$("#keyWord").val("");
	}
	
</script>
</head>
<body style="margin: 10px">
<div id="p" class="easyui-panel" title="编写日志" style="padding: 10px">
 	<table cellspacing="20px">
   		<tr>
   			<td width="80px">日志标题：</td>
   			<td><input type="text" id="title" name="title" style="width: 400px;"/></td>
   		</tr>
   		<tr>
   			<td>所属类别：</td>
   			<td>
   				<select class="easyui-combobox" style="width: 154px" id="blogTypeId" name="blogType.id" editable="false" panelHeight="auto" >
					<option value="">请选择日志类别...</option>
				    <c:forEach var="blogType" items="${blogTypeCountList }">
				    	<option value="${blogType.id }">${blogType.typeName }</option>
				    </c:forEach>			
                </select>
   			</td>
   		</tr>
   		<tr>
   			<td valign="top">日志内容：</td>
   			<td>
				   <script id="editor" type="text/plain" style="width:100%;height:500px;"></script>
   			</td>
   		</tr>
   		<tr>
   			<td>关键字：</td>
   			<td><input type="text" id="keyWord" name="keyWord" style="width: 400px;"/>&nbsp;(多个关键字中间用","隔开)</td>
   		</tr>
   		<tr>
   			<td></td>
   			<td>
   				<a href="javascript:submitData(1)" class="easyui-linkbutton" data-options="iconCls:'icon-submit'">保存草稿</a>&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="javascript:submitData(2)" class="easyui-linkbutton" data-options="iconCls:'icon-submit'">发布日志</a>
            </td>
   		</tr>
   	</table>
 </div>
 
 <script type="text/javascript">

    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    var ue = UE.getEditor('editor');


</script>
</body>
</html>