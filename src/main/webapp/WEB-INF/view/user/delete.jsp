<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.container {
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
		<h2>회원탈퇴</h2>
		<p>비밀번호를 입력해주세요.</p>
		<form action="/user/deleteProc" method="POST">
			<div class="form-group">
				<label for="password">Password : <input type="password" class="form-control" id="password" name="password"></label>
			</div>
			<button type="submit" class="btn btn-primary">삭제하기</button>
			<a href="/" class="btn btn-primary">돌아가기</a>
			<div class="form-group">
				<label for="username"><input type="hidden" class="form-control" id="userName" name="userName" value="${user.userName}"></label>
			</div>
		</form>
		<br>
	</div>
</body>
</html>