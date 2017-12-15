<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>list页面</title>
</head>

<body>
	<br>
	<h2 align="center">部门信息列表</h2>
	<br>
	<table align="center" width="80%" border="1" cellpadding="0" cellspacing="0">
		<tr>
			<th>部门ID</th>
			<th>部门名称</th>
			<th>部门描述</th>
			<th colspan="2">操作</th>
		</tr>
		
			<s:iterator value="#departmentList">
			<tr>
				<td>${id}</td>
				<td>${name}</td>
				<td>${description}</td>
				<td><s:a action="department_delete?id=%{id}" onclick="return confirm('确定要删除吗?')">删除</s:a></td>
				<td><s:a action="department_editUI?id=%{id}">修改</s:a></td>
			</tr>
			</s:iterator>
		
		<tr><td colspan="5">&nbsp;</td></tr>
		<tr>
			<td colspan="5"><s:a action="department_addUI">添加部门信息</s:a></td>
		</tr>
	</table>
	<br>
</body>
</html>
