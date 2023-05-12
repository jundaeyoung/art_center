<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.Arrays"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="/css/main.css">
</head>
<style>
</style>
<body>

	<div class="title">
		<div>
			<img alt="" src="/images/mark.png" width="100" height="50">
		</div>

		<c:choose>
			<c:when test="${userInfo == null}">
				<div class="user--btn">
					<form action="user/loginTest" method="get">
						<button type="submit" class="login--btn">로그인</button>
					</form>
					<form action="#" method="get">
						<button type="submit" onclick="#" class="signUp--btn">회원가입</button>
					</form>
				</div>
			</c:when>
			<c:otherwise>
				<div class="user--btn">
					<form action="#" method="get">
						<button type="submit" class="logout--btn">내정보</button>
					</form>
					<form action="#" method="get">
						<button type="submit" onclick="#" class="logout--btn"><a href="/user/logout">로그아웃</a>
						</button>
					</form>
					&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					<p>반갑습니다. ${userInfo.nickname} 님</p>
				</div>
			</c:otherwise>
		</c:choose>
	</div>