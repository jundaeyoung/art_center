<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">

.container{
margin-left: 30px;
}

</style>
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="/css/styles.css">
</head>
<body>
<div class="container">
<h1>main이에요</h1>
<c:choose>
<c:when test="${principal == null}">
<a href="/login" id="btn" class="btn btn-primary" id ="btn">로그인</a>
<a href="/signUp" id="btn" class="btn btn-primary" id = "btn">회원가입</a>
</c:when>
<c:otherwise>
<p>${principal.userName}님 안녕하세요.</p>
<a href="/update?userName=${principal.userName}" class="btn btn-primary" id ="btn">수정</a>
<a href="/delete?userName=${principal.userName}" class="btn btn-primary" id ="btn">회원탈퇴</a>
<a href="/logout" class="btn btn-primary"  id ="btn">로그아웃</a>
</c:otherwise>
</c:choose>
</div>

</body>
</html>