<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="display: flex; justify-content: center; align-items: center; flex-direction: column;">
		<div style="display: flex; justify-content: center; align-items: center; margin-top: 150px;">
			<img alt="" src="/images/errorPage.png" width="1500">
		</div>
		<div style="display: flex; flex-direction: row; width: 430px; justify-content: space-between;margin-top: -150px;">
			<form action="/">
				<button type="submit" style="width: 200px; font-size: 30px; height: 60px; border-radius: 5px;">HOME</button>
			</form>
			<button onclick="history.back()" style="width: 200px; font-size: 30px; height: 60px; border-radius: 5px;">뒤로가기</button>
		</div>
	</div>

</body>
</html>