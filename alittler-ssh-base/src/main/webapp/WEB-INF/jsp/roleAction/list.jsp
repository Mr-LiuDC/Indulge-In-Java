<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>list页面</title>
</head>

<body>
	<br>
	<h2 align="center">角色信息列表</h2>
	<br>
	<table align="center" width="80%" border="1" cellpadding="0" cellspacing="0">
		<tr>
			<th>角色ID</th>
			<th>角色名称</th>
			<th>角色描述</th>
			<th colspan="2">操作</th>
		</tr>
		
			<s:iterator value="#roleList">
			<tr>
				<td>${id}</td>
				<td>${name}</td>
				<td>${description}</td>
				<td><s:a action="role_delete?id=%{id}" onclick="return confirm('确定要删除吗?')">删除</s:a></td>
				<td><s:a action="role_editUI?id=%{id}">修改</s:a></td>
			</tr>
			</s:iterator>
		
		<tr><td colspan="5">&nbsp;</td></tr>
		<tr>
			<td colspan="5"><s:a action="role_addUI">添加角色信息</s:a></td>
		</tr>
	</table>
	<br>
</body>
</html>
