<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.Arrays"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link rel="stylesheet" href="/css/user/show.css">



<div>
	<div>찜하기</div>
	<c:choose>
		<c:when test="${showList.id==showInfo.id}">


			<div>${showList.title}</div>
			<div>
				<div>
					<h5>기간</h5>
					<p>${showList.startDate}~${showInfo.endDate}</p>

				</div>


				기간 시간 장소 입장연령 관람시간 가격 주회 후원 문의
			</div>

			<div>${showList.imgRoute}</div>
		</c:when>
		<c:otherwise>

		</c:otherwise>

	</c:choose>

	<div>
		<form action="/ticket/ticketing/${showInfo.id}" method="get">
			<button type="subnit">예매하기</button>

		</form>
	</div>

</div>












<%@ include file="/WEB-INF/view/layout/footer.jsp"%>