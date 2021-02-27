<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<script src="${ contextPath }/resources/jq/jquery-1.11.0.min.js"></script>

<%--
	. ajaxForm 플러그인
	. ajax로 파일을 업로드할 때 가장 널리 사용하는 방법
 --%>
<script src="${ contextPath }/resources/jq/jquery.form.min.js"></script>
<script src="${ contextPath }/resources/js/05_addnewitem.js"></script>
<c:if test="${empty sessionScope.id}">
		<%--
			. <meta http-equiv="refresh" content="시간(초 단위);url=이동하고자 하는 웹페이지 주소">
			. refresh 태그는 새로고침을 해주는 태그이다.
			. 즉 로그아웃 상태일 경우, 1초 뒤에 자동으로 managerMain.do 페이지로 이동한다는 의미이다.
		 --%>
		<meta http-equiv="refresh" content="0; url=${ contextPath }/managerMain.do">
	</c:if>
<h2>신상품 등록</h2>
<form method="post" id="fileUploadForm" action="${ contextPath }/addNewItemPro.do" enctype="multipart/form-data">
	<table border="1"  style="border-collapse:collapse;">
		<tr height="30">
			<th width ="200" align="left">상품 카테고리</th>
			<td width = "500">
				<select name="item_category">
					<option value="100">채소</option>
					<option value="200">해산물</option>
					<option value="300">육류</option>
					<option value="400">전자제품</option>
				</select>
			</td>
		</tr>
		<tr height="30">
			<th width ="200" align="left">상품명</th>
			<td width = "500">
				<input type="text" name="item_name" id="item_name">
			</td>
		</tr>
		<tr height="30">
			<th width ="200" align="left">상품가격</th>
			<td width = "500">
				<input type="text" name="item_price" id="item_price"> 원
			</td>
		</tr>
		<tr height="30">
			<th width ="200" align="left">상품재고</th>
			<td width = "500">
				<input type="text" name="item_stock" id="item_stock">
			</td>
		</tr>
		<tr height="30">
			<th width ="200" align="left">이미지</th>
			<td width = "500">
				<input type="file" name="item_image" id="item_image" style="color: black; background-color: white;">
			</td>
		</tr>
		<tr height="30">
			<th width ="200" align="left">상품정보</th>
			<td width = "500">
				<input type="text" name="item_info" id="item_info" size="50">
			</td>
		</tr>
		<tr height="30">
			<th width ="200" align="left">할인률</th>
			<td width = "500">
				<input type="text" name="discount_rate" id="discount_rate"> %
			</td>
		</tr>
	</table>
	<br>
	<input type="submit" name="submit" id="submit" value="상품 추가하기" style="color: black; background-color: white;">
</form>