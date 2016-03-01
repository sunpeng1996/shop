<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>My JSP 'success.jsp' starting page</title>

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
		 <a href="${pageContext.request.contextPath}/accountAction_demo.action">拦截器工作流测试</a>
		 <%
		 	  List<String> strList=new ArrayList<String>();
		 	  strList.add("aaa");
		 	  request.setAttribute("strList",strList);
		  %>
		  <c:if test="${empty requestScope.strList}">
		  	     为空集合
		  </c:if>
		  <c:if test="${not empty requestScope.strList}">
		  	   不为空集合
		  </c:if>
	</body>
</html>
