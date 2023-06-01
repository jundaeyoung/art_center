<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<html lang="utf-8" xmlns:th="http://www.thymeleaf.org"></html>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
<script type="text/javascript" src="/js/main.js"></script>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<link rel="stylesheet" href="/css/user/signUp.css">
<body>
<div class="container">
	<div class="signInContainer">
	<div class="loginContainer">
		<div class="login--title">
			<img alt="" src="/images/background/logo.png" class="loginLogo">
		</div>
		<br>
		<form action="/user/deleteProc" method="post">
			<br>
			<input type="hidden" class="form-control" id="userName" name="userName" value="${user.userName}">
			<c:choose>
				<c:when test="${user.apiId != null}">
				<input type="hidden"  name="password" id="password" value="${user.password}">
				</c:when>
				<c:otherwise>
				<div id="ipw">
				<p>비밀번호 :</p>
				<i class="material-icons" style="margin-left:440px;">lock_outline</i> <input type="password" placeholder="비밀번호를 입력하세요" name="password" id="password" class="infoPw">
				<br>
				</div>
				<span class="error--messege" th:if="${valid_password}">${valid_password}</span>
				</c:otherwise>
			</c:choose>
			<input type="submit" value="회원탈퇴" class="login" style="margin-left: -100px;">
		</form>
			</div>
			</div>
			</div>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
			
			