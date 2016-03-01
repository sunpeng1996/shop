<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'save.jsp' starting page</title>

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
     添加角色:
     <form action="${pageContext.request.contextPath}/roleAction_query.action" method="post">
     	<input type="submit" value="查询所有角色" />
     </form>
     <table border="1" width="400">
     	<tr>
     		<td>编号</td>
     		<td>角色名</td>
     		<td>说明</td>
     		<td>更新操作</td>
     		<td>删除操作</td>
     	</tr>
     	<c:forEach items="${requestScope.roles}" var="role" varStatus="num">
     		<tr>
	     		<td>${num.count}</td>
	     		<td>${role.rname}</td>
	     		<td>${role.rdetail}</td>
	     		<td>
		     		<c:url value="/roleAction_updateUI.action" var="update">
		     			<c:param name="rid" value="${role.rid}" />
		     		</c:url>
		     		<a href="${update}">更新/授权</a>
	     		</td>
	     		<td>
	     			<c:url value="/roleAction_delete.action" var="delete">
	     				<c:param name="rid" value="${role.rid}" />
	     			</c:url>
	     			<a href="${delete}">删除</a>
	     		</td>
     		</tr>
     	</c:forEach>
     </table>
  </body>
</html>
