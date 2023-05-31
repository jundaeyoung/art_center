<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/adminHeader.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid px-4">
					<h1 class="mt-4">Tables</h1>
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
						<li class="breadcrumb-item active">Tables</li>
					</ol>
					<div class="card mb-4">
						<div class="card-body">
							DataTables is a third party plugin that is used to generate the demo table below. For more information about DataTables, please visit the <a target="_blank" href="https://datatables.net/">official
								DataTables documentation</a> .
						</div>
						
						
					</div>
					<div class="card mb-4">
						<div class="card-header">
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
<%@ include file="/WEB-INF/view/layout/adminFooter.jsp"%>
