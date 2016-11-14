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
					<td><a href="detail?bno=${vo.bno }">${vo.title }</a></td>
					<td>${vo.userid }</td>
					<td>
						<fmt:formatDate value="${vo.regdate }" 
							pattern="yyyy-MM-dd HH:mm:ss"/>
					</td>
				</tr>
			</c:forEach>
			
		</table>
	
	<!-- jQuery CDN  -->
	<!-- https://developers.google.com/speed/libraries/#jquery 에서 복사-->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script>
		$(document).ready(function() {
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