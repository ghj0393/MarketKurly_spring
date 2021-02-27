<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="${contextPath}/searchItemPro.do">
		<h2>상품 검색</h2>
		<table>
		<tr>
			<td align="center">
			<input type="text" name="item_name" style="border-radius: 20px; height:20px;">&nbsp;
			<input type="image" src="${contextPath}/resources/img/search.png" alt="Submit" style="width: 20px;">
			</td>
		</tr>
		</table>
	</form>
	<p>
</body>
</html>