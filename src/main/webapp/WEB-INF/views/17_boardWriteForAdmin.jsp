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
	<h2>게시글 작성(관리자)</h2>
	<form method="post" action="${contextPath}/boardWriteForAdminPro.do">
		<table border="1" style="border-collapse:collapse;">
			<tr height="50">
			<c:set var="writer" value="${sessionScope.id}"/>
				<th width="200" align="center">작성자</th>
				<td width="400">
					<input type="text" value="${writer}" readonly>
				</td>
			</tr>
			<tr height="50">
				<th width="200" align="center">제목</th>
				<td width="400">
					<input type="text" name="title">
				</td>
			</tr>
			<tr height="150">
				<th width="200" align="center">글내용</th>
				<td width="400">
					<textarea cols="50" rows="10" name="content"></textarea>
				</td>
			</tr>
			<tr height="50">
				<th width="200" align="center">패스워드</th>
				<td width="400">
					<input type="password" name="pw">
				</td>
			</tr>
		</table>
		<br>
		<input type="hidden" name="writer" value="${writer}">
		
		<input type="submit" value="글쓰기" style="color: black; background-color: white;">&nbsp;
		<input type="reset" value="다시쓰기" style="color: black; background-color: white;">
		<input type="button" value="목록으로" onclick="location.href='${contextPath}/serviceCenter.do'" style="color: black; background-color: white;">
	</form>
	<p>
</body>
</html>