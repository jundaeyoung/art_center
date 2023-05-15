<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" href="/css/user/show.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<script type="text/javascript" src="/js/main.js"></script>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>

<style>

</style>


<div class="container">
   <div>
      <div id="imail">
         <i class="material-icons">person_outline</i>
      </div>
      <div id="ipw">
         <i class="material-icons">lock_outline</i>
      </div>
      <h5>로그인</h5>
      <br>
      <form action="/user/loginProc" method="post">
         <input type="text" placeholder="아이디를 입력하세요" name="userName" id="userName" class="info"><br> <input type="password" placeholder="비밀번호를 입력하세요" name="password" id="password" class="info"><br>
         <input type="submit" value="로그인" class="login">
      </form>
      <div class="selectIdAndPw">
         <a href="/user/signUp">회원가입</a>
         <p>|</p>
         <a>아이디 찾기</a>
         <p>|</p>
         <a>비밀번호 찾기</a>
      </div>
   </div>
</div>
</body>
</html>