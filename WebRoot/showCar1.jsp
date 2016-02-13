<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">

    <title>我的购物车</title>
    
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
    	购物车如下：
    	<table>
    		<tr>
    				<th>商品名称</th>
    				<th>商品价格</th>
    				<th>商品数量</th>
    				<th>操作</th>
    		</tr>
    		
    		<c:forEach var="sorder" items="${sessionScope.forder.sorders }">
    				<tr>
    						<th>${sorder.sname }</th>
    						<th>${sorder.sprice }</th>
    						<th>
    								<input type="text" value="${sorder.snumber}" size="2" />
    						</th>
    						<th>删除</th>
    				</tr>
    		
    		</c:forEach>
    		
    	</table>
    	
    	 <div id="ftotal">
     		   <!-- 显示购物的总价格 -->
    			${sessionScope.forder.ftotal}
    	</div>
    	
    	<div>
    			<a href="">提交</a>
    	</div>
  </body>
</html>
