<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
<script type="text/javascript" src="/js/main.js"></script>

<link rel="stylesheet" href="/css/styles.css">
<link rel="stylesheet" href="/css/user/signIn.css">


<div class="signInContainer">
	<div class="loginContainer">
		<div class="login--title">
		<img alt="" src="/images/background/logo.png" class="loginLogo">
		<h3>Amadeus Login</h3>
		</div>
		<br>
		<form action="/user/loginProc" method="post">
			<div id="imail">
				<i class="material-icons">person_outline</i> <input type="text" placeholder="아이디를 입력하세요" name="userName" id="userName" class="info"><br>
			</div>
			<div id="ipw">
				<i class="material-icons">lock_outline</i> <input type="password" placeholder="비밀번호를 입력하세요" name="password" id="password" class="info"><br>
			</div>
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
	<div class="line"></div>
	<div>
	<a href="https://kauth.kakao.com/oauth/authorize?client_id=2b8daa8c6238674fc9d677d8c51dd08f&redirect_uri=http://localhost:8080/auth/kakao/callback&response_type=code">
	<img alt="" src="/images/kakao_login_medium_wide.png" class="kakaoLogo">
	</a>
	<a href="https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=q3WIWBEaLw_SUTxgY8kb&redirect_uri=https://localhost:8080/auth/naver/callback&state=state_parameter_passthrough_value">네이버</a>
	<a href="https://accounts.google.com/o/oauth2/v2/auth
?client_id=101775853902-vpcpe0bdhvfndednj00mn5bsvij135m5.apps.googleusercontent.com
&redirect_uri=http://localhost:8080/google/callback
&response_type=code&scope=https://www.googleapis.com/auth/userinfo.email">구글</a>
	
	</div>
	<!-- 오픈 api 자리 -->
	</div>
	
	