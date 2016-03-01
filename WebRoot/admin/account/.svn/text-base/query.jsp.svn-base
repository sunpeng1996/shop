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
       <form action="${pageContext.request.contextPath}/accountAction_query.action" method="post">
       	    登录名查询:<input type="text" name="alogin" />
       	    <input type="submit" value="查询" />
       </form>
       <c:if test="${requestScope.accounts!=null}">
       	   <table>
       	   		<tr>
       	   			<th>编号</th>
       	   			<th>登录名</th>
       	   			<th>真实姓名</th>
       	   			<th>更新</th>
       	   			<th>删除</th>
       	   		</tr>
       	   		<c:forEach items="${requestScope.accounts}" var="account" varStatus="num">
					<tr>
						<td>${num.count}</td>
						<td>${account.alogin}</td>
						<td>${account.aname}</td>
						<td>
						 <!--  
							<c:url value="/admin/account/test.jsp" var="url">
								<c:param name="test" value="c#" />
								<c:param name="test2" value="c++" />
							</c:url>
						<a href="${url}">更新</a>
						-->
							<c:url value="/accountAction_updateUI.action" var="update">
								<c:param name="aid" value="${account.aid}" />
							</c:url>
							<a href="${update}">更新</a>
						</td>
						<td>
							<c:url value="/accountAction_delete.action" var="delete">
								<c:param name="aid" value="${account.aid}" />
							</c:url>
							<a href="${delete}">删除</a>
						</td>
					</tr>       	   			
       	   		</c:forEach>
       	   </table>
       </c:if>     
  </body>
</html>
