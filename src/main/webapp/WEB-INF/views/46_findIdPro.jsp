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
	<br><br><br>
	<h2 align="center">아이디 찾기</h2>
	<table>
		
		<tr height="100">
			<td width="300" align="center">
				<input type="image" src="${contextPath}/resources/img/findId.png" style="width: 100px">
			</td>
		</tr>
		<c:if test="${check == 0}">
		<tr>
			<td align="center">
			<font size="5" color="purple"><b>
			고객님께서 입력하신 정보가<br>
			정확한지 확인 후 다시 시도해주세요.</b></font>
			</td>
		</tr>
		<tr height="150">
			<td width="300" align="center">
				<a href="${contextPath}/findId.do">
				<input type="image" src="${contextPath}/resources/img/findIdRetry.png" style="width: 320px">
				</a>
			</td>
		</tr>
		</c:if>
		<c:if test="${check == 1}">
		<tr>
			<td align="center">
			<font size="5" color="purple"><b>
			고객님의<br>
			아이디 찾기가 완료되었습니다!</b></font>
			</td>
		</tr>
		<tr height="10">
			<td align="center">
			<font size="2"><b>아이디:${fId}</b></font>
			</td>
		</tr>
		<tr height="150">
			<td width="300" align="center">
				<a href="${contextPath}/login.do">
				<input type="image" src="${contextPath}/resources/img/logindo.png" style="width: 320px">
				</a>
			</td>
		</tr>
		</c:if>
	</table>
</body>
</html>












