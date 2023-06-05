<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/adminHeader.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



		<div id="layoutSidenav_content">
			<main>
			<div class="fouc">
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
							<i class="fas fa-table me-1"></i> DataTable Example
						</div>
						<div class="card-body">
							<table id="datatablesSimple">
                                    <thead>
                                          <tr>
                                            <th>예약자</th>
                                            <th>전화번호</th>
                                            <th>시작날짜</th>
                                            <th>종료날짜</th>
                                            <th>시작시간</th>
                                            <th>종료시간</th>
                                            <th>위치</th>
                                            <th>장소</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                   <c:forEach var="rentPlaces" items="${rentPlaces}">
                                    <tr>
                                    	<td>${rentPlaces.nickname}</td>
                                    	<td>${rentPlaces.tel}</td>
                                    	<td>${rentPlaces.startDate}</td>
                                    	<td>${rentPlaces.endDate}</td>
                                    	<td>${rentPlaces.startTime}</td>
                                    	<td>${rentPlaces.endTime}</td>
                                    	<td>${rentPlaces.name}</td>
                                    	<td>${rentPlaces.location}</td>
                                    </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
						</div>
					</div>
				</div>
				</div>
<%@ include file="/WEB-INF/view/layout/adminFooter.jsp"%>





