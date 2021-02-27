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
					<a href="${contextPath}/showBoardContentForAdmin.do?num=${board.num}">
					${board.title}
					</a>
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
				onclick="location.href='${contextPath}/boardWriteForAdmin.do'" style="color: black; background-color: white;">
			</td>
		</tr>
	</table>
	<p>
	
	<c:if test="${count > 0}">
		<c:if test="${startPage > clickablePageSize }">
			<a href="${contextPath}/serviceCenter.do?curPageNum=${startPage - clickablePageSize}">[이전]</a>
		</c:if>
		<c:forEach var="i" begin="${startPage}" end="${endPage}">
			<c:if test="${curPageNum == i}">
			<a href="${contextPath}/serviceCenter.do?curPageNum=${i}">
				<b style="color: purple;">[${i}]</b>
			</a>
			</c:if>
			<c:if test="${curPageNum != i}">
			<a href="${contextPath}/serviceCenter.do?curPageNum=${i}">[${i}]</a>
			</c:if>
		</c:forEach>
		<c:if test="${endPage < pageCount}">
			<a href="${contextPath}/serviceCenter.do?curPageNum=${startPage + clickablePageSize}">[다음]</a>
		</c:if>
	</c:if>

</body>
</html>

















