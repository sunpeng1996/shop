<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<script type="text/javascript" src="/shop/js/jquery-1.2.min.js"></script>
	</head>
	<body>
		更细商品信息
		<form
			action="${pageContext.request.contextPath}/goodsAction_update.action"
			method="post" enctype="multipart/form-data">
			<div style="width: 700px;">
					<table border="1" cellpadding="0" cellspacing="0" id="save_text">
					<tr>
					<td>
						商品名称：
					</td>
					<td>
						<input type="text" class="text" id="text" name="gname" value="${goods.gname}" />
					</td>
					<td></td>
				</tr>
				<tr>
					<td>
						商品售价：
					</td>
					<td>
						<input type="text" name="gprice" class="text" value="${goods.gprice}" />
					</td>
					<td></td>
				</tr>
				<tr>
					<td>
						图片上传：
					</td>
					<td colspan="2">
						<input type="file" name="goodsFile.image" />
					</td>
				</tr>
				<tr>
					<td>
						商品类型：
					</td>
					<td>
						<select id="cid" name="category.cid">
							<option value="0">
								请选择
							</option>
							<c:forEach items="${applicationScope.categorys}" var="category">
								<c:choose>
									<c:when test="${category.cid==goods.category.cid}">
										<option value="${category.cid}" selected="selected">${category.ctype}</option>
									</c:when>
									<c:otherwise>
										<option value="${category.cid}">${category.ctype}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</td>
					<td></td>
				</tr>
				<tr>
					<td>
						加入推荐：
					</td>
					<td>
						<c:choose>
							<c:when test="${goods.gcommend==true}">
								推荐:<input type="radio" name="gcommend" checked="checked" value="true" />
								不推荐:<input type="radio" name="gcommend" value="false" />
							</c:when>
							<c:otherwise>
								推荐:<input type="radio" name="gcommend" value="true" />
								不推荐:<input type="radio" name="gcommend" checked="checked" value="false" />
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr>
					<td>
						是否有效：
					</td>
					<td>
					  <c:choose>
							<c:when test="${goods.gopen==true}">
								上架:<input type="radio" name="gopen" checked="checked" value="true" />
								下架:<input type="radio" name="gopen" value="false" />
							</c:when>
							<c:otherwise>
								上架:<input type="radio" name="gopen" value="true" />
								下架:<input type="radio" name="gopen" checked="checked" value="false" />
							</c:otherwise>
						</c:choose>
					</td>
					<td></td>
				</tr>
				<tr>
					<td valign="top">
						商品简单描述：
					</td>
					<td colspan="2" style="height: 80px">
						<textarea name="gremark" cols="40" rows="4">${goods.gremark}</textarea>
					</td>
				</tr>
				<tr>
					<td valign="top">
						商品详细描述：
					</td>
					<td colspan="2">
						<textarea name="gxremark" cols="40" rows="8">
							${goods.gxremark}
						</textarea>
					</td>
				</tr>

				<tr>
					<td colspan="3" align="center" id="save_text_td1">
						<input type="submit" value="确定" />
						<input type="reset" value="重置" />
						<input type="hidden" name="gpic" value="${goods.gpic}" />
						<input type="hidden" name="gid" value="${goods.gid}" />
					</td>
				</tr>
			</table>
			</div>
		</form>
	</body>
</html>