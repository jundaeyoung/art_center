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

<link rel="stylesheet" href="/css/user/signUp.css">



<div class="container">
	
				<div class="signUpContainer">
				<div class="choiceContainer">
				<img alt="" src="/images/user-icon-normal.png" id="signUpicon">
					<a href="/user/signUpchoice?roleId=1" class="signUp" style="color: #fff">일반회원</a><br>
					<h3>14세 이상 개인</h3>
				</div>
				<div class="choiceContainer">
				<img alt="" src="/images/user-icon-biz.png" id="signUpicon">
					<a href="/user/signUpchoice?roleId=2" class="signUp" style="color: #fff;">매니저</a><br>
					<h3>공연 주최자</h3>
				</div>
				</div>
				
</div>

<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
