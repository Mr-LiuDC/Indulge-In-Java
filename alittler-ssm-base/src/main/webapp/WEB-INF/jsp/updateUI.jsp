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
	
	<form action="update.do" method="post">
	<input type="hidden" name="personId" value="${person.personId }">
		<table align="center" width="80%">
			<tr>
				<td><label>姓名：</label><input type="text" name="name" value="${person.name }"></td>
				<td><label>性别：</label> <select name="gender">
						<option value="">请选择</option>
						<option value="1" <c:if test="${person.gender == 1 }">selected</c:if> >帅哥</option>
						<option value="0" <c:if test="${person.gender == 0 }">selected</c:if> >美女</option>
				</select></td>
				<td><label>地址：</label><input type="text" name="personAddr" value="${person.personAddr }"></td>
				<td><label>生日：</label><input type="text" name="birthday"  value='<f:formatDate pattern="yyyy-MM-dd"
						value="${person.birthday }" />'></td>
				<td><input type="submit" value="修改信息"></td>
			</tr>
		</table>
	</form>
	<br>
</body>
</html>
