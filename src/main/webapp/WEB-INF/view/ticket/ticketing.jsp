<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.Arrays"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link rel="stylesheet" href="/css/user/review.css">

<h1>지금부터 예매를 시작하게따~~</h1>



<form action="/ticket/ticketing" method="post">
	<div>
		<label for="showTitle"></label> <select name="showTitle">
			<option value="0">관람할 공연을 선택해 주세요</option>
			<c:forEach var="hobby" items="${showList}">
				<option value="${showList.title}">${showList.title}</option>
			</c:forEach>
		</select>
	</div>
	<div>
		<label for="showDate"><input type="text" name="showDate" id="showDate" value="2023-06-08"> </label>
	</div>
	<div>
		<label for="people"><input type="text" name="people" id="people" value="1"> </label>
	</div>

	<div>
		<button type="submit">예매하기</button>
	</div>
</form>




<%@ include file="/WEB-INF/view/layout/footer.jsp"%>

