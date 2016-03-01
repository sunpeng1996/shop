<%@page language="java" contentType="text/html;charset=UTF-8"%>
<html>
	<head>
		<title>To YeePay Page
		</title>
	</head>
	<body>
		<form name="yeepay" action='https://www.yeepay.com/app-merchant-proxy/node' method='POST' target="_blank">
			<input type='hidden' name='p0_Cmd'   value='${requestScope.sendData.p0_Cmd}'>
			<input type='hidden' name='p1_MerId' value='${requestScope.sendData.p1_MerId}'>
			<input type='hidden' name='p2_Order' value='${requestScope.sendData.p2_Order}'>
			<input type='hidden' name='p3_Amt'   value='${requestScope.sendData.p3_Amt}'>
			<input type='hidden' name='p4_Cur'   value='${requestScope.sendData.p4_Cur}'>
			<input type='hidden' name='p5_Pid'   value='${requestScope.sendData.p5_Pid}'>
			<input type='hidden' name='p6_Pcat'  value='${requestScope.sendData.p6_Pcat}'>
			<input type='hidden' name='p7_Pdesc' value='${requestScope.sendData.p7_Pdesc}'>
			<input type='hidden' name='p8_Url'   value='${requestScope.sendData.p8_Url}'>
			<input type='hidden' name='p9_SAF'   value='${requestScope.sendData.p9_SAF}'>
			<input type='hidden' name='pa_MP'    value='${requestScope.sendData.pa_MP}'>
			<input type='hidden' name='pd_FrpId' value='${requestScope.sendData.pd_FrpId}'>
			<input type="hidden" name="pr_NeedResponse"  value="${requestScope.sendData.pr_NeedResponse}">
			<input type='hidden' name='hmac' value='${requestScope.hmac}'>
			<input type='submit' />
		</form>
	</body>
</html>
