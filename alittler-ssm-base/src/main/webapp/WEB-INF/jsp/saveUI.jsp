<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'list.jsp' starting page</title>
</head>
<body>
	
	<br><br>

	<table align="center" width="80%" border="1">
		<tr>
			<td><a href="listPerson.do">返回list列表页面</a></td>
		</tr>
	</table>
	
	<br>
	
	<form action="save.do" method="post">
		<table align="center" width="80%">
			<tr>
				<td><label>姓名：</label><input type="text" name="name"></td>
				<td><label>性别：</label> <select name="gender">
						<option value="">请选择</option>
						<option value="1" >帅哥</option>
						<option value="0" >美女</option>
				</select></td>
				<td><label>地址：</label><input type="text" name="personAddr"></td>
				<td><label>生日：</label><input type="text" name="birthday"></td>
				<td><input type="submit" value="添加信息"></td>
			</tr>
		</table>
	</form>
</body>
</html>
