<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.Arrays"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link rel="stylesheet" href="/css/main.css">
<link rel="stylesheet" href="/css/ticketing.css">
<script type="text/javascript" src="/js/seatSelection.js"></script>
<script type="text/javascript" src="/js/ticketingCalendar.js"></script>
<style>
.tickting--img img {
	height: 300px;
}

.main {
	display: inline-block;
}
</style>

<div class="main">

	<h1>${title}</h1>

	<div class="tickting--img">
		<img alt="" src="/images/${imgRoute}">
	</div>

	<form action="/ticket/ticketing" method="post">
		<input type="hidden" id="hiddenShowId" value="${showId}">
		<div class="">
			<table class="Calendar">
				<thead>
					<tr>
						<td onClick="prevCalendar();" style="cursor: pointer;">&#60;</td>
						<td colspan="5"><span id="calYear"></span>년 <span id="calMonth"></span>월</td>
						<td onClick="nextCalendar();" style="cursor: pointer;">&#62;</td>
					</tr>
					<tr>
						<td>일</td>
						<td>월</td>
						<td>화</td>
						<td>수</td>
						<td>목</td>
						<td>금</td>
						<td>토</td>
					</tr>
				</thead>

				<tbody>
				
					
					<c:forEach var="showDateList" items="${showDateList}">
						<input type="hidden" class="listDate" value="${showDateList.showDate}">					
					</c:forEach>
				
				</tbody>
			</table>
		</div>

		<div>
		
		
		
		
		
		</div>










		<div>
			좌석 정보 <span>인원수 선택 : </span> <select id="person">
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


</div>

<%@ include file="/WEB-INF/view/layout/footer.jsp"%>

