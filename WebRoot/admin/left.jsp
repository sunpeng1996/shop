<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
      <ul>
      	 <li><a href="${pageContext.request.contextPath}/admin/account/saveAccount.jsp" target="right">添加管理员</a></li>
      	 <li><a href="${pageContext.request.contextPath}/admin/account/queryAccount.jsp" target="right">查询管理员</a></li>
      	 <li><a href="${pageContext.request.contextPath}/admin/category/saveCategory.jsp" target="right">添加类别</a></li>
      	 <li><a href="${pageContext.request.contextPath}/admin/category/query.jsp" target="right">查询类别</a></li>
      	 <li><a href="${pageContext.request.contextPath}/admin/goods/saveGoods.jsp" target="right">添加商品</a></li>
      	 <li><a href="${pageContext.request.contextPath}/admin/goods/query.jsp" target="right">查询商品</a></li>
      </ul>
  </body>
</html>
