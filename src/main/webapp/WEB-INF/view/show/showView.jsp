<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.Arrays"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link rel="stylesheet" href="/css/user/show.css">

<br>
<br>
<br>
<div>


	<div>
		<div>
			<h1>${title}</h1>
		</div>
		<form action="/ticket/ticketing/${showId}" method="get">
			<button type="subnit">예매하기</button>

		</form>
		<div class="show--img">
			<img alt="" src="/images/${imgRoute}">
		</div>

		<div class="show--period">
			<p>${startDate}&nbsp;~&nbsp;${endDate}</p>
		</div>

		<div class="show--times">


			<h3>상연 정보</h3>
			<c:forEach var="showInfo" items="${showInfo}">

				<p>${showInfo.showDate}&nbsp;${showInfo.showTime}</p>
			</c:forEach>
		</div>
		<div>
		<p>장소</p>
		<p></p>
		
		</div>



		 장소 입장연령 관람시간 가격 주회 후원 문의

	</div>

	<div></div>

</div>












<%@ include file="/WEB-INF/view/layout/footer.jsp"%>