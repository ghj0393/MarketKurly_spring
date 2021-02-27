/**
 * 18_join.js
 */
var contextPath = window.location.pathname.substring(0,
		window.location.pathname.indexOf("/", 2));
var statusId = false;
var statusEmail = false;

$(document).ready(function() {
	$("#checkDoubleId").click(function() {
		if ($("#id").val()) {
			$.ajax({
				type : "POST",
				url : contextPath + "/checkDoubleId.do",
				data : {
					id : $("#id").val()
				},

				success : function(data) {
					var str = '<p id="check">';
					var loc = data.indexOf(str);
					var len = str.length;
					var check = data.substr(loc + len, 1);
					
					if (check == "1") {
						alert("중복된 아이디입니다.");
						$("#id").val("");
						$("#id").focus();
						statusId = false;
					} else {
						alert("사용할 수 있는 아이디입니다.");
						$("#pw").focus();
						statusId = true;
					}
				}
			});
		} else {
			alert("사용할 아이디를 입력하세요.");
			$("#id").focus();
		}
	});

	$("#checkDoubleEmail").click(function() {
		if ($("#email").val()) {
			$.ajax({
				type : "POST",
				url : contextPath + "/checkDoubleEmail.do",
				data : {
					email : $("#email").val()
				},

				success : function(data) {
					var str = '<p id="check">';
					var loc = data.indexOf(str);
					var len = str.length;
					var check = data.substr(loc + len, 1);
					
					if (check == "1") {
						alert("중복된 이메일입니다");
						$("#email").val("");
						$("#email").focus();
						statusEmail = false;
					} else {
						alert("사용할 수 있는 이메일입니다.");
						statusEmail = true;
					}
				}
			});
		} else {
			alert("사용할 이메일을 입력하세요.");
			$("#email").focus();
		}

	});

	$("#join").click(function() {
		if (checkInfo()) {
			if(!statusId){
				alert("아이디 중복체크를 하세요.");
			}
			if(statusId && !statusEmail){
				alert("이메일 중복체크를 하세요.");
			}
			if(statusId && statusEmail){
				$.ajax({
					type : "POST",
					url : contextPath + "/joinPro.do",
					data : {
						id : $("#id").val(),
						pw : $("#pw").val(),
						name : $("#name").val(),
						tel : $("#tel").val(),
						address : $("#address").val(),
						email : $("#email").val()
					},
	
					success : function(data) {
						alert("회원가입이 완료되었습니다.");
						window.location.href = contextPath + "/index.do";
					},
	
					error : function(data) {
						alert("error");
					}
				});
			}
		}
	});

});

function checkInfo() {
	if (!$("#id").val()) {
		alert("아이디를 입력하세요.");
		$("#id").focus();
		return false;
	}

	if (!$("#pw").val()) {
		alert("비밀번호를 입력하세요.");
		$("#passwd").focus();
		return false;
	}

	if (!$("#name").val()) {
		alert("사용자 이름을 입력하세요.");
		$("#name").focus();
		return false;
	}

	if (!$("#tel").val()) {
		alert("전화번호를 입력하세요.");
		$("#tel").focus();
		return false;
	}

	if (!$("#address").val()) {
		alert("주소를 입력하세요.");
		$("#address").focus();
		return false;
	}

	if (!$("#email").val()) {
		alert("이메일을 입력하세요.");
		$("#email").focus();
		return false;
	}
	return true;
}