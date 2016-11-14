<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Member</title>
</head>
<body>
	<h1>회원 전체 리스트</h1>
	
	<nav>
		<ul>
			<li><a href="register">신규 회원 등록</a></li>
			
		</ul>
	</nav>
	
	<table>
		<tr>
			<th>번호</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이메일</th>
		</tr>	
		<c:forEach var="member" items="${memberList }">
			<tr>
				<td>${member.mid }</td>
				<td><a href="detail?userid=${member.userid}">${member.userid }</a></td>
				<td>${member.password }</td>
				<td>${member.email }</td>
			</tr>
		</c:forEach>
	</table>
	
	<!-- jQuery CDN  -->
	<!-- https://developers.google.com/speed/libraries/#jquery 에서 복사-->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script>
	$(document).ready(function() {
		if ('${insert_result}'=='success') {
			alert('신규 회원 가입 성공')
		} else if ('${insert_result}' == 'fail') {
			alert('신규 회원 가입 실패');
		}
		
		if ('${update_result}'=='success') {
			alert('회원 정보 수정 성공')
		} else if ('${update_result}' == 'fail') {
			alert('회원 정보 수정 실패');
		}
		
		if ('${delete_result}'=='success') {
			alert('회원 정보 삭제 성공')
		} else if ('${update_result}' == 'fail') {
			alert('회원 정보 삭제 실패');
		}
		
	});
	</script>
</body>
</html>