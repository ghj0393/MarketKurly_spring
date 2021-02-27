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
	<c:if test="${empty sessionScope.id}">
		<%--
			. <meta http-equiv="refresh" content="시간(초 단위);url=이동하고자 하는 웹페이지 주소">
			. refresh 태그는 새로고침을 해주는 태그이다.
			. 즉 로그아웃 상태일 경우, 1초 뒤에 자동으로 managerMain.do 페이지로 이동한다는 의미이다.
		 --%>
		<meta http-equiv="refresh" content="0; url=${ contextPath }/managerMain.do">
	</c:if>
	<h2>주문현황</h2>
	<table border ="1" style="border-collapse:collapse;">
		<tr height="50">
			<th width="50" align="center">번호</th>
			<th width="100" align="center">아이디</th>
			<th width="100" align="center">주문자명</th>
			<th width="100" align="center">상품명</th>
			<th width="100" align="center">가격</th>
			<th width="100" align="center">구매갯수</th>
			<th width="50" align="center">이미지</th>
			<th width="200" align="center">구매일자</th>
			<th width="100" align="center">결제수단</th>
			<th width="300" align="center">주소</th>
		</tr>
	<c:set var="number" value="0" />
	<c:forEach var="order" items="${orderList}">
		<tr height="30">
			<td width="50" align="center">
				<c:set var="number" value="${number+1}" />
		  		${number}	
			</td>
			<td width="100" align="center">${order.customer_id}</td>
			<td width="100" align="center">${order.customer_name}</td>
			<td width="100" align="center">${order.item_name}</td>
			<td width="100" align="center">${order.buy_price}원</td>
			<td width="100" align="center">${order.buy_count}개</td>
			<td width="50" align="center">
				<img src="${contextPath}/resources/img/${order.item_image}" height="50">
			</td>
			<td width="200" align="center">${order.buy_date}</td>
			<td width="100" align="center">${order.howpay}</td>
			<td width="300" align="center">${order.address}</td>
		</tr>
	</c:forEach>
	</table>
	<p>
</body>
</html>