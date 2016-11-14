<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board</title>
</head>
<body>

	<h1>게시글 수정/삭제 페이지</h1>
	
	<form id="frm">
	

	<input type="hidden" name="bno" value="${boardVO.bno }" /><br/><!-- 보내야하니까 name이 있어야 해 -->
	
	제목<br/>
	<input type="text" name="title" value="${boardVO.title }" /><br/>
	
	본문<br/>
	<textarea rows="5" cols="40" name="content" >${boardVO.content }</textarea><br/>
	
	작성자 아이디<br/>
	<input type="text" value="${boardVO.userid }" readonly /><br/>
	<%-- 
	작성시간<br/>
	<fmt:formatDate value="${boardVO.regdate }"
		pattern="yyyy-MM-dd HH:mm:ss" var="regdate" />
	<input type="text" value="${regdate }" readonly>
	 --%>
	 
	 <!-- 수정완료/삭제 할 때   -->
	 <input type="hidden" name="page" value="${page}" />
	 
	 
	 
	</form>
	<br/>
	<button type="submit" id="btnUpdate">수정 완료</button>
	<button type="submit" id="btnDelete">삭제</button>
	<button type="button" id="btnCancel">취소</button>
	<button type="button" id="btnList">메인으로 돌아가기</button>
	
	<!-- jQuery CDN -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<script>
			$(document).ready(function() {
				var frm = $('#frm');
				
				$('#btnList').click(function() {
					location = 'list-page?${page}';
				})
				
			
				$('#btnCancel').click(function() {
					//location = 'list'; // location = 이동할 주소(요청 매핑)
					location = 'detail?bno=${boardVO.bno}&page=${page}';
				});
				
				
				// 업데이트 버튼 처리
				$('#btnUpdate').click(function() {
					frm.attr('action', 'update'); // attr('속성이름', '속성값')
					frm.attr('method', 'post');
					frm.submit();
				});
				
				// 삭제

				$('#btnDelete').click(function(){
					var result = confirm('정말 삭제하시겠습니까?');
					if(result == true){
					frm.attr('action','delete');
					frm.attr('method','post');
					frm.submit();
					}
				});
				
			});
		</script>
</body>
</html>