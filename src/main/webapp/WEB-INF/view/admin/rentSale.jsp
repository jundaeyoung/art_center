<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/adminHeader.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="/js/admin/rentSales.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />

<div id="layoutSidenav_content">
   <main>
      <div class="fouc">
         <div style="padding: 0 30px">
            <h1 class="mt-4" style="margin-bottom: 30px;">대관 매출 보기</h1>
            <div class="row">
               <div class="col-xl-6">
                  <div class="card mb-4">
                     <div class="card-header">
                        <i class="fas fa-chart-bar me-1"></i> 총 대관 매출
                     </div>
                     <div class="card-body">
                        <canvas id="myBarChart" width="80%" height="40"></canvas>
                     </div>
                  </div>
               </div>
            </div>
         </div>
         <div class="container-fluid px-4">
            <ol class="breadcrumb mb-4">
            </ol>
            <div class="card mb-4"></div>
            <div class="card mb-4">
               <div class="card-header">
                  <form action="/admin/sales/selectRentSaleByStartDateAndEndDate" method="post">
                     <label for="startDate">기간선택:</label> <input type="text" id="startDate" name="startDate" style="width: 200px; margin-bottom: 10px;" />
                     <button type="submit">검색</button>
                  </form>

                  <form action="/admin/sales/selectRentSaleBySearchTitle" method="post">
                     <label for="searchTitle">장소:</label> <input type="text" id="searchTitle" name="searchTitle" />
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
      </div>
      <script type="text/javascript" src="/js/dateRangePicker.js"></script>


      <%@ include file="/WEB-INF/view/layout/adminFooter.jsp"%>