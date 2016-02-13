<%@ page language="java" import="java.util.*"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'detail.jsp' starting page</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$(".delBtn").click(function(){
				 //获取商品编号,给后台删除指定购物项
				 var gid=$(this).attr("id");
				 $.post("/shop/sorderAction_removeSorder.action",
				 	{"goods.gid":gid},
				 	function(result){
				 		 // 更新总价格
				 		$("#ftotal").text(result.ftotal);
				 	});
				 // 删除选中行
				 $(this).parents("tr:first").remove();
				
			});
		});
	</script>

  </head>
  
  <body>
    	购物车如下:
    	<table>
			<tr>
				<td>
					商品名
				</td>
				<td>
					价格
				</td>
				<td>
					数量
				</td>
				<td>
					操作
				</td>
			</tr>    	
    	<c:forEach items="${sessionScope.forder.sorders}" var="sorder">
    		<tr>
    			<td>
    				${sorder.sname}
    			</td>
    			<td>
    				${sorder.sprice}
    			</td>
    			<td>
    				<input type="text" value="${sorder.snumber}" size="2" />
    			</td>
    			<td>
    				<input type="button" value="删除" class="delBtn" id="${sorder.goods.gid}" />
    			</td>
    		</tr>
    	</c:forEach>
    </table>
    <div id="ftotal">
        <!-- 显示购物的总价格 -->
    	${sessionScope.forder.ftotal}
    </div>
    <a href="">提交</a>
  </body>
</html>
