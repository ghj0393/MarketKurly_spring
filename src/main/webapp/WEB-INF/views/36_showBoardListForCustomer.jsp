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
	<h2>고객센터</h2>
	<hr size="1" color="purple" width="300">
	<br>
	<table border="1" style="border-collapse: collapse;">
		<tr height="30">
			<th width="50" align="center">번호</th>
			<th width="400" align="center">제목</th>
			<th width="200" align="center">작성자</th>
			<th width="200" align="center">작성일</th>
			<th width="50" align="center">조회수</th>
		</tr>
		<c:set var="number" value="${number}"/>
		<c:forEach var="board" items="${boardList}">
			<tr height="30">
				<td width="50" align="center">
					${number}
					<c:set var="number" value="${number-1}"/>
				</td>
				<td width="400" align="left">
					<c:forEach begin="0" end="${board.re_step-1}">
						&nbsp;
					</c:forEach>
					<%-- <c:if test="${sessionScope.id eq board.writer or board.writer eq admin}"> --%>
					
 					<a href="${contextPath}/showBoardContentForCustomer.do?num=${board.num}">
					${board.title}
					</a>
					
					<%-- </c:if>
					<c:if test="${sessionScope.id ne board.writer and board.writer ne admin}">
					<a>
					${board.title}
					</a>
					</c:if> --%>
				</td>
				<td width="200" align="center">
					${board.writer}
				</td>
				<td width="200" align="center">
					${board.reg_date}
				</td>
				<td width="50" align="center">
					${board.readcount}
				</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<table>
		<tr height="30">
			<td width="910" align="right">
				<input type="button" value="글쓰기" 
				onclick="location.href='${contextPath}/boardWriteForCustomer.do'" style="color: black; background-color: white;">
			</td>
		</tr>
	</table>
	<p>
	
	<c:if test="${count > 0}">
		<c:if test="${startPage > clickablePageSize }">
			<a href="${contextPath}/showBoardListForCustomer.do?curPageNum=${startPage - clickablePageSize}">[이전]</a>
		</c:if>
		<c:forEach var="i" begin="${startPage}" end="${endPage}">
			<c:if test="${curPageNum == i}">
			<a href="${contextPath}/showBoardListForCustomer.do?curPageNum=${i}">
				<b style="color: purple;">[${i}]</b>
			</a>
			</c:if>
			<c:if test="${curPageNum != i}">
			<a href="${contextPath}/showBoardListForCustomer.do?curPageNum=${i}">[${i}]</a>
			</c:if>
		</c:forEach>
		<c:if test="${endPage < pageCount}">
			<a href="${contextPath}/showBoardListForCustomer.do?curPageNum=${startPage + clickablePageSize}">[다음]</a>
		</c:if>
	</c:if>

</body>
</html>

















