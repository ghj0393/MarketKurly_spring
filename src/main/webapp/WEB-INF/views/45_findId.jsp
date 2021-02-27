<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="${contextPath}/findIdPro.do">
		<h1>아이디 찾기</h1>
		<hr width="700" color="black" size="3"/>
		<table>
			<tr height="10">
				<td width="300" align="left">
				<font size="2"><b>이름</b></font>
				</td>
			</tr>
			<tr height="50">
				<td width="300" align="center">
					<input type="text" name="name" placeholder="고객님의 이름을 입력하세요" style="width:300px; height:50px">
				</td>
			</tr>
			<tr height="10">
				<td width="300" align="left">
				<font size="2"><b>이메일</b></font>
				</td>
			</tr>
			<tr height="50">
				<td width="300" align="center">
					<input type="email" name="email" placeholder="가입 시 등록하신 이메일 주소를 입력하세요" style="width:300px; height:50px"><br>
				</td>
			</tr>
			<tr height="100">
				<td width="300">
					<input type="image" src="${contextPath}/resources/img/check.PNG" id="submit" value="submit" style="width: 320px">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>