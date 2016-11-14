<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link type="text/css" href="<%=request.getContextPath() %>/resources/bootstrap/css/bootstrap.css" rel="stylesheet"/>
</head>
<body>
 <div class="container-fluid">
  <div class="row-fluid">
   <div class="span12">
    <fieldset>
    <legend>일반 구매자 양식</legend>
    <form class="form-horizontal" method="post" action='' name="" id="">
     <div class="control-group">
      <label class="control-label">아이디</label>
      <div class="controls">
       <input type="text" name="buyer_id" id="" title="" value="" placeholder="아이디">
      </div>
     </div>
     <div class="control-group">
      <label class="control-label">비밀번호</label>
      <div class="controls">
       <input type="text" name="buyer_password" id="buyer_password" title="buyer_password" value="" placeholder="비밀번호">
      </div>
     </div>
     <div class="control-group">
      <label class="control-label">이메일</label>
      <div class="controls">
       <input type="text" name="email" id="email" title="Email" value="" placeholder="이메일">
      </div>
     </div>
     <br>
     <div class="form-actions">
      <button type="submit" class="btn btn-success">가입하기</button>
      <button type="button" class="btn">취소</button>
     </div>
    </form>
    </fieldset>
   </div>
  </div>
 </div>  
</body>
</html>