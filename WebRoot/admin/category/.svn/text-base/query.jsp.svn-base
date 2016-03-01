<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>My JSP 'saveScategory.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.min.js"></script>
		<script type="text/javascript">
			$(function() { // id 标签  class
				$(".delBtn").click(function() {
					$.post("categoryAction_delete.action", {cid : $(this).attr("lang")});
					// 获取所有的tr,然后通过筛选得到第一个(最近的tr)
					$(this).parents("tr:first").remove();
				});
			$(".updBtn").click(
				function() {
				    // 获取当前按钮的父亲的前一个兄弟节点
					var jchTd = $(this).parent().prev();  //next() 邻近选择器
					// 如果相对位置比较远,通过siblings [兄弟] 来筛选同级别的节点
					var jtxtTd = $(this).parent().siblings(".stype");
					if ($(this).val() == "更新") {
						$(this).val("确认");
						jchTd.children().removeAttr("disabled");
						// td.val() 是错的, td没有value属性 这种方式只能表单元素
						// td.text() 可以赋值,只支持文本不支持标签
						jtxtTd.html("<input value='" + jtxtTd.html() + "' />");
					} else {
						$(this).val("更新");
						jchTd.children().attr("disabled", "disabled");
						// td的值,为td内部input 标签的值
						jtxtTd.html(jtxtTd.children().val());
						var isChecked = jchTd.children()
						.attr("checked") == "checked" ? true: false;
						$.post("categoryAction_update.action", {
							"cid" : $(this).attr("lang"),
							"ctype" : jtxtTd.html(),
							"chot" : isChecked
						});
					}
			});
	});
</script>
	</head>

	<body>
		<form
			action="${pageContext.request.contextPath}/categoryAction_query.action" method="post">
			类别名称
			<input type="text" name="ctype" />
			<input type="submit" value="查询" />
		</form>
	<table>
		<tr>
			<td>
				<table>
			<tr>
				<td>
					<table border="1">
						<tr>
							<td>
								编号
							</td>
							<td>
								类别名称
							</td>
							<td>
								热点
							</td>
							<td>
								更新操作
							</td>
							<td>
								删除操作
							</td>
						</tr>
						<c:forEach items="${requestScope.categorys}" var="category" varStatus="num">
							<tr>
								<td>
									${num.count}
								</td>
								<td class="stype">
									<c:out value="${category.ctype}" default="　"></c:out>
								</td>
								<td>
									<c:choose>
										<c:when test="${category.chot==true}">
											<input type="checkbox" value="true" checked="checked" disabled="disabled" />
										</c:when>
										<c:otherwise>
											<input type="checkbox" value="true" disabled="disabled" />
										</c:otherwise>
									</c:choose>
								</td>
								<td>
									<input value="更新" type="button" class="updBtn" lang="${category.cid}" />
								</td>
								<td>
									<input value="删除" type="button" class="delBtn" lang="${category.cid}" />
								</td>
							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>
		</table>
			</td>
		</tr>	
	</table>
		
	</body>
</html>
