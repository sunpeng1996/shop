<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="my" uri="http://java.sun.com/jsp/jstl/my"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/js/tree/jquery.treeview.css">
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/jquery-1.7.min.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/tree/jquery.treeview.js"></script>
		<script type="text/javascript">
	$(function() {
		$("#root").treeview( {
			/* 展开还是收起, 默认为false 展开*/
			collapsed : false,
			/* 唯一的, 当前菜单打开的时候其他菜单收缩*/
			unique : true
		});
	});
</script>
	</head>

	<body>
		<ul id="root">
			<!-- 
			     最好: 只查询 isleft为true的菜单,然后在进行判断, 但是hibernate查询语句是不灵活的. 在之前已经配置了 懒加载
			     而且以后我只需要查父菜单,这个功能都实现不了
			    <set name="children" inverse="true" lazy="true" fetch="subselect" order-by="pid asc">
            		<key>
                		<column name="parentId" />
            		</key>
            		<one-to-many class="Privilege" />
        		</set>
        	   所以开发时候只有：
        	   1: update delete save  query都是自己写HQL语句, lazy=true 
        	   2: sqlquery(): hierbate支持原生态sql语句(这种方式避免使用, 因为不能使用hiberante的二级缓存、不能跨不同的数据库)
        	   3: myBatis: 此框架(开源),半自动化的框架, hibernate是全自动的框架   
			 -->
			<c:forEach items="${applicationScope.privileges}" var="privilege">
				<c:if test="${my:contains(sessionScope.allPurls,privilege.purl) && privilege.isleft}">
				<li>
					<span>${privilege.pname}</span>
					<ul>
					    <c:forEach items="${privilege.children}" var="children">
					    	<c:if test="${my:contains(sessionScope.allPurls,children.purl) && children.isleft}">
							<li>
								<a href="${pageContext.request.contextPath}/${children.purl}.action" target="right">${children.pname}</a>
							</li>
							</c:if>
						</c:forEach>
					</ul>
				</li>
				</c:if>
			</c:forEach>
		</ul>
	</body>
</html>
