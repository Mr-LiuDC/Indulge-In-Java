
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>saveUI页面</title>
</head>

<body>
	<br>
	<h2 align="center">saveUI</h2>
	<h3 align="center">添加角色信息</h3>
	<table align="center" width="80%" border="1" cellpadding="0" cellspacing="0">
		<s:form action="role_%{id == null ? 'add' : 'edit' }">
			<s:hidden name="id"></s:hidden>
			<tr>
				<td><label>角色名称：</label>
				<s:textfield name="name"></s:textfield></td>
				<td><label>角色描述：</label>
				<s:textarea name="description"></s:textarea></td>
				<td><s:submit value="提交角色信息"></s:submit></td>
			</tr>
		</s:form>
	</table>
</body>
</html>
