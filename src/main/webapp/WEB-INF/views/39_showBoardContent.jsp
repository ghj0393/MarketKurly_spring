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
	<h2>게시글 정보</h2>
	<table border="1" style="border-collapse: collapse;">
		<tr height="40">
			<th align="center" width="120"> 글번호 </th>
			<td align="center" width="180">${board.num}</td>
			<th align="center" width="120"> 조회수 </th>
			<td align="center" width="180">${board.readcount}</td>
		</tr>
		<tr height="40">
			<th align="center" width="120"> 작성자 </th>
			<td align="center" width="180"> ${board.writer}</td>
			<th align="center" width="120"> 작성일 </th>
			<td align="center" width="180"> ${board.reg_date}</td>
		</tr>
		<tr height="40">
			<th align="center" width="120"> 제목 </th>
			<td align="center" colspan="3"> ${board.title}</td>
		</tr>
		<tr height="80">
			<th align="center" width="120"> 글 내용 </th>
			<td align="center" colspan="3"> ${board.content}</td>
		</tr>
		<tr height="40">
			<td align="center" colspan="4">
				<c:set var="viewer" value="${sessionScope.id}"/>
				<c:if test="${viewer == board.writer or type == 0}">
				<input type="button" value="수정하기" onclick="location.href='${contextPath}/boardUpdateForCustomer.do?num=${board.num}'" style="color: black; background-color: white;">
					<c:if test="${board.re_step == 1}">
					<input type="button" value="게시글 삭제하기" onclick="location.href='${contextPath}/boardDeleteForCustomer.do?num=${board.num}'" style="color: black; background-color: white;">
					</c:if>
					<c:if test="${board.re_step != 1}">
					<input type="button" value="댓글 삭제하기" onclick="location.href='${contextPath}/boardDeleteForCustomer.do?num=${board.num}'" style="color: black; background-color: white;">
					</c:if>
				</c:if>
				<input type="button" value="목록보기" onclick="location.href='${contextPath}/showBoardListForCustomer.do'" style="color: black; background-color: white;">
			</td>
		</tr>
	</table>
	<p>
</body>
</html>
















