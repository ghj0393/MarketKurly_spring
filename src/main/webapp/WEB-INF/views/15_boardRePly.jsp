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
	<form method="post" action="${contextPath}/boardRePlyPro.do?num=${board.num}">
	<h2>댓글 작성(관리자)</h2>
	<c:if test="${type == 0}">
	<table border="1" style="border-collapse: collapse;">
		<tr height="40">
			<th align="center" width="120"> 글번호 </th>
			<td align="center" width="180">${board.num}</td>
			<th align="center" width="120"> 조회수 </th>
			<td align="center" width="180">${board.readcount}</td>
		</tr>
		<tr height="40">
			<th align="center" width="120"> 작성자 </th>
			<td align="center" width="180"> ${id}</td> <!-- -- -->
			<th align="center" width="120"> 작성일 </th>
			<td align="center" width="180"> ${board.reg_date}</td>
		</tr>
		<tr height="40">
			<th align="center" width="120"> 제목 </th>
			<td colspan="3"> 
				<input type="text" name="title" value="[답글]">
			</td>
		</tr>
		<tr height="80">
			<th align="center" width="120"> 글 내용 </th>
			<td colspan="3"> 
				<textarea rows="10" name="content" style="width: 90%"></textarea>
			</td>
		</tr>
		<tr height="40">
			<td align="center" colspan="4">
				<input type="submit" value="등록하기" style="color: black; background-color: white;">
				<!-- onclick="location.href='${contextPath}/boardRePlyPro.do?num=${board.num}'" -->
				<input type="reset" value="다시작성" style="color: black; background-color: white;">
				<input type="button" value="목록보기" onclick="location.href='${contextPath}/serviceCenter.do'" style="color: black; background-color: white;">
			</td>
		</tr>
	</table>
	</c:if>
	</form>
	<p>
</body>
</html>
















