<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/adminHeader.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">

$.ajax({
    type: "get",
    url: "/api/joinPerDay",
    contentType: "application/json; charset=utf-8",
}).done(function (joinPerDay) {
    google.charts.load('current', { 'packages': ['bar'] });
    google.charts.setOnLoadCallback(drawStuff);

    function drawStuff() {
        let data = new google.visualization.arrayToDataTable([
            ['Move', 'Count'],
            ["King's pawn (e4)", 44],
            ["Queen's pawn (d4)", 31],
            ["Knight to King 3 (Nf3)", 12],
            ["Queen's bishop pawn (c4)", 10],
            ['Other', 3]
        ]);

        let options = {
            width: 800,
            legend: { position: 'none' },
            chart: {
                title: '일일 가입자 수',
            },
            axes: {
                x: {
                    0: { side: 'top', label: '날짜' } // Top x-axis.
                }
            },
            bar: { groupWidth: "90%" }
        };

        let chart = new google.charts.Bar(document.getElementById('top_x_div'));
        // Convert the Classic options to Material options.
        chart.draw(data, google.charts.Bar.convertOptions(options));
    };

}).fail(function (error) {
    console.log(error);
    console.log('일일 유저 가입자 수 그래프를 불러오는 데 실패하였습니다.');
});

</script>
<div id="layoutSidenav_content">
	<main>
		<div id="top_x_div" style="width: 800px; height: 600px;"></div>
		<div class="container-fluid px-4">
			<h1 class="mt-4">Tables</h1>
			<ol class="breadcrumb mb-4">
				<li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
				<li class="breadcrumb-item active">Tables</li>
			</ol>
			<div class="card mb-4">
				<div class="card-body">
					DataTables is a third party plugin that is used to generate the demo table below. For more information about DataTables, please visit the <a target="_blank"
						href="https://datatables.net/">official DataTables documentation</a> .
				</div>
			</div>
			<div class="card mb-4">
				<div class="card-header">
					<i class="fas fa-table me-1"></i> DataTable Example
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
									<td>
										<form action="/admin/updateUser?username=${userList.userName}" method="get">
											<a href="/admin/updateUser?userName=${userList.id}">수정</a>
										</form>
									</td>
									<td>
										<form action="/admin/deleteUser?id=${userList.id}" method="get">
											<a href="/admin/deleteUser?id=${userList.id}">삭제</a>
										</form>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<%@ include file="/WEB-INF/view/layout/adminFooter.jsp"%>