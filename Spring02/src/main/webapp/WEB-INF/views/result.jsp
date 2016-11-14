<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>코드 확인</h1>
 
인증번호 입력
<input type="text" name="code" id="code">
<button id="btnCheck">확인</button>
 
<div id="right">
아이디: aaaa
비밀번호:bbb
</div>
<div id="wrong">
입력한 값이 틀립니다.
</div>
 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$("#right").hide()
	$("#wrong").hide()
	$("#btnCheck").click(function(){
		var tobecheck = $("#code").val();
		if (tobecheck=="${code}") {
			$("#right").show();
			$("#wrong").hide();
		} else {
			$("#wrong").show();
			$("#right").hide();
		}
	});
});
 
</script>

</body>
</html>