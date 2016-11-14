<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>   
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Board</title>
	<style>
		table, th, td {
			border-bottom: 1px solid gray;
			border-collapse: collapse;
		}
		th {
			background-color: lightpink;
			border-left: 1px solid white;
		}
		ul {
			list-style-type: none;
		}
		li {
			display:inline-block;
		}
	</style>
</head>
<body>
	<h1>게시글 전체 목록</h1>
	<nav>
		<ul>
			<li><a href="register">새 게시글 작성</a></li>
		</ul>
	</nav>
	
	<hr/>
	
		<table>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성시간</th>
			</tr>
			<c:forEach var="vo" items="${boardList }">
				
				<tr>
					<td>${vo.bno }</td>
					<%-- <td><a href="detail?bno=${vo.bno }">${vo.title }</a></td> --%>
					<td><a href="${vo.bno }">${vo.title }</a></td>
					<td>${vo.userid }</td>
					<td>
						<fmt:formatDate value="${vo.regdate }" 
							pattern="yyyy-MM-dd HH:mm:ss"/>
					</td>
				</tr>
			</c:forEach>
			
		</table>
		<br/>
		<ul class="pageLinks">
			<c:if test="${pageMaker.hasPrev }">
				<%-- <li><a href="list-page?page=${pageMaker.startPageNum - 1 }"> --%>
				<li><a href="${pageMaker.startPageNum - 1 }">
				&laquo;이전</a></li>
			</c:if>
			
			<c:forEach begin="${pageMaker.startPageNum }" 
					end="${pageMaker.endPageNum }"
					var="num">
				<%-- <li><a href="list-page?page=${num }">${num }</a></li> --%>
				<li><a href="${num }">${num }</a></li>
			</c:forEach>
			
			<c:if test="${pageMaker.hasNext }">
				<%-- <li><a href="list-page?page=${pageMaker.endPageNum + 1}"> --%>
				<li><a href="${pageMaker.endPageNum + 1}"> 
				다음&raquo;</a></li>
			</c:if>
		</ul>
	
	<%-- 현재 페이지, 페이지 당 보여줄 게시글 개수를 보내주기 위해서 --%>
	<%-- 사용자에게는 보이지 않지만, 서버로 보낼 정보를 양식 데이터로 저장하는 form  --%>
	<form id="pageForm">
		<input type="hidden" name="bno" />
		<input type="hidden" name="page" value="${pageMaker.criteria.page }">
		<input type="hidden" name="perPage" value="${pageMaker.criteria.perPage }"/>
	</form>
	
	
	<!-- jQuery CDN  -->
	<!-- https://developers.google.com/speed/libraries/#jquery 에서 복사-->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script>
		$(document).ready(function() {
			var frm = $('#pageForm');
			
			// table 안의 tr 안의 td 안의 a 태그 click 커스터마이징(Customizing:주문 제작)
			 $('table tr td a').click(function() { 
				event.preventDefault();// 기존의 a태그 역할을 막는다.(우리가 url주소를 만들기 위해) // 
				
				var bno = $(this).attr('href');
				//this의 속성중에서 href값을 읽어오겠다.
				frm.find('[name="bno"]').val(bno);
				
				frm.attr('action', 'detail');
				frm.attr('method', 'get');
				frm.submit(); // form을 submit 사용자에겐 보이진 않음
			});
			
				// ul 태그 안의 li 태그 안의 a 태그를 찾아서 click 이벤트를 커스터 마이징
				// ul태그 밑에 있는 li태그 밑에있는 a태그
				/* $('ul li a').click(function() { */
			// 클래스 pageLinks 안의 tr 안의 td 안의 a 태그 click 커스터마이징(Customizing:주문 제작)
			$('.pageLinks li a').click(function() {
				event.preventDefault();// 기본 이벤트 처리 방식을 방지(막음)
				// pageForm 안에 있는 name="page"인 요소를 찾음
				// 이동할 페이지 번호를 세팅
				var targetPage = $(this).attr('href'); // this: <a>
								// ㄴ 실제로 클릭한 a태그 하나
				
				frm.find('[name="page"]').val(targetPage);
								
				// 페이징 화면으로 보내기 위한 action 정보 // 페이징 화면으로 보내기
				frm.attr('action', 'list-page');	
				
				// 페이징 화면을 처리하는 Controller의 method(요청 처리 방식)-GET
				frm.attr('method', 'get');
				
				// 폼 양식을 서버로 전송
				frm.submit();
			});

			
			
			
			if ('${insert_result}' == 'success') {
				alert('새 글이 정상적으로 등록됐습니다.');
			} else if ('${insert_result}' == 'fail') {
				alert('새 글 등록 실패!');
			}
			if ('${update_result}' == 'success') {
				alert('${bno}번 글이 정상적으로 수정됐습니다.');
			} else if ('${update_result}' == 'fail') {
				alert('${bno}번 글 수정 실패!');
			}
			if ('${delete_result}' == 'success') {
				alert('${bno}번 글이 정상적으로 삭제됐습니다.');
			} else if ('${delete_result}' == 'fail') {
				alert('${bno}번 글 삭제 실패!');
			}
		});
	</script>
</body>
</html>