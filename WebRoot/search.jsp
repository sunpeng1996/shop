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
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/auto/main.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/auto/thickbox.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/auto/jquery.autocomplete.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/auto/jquery.autocomplete.js"></script>
		<script type="text/javascript">
			$(function(){
				$("#auto").autocomplete("goodsAction_auto.action",{
					delay:1000,
					formatItem:function(row){
						return row.word + "约" + row.num + "结果"; 
					},
					parse:function(data){
						// data 后台返回json格式
						return $.map(data,function(temp){
							return {
								data:temp,
								result:temp.word
							}
						});
					}
				}).result(function(event,item){
					// 改变url的地址
					location.href="goodsAction_search.action?gname=" + item.word;
				});
			});
		</script>
	</head>
	<body>
		<form action="${pageContext.request.contextPath}/goodsAction_search.action" method="post">
			搜索:<input type="text" name="gname" id="auto" />
			<input type="submit" value="给我搜" />
		</form>
		<c:forEach items="${requestScope.goodsList}" var="goods">
			商品编号:${goods.gid}<br/>
			商品名:${goods.gname}<br/>
			商品介绍:${goods.gremark}<br/>
			<a href="${pageContext.request.contextPath}/goodsAction_detail.action?gid=${goods.gid}">详细</a>
		</c:forEach>
	</body>
</html>
