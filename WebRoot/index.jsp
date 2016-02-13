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
		<table width="721" height="370" border="1">
			<c:forEach items="${applicationScope.bigList}" var="list">
			<tr>
				<td colspan="4">
					${list[0].category.ctype}
				</td>
			</tr>
			<tr>
				<c:forEach items="${list}" var="goods">
				<td width="206">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td>
								<img src="image/${goods.gpic}">
							</td>
						</tr>
						<tr>
							<td>
								${goods.gname}
							</td>
						</tr>
						<tr>
							<td>
								${goods.gprice}
							</td>
						</tr>
						<tr>
							<td>
								<c:url var="detail" value="goodsAction_detail.action">
										<c:param name="gid" value="${goods.gid }"></c:param>			
								</c:url>
								<a href="${detail }">详细</a>
							</td>
						</tr>
					</table>
				</td>
				</c:forEach>
			</tr>
			</c:forEach>
		</table>
	</body>
</html>
