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
	<c:if test="${check == 0}">
	<script>
		alert("insert error");
		location.href="${contextPath}/index.do";
	</script>
	</c:if>
	
	<c:if test="${check == 1}">
	<script>
		alert("상품을 장바구니에 담았습니다.");
		location.href="${contextPath}/cartInfo.do";
	</script>
	</c:if>
</body>
</html>