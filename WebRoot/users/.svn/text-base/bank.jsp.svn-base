<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'bank.jsp' starting page</title>

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
   支付订单号:${sessionScope.forder.fid}<br/>
   支付金额为:${sessionScope.forder.ftotal} <br/>
   <form action="${pageContext.request.contextPath}/payAction_submit.action" method="post">
      请选择银行:
      <table>
      	<tr>
      	   <c:forEach items="${applicationScope.bankImages}" var="image" varStatus="num">
      			<td>
      			<input type="radio" name="pd_FrpId" value="${fn:substring(image, 0,fn:indexOf(image,'.'))}" />
      			<img src="${pageContext.request.contextPath}/image/logo/${image}"  /></td>
      			 <c:if test="${num.count%5==0}">
      	   	  	  	</tr><tr>
      	   	  	</c:if>
      	   </c:forEach>
      	</tr>
      </table>
      <input type="hidden" name="p2_Order" value="${sessionScope.forder.fid}"><br/>
      <input type="hidden" name="p3_Amt" value="${sessionScope.forder.ftotal}"><br/>
      <input type="submit" value="提交" />     
   </form>
  </body>
</html>
