<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <title>editUI页面</title>
  </head>
  
  <body>
    editUI<br><br><br>
    
    <%-- 
    <s:form action="role_edit">
    	<s:hidden name="id"></s:hidden>
    	<s:textfield name="name" value="%{name}"></s:textfield>
    	<s:textarea name="description" value="%{description}"></s:textarea>
    	<s:submit value="提交"></s:submit>
    </s:form>
    --%>
    
    <!-- ==============下面的方式也可,更简单============ -->
    
    <s:form action="role_edit">
    	<s:hidden name="id"></s:hidden>
    	<s:textfield name="name"></s:textfield>
    	<s:textarea name="description"></s:textarea>
    	<s:submit value="提交"></s:submit>
    </s:form>
    
    
  </body>
</html>
