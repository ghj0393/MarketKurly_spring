<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<%-- 외부의 자바스크립트 코드를 jsp파일로 불러오기 위한 명령어 --%>
	<script src="${contextPath}/resources/jq/jquery-1.11.0.min.js"></script>
	<script src="${contextPath}/resources/js/18_join.js"></script>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById("address").value = roadAddr;
                
            }
        }).open();
    }
</script>
</head>
<body>
	<h1>회원가입</h1>
	<hr width="700" color="black" size="3"/>
	<br>
	<table>
		<tr height="50">
			<th width="150">아이디</th>
			<td width="300" align="center">
				<input type="text" id="id" name="id" placeholder="6자 이상의 영문 혹은 영문과 숫자를 조합" style="width:300px; height:40px">
			</td>
			<td width="50">
				<!-- <button id="checkDoubleId">중복확인</button> -->	
				<input type="image" src="${contextPath}/resources/img/checkIdEmail.png" id="checkDoubleId"style="width: 110px">
			</td>
		</tr>
		<tr height="50">
			<th width="150">패스워드</th>
			<td width="300" align="left" colspan="2">
				<input type="password" id="pw" name="pw" placeholder="비밀번호를 입력해주세요" style="width:300px; height:40px">
			</td>	
		</tr>
		<tr height="50">
			<th width="150">이름</th>
			<td width="300" align="left" colspan="2">
				<input type="text" id="name" name="name" placeholder="이름을 입력해주세요" style="width:300px; height:40px">
			</td>	
		</tr>
		<tr height="50">
			<th width="150">휴대폰</th>
			<td width="300" align="left" colspan="2">
				<input type="text" id="tel" name="tel" placeholder="(-)없이 입력" style="width:300px; height:40px">
			</td>	
		</tr>
		<tr height="50">
			<th width="150">주소</th>
			<td width="300" align="left">
				<input type="text" name="address" id="address" placeholder="주소를 입력해주세요" style="width:300px; height:40px">
				<span id="guide" style="color:#999;display:none"></span>
			</td>	
			<!-- <td>
				<button onclick="sample4_execDaumPostcode()">주소 찾기</button>
			</td> -->
		</tr>
		<tr height="50">
			<td colspan="3" align="center">
				<!-- <button onclick="sample4_execDaumPostcode()">주소 찾기</button> -->
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="image" src="${contextPath}/resources/img/checkadress.png" 
				onclick="sample4_execDaumPostcode()" style="width: 300px">
			</td>
		</tr>
		<tr height="50">
			<th width="150">이메일</th>
			<td width="300" align="center">
				<input type="email" id="email" name="email" placeholder="예:marketkurly@kurly.com" style="width:300px; height:40px">
			</td>
			<td width="75">
				<!-- <button id="checkDoubleEmail">중복확인</button> -->
				<input type="image" src="${contextPath}/resources/img/checkIdEmail.png" id="checkDoubleEmail"style="width: 110px">
			</td>
		</tr>
		<tr height="50">
			<td colspan="3" align="center">
				<br>
				<!-- <button id="join">가입하기</button> -->
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="image" src="${contextPath}/resources/img/gotoJoinPro.PNG" 
				id="join" style="width: 300px">
			</td>
		</tr>
	</table>
</body>
</html>

















