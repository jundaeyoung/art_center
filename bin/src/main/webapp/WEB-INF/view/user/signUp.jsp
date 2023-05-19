<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 페이지</title>
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
<div class="container">
<form action="/user/signUp" method="post">
			<div class="form-group">
				<label for="username">User name :</label> <input type="text" class="form-control" id="userName" name="userName" value="qwer1234">
			</div>
			<div class="form-group">
				<label for="password">Password :</label> <input type="password" class="form-control" id="password" name="password" value="1234">
			</div>
			<div class="form-group">
				<label for="nickname">nickname :</label> <input type="text" class="form-control" id="nickname" name="nickname" value="항아">
			</div>
			<div class="form-group">
				<label for="email">email :</label> <input type="text" class="form-control" id="email" name="email" value="a@naver.com">
			</div>
			<div class="form-group">
				<label for="birthDate">birthDate :</label> <input type="text" class="form-control" id="birthDate" name="birthDate" value="19950607">
			</div>
			<div class="form-group">
				<label for="tel">tel :</label> <input type="text" class="form-control" id="tel" name="tel" >
			</div>
			
			<button type="submit" class="btn btn-primary">회원가입</button>
		</form>
		</div>
</body>
</html>