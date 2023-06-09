<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="/css/manager/managerShowSale.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<script type="text/javascript" src="/js/main.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
	crossorigin="anonymous"></script>
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript" src="/js/dateRangePicker.js"></script>




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
					style="display: flex; flex-direction: row; justify-content: flex-start;">
					<div class="date">
						<label for="content">기간선택 : </label> <input type="text"
							id="startDate" name="startDate" style="width: 300px;" />
					</div>
					<div>
						<input type="hidden" id="infant_rate" value="${principal.getId()}"
							name="organizerId">
					</div>
					<div class="btn__sub">
						<button type="submit" id="dateSearch"
							style="width: 100px; height: 50px; position: relative; z-index: 999;">검색</button>
					</div>
				</div>
			</div>
		</form>
	</div>
	<div class="signUpShow__info">
		<form action="/manager/showSaleBySearch" method="post">
			<div
				style="display: flex; width: 500px; flex-direction: row; justify-content: center; margin-left: -30px;">
				<div
					style="display: flex; flex-direction: row; justify-content: flex-start;">
					<div class="date">
						<label for="title">제 목 : </label> <input type="text" id="title"
							name="title" style="width: 300px;" />
					</div>
					<div>
						<input type="hidden" id="infant_rate" value="${principal.getId()}"
							name="organizerId">
					</div>
					<div class="btn__sub">
						<button type="submit" id="search"
							style="width: 100px; height: 50px;">검색</button>
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
<div class="card-body" style="margin-top: 50px;">
	<canvas id="myBarChart" width="80%" height="40"></canvas>
</div>
<div>
	<div class="show">
		<c:forEach var="showList" items="${showList}">
			<a href="/show/showView/${showList.showId}">
				<div class="review__content" style="margin-left: -30px;">
					<div>
						<img src="/images/upload/${showList.imgRoute}" width="230" height="300">
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
					<c:set var="totalAdultPrice"
						value="${adultRate * showList.adultCount}" />
					<c:set var="totalYouthPrice"
						value="${youthRate * showList.youthCount}" />

					<fmt:formatNumber value="${totalAdultPrice}" pattern="#,##0"
						var="A__price" />
					<fmt:formatNumber value="${totalYouthPrice}" pattern="#,##0"
						var="Y__price" />

					<c:set var="totalPrice" value="${totalAdultPrice+totalYouthPrice}" />
					<fmt:formatNumber value="${totalPrice}" pattern="#,##0"
						var="T__price" />


					<div class="money__content">
						<h1>매출</h1>
						<div id="money">
							<div style="width: 300px;">
								<p>성인요금 : ${formattedAdultRate}</p>
								<p>청소년 요금 : ${formattedYouthRate}</p>
							</div>
							<div
								style="border: none; border-top: 1px solid #ccc; border-bottom: 1px solid #ccc; width: 150px;">
								<p>인원 : ${showList.adultCount}</p>
								<p>인원 : ${showList.youthCount}</p>
							</div>
							<div style="width: 200px;">
								<p>합계 : ${A__price}</p>
								<p>합계 : ${Y__price}</p>
							</div>
						</div>
						<h3>총 합계 : ${T__price}</h3>
					</div>
				</div>
			</a>
		</c:forEach>
	</div>
</div>

<script type="text/javascript"
	src="/js/manager/managerShowSaleByDate.js"></script>

<%@ include file="/WEB-INF/view/layout/footer.jsp"%>


