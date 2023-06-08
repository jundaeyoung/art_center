<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
<script type="text/javascript" src="/js/main.js"></script>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<link rel="stylesheet" href="/css/user/signIn.css">


<div class="signInContainer" >
	<div class="loginContainer">
		<div class="login--title">
			<img alt="" src="/images/background/logo.png" class="loginLogo">
		</div>
		<br>
		<form action="/user/loginProc" method="post">
			<div id="imail">
			<label>
				아이디 :					
			</label>
				<i class="material-icons">person_outline</i> <input type="text" placeholder="아이디를 입력하세요" name="userName" id="userName" class="info"><br>
			</div>
			<div id="ipw">
			<label>
				비밀번호 : 
			</label>
				<i class="material-icons">lock_outline</i> <input type="password" placeholder="비밀번호를 입력하세요" name="password" id="password" class="info"><br>
			</div>
			<input type="submit" value="로그인" class="login">
		</form>
		<div class="selectIdAndPw">
			<a href="/user/signUp">회원가입</a>
			<p>|</p>
			<a href="/user/findId">아이디 찾기</a>
			<p>|</p>
			<a href="/user/findPw">비밀번호 찾기</a>
		</div>
			<div class="logobox">
		
		<div class="naverLogo">
			<a href="https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=q3WIWBEaLw_SUTxgY8kb&state=randomtext&redirect_uri=http://192.168.0.85:8080/auth/naver/callback"> <img alt=""
				src="/images/btn_naver.png" class="naverLogo"></a>
		</div>

		<div class="googleLogo">
		<a href="https://accounts.google.com/o/oauth2/v2/auth
		?client_id=101775853902-vpcpe0bdhvfndednj00mn5bsvij135m5.apps.googleusercontent.com
		&redirect_uri=http://localhost:8080/google/callback
		&response_type=code&scope=https://www.googleapis.com/auth/userinfo.email"><img alt="" src="/images/btn_google_light_normal_ios.png"></a>
		</div>
		<div class="kakaoLogo">
			<a href="https://kauth.kakao.com/oauth/authorize?client_id=2b8daa8c6238674fc9d677d8c51dd08f&redirect_uri=http://192.168.0.85:8080/auth/kakao/callback&response_type=code"> <img alt=""
						src="/images/kakaoLogo-removebg-preview.png">
					</a>
				</div>
		
			</div>
			</div>
</div>

<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
