<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.show__img {
	width: 400px;
	height: 500px;
}
</style>
</head>
<body>
<p>${title}</p>
<p>${content}</p>
<img alt="" src="/images/upload/${imgRoute}" class="show__img">
</body>
</html>