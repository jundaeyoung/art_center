<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="/css/manager/managerShowSale.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<script type="text/javascript" src="/js/main.js"></script>

<script type="text/javascript"
	src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://www.gstatic.com/charts/loader.js"></script>

<div class="show__header"></div>
<div class="signUpShow__content" style="margin-left: -60px;">
	<div class="btn__sub" style="margin-top: -30px;">
		<a href="/manager/showSale"><button
				style="width: 150px; height: 50px;">전체 검색</button></a>
	</div>
	<div class="signUpShow__info">
		<form action="/manager/showSaleByDate" method="post">
			<div
				style="display: flex; width: 600px; flex-direction: row; justify-content: center;">
				<div
					style="height:; display: flex; flex-direction: row; justify-content: flex-start;">
					<div class="date">
						<label for="content">기간선택 : </label> <input type="text"
							id="startDate" name="startDate" style="width: 300px;" />
					</div>
					<div>
						<input type="hidden" id="infant_rate" value="${principal.getId()}"
							name="organizerId">
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
			<div
				style="display: flex; width: 500px; flex-direction: row; justify-content: center;">
				<div
					style="height:; display: flex; flex-direction: row; justify-content: flex-start;">
					<div class="date">
						<label for="title">제 목 : </label> <input type="text" id="title"
							name="title" style="width: 300px;" />
					</div>
					<div>
						<input type="hidden" id="infant_rate" value="${principal.getId()}"
							name="organizerId">
					</div>
					<div class="btn__sub">
						<button type="submit" style="width: 100px; height: 50px;">검색</button>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>
<div class="sumdiv">
	<div class="sum">
		<h3></h3>
		<h3>매 출 :</h3>
		<h3>${sum}원</h3>
		<h3></h3>
	</div>
</div>
<div id="chart_div" style="height: 300px;"></div>
<div>
	<div class="show">
		<c:forEach var="showList" items="${showList}">
			<a
				href="/manager/showSaleDetailByShowId/${showList.showId}/${principal.getId()}">
				<div class="review__content" style="margin-left: -30px;">
					<div>
						<img src="/images/${showList.imgRoute}" width="230" height="300">
					</div>
					<div class="show__content">
						<h1>공연 정보</h1>
						<div style="width: 400px;">
							<p>제 목 : ${showList.title}</p>
							<p>기간 :
								${showList.startDate}&nbsp&nbsp~&nbsp&nbsp${showList.endDate}</p>
							<c:choose>
								<c:when test="${showList.showStatus==1}">
									<p>공연 상태 : 공연중</p>
								</c:when>
								<c:otherwise>
									<p>공연 상태 : 공연 종료</p>
								</c:otherwise>
							</c:choose>

						</div>
					</div>
					<fmt:parseNumber var="adultRate" type="number"
						value="${showList.adultRate}" />
					<fmt:formatNumber value="${adultRate}" pattern="#,##0"
						var="formattedAdultRate" />
					<fmt:parseNumber var="youthRate" type="number"
						value="${showList.youthRate}" />
					<fmt:formatNumber value="${youthRate}" pattern="#,##0"
						var="formattedYouthRate" />
					<fmt:parseNumber var="infantRate" type="number"
						value="${showList.infantRate}" />
					<fmt:formatNumber value="${infantRate}" pattern="#,##0"
						var="formattedInfantRate" />
					<c:set var="totalAdultPrice"
						value="${adultRate * showList.adultCount}" />
					<c:set var="totalYouthPrice"
						value="${adultRate * showList.youthCount}" />
					<c:set var="totalInfantPrice"
						value="${adultRate * showList.infantCount}" />

					<fmt:formatNumber value="${totalAdultPrice}" pattern="#,##0"
						var="A__price" />
					<fmt:formatNumber value="${totalYouthPrice}" pattern="#,##0"
						var="Y__price" />
					<fmt:formatNumber value="${totalInfantPrice}" pattern="#,##0"
						var="I__price" />

					<c:set var="totalPrice"
						value="${totalAdultPrice+totalYouthPrice+totalInfantPrice}" />
					<fmt:formatNumber value="${totalPrice}" pattern="#,##0"
						var="T__price" />


					<div class="money__content">
						<h1>매출</h1>
						<div id="money">
							<div style="width: 300px;">
								<p>성인요금 : ${formattedAdultRate}</p>
								<p>청소년 요금 : ${formattedYouthRate}</p>
								<p>유아 요금 : ${formattedInfantRate}</p>
							</div>
							<div
								style="border: none; border-top: 1px solid #ccc; border-bottom: 1px solid #ccc; width: 150px;">
								<p>인원 : ${showList.adultCount}</p>
								<p>인원 : ${showList.youthCount}</p>
								<p>인원 : ${showList.infantCount}</p>
							</div>
							<div style="width: 200px;">
								<p>합계 : ${A__price}</p>
								<p>합계 : ${Y__price}</p>
								<p>합계 : ${I__price}</p>
							</div>
						</div>
						<h3>총 합계 : ${T__price}</h3>
					</div>
				</div>
			</a>
		</c:forEach>
	</div>
</div>


<script type="text/javascript">
$(document).ready(function() {
	$.ajax({
    	type: 'get',
    	url: '/apiShowSale/manager/showSale',
  	    contentType: 'application/json; charset=utf-8',
  }).done(function(response) {
	google.charts.load('current', {
		packages : [ 'corechart', 'bar' ]
	});

	google.charts.setOnLoadCallback(drawBasic);

	function drawBasic() {
		var data = new google.visualization.DataTable();
		data.addColumn('string', '요일');
		data.addColumn('number', '방문자수(명)');
		for(var i=0; i<response.length;i++){
	console.log("DDD");
			console.log(i);
			data.addRows([
			[ response[i].title, 2 ],
			]);
		}
		var options = {
			title : '이번주 일별 방문자 현황',
			hAxis : {
				title : '요일',
				viewWindow : {
					min : [ 7, 30, 0 ],
					max : [ 17, 30, 0 ]
				}
			},
			vAxis : {
				title : '방문자수(명)'
			}
		};
		var chart = new google.visualization.ColumnChart(
		document.getElementById('chart_div'));
		chart.draw(data, options);

	}
  });
});
</script>




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

