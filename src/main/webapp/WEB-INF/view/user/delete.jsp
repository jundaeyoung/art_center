<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" href="/css/user/signUp.css">



<div class="container">
	<div class="signInContainer">
	<div class="loginContainer"style="margin-top: 200px;">
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
			<input type="submit" value="회원탈퇴" class="login" style="margin-left: -100px;margin-bottom: 300px;">
		</form>
			</div>
			</div>
			</div>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
			
			