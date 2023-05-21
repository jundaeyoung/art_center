<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.Arrays"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link rel="stylesheet" href="/css/main.css">
<link rel="stylesheet" href="/css/reservationCalendar.css">
<script type="text/javascript" src="/js/reservationCalendar.js"></script>

<script type="text/javascript" src="/js/seatSelection.js"></script>

<style>
.main {
	display: inline-block;
}
</style>

<div class="main">

	<div class="reservation">
		<form action="/ticket/ticketing/${showId}" method="post">
			<div class="reservation--calendar">
				<input type="hidden" id="hiddenShowId" value="${showId}">
				<div>
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
			</div>
			<div class="reservation--Time">
				<h3 class="title">관람 시간</h3>
				<div class="watchTime--content">
					<span class="TagPlay"> </span>
				</div>
			</div>

			<div>

				<div>좌석 선택</div>
				<p>${title}</p>
				<div></div>
			</div>

			<div class="side--middle">

				<div>좌석 정보</div>
				<span>인원수 선택 : </span> <select id="person">
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

			<button type="button" class="btn--ticketing">예매하기</button>
		</form>
	</div>
</div>


<script type="text/javascript" src="/js/reservationCalendar2.js"></script>

<%@ include file="/WEB-INF/view/layout/footer.jsp"%>

