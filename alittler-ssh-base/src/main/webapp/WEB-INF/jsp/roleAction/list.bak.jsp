<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <title>list页面</title>
  </head>
  
  <body>
    list<br><br><br>
    

    <s:iterator value="#roleList">
    	<s:property value="id"/> ,
    	<s:property value="name"/> ,
    	<s:property value="description "/> ,
    	<s:a action="role_delete?id=%{id}" onclick="return confirm('确定要删除吗?')">删除</s:a>,
    	<s:a action="role_editUI?id=%{id}">修改</s:a>
    	<br>
    </s:iterator>
    <br>
    <br>
    <s:a action="role_addUI">添加</s:a>

    
	<!-- ============下面这种方式也行，且更加简单============= -->
	
	<br><br>
    <s:iterator value="#roleList">
    	${id} ,
    	${name} ,
    	${description} ,
    	<s:a action="role_delete?id=%{id}" onclick="return confirm('确定要删除吗?')">删除</s:a>,
    	<s:a action="role_editUI?id=%{id}">修改</s:a>
    	<br>
    </s:iterator>
    <br>
    <br>
    <s:a action="role_addUI">添加</s:a>
    
    
  </body>
</html>
