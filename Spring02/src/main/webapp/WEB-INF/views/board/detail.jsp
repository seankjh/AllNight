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
	<h1>게시글 상세 보기</h1>
	<!-- <form id="frm"> -->
	<form action = "update">
	글번호<br/>
	<input type="text" name="bno" value="${boardVO.bno }" readonly/><br/><!-- name -->
	제목<br/>
	<input type="text" value="${boardVO.title }" readonly/><br/>
	본문<br/>
	<textarea rows="5" cols="40" readonly>${boardVO.content }</textarea><br/>
	작성자 아이디<br/>
	<input type="text" value="${boardVO.userid }" readonly /><br/>
	작성시간<br/>
	<fmt:formatDate value="${boardVO.regdate }"
		pattern="yyyy-MM-dd HH:mm:ss" var="regdate" />
	<input type="text" value="${regdate }" readonly><br/>
	
	<input type="submit" value="수정">
	<input type="button" id="btnList" value="메인으로 돌아가기">
	
	<!-- page 정보를 update 요청에 포함시키기 위해서  -->
	<input type="hidden" name="page" value="${page}" >
	
	</form>
	<!-- jQuery CDN -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script>
	$(document).ready(function() { 
		$('#btnList').click(function() {
			//location = 'list';
			location = 'list-page?page=${page}';
		});
	});
	</script>
	
	<h1>댓글 처리 테스트</h1>
<div>
    <input type="text" name="rtext" id="rtext"
        placeholder="댓글을 입력하세요..." required />
    <input type="text" name="replier" id="replier"
        placeholder="아이디" required />
    <button type="button" id="btnCreate">댓글 입력</button>
</div>

<h2>댓글 목록</h2>
<div>
    <ul id="replies"></ul>
</div>

<div id="modify" >
    <input type="text" name="rno" id="rno_mod" readonly />
    <br/>
    <input type="text" name="rtext" id="rtext_mod" />
    <br/>
    <button id="btn_del">삭제</button>
    <button id="btn_update">수정완료</button>
    <button id="btn_cancel">취소</button>
</div>

<!-- jQuery CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
$(document).ready(function() {
	var bno = ${boardVO.bno};
	$('#modify').hide();
	getAllReplies();
	
	// DB에서 해당 글번호(bno)의 모든 댓글을 읽어오는 함수 정의
	function getAllReplies() {
		// $.getJSON(url, data, callback): 
		//    HTTP GET 요청을 사용해서 JSON 데이터를 로드하는 Ajax 함수
		//    url (필수 파라미터): 요청을 보내는 주소
		//    data (선택 파라미터): 요청과 함께 서버로 보내는 데이터
		//    callback (선택 파라미터): 요청이 성공했을 때 호출되는 콜백 함수
		//var url = '/ex02/replies/all/' + bno;
		var url='/ex02/board/detail/all/'+bno;
		
		$.getJSON(url, function(result) {
			console.log("댓글 개수: " + result.length);
			var list = '';
			/* data의 개수만큼 function()의 내용을 반복해서 수행 */
			$(result).each(function() {
				var date = new Date(this.regdate);
				var dateString = date.toLocaleDateString();
				console.log(dateString);
				
				list += '<li class="reply_list" data-rno="' + this.rno+ '">'
				    + '#' + this.rno + ' '
				    + '<span class="replier">'
				    + this.replier + ' ' 
				    + '</span>'
				    + '<span class="rtext">'
				    + this.rtext
				    + '</span>'
				    + '<span class="regdate">'
				    + ' ' + dateString + ' '
				    + '</span>'
				    + '<button>수정</button>'
				    + '</li>';
				
			}); /* 데이터 개수에 따른 반복문 처리 끝 */
			$('#replies').html(list);
			
		}); /* 서버에서 전달된 JSON 데이터 처리 끝 */
	}; /* end of getAllReplies() */
	
	// btnCreate 버튼 처리: 댓글 입력 기능
	$('#btnCreate').click(function() {
		var rtextString = $('#rtext').val(); /* 댓글 내용 */
		var replierString = $('#replier').val(); /* 댓글 작성자 */
		
		// $.ajax({}): Ajax 방식으로 서버로 GET, POST, PUT, ... 요청을 보내는 함수
		$.ajax({
			type: 'post',
			url: '/ex02/board/detail',
			headers: {
				'Content-Type': 'application/json',
				'X-HTTP-Method-Override': 'POST'
			},
			/* JSON.stringify({}): JavaScript 객체를 JSON 문자열로 변환 */
			data: JSON.stringify({
				bno: bno,
				rtext: rtextString,
				replier: replierString
			}),
			success: function(result) {
				if (result == 1) {
					alert('댓글 입력 성공');
					$('#rtext').val('');
					$('#replier').val('');
				}
				/* 댓글 목록 갱신 */
				getAllReplies();
				
			} /* 콜백 함수 끝 */
		});
		
	}); /* btnCreate() 처리 끝 */
	
	// li 태그 안에 있는 [수정] 버튼 처리
	// -> 삭제/수정완료/취소 메뉴를 보여주기
	$('#replies').on('click', '.reply_list button', function() {
		/* 숨겨져 있는 메뉴를 보여주기 */
		$('#modify').show();
		
		/* 댓글 번호, 내용을 표시 */
		/* 버튼이 속해 있는 li 태그를 찾기 위해서
		  $(this) -> button
		  $(this).parent() -> button의 부모 요소 -> li 태그
		*/
		var reply = $(this).parent();
		/* li 태그의 data-rno 속성값을 읽어옴 */
		var rno = reply.attr('data-rno');
		/* li 태그의 자식 요소 중에서 class가 rtext인 span 요소의 텍스트 */
		var text = reply.children('.rtext').text();
		
		$('#rno_mod').val(rno);
		$('#rtext_mod').val(text);
		
	}); /* [수정] 버튼 클릭 처리 끝 */
	
	// 수정/삭제 메뉴의 [취소] 버튼 처리
	$('#btn_cancel').click(function() {
		$('#modify').hide();
	});
	
	// 수정/삭제 메뉴의 [삭제] 버튼 처리
	$('#btn_del').click(function() {
		var check = confirm('정말 삭제하시겠습니까?');
		if (check == true) {
			var rno = $('#rno_mod').val();
			$.ajax({
				type: 'delete',
				url: '/ex02/board/detail/' + rno,
				headers: {
					'Content-Type': 'application/json',
					'X-HTTP-Method-Override': 'DELETE'
				},
				success: function(result) {
					if (result == 'success') {
						alert(rno + '번 댓글이 삭제됐습니다!');
						$('#modify').hide();
						getAllReplies();
					}
				} /* end callback 함수 */
			}); /* end ajax */
			
		} /* end if */
		
	}); /* [삭제] 버튼 처리 끝*/
	
	$('#btn_update').click(function() {
		// val(), attr(), html(), text(), css()
		var rno = $('#rno_mod').val();
		var text = $('#rtext_mod').val();
		
		$.ajax({
			type: 'put',
			url: '/ex02/board/detail/' + rno,
			headers: {
				'Content-Type': 'application/json',
				'X-Http-Method-Override': 'PUT'
			},
			data: JSON.stringify({
				rno: rno,
				rtext: text
			}),
			success: function(result) {
				if (result == 'success') {
					alert(rno + '번 댓글이 수정됐습니다.');
					$('#modify').hide();
					getAllReplies();
				}
			} /* callback 함수 끝 */
		}); /* ajax 끝 */
		
	}); /* [수정완료] 버튼 처리 끝 */
	
}); // end document ready

</script>
	
	<!-- <br/>
	<button type="submit" id="btnUpdate">게시글 수정</button>
	<button type="submit" id="btnDelete">게시글 삭제</button>
	<button type="submit" id="btnList">게시글 전체 목록</button>
	
	jQuery CDN
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
$(document).ready(function() {
	var frm = $('#frm'); // form 양식 엘리먼트
	
	$('#btnList').click(function() {
		//location = 'list'; // location = 이동할 주소(요청 매핑)
		location = '/ex02/board/list'
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
		var result = confirm('정말 삭제할래요?')
		if (result == true) {
			frm.attr('action', 'delete');
			frm.attr('method', 'post');
			frm.submit();
		}
	});
	
}); 
</script>-->
</body>
</html>