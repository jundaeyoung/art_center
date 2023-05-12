<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.container{
margin-left: 30px;
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
	<h2>로그인</h2>
		<form action="/loginProc" method="POST">
		<div class="text">
			<div class="form-group">
				<label for="username">User name :<input type="text" class="form-control"  id="userName" name="userName"></label> 
			</div>
			<div class="form-group">
				<label for="password">Password :<input type="password" class="form-control" id="password" name="password"></label> 
			</div>
		</div>
			<button type="submit" class="btn btn-primary">로그인</button>
		</form>
	<br>
</div>
</body>
</html>