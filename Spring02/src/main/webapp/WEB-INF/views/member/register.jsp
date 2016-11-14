<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Member</title>
</head>
<body>
	
	<h1>신규 회원 등록 페이지</h1>
	
	<!-- form에서 action 속성을 지정하지 않은 경우,
	submit 버튼을 누르면 원래 자기 자신 주소(URL)로 다시 요청(request)을 보냄  -->
	
	<form  method="post">
		아이디<br/>
		<input type="text" name="userid" /><br/>
		비밀번호<br/>
		<input type="password" name="password" /><br/>
		이메일<br/>
		<input type="text" name="email" /><br/>
		<input type="submit" value="등록" />
	</form>
	
	
	
</body>
</html>






























