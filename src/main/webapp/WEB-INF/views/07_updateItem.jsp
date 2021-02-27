<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>상품 수정</h2>
	<form method="post" action="${ contextPath }/updateItemPro.do" enctype="multipart/form-data">
		<c:set var="update" value="${item}"/>
		<table border="1" style="border-collapse: collapse;">
			<tr height="30">
				<th width="150" align="center">번호</th>
				<td width="300">${update.getItem_number()}</td>
			</tr>
			<tr height="30">
				<th width="150" align="center">카테고리</th>
				<td width="300">
					<select name="item_category">
						<option value="100" <c:if test="${update.item_category == 100}">selected</c:if>>채소</option>
						<option value="200" <c:if test="${update.item_category == 200}">selected</c:if>>해산물</option>
						<option value="300" <c:if test="${update.item_category == 300}">selected</c:if>>육류</option>
						<option value="400" <c:if test="${update.item_category == 400}">selected</c:if>>전자제품</option>
					</select>
				</td>
			</tr>
			<tr height="30">
				<th width="150" align="center">상품명</th>
				<td width="300">
					<input type="text" name="item_name" value="${update.item_name}">
				</td>
			</tr>
			<tr height="30">
				<th width="150" align="center">가격</th>
				<td width="300">
					<input type="text" name="item_price" value="${update.item_price}">
				</td>
			</tr>
			<tr height="30">
				<th width="150" align="center">재고</th>
				<td width="300">
					<input type="text" name="item_stock" size="3" value="${update.item_stock}">
				</td>
			</tr>
			<tr height="30">
				<th width="150" align="center">이미지</th>
				<td width="300">
					<img src="${contextPath}/resources/img/${update.item_image}" height="30">
					<input type="file" name="item_image" value="업로드">
				</td>
			</tr>
			<tr height="30">
				<th width="150" align="center">상품정보</th>
				<td width="300">
					<input type="text" name="item_info" value="${update.item_info}">
				</td>
			</tr>
			<tr height="30">
				<th width="150" align="center">할인률</th>
				<td width="300">
					<input type="text" name="discount_rate" size="3" value="${update.discount_rate}">%
				</td>
			</tr>
			<tr height="30">
				<th width="150" align="center">등록일</th>
				<td width="300">${update.reg_date}</td>
			</tr>
			<tr height="30">
				<th width="150" align="center">판매량</th>
				<td width="300">${update.sold}</td>
			</tr>
			<tr height="30">
				<td width="450" align="center" colspan="2">
					<input type="hidden" name="item_number" value="${update.item_number}"> 

					<input type="submit" value="수정하기" style="color: black; background-color: white;">&nbsp; 
					<input type="reset" value="다시작성" style="color: black; background-color: white;">&nbsp; 
					<input type="button" value="목록으로" onclick="location.href='${contextPath}/itemListForManager.do'" style="color: black; background-color: white;">
				</td>
			</tr>
		</table>
	</form>
	<p>
</body>
</html>