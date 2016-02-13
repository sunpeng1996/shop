<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>My JSP 'queryGoods.jsp' starting page</title>
		<style type="text/css">
			.red1{
				background-color: #ececec;
			}
			.red2{
				background-color: #fcfcfc;
			}
		</style>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.min.js"></script>
		<script type="text/javascript">
			$(function(){
			    /* 鼠标移动到tr样式
				$("#goodsList tr").not(":first").mouseover(function(){
					$(this).addClass("red1");
				});
				$("#goodsList tr").mouseout(function(){
					$(this).removeClass("red1");
				});*/
				$("#goodsList>tbody>tr:odd").addClass("red1");
				$("#goodsList>tbody>tr:even").not(":first").addClass("red2");
			});
		
		</script>
	</head>

	<body>
		<form action="${pageContext.request.contextPath}/goodsAction_query.action" method="post"> 
			商品名:<input type="text" name="gname" />
			<input type="submit" value="提交" />
		</form>
		<table border="1" id="goodsList">
			<tbody>
			<tr>
				<td>编号</td>
				<td>商品名称</td>
				<td>商品价格</td>
				<td>日期</td>
				<td>是否推荐</td>
				<td>是否有效</td>
				<td>所属类别</td>
				<td>更新操作</td>
				<td>删除操作</td>
			</tr>
			<c:forEach items="${requestScope.goodsList}" var="goods" varStatus="num">
				<tr>
					<td>${num.count}</td>
					<td>${goods.gname}</td>
					<td>${goods.gprice}</td>
					<td><fmt:formatDate value="${goods.gdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td>${goods.gcommend}</td>
					<td>${goods.gopen}</td>
					<td>${goods.category.ctype}</td>
					<td>
						<c:url value="/goodsAction_get.action" var="updBtn">
							<c:param name="gid" value="${goods.gid}" />
						</c:url>
						<a href="${updBtn}">更新</a>
					</td>
					<td>
						<c:url value="/goodsAction_delete.action" var="delBtn">
							<c:param name="gid" value="${goods.gid}" />
						</c:url>
					<a href="${delBtn}">删除</a>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</body>
</html>
