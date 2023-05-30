<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/adminHeader.jsp"%>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<div id="layoutSidenav_content">
	<main>
		<a href="/sales/showGrape">공연 매출 그래프</a>
		<div id="columnchart_material" style="width: 1200px; height: 800px; margin-left: 150px; padding: 100px;"></div>
		<div class="container-fluid px-4">
			<ol class="breadcrumb mb-4">
			</ol>
			<div class="review__content" style="margin-left: -30px;"></div>


			<%@ include file="/WEB-INF/view/layout/adminFooter.jsp"%>



			<script type="text/javascript">
				$(document)
						.ready(
								function() {
									$
											.ajax(
													{
														type : 'get',
														url : '/apiAdminShowSale/admin/rentSale',
														contentType : 'application/json; charset=utf-8',
													})
											.done(
													function(response) {
														google.charts
																.load(
																		'current',
																		{
																			'packages' : [ 'bar' ]
																		});
														google.charts
																.setOnLoadCallback(drawChart);

														function drawChart() {
															var data = google.visualization
																	.arrayToDataTable([
																			[
																					'title',
																					'총매출' ],
																			[
																					response[0].title,
																					response[0].totalPrice ], ]);
															for (var i = 1; i < response.length; i++) {
																data
																		.addRows([
																				[
																						response[i].title,
																						response[i].totalPrice ], ]);
															}

															var options = {
																chart : {
																	title : ' 대관 총 매출 (공연별)',
																},
																bar : {
																	groupWidth : '100%' // 예제에서 이 값을 수정
																},
																fontSize : 30,
																vAxis : {
																	format : '₩#,###'
																}

															};

															var chart = new google.charts.Bar(
																	document
																			.getElementById('columnchart_material'));

															chart
																	.draw(
																			data,
																			google.charts.Bar
																					.convertOptions(options));

															var chart = new google.visualization.ColumnChart(
																	document
																			.getElementById('chart_div'));
															chart.draw(data,
																	options);

														}
													});
								});
			</script>