<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <title>addUI页面</title>
  </head>
  
  <body>
    addUI<br><br><br>
    
    
    <s:form action="role_add">
    	<s:textfield name="name"></s:textfield>
    	<s:textarea name="description"></s:textarea>
    	<s:submit value="提交"></s:submit>
    </s:form>
    
    
  </body>
</html>
