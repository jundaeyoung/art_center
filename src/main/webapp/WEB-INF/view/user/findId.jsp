<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<html lang="utf-8" xmlns:th="http://www.thymeleaf.org"></html>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
<script type="text/javascript" src="/js/main.js"></script>
<script type="text/javascript"
	src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.11.3.min.js"></script>

<link rel="stylesheet" href="/css/user/findId.css">



<div class="container">
	<div class="signInContainer">
		<div class="loginContainer">
			<div class="login--title">
				<img alt="" src="/images/background/logo.png" class="loginLogo">
			</div>
			<br>
			<form action="/user/findId" method="post">
				<div class="content">

					<span class="error--messege" th:if="${valid_password}">${valid_password}</span>
					<br>
					<div id="ipw" class="email">
						<p>이메일 :</p>
						<i class="material-icons" style="margin-left: 560px;">mail_outline</i>
						<input type="email" placeholder="이메일을 입력하세요" name="email"
							id="email" class="info"><br>
					</div>
					<br>
					<div id="ipw">
						<p>전화번호 :</p>
						&nbsp; <i class="material-icons">phone_android</i> <input
							type="text" placeholder="전화번호를 입력하세요" name="tel" id="tel"
							class="info"><br>
					</div>
					<span class="error--messege" th:if="${valid_tel}">${valid_tel}</span>
					<br> <input type="hidden" value="${roleId}" name="roleId">
					<c:choose>
						<c:when test="${userInfo.id != null}">
							<input type="hidden" value="${apiId}" id="apiId" name="apiId">
						</c:when>
						<c:otherwise>
						</c:otherwise>
					</c:choose>
					<input type="submit" value="아이디찾기" class="login" onclick="save()">
				</div>
			</form>
			<div class="selectIdAndPw"
				style="font-size: 20px; margin-left: 540px;">
				<a href="/user/login">로그인</a>
				<p>|</p>
				<a href="/user/signUp">회원가입</a>
				<p>|</p>
				<a href="/user/findPw">비밀번호 찾기</a>
			</div>
			<div class="logobox">

				<div class="naverLogo">
					<a
						href="https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=q3WIWBEaLw_SUTxgY8kb&state=randomtext&redirect_uri=http://localhost:8080/auth/naver/callback">
						<img alt="" src="/images/btn_naver.png" class="naverLogo">
					</a>
				</div>

				<div class="googleLogo">
					<a
						href="https://accounts.google.com/o/oauth2/v2/auth
		?client_id=101775853902-vpcpe0bdhvfndednj00mn5bsvij135m5.apps.googleusercontent.com
		&redirect_uri=http://localhost:8080/google/callback
		&response_type=code&scope=https://www.googleapis.com/auth/userinfo.email"><img
						alt="" src="/images/btn_google_light_normal_ios.png"></a>
				</div>
				<div class="kakaoLogo">
					<a
						href="https://kauth.kakao.com/oauth/authorize?client_id=2b8daa8c6238674fc9d677d8c51dd08f&redirect_uri=http://localhost:8080/auth/kakao/callback&response_type=code">
						<img alt="" src="/images/kakaoLogo-removebg-preview.png">
					</a>
				</div>

			</div>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
