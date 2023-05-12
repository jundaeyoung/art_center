<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head> 
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/user/loginProc" method="POST">
		<div>
			<label for="userName"> <input type="text" name="userName" id="userName" value="1">
			</label>
		</div>
		<div>
			<label for="password"> <input type="password" name="password" id="password" value="1234">
			</label>
		</div>
		<div>
			<button type="submit">로그인</button>
		</div>
	</form>
</body>
</html>