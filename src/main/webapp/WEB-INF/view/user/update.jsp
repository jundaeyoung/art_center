<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인정보 수정 페이지</title>
<style type="text/css">
.container{
margin-left: 50px;
}
</style>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="/css/styles.css">
</head>
<body>
<form action="/update" method="post">
			<div class="container">
			${user.userName}님 정보 수정
			<div class="form-group">
				<input type="hidden" class="form-control" id="userName" name="userName" value="${user.userName}">
			</div>
			<div class="form-group">
				<label for="password">Password :</label> <input type="password" class="form-control" id="password" name="password" value="${user.password}">
			</div>
			<div class="form-group">
				<label for="nickname">nickname :</label> <input type="text" class="form-control" id="nickname" name="nickname" value="${user.nickname}">
			</div>
			<div class="form-group">
				<label for="email">email :</label> <input type="text" class="form-control" id="email" name="email" value="${user.email}">
			</div>
			<div class="form-group">
				<label for="birthDate">birthDate :</label> <input type="text" class="form-control" id="birthDate" name="birthDate" value="${user.birthDate}">
			</div>
			<div class="form-group">
				<label for="tel">tel :</label> <input type="text" class="form-control" id="tel" name="tel"  value="${user.tel}">
			</div>
			
			<button type="submit" class="btn btn-primary">개인정보 수정</button>
		</form>
</body>
</html>