<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board</title>
</head>
<body>

	<h1>새 글 작성</h1>
	
	<form method="post"><!-- action을 지정해주지 않으면 그대로.. -->
		제목<br/> <!-- 레이블을 넣어보자 -->
		<input type="text" name="title" required/><br/>
		본문<br/>
		<textarea rows="5" cols="40" name="content" required></textarea><br/>
		작성자  아이디<br/>
		<input type="text" name="userid" required/><br/>
		
		<input type="submit" value="작성 완료">
	</form>
	

</body>
</html>