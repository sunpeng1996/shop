<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="my" uri="http://java.sun.com/jsp/jstl/my"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>My JSP 'save.jsp' starting page</title>

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
		$("[type=checkbox]").click(function(){
		  	// 选中取消的时候同时选中取消下级权限		  	
		  	$(this).siblings("ul").find("input").attr("checked",this.checked);
		  	// 当选中某一个权限的时候,要选中上级的所有权限,取消的时候,则不取消
		  	if(this.checked){		  		
		  		$(this).parents("li").children("input").attr("checked",true);
　　　		}
		});
	});
</script>
	</head>

	<body>
		正在更新[${sessionScope.role.rname}]角色
		<br />
		<form
			action="${pageContext.request.contextPath}/roleAction_update.action"
			method="post">
			更新基本信息:
			<br />
			角色名:
			<input type="text" name="rname" value="${requestScope.role.rname}" />
			<br />
			描述:
			<textarea cols="20" name="rdetail">${requestScope.role.rdetail}</textarea>
			<br />
			更新授权信息:
			<ul id="root">
				<c:forEach items="${applicationScope.privileges}" var="privilege">
					<li>
						<input type="checkbox" name="pid" id="pid_${privilege.pid}"
							value="${privilege.pid}" ${my:contains(requestScope.myUrl,privilege.purl)?'checked':''} />
						<!-- for 要捆绑 表单元素的ID, 这样单击label就和单击表单元素一样 -->
						<label for="pid_${privilege.pid}">
							${privilege.pname}
						</label>
						<br />
						<ul>
							<c:forEach items="${privilege.children}" var="children">
								<li>
									<input type="checkbox" name="pid" id="pid_${children.pid}"
										value="${children.pid}" ${my:contains(requestScope.myUrl,children.purl)?'checked':''} />
									<!-- for 要捆绑 表单元素的ID, 这样单击label就和单击表单元素一样 -->
									<label for="pid_${children.pid}">
										${children.pname}
									</label>
									<br />
								</li>
							</c:forEach>
						</ul>
					</li>
				</c:forEach>
			</ul>
			<input type="submit" value="提交" />
			<input type="hidden" value="${role.rid}" name="rid" />
		</form>
	</body>
</html>
