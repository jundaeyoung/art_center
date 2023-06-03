<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script type="text/javascript"
	src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<link rel="stylesheet" href="/css/user/userInfoUpdate.css">
<%@ include file="/WEB-INF/view/layout/header.jsp"%>


<div class="container">
	<div class="signInContainer">
		<div class="loginContainer">
			<div class="login--title">
				<img alt="" src="/images/background/logo.png" class="loginLogo">
			</div>
			<br>
			<form action="/user/update" method="post">
				<br> <input type="hidden" class="form-control" id="userName"
					name="userName" value="${user.userName}">
				<c:choose>
					<c:when test="${user.apiId != null}">
						<input type="hidden" name="password" id="password"
							value="${user.password}">
					</c:when>
					<c:otherwise>
						<div id="ipw">
							<p>비밀번호 :</p>
							<i class="material-icons">lock_outline</i> <input type="password"
								placeholder="비밀번호를 입력하세요" name="password" id="password"
								class="infoPw"> <br>
						</div>
					</c:otherwise>
				</c:choose>
				<span class="error--messege" th:if="${valid_password}">${valid_password}</span>
				<br>
				<div id="ipw">
					<p>닉네임 :</p>
					<i class="material-icons">insert_emoticon</i> <input type="text"
						placeholder="닉네임을 입력하세요" name="nickname" id="nickname"
						class="info" value="${user.nickname}"><br>
				</div>
				<span class="error--messege" th:if="${valid_nickname}">${valid_nickname}</span>
				<br>
				<div id="ipw">
					<p>이메일 :</p>
					<i class="material-icons">mail_outline</i> <input type="email"
						placeholder="이메일을 입력하세요" name="email" id="email" class="info"
						value="${user.email}"><br>
				</div>
				<span class="error--messege" th:if="${valid_email}">${valid_email}</span>
				<br> <input type="hidden" name="birthDate" id="birthDate">
				<div id="ipw">
					<p>전화번호 :</p>
					&nbsp; <i class="material-icons">phone_android</i> <input
						type="text" placeholder="전화번호를 입력하세요" name="tel" id="tel"
						class="info" value="${user.tel}"><br>
				</div>
				<span class="error--messege" th:if="${valid_tel}">${valid_tel}</span>
				<br> <input type="hidden" value="${userInfo.id}" id="apiId"
					name="apiId"> <input type="submit" value="정보수정"
					class="login">
			</form>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/view/layout/footer.jsp"%>


