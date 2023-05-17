<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.Arrays"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link rel="stylesheet" href="/css/user/show.css">

<style>
.main {
	display: inline-block;
}

.show--dtail--content {
	display: flex;
}

.show--info {
	display: flex;
	flex-direction: column;
}

.show--img img {
	height: 300px;
	width: 235px;
	padding-bottom: 0;
}

.btn--ticketing {
	width: 235px;
	margin-left: 0;
	border: none;
	height: 40px;
	background-color: #DBE4EB;
	cursor: pointer;
	border-radius: 15px;
	
}
</style>

<div class="main">

	<div class="show--dtail--content">
		<div class="show--info">
			<div class="show--title">
				<h1>${title}</h1>
			</div>


			<div class="show--period">
				<p>기간</p>
				<p>${startDate}&nbsp;~&nbsp;${endDate}</p>
			</div>

			<div class="show--times">
				<p>상연 정보</p>
				<c:forEach var="showInfo" items="${showInfo}">

					<p>${showInfo.showDate}&nbsp;${showInfo.showTime}</p>
				</c:forEach>
			</div>

			<div>
				<p>장소</p>
				<p>${location}&nbsp;${name}</p>
			</div>


			<div>
				<p>입장 연령</p>
				<p>${admissionAge}</p>

			</div>

		</div>

		<div class="show--img">
			<img alt="" src="/images/${imgRoute}">
		<form action="/ticket/ticketing/${showId}" method="get">
			<button type="subnit" class="btn--ticketing">예매하기</button>
		</form>
		</div>


	</div>

	<div>
		<p>작품소개</p>
		${content}


	</div>

</div>












<%@ include file="/WEB-INF/view/layout/footer.jsp"%>