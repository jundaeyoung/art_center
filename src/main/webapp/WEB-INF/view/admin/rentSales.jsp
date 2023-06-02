<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/adminHeader.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



		<div id="layoutSidenav_content">
			<main>
			<div class="row">
                            <div class="col-xl-6">
                                <div class="card mb-4">
                                    <div class="card-header">
                                        <i class="fas fa-chart-bar me-1"></i>
                                        총 대관 매출
                                    </div>
                                    <div class="card-body"><canvas id="myBarChart" width="80%" height="40"></canvas></div>
                                </div>
                            </div>
                        </div>
				<div class="container-fluid px-4">
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
						<li class="breadcrumb-item active">Tables</li>
					</ol>
					<div class="card mb-4">
						
					</div>
					<div class="card mb-4">
						<div class="card-header">
						<form action="/sales/rentSalesDay" method="post">
						<label for="startDate">시작날짜:</label> <input type="date"
							id="startDate" name="startDate" /> <label for="endDate">종료날짜:</label>
						<input type="date" id="endDate" name="endDate" />
						<button type="submit">검색</button>
					</form>
					 <form action="/sales/showSalesDay" method="POST">
                    </form>
                    <form action="/sales/rentSalesTitle" method="post">
						<label for="searchTitle">장소:</label> <input type="text"
							id="searchTitle" name="searchTitle" />
						<button type="submit">검색</button>
					</form>
							<i class="fas fa-table me-1"></i> 
						</div>
						<div class="card-body">
						<table id="datatablesSimple">
                                    <thead>
                                          <tr>
                                            <th>시작날짜</th>
                                            <th>시작시간</th>
                                            <th>종료날짜</th>
                                            <th>종료시간</th>
                                            <th>공연</th>
                                            <th>건물</th>
                                            <th>위치</th>
                                            <th>예약자</th>
                                            <th>가격</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                   <c:forEach var="rentSaleslist" items="${rentSaleslist}">
                                    <tr>
                                    	<td>${rentSaleslist.startDate}</td>
                                    	<td>${rentSaleslist.startTime}</td>
                                    	<td>${rentSaleslist.endDate}</td>
                                    	<td>${rentSaleslist.endTime}</td>
                                    	<td>${rentSaleslist.title}</td>
                                    	<td>${rentSaleslist.location}</td>
                                    	<td>${rentSaleslist.name}</td>
                                    	<td>${rentSaleslist.nickname}</td>
                                    	<td>${rentSaleslist.rentPrice}</td>
                                    </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                             <p>총매출 : ${totalRentPrice}원</p>
						</div>
					</div>
				</div>
				<script type="text/javascript">
				$(document).ready(function() {
					  Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
					  Chart.defaults.global.defaultFontColor = '#292b2c';

					  function drawChart(response) {
					    var labels = [];
					    var data = [];

					    for (var i = 0; i < response.length; i++) {
					      labels.push(response[i].title);
					      var value = parseInt(response[i].totalPrice);
					      data.push(value);
					    }

					    var ctx = document.getElementById("myBarChart").getContext("2d");
					    var myBarChart = new Chart(ctx, {
					      type: 'bar',
					      data: {
					        labels: labels,
					        datasets: [{
					          label: "대관 총매출",
					          backgroundColor: "rgba(2,117,216,1)",
					          borderColor: "rgba(2,117,216,1)",
					          data: data,
					        }],
					      },
					      options: {
					        scales: {
					          x: {
					            grid: {
					              display: false
					            }
					          },
					          y: {
					            ticks: {
					              beginAtZero: true,
					              callback: function(value, index, values) {
					                return value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",") + "원";
					              }
					            },
					            grid: {
					              display: true
					            }
					          }
					        },
					        plugins: {
					          title: {
					            display: true,
					            text: '대관 총 매출',
					            font: {
					              size: 10
					            },
					          }
					        },
					        tooltips: {
					          callbacks: {
					            label: function(tooltipItem, data) {
					              return tooltipItem.yLabel.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",") + "원";
					            }
					          },
					        },
					      }
					    });
					  }

					  $.ajax({
					    type: 'get',
					    url: '/apiAdminShowSale/admin/rentSale',
					    contentType: 'application/json; charset=utf-8',
					  }).done(function(response) {
					    drawChart(response);
					  }).fail(function(error) {
					    console.log(error);
					    console.log("데이터를 불러오는 데 실패하였습니다.");
					  });
					});
				</script>
				<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
<%@ include file="/WEB-INF/view/layout/adminFooter.jsp"%>