<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/adminHeader.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
<script type="text/javascript" src="/js/dateRangePicker.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
<script src="/js/admin/showSalesChart.js"></script>
<script src="/js/admin/userJoinPerDay.js"></script>

<div id="layoutSidenav_content">
	<main>
		<h1 class="mt-4">공연 매출 보기</h1>
		<div class="card-body">유저들이 티켓팅한 목록입니다.</div>
		<div class="row">
			<div class="col-xl-6">
				<div class="card mb-4">
					<div class="card-header">
						<i class="fas fa-chart-bar me-1"></i> 총 공연 매출
					</div>
					<div class="card-body">
						<canvas id="myBarChart" width="80%" height="40"></canvas>
					</div>
				</div>
			</div>
		</div>

		<div class="container-fluid px-4">
			<div class="card mb-4"></div>
			<div class="card mb-4">
				<div class="card-header">
					<form action="/admin/sales/selectShowSaleListByStartDateAndEndDate" method="post">
						<label for="startDate">기간선택:</label> <input type="text" id="startDate" name="startDate" style="width: 200px; margin-bottom: 10px;" />
						<button type="submit">검색</button>
					</form>
					<form action="/admin/sales/selectShowSaleSearchByTitle" method="post">
						<label for="searchTitle">공연 제목:</label> <input type="text" id="searchTitle" name="searchTitle" />
						<button type="submit">검색</button>
					</form>
					<i class="fas fa-table me-1"></i> 예매 목록
				</div>
				<div class="card-body">
					<table id="datatablesSimple">
						<thead>
							<tr>
								<th>시작날짜</th>
								<th>종료날짜</th>
								<th>공연</th>
								<th>성인요금</th>
								<th>청소년요금</th>
								<th>매출</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="showSalesList" items="${showSalesList}">
								<tr>
									<td>${showSalesList.startDate}</td>
									<td>${showSalesList.endDate}</td>
									<td>${showSalesList.title}</td>
									<td>${showSalesList.adultRate}</td>
									<td>${showSalesList.youthRate}</td>
									<td>${showSalesList.totalshowSales}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<p>총매출 : ${totalShowPrice} 원</p>
				</div>
			</div>
		</div>



		<%@ include file="/WEB-INF/view/layout/adminFooter.jsp"%>
		
		
		
		