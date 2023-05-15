<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.Arrays"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link rel="stylesheet" href="/css/user/review.css">
<script type="text/javascript" src="/js/seatSelection.js"></script>


<h1>지금부터 예매를 시작하게따~~</h1>
<!--  

여기에 공연 아이디 갖고와야함



-->

<form action="/ticket/ticketing" method="post">
<c:forEach var="showInfo">
	<div>
		<input type="date" name="showDate">
	</div>






</c:forEach>
	<div>
		<select>
			<option></option>		
		</select>

	</div>
	<div>
		좌석 정보
		
		<span>인원수 선택 : </span>
		<select id="person">
			<option value="1">1명</option>
			<option value="2">2명</option>
			<option value="3">3명</option>
			<option value="4">4명</option>
			<option value="5">5명</option>
		</select>

		<table border="1">
			<tr>
				<td><label><input type="checkbox" />1</label></td>
				<td><label><input type="checkbox" />2</label></td>
				<td><label><input type="checkbox" />3</label></td>
				<td><label><input type="checkbox" />4</label></td>
				<td><label><input type="checkbox" />5</label></td>
				<td><label><input type="checkbox" />6</label></td>
			</tr>
			<tr>
				<td><label><input type="checkbox" />7</label></td>
				<td><label><input type="checkbox" />8</label></td>
				<td><label><input type="checkbox" />9</label></td>
				<td><label><input type="checkbox" />10</label></td>
				<td><label><input type="checkbox" />11</label></td>
				<td><label><input type="checkbox" />12</label></td>
			</tr>
		</table>
	</div>
	<div>
		<button type="submit">예매하기</button>
	</div>
</form>




<%@ include file="/WEB-INF/view/layout/footer.jsp"%>

