<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'list.jsp' starting page</title>

<script type="text/javascript">
	function confirmDeletePerson(personId) {
		if (confirm("确定要删除这条信息吗？")) {
			window.location.href = "delete.do?personId="+personId;
		}
	}
</script>

</head>
<body>

	<br><br>
	
	<form action="listPerson.do" method="post">
		<table align="center" width="80%">
			<tr>
				<td><label>姓名：</label><input type="text" name="name" value="${qc.name }"></td>
				<td><label>性别：</label> <select name="gender">
						<option value="">请选择</option>
						<option value="1" <c:if test="${qc.gender == 1 }">selected</c:if> >帅哥</option>
						<option value="0" <c:if test="${qc.gender == 0 }">selected</c:if> >美女</option>
				</select></td>
				<td><label>地址：</label><input type="text" name="personAddr" value="${qc.personAddr }"></td>
				<td><label>生日：</label>
				<input type="text" name="birthday"  value='<f:formatDate pattern="yyyy-MM-dd" value="${qc.birthday }" />'></td>
				<td><input type="submit" value="查询"></td>
			</tr>
		</table>
	</form>
	<br>
	<table align="center" width="80%" border="1">
		<tr>
			<td><a href="toSaveUI.do">添加信息</a></td>
		</tr>
	</table>
	<table align="center" width="80%" border="1">
		<tr>
			<th>姓名</th>
			<th>性别</th>
			<th>地址</th>
			<th>生日</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${pList }" var="person">
			<tr>
				<td>${person.name }</td>
				<td><c:if test="${person.gender == 1 }">帅哥</c:if> <c:if
						test="${person.gender == 0 }">美女</c:if></td>
				<td>${person.personAddr }</td>
				<td><f:formatDate pattern="yyyy-MM-dd"
						value="${person.birthday }" /></td>
				<td>
					<a href="toUpdateUI.do?personId=${person.personId }">修改</a>
					<a href="JavaScript:void(0);" onclick="confirmDeletePerson(${person.personId});">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
