<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/adminHeader.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<div id="layoutSidenav_content">
   <main>
      <div class="container-fluid px-4">
         <h1 class="mt-4">예매 목록 보기</h1>
         <div class="card mb-4">
            <div class="card-body">
                유저들이 티켓팅한 목록입니다. 
            </div>
         </div>
         <div class="card mb-4">
            <div class="card-header">
               <i class="fas fa-table me-1"></i> 예매 목록
            </div>
            <div class="card-body">
               <table id="datatablesSimple">
                  <thead>
                     <tr>
                        <th>닉네임</th>
                        <th>전화번호</th>
                        <th>EMail</th>
                        <th>공연제목</th>
                        <th>공연날짜</th>
                        <th>공연시간</th>
                        <th>성인요금</th>
                        <th>청소년요금</th>
                        <th>성인인원수</th>
                        <th>청소년인원수</th>
                        <th>예매날짜</th>
                        <th>예매가격</th>
                     </tr>
                  </thead>
                  <tbody>
                     <c:forEach var="ticketList" items="${ticketList}">
                        <fmt:parseNumber var="adultRate" type="number" value="${ticketList.adultRate}" />
                        <fmt:formatNumber value="${adultRate}" pattern="#,##0" var="formattedAdultRate" />
                        <fmt:parseNumber var="youthRate" type="number" value="${ticketList.youthRate}" />
                        <fmt:formatNumber value="${youthRate}" pattern="#,##0" var="formattedYouthRate" />
                        <c:set var="totalAdultPrice" value="${adultRate * ticketList.adultCount}" />
                        <c:set var="totalYouthPrice" value="${adultRate * ticketList.youthCount}" />
                        <fmt:formatNumber value="${totalAdultPrice}" pattern="#,##0" var="A__price" />
                        <fmt:formatNumber value="${totalYouthPrice}" pattern="#,##0" var="Y__price" />

                        <c:set var="totalPrice" value="${totalAdultPrice+totalYouthPrice}" />
                        <fmt:formatNumber value="${totalPrice}" pattern="#,##0" var="T__price" />
                        <tr>
                           <th>${ticketList.nickname}</th>
                           <th>${ticketList.tel}</th>
                           <th>${ticketList.email}</th>
                           <th>${ticketList.title}</th>
                           <th>${ticketList.showDate}</th>
                           <th>${ticketList.showTime}</th>
                           <th>${ticketList.adultRate}</th>
                           <th>${ticketList.youthRate}</th>
                           <th>${ticketList.adultCount}</th>
                           <th>${ticketList.youthCount}</th>
                           <th>${ticketList.ticketingDate}</th>
                           <th>${totalAdultPrice}원</th>
                        </tr>
                     </c:forEach>
                  </tbody>
                  <tfoot>
                  </tfoot>
               </table>
            </div>
         </div>
      </div>

<%@ include file="/WEB-INF/view/layout/adminFooter.jsp"%>




