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
<%-- 	<h1>회원 정보 수정</h1>

	<form action="detail"  method="post">
		아이디<br/>
		<input type="text" name="userid" value="${member.userid }" ><br/>
		비밀번호<br/>
		<input type="text" name="pwd" value="${member.pwd }"><br/>
		이메일<br/>
		<input type="text" name="email" value="${member.email }"><br/>
		<input type="submit" value="수정" />
	</form> --%>

<form id="frm">
회원 번호<br/>
<input type="text" name="mid" value="${vo.mid }" readonly /><br/>
아이디<br/>
<input type="text" name="userid" value="${vo.userid }" readonly><br/>
비밀번호<br/>
<input type="text" name="pwd" value="${vo.pwd }" /><br/>
이메일<br/>
<input type="email" name="email" value="${vo.email }" /><br/>

</form>
<br/>
<!-- 버튼 마다 다른 요청 주소로 submit하기 위해서 -->
<button type="submit" id="btnUpdate">회원 정보 수정</button>
<button type="submit" id="btnDelete">회원 정보 삭제</button>
<button type="button" id="btnList">회원 전체 리스트</button>

<!-- jQuery CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
$(document).ready(function() {
	var frm = $('#frm'); // form 양식 엘리먼트
	
	$('#btnList').click(function() {
		//location = 'list'; // location = 이동할 주소(요청 매핑)
		location = '/ex02/member/list'
	});
	
	// 업데이트 버튼 처리
	$('#btnUpdate').click(function() {
		frm.attr('action', 'update'); // attr('속성이름', '속성값')
		frm.attr('method', 'post');
		frm.submit();
	});
	
	// 삭제 버튼 처리
	$('#btnDelete').click(function() {
		// 삭제 확인 다이얼로그 띄운 후, YES를 클릭했을 때
		frm.attr('action', 'delete');
		frm.attr('method', 'post');
		frm.submit();
	});
	
});
</script>


</body>
</html>