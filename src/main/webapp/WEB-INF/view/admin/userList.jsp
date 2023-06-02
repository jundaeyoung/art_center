<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/adminHeader.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
<script src="/js/admin/showSalesChart.js"></script>
<script src="/js/admin/userJoinPerDay.js"></script>

<div id="layoutSidenav_content">
	<main>
		<div class="row">
			<div class="col-xl-6">
				<div class="card mb-4">
					<div class="card-header">
						<i class="fas fa-chart-area me-1"></i> 일일 가입자 수
					</div>
					<div class="card-body">
						<canvas id="myAreaChart" width="80%" height="40"></canvas>
					</div>
				</div>
			</div>
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
			<ol class="breadcrumb mb-4">
				<li class="breadcrumb-item active">User List</li>
			</ol>
			<div class="card mb-4"></div>
			<div class="card mb-4">
				<div class="card-header">
					<i class="fas fa-table me-1"></i> User
				</div>
				<div class="card-body">
					<table id="datatablesSimple">
						<thead>
							<tr>
								<th>user_name</th>
								<th>nickname</th>
								<th>email</th>
								<th>birth_date</th>
								<th>tel</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="userList" items="${userList}">
								<tr>
									<td>${userList.userName}</td>
									<td>${userList.nickname}</td>
									<td>${userList.email}</td>
									<td>${userList.birthDate}</td>
									<td>${userList.tel}</td>
									<td><a href="/admin/updateUser/${userList.userName}">수정</a></td>
									<td><a href="/admin/deleteUser/${userList.id}">삭제</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
<%@ include file="/WEB-INF/view/layout/adminFooter.jsp"%>
		
		
		