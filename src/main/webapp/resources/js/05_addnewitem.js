/**
 * 05_addnewitem.js
 */
var contextPath = window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));

$(document).ready(function(){
	$("#submit").click(function(){
		
		if (!$("#item_name").val()) {
			alert("상품명을 입력하세요.");
			$("#item_name").focus();
			return false;
		}

		if (!$("#item_price").val()) {
			alert("상품가격을 입력하세요.");
			$("#item_price").focus();
			return false;
		}

		if (!$("#item_stock").val()) {
			alert("상품재고를 입력하세요.");
			$("#item_stock").focus();
			return false;
		}
		
		if (!$("#item_image").val()) {
			alert("이미지를 입력하세요.");
			$("#item_image").focus();
			return false;
		}

		if (!$("#item_info").val()) {
			alert("상품정보를 입력하세요.");
			$("#item_info").focus();
			return false;
		}

		if (!$("#discount_rate").val()) {
			alert("할인률을 입력하세요.");
			$("#discount_rate").focus();
			return false;
		}
		
		$("#fileUploadForm").ajaxForm({
			success : function(data){
				alert("상품등록완료!");
				window.location.href=contextPath+"/itemListForManager.do";
			}
		});
	});
});

















