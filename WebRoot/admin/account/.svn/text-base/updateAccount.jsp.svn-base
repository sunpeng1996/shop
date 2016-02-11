<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
             更新管理员信息<br/>
       <form action="${pageContext.request.contextPath}/accountAction_update.action" method="post">
       	    登录名:<input type="text" name="alogin" value="${requestScope.account.alogin}" /><br/>
       	    姓名:<input type="text" name="aname" value="${requestScope.account.aname}" /><br/>
       	    密码:<input type="text" name="apass" value="${requestScope.account.apass}" /><br/>
       	  <input type="submit" value="添加" />
       	  <input type="hidden" name="aid" value="${requestScope.account.aid}" />
       </form>
  </body>
</html>
