<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.Arrays"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link rel="stylesheet" href="/css/user/show.css">
<link rel="stylesheet" href="/css/reservationCalendar.css">
<script type="text/javascript" src="/js/reservationCalendar.js"></script>
<style>
.main {
	display: inline-block;
}

.main--content {
	display: flex;
}

.show--content {
	display: flex;
	background-color: aqua;
}

.show--info {
	display: flex;
	flex-direction: column;
	background-color: maroon;
}

.show--title {
	width: 500px;
}

.show--img img {
	height: 300px;
	width: 235px;
	padding-bottom: 0;
}

.btn--ticketing {
	width: 235px;
	margin-left: 0;
	border: none;
	height: 40px;
	background-color: #DBE4EB;
	cursor: pointer;
	border-radius: 15px;
}
</style>

<div class="main">
	<div class="main--content">
		<div class="show--content">
			<div class="show--info">
				<div class="show--title">
					<h1>${title}</h1>
				</div>
				<div class="show--img">
					<img alt="" src="/images/${imgRoute}">

				</div>

				<div class="show--period">
					<p>기간</p>
					<p>${startDate}&nbsp;~&nbsp;${endDate}</p>
				</div>
				<div class="show--times">
					<p>상연 정보</p>
					<c:forEach var="showInfo" items="${showInfo}">
						<p>${showInfo.showDate}&nbsp;${showInfo.showTime}</p>
					</c:forEach>
				</div>
				<div>
					<p>장소</p>
					<p>${location}&nbsp;${name}</p>
				</div>
				<div>
					<p>입장 연령</p>
					<p>${admissionAge}</p>

				</div>
				<div>
					<div>
						<p>주최</p>
						<p>${nickname}</p>
					</div>
					<div>
						<p>문의</p>
						<p>${tel}</p>
					</div>
				</div>
			</div>


		</div>
			<div class="reservation">
			<form action="/ticket/ticketing/${showId}" method="get">
				<div class="reservation--calendar">
					<input type="hidden" id="hiddenShowId" value="${showId}">
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
				<div class="reservation--Time">
					<h3 class="title">관람 시간</h3>
					<div class="watchTime--content">
						<span class="TagPlay"> </span>
					</div>
				</div>
			</form>
			<button type="button" class="btn--ticketing">예매하기</button>
		</div>
</div>
<div class="show--introduction">
	<div>
		<p>작품소개</p>

	</div>
	<div class="show--introContent">${content}</div>
</div>

</div>





<script type="text/javascript" src="/js/reservationCalendar2.js">

</script>






<%@ include file="/WEB-INF/view/layout/footer.jsp"%>