<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="/css/manager/managerShowSaleDetail.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<script type="text/javascript" src="/js/main.js"></script>

<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>




<div class="show__header"></div>
<div class="signUpShow__content">
	<div class="signUpShow__info">
		<form action="/manager/showSaleByDate" method="post">
			<div style="display: flex; width: 700px; flex-direction: row; justify-content: center;">
				<div style="height:; display: flex; flex-direction: row; justify-content: flex-start;">
					<div class="date">
						<label for="content">기간선택 : </label> <input type="text" id="startDate" name="startDate" style="width: 300px;" />
					</div>
					<div>
						<input type="hidden" id="infant_rate" value="${principal.getId()}" name="organizerId">
					</div>
					<div class="btn__sub">
						<button type="submit" style="width: 100px; height: 50px;">검색</button>
					</div>
				</div>
			</div>
		</form>
	</div>
	<div class="signUpShow__info">
		<form action="/manager/showSaleBySearch" method="post">
			<div style="display: flex; width: 700px; flex-direction: row; justify-content: center;">
				<div style="height:; display: flex; flex-direction: row; justify-content: flex-start;">
					<div class="date">
						<label for="title">제 목 : </label> <input type="text" id="title" name="title" style="width: 300px;" />
					</div>
					<div>
						<input type="hidden" id="infant_rate" value="${principal.getId()}" name="organizerId">
					</div>
					<div class="btn__sub">
						<button type="submit" style="width: 100px; height: 50px;">검색</button>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>
<div>
	<div class="show">
		<div class="review__content">
			<c:choose>
				<c:when test="${imgRoute==null}">
					<h1>주문 목록이 없습니다.</h1>
				</c:when>
				<c:otherwise>
					<div>
						<img src="/images/${imgRoute}" width="230" height="300">
					</div>
					<div class="show__content">
						<h1>공연 정보</h1>
						<div>
							<p>제 목 : ${title}</p>
							<p>기간 :</p>
						</div>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
		<h1>주문 목록</h1>
		<c:forEach var="showList" items="${showList}">
			<fmt:parseNumber var="adultRate" type="number" value="${showList.adultRate}" />
			<fmt:formatNumber value="${adultRate}" pattern="#,##0" var="formattedAdultRate" />
			<fmt:parseNumber var="youthRate" type="number" value="${showList.youthRate}" />
			<fmt:formatNumber value="${youthRate}" pattern="#,##0" var="formattedYouthRate" />
			<fmt:parseNumber var="infantRate" type="number" value="${showList.infantRate}" />
			<fmt:formatNumber value="${infantRate}" pattern="#,##0" var="formattedInfantRate" />
			<c:set var="totalAdultPrice" value="${adultRate * showList.adultCount}" />
			<c:set var="totalYouthPrice" value="${adultRate * showList.youthCount}" />
			<c:set var="totalInfantPrice" value="${adultRate * showList.infantCount}" />

			<fmt:formatNumber value="${totalAdultPrice}" pattern="#,##0" var="A__price" />
			<fmt:formatNumber value="${totalYouthPrice}" pattern="#,##0" var="Y__price" />
			<fmt:formatNumber value="${totalInfantPrice}" pattern="#,##0" var="I__price" />

			<c:set var="totalPrice" value="${totalAdultPrice+totalYouthPrice+totalInfantPrice}" />
			<fmt:formatNumber value="${totalPrice}" pattern="#,##0" var="T__price" />


			<div class="money__content">
				<div id="money">
					<div>
						<c:choose>
							<c:when test="${showList.adultCount!=0}">
								<p>성인 : ${formattedAdultRate}</p>
							</c:when>
							<c:when test="${showList.youthCount!=0}">
								<p>청소년 : ${formattedYouthRate}</p>
							</c:when>
							<c:otherwise>
								<p>유아 : ${formattedInfantRate!=0}</p>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
				<h3>총 합계 : ${T__price}</h3>
			</div>
		</c:forEach>
	</div>
</div>


<script type="text/javascript">
	$(function() {
		$('#startDate').daterangepicker(
				{
					"locale" : {
						"format" : "YYYY-MM-DD",
						"separator" : " ~ ",
						"applyLabel" : "확인",
						"cancelLabel" : "취소",
						"fromLabel" : "From",
						"toLabel" : "To",
						"customRangeLabel" : "Custom",
						"weekLabel" : "W",
						"daysOfWeek" : [ "월", "화", "수", "목", "금", "토", "일" ],
						"monthNames" : [ "1월", "2월", "3월", "4월", "5월", "6월",
								"7월", "8월", "9월", "10월", "11월", "12월" ],
						"firstDay" : 0
					},
					"startDate" : "2023-5-16",
					"endDate" : "2023-10-23",
					"drops" : "down"
				},
				function(start, end, label) {
					console.log('New date range selected: '
							+ start.format('YYYY-MM-DD') + ' to '
							+ end.format('YYYY-MM-DD') + ' (predefined range: '
							+ label + ')');
				});
	});

	// 파일 업로드 시 이름 나오도록 
	$("#file").on('change', function() {
		var fileName = $("#file").val();
		$(".upload-name").val(fileName);
	});
</script>

<%@ include file="/WEB-INF/view/layout/footer.jsp"%>

