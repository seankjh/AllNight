<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>

</head>
<body>

	<form action="test" method="post" enctype="multipart/form-data">
		파일이름<input type="text" name="name"><br/>
		<input type="file" name="file"><br/> 
		<input type="submit" value="Upload"> 
	</form>
	
</body>
</html>