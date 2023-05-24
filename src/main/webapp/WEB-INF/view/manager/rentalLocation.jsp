<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
<link rel="stylesheet" href="/css/manager/rentalLocation.css">

<div class="rental__img"></div>
<div class="rental__title">
	<h1>${location}대관</h1>
</div>

<div class="rental__info">
	<h1>예약 정보</h1>
</div>

<div class="content_all">
	<div class="content">
		<div class="rental__info_content">
			<form action="/rental/reservation" method="post">

				<div class="rental__location">
					<label>공연 이름 : ${show.title}</label>
				</div>
				
				<div class="rental__location">
					<label>대관 장소 : ${location}</label>
				</div>

				<div class="rental__date">
					<label>대관 기간 : </label> <input type="text" id="dateTime" name="startDate" value="" onchange="calculatePrice()" />
				</div>

				<div class="rental__hole">
					<label>대관 홀 : </label> <select id="locationSelect" onchange="calculatePrice()" name="holeId">
						<c:forEach var="locationLists" items="${locationLists}">
							<option value="${locationLists.holeId}" data-price="${locationLists.price}">${locationLists.name}</option>
						</c:forEach>
					</select>
				</div>
				<div class="rental__price">
					<p id="totalPrice" style="margin: 0;"></p>
				</div>
				<div class="rental__time">
					<label>대관 시간 : </label> <select id="timeSelect" name="startTime" onchange="calculatePrice()">
						<c:forEach var="timeList" items="${timeList}">
							<option value="${timeList.startTime}" id="${timeList.startTime}">${timeList.startTime}</option>
						</c:forEach>
					</select> <label> ~ </label> <select id="endTime" name="endTime" onchange="calculatePrice()">
						<c:forEach var="timeList" items="${timeList}">
							<option value="${timeList.endTime}">${timeList.endTime}</option>
						</c:forEach>
					</select> <input type="hidden" id="locationId" name="locationId" value="${locationId}">
					<input type="hidden" id="locationId" name="showId" value="${show.id}">
				</div>
				<div class="rental__ok">
					<input type="submit" class="rental__btn" value="신청하기" style="font-size: 20px; margin-right: 50px;">
				</div>
			</form>
			<div class="back" style="margin-left: 200px; margin-top: -80px;">
				<button class="back__btn" onclick="location.href='/rental'" style="font-size: 20px;">취소하기</button>
			</div>
		</div>
	</div>
	<div class="hole__img">
		<img alt="" src="/images/rental/hole.png">
	</div>
</div>

<script type="text/javascript" src="/js/manager/rentalLocation.js"></script>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
