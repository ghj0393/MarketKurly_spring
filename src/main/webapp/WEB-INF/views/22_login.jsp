<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="${contextPath}/loginPro.do">
		<h1>로그인</h1>
		<hr width="700" color="black" size="3"/>
		<table>
			<tr height="10">
				<td width="300" align="left">
				<font size="2"><b>아이디</b></font>
				</td>
			</tr>
			<tr height="50">
				<td width="300" align="center">
					<input type="text" name="id" placeholder="아이디를 입력하세요" style="width:300px; height:50px">
				</td>
			</tr>
			<tr height="10">
				<td width="300" align="left">
				<font size="2"><b>비밀번호</b></font>
				</td>
			</tr>
			<tr height="50">
				<td width="300" align="center">
					<input type="password" name="pw" placeholder="비밀번호를 입력하세요" style="width:300px; height:50px">
				</td>
			</tr>
			<tr height="50">
				<td width="300" align="right">
					<font size="2"><a href="${contextPath}/findId.do">아이디 찾기</a></font>
					<img alt="top" src="${contextPath}/resources/img/top.jpg">
					<font size="2"><a href="${contextPath}/findPw.do">비밀번호 찾기</a></font>
				</td>
			</tr>
			<tr height="50">
				<td width="300">
					<input type="image" src="${contextPath}/resources/img/login.PNG" id="submit" value="submit" style="width: 320px">
				</td>
			</tr>
			<tr height="50">
				<td width="300">
					<img src="${contextPath}/resources/img/join.PNG" onclick="location.href='${contextPath}/join.do'" width="320"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>