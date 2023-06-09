<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.Arrays"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet"
   href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link rel="stylesheet" href="/css/main.css">
<link rel="stylesheet" href="/css/reservationCalendar.css">
<script type="text/javascript" src="/js/reservation.js"></script>

<script type="text/javascript" src="/js/seatSelection.js"></script>


<div class="main">
   <form action="/ticket/ticketing" method="post">
      <div class="reservation">
         <div class="reservation--calendar">
            <p style="font-size: 30px; width: 300px;">${showInfoList[0].title}</p>
            <input type="hidden" id="hiddenShowId" name="showId"
               value="${showId}">
            <div>
               <table class="Calendar">
                  <thead>
                     <tr>
                        <td onClick="prevCalendar();" style="cursor: pointer;">&#60;</td>
                        <td colspan="5"><span id="calYear"></span>년 <span
                           id="calMonth"></span>월</td>
                        <td onClick="nextCalendar();" style="cursor: pointer;">&#62;</td>
                     </tr>
                     <tr>
                        <td>일</td>
                        <td>월</td>
                        <td>화</td>
                        <td>수</td>
                        <td>목</td>
                        <td>금</td>
                        <td>토</td>
                     </tr>
                  </thead>
                  <tbody>
                     <c:forEach var="showDateList" items="${showDateList}">
                        <input type="hidden" class="listDate" value="${showDateList.showDate}">
                     </c:forEach>
                  </tbody>
               </table>
            </div>
         </div>
         <input type="hidden" name="showTypeId" value="${showInfoList[0].showTypeId}">
         <c:choose>
            <c:when test="${showInformation==1}">
               <div class="reservation--Time">
                  <p class="title" style="font-size: 30px; width: 300px;">관람 시간</p>
                  <div class="watchTime--content">
                     <div class="TagPlay"></div>
                  </div>
               </div>



               <div class="side--middle">
                  <p style="font-size: 30px; width: 300px;">좌석 선택</p>
                  <div class="seat--information">
                     <div class="seat--info"></div>
                  </div>
                  <button type="submit" class="btn--ticketing">예 매</button>
               </div>

            </c:when>
            <c:when test="${showInformation==2}">
               <div class="reservation--Time"style="margin-left: -200px;">
                  <p class="title" style="font-size: 30px; width: 300px;">관람 시간</p>
                  <div class="watchTime--content">
                     <div class="TagPlay"></div>
                  </div>
               </div>
               <button type="submit" class="btn--ticketing"
                  style="margin-left: -400px; margin-top: 430px;">예 매</button>
            </c:when>
            <c:otherwise>
               <div class="reservation--Time"style="margin-left: -200px;">
                  <p class="title" style="font-size: 30px; width: 300px;">관람 시간</p>
                  <div class="watchTime--content">
                     <div class="TagPlay"></div>
                  </div>
                  <p class="title" id="count" style="font-size: 30px; width: 300px;">신청 가능 인원</p>
                  <div id="remainingCount"></div>
               </div>
               <button type="submit" class="btn--ticketing"
                  style="margin-left: -400px; margin-top: 430px;">예 매</button>
            </c:otherwise>
         </c:choose>
      </div>
   </form>
</div>


<%@ include file="/WEB-INF/view/layout/footer.jsp"%>

