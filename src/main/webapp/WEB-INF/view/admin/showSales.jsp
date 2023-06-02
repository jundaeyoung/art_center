<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/adminHeader.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<div id="layoutSidenav_content">
	<main>
		<div class="container-fluid px-4">
			<h1 class="mt-4">예매 목록 보기</h1>
			<div class="card mb-4">
				<div class="card-body">유저들이 티켓팅한 목록입니다.</div>
			</div>
			<div class="card mb-4">
				<div class="card-header">
					<form action="/sales/showSalesDay" method="post">
						<label for="startDate">시작날짜:</label> <input type="date"
							id="startDate" name="startDate" /> <label for="endDate">종료날짜:</label>
						<input type="date" id="endDate" name="endDate" />
						<button type="submit">검색</button>
					</form>
					<form action="/sales/showSalesTitle" method="post">
						<label for="searchTitle">공연 제목:</label> <input type="text"
							id="searchTitle" name="searchTitle" />
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
						<p>총매출 : ${totalShowPrice}원</p>
				</div>
			</div>
		</div>

		<%@ include file="/WEB-INF/view/layout/adminFooter.jsp"%>
		
		
		