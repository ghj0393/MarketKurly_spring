<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시글 수정하기</h2>
	<form method="post" action="${contextPath}/boardUpdateForCustomerPro.do">
		<table border="1" style="border-collapse:collapse;">
			<tr height="40">
				<th align="center" width="120"> 글번호 </th>
				<td align="center" width="180"> ${board.num}</td>
				<th align="center" width="120"> 조회수 </th>
				<td align="center" width="180"> ${board.readcount}</td>
			</tr>
			<tr height="40">
				<th align="center" width="120"> 작성자 </th>
				<td align="center" width="180"> ${board.writer}</td>
				<th align="center" width="120"> 작성일 </th>
				<td align="center" width="180"> ${board.reg_date}</td>
			</tr>
			<tr height="40">
				<th align="center" width="120"> 제목 </th>
				<td align="left" colspan="3"> 
				<input type="text" name="title" value="${board.title}" size="30">
				</td>
			</tr>
			<tr height="80">
				<th align="center" width="120"> 글 내용 </th>
				<td align="left" colspan="3"> 
				<textarea name="content" cols="50" rows="10">${board.content}</textarea>
				</td>
			</tr>
		</table>
		<br>
		<input type="hidden" name="num" value="${board.num}">

		<input type="submit" value="수정하기" style="color: black; background-color: white;">&nbsp;
		<input type="reset" value="다시작성" style="color: black; background-color: white;">&nbsp;
		<c:if test="${sessionScope.id eq 'admin'}">
		<input type="button" value="목록보기" onclick="location.href='${contextPath}/serviceCenter.do'">
		</c:if>
		<c:if test="${sessionScope.id ne 'admin'}">
		<input type="button" value="목록보기" onclick="location.href='${contextPath}/showBoardListForCustomer.do'" style="color: black; background-color: white;">
		</c:if>
	</form>
	<p>
</body>
</html>