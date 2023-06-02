<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="/css/manager/managerShowSaleDetail.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<script type="text/javascript" src="/js/main.js"></script>

<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript" src="/js/daterangepicker.js"></script>




<div class="show__header"></div>
<div class="signUpShow__content">
	<div class="signUpShow__info">
		<form action="/manager/showSaleByDate" method="post">
			<div style="display: flex; width: 700px; flex-direction: row; justify-content: center;">
				<div style="height:; display: flex; flex-direction: row; justify-content: flex-start;">
					<div class="date">
						<label for="content">기간선택 : </label> <input type="text" id="startDate" name="startDate" style="width: 300px;" />
					</div>
					<div>
						<input type="hidden" id="infant_rate" value="${principal.getId()}" name="organizerId">
					</div>
					<div class="btn__sub">
						<button type="submit" style="width: 100px; height: 50px;">검색</button>
					</div>
				</div>
			</div>
		</form>
	</div>
	<div class="signUpShow__info">
		<form action="/manager/showSaleBySearch" method="post">
			<div style="display: flex; width: 700px; flex-direction: row; justify-content: center;">
				<div style="height:; display: flex; flex-direction: row; justify-content: flex-start;">
					<div class="date">
						<label for="title">제 목 : </label> <input type="text" id="title" name="title" style="width: 300px;" />
					</div>
					<div>
						<input type="hidden" id="infant_rate" value="${principal.getId()}" name="organizerId">
					</div>
					<div class="btn__sub">
						<button type="submit" style="width: 100px; height: 50px;">검색</button>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>
<c:forEach var="showList" items="${showList}">
	<fmt:parseNumber var="adultRate" type="number" value="${showList.adultRate}" />
	<fmt:formatNumber value="${adultRate}" pattern="#,##0" var="formattedAdultRate" />
	<fmt:parseNumber var="youthRate" type="number" value="${showList.youthRate}" />
	<fmt:formatNumber value="${youthRate}" pattern="#,##0" var="formattedYouthRate" />
	<fmt:parseNumber var="infantRate" type="number" value="${showList.infantRate}" />
	<c:set var="totalAdultPrice" value="${adultRate * showList.adultCount}" />
	<c:set var="totalYouthPrice" value="${youthRate * showList.youthCount}" />

	<fmt:formatNumber value="${totalAdultPrice}" pattern="#,##0" var="A__price" />
	<fmt:formatNumber value="${totalYouthPrice}" pattern="#,##0" var="Y__price" />
	<fmt:formatNumber value="${totalInfantPrice}" pattern="#,##0" var="I__price" />

	<c:set var="totalPrice" value="${totalAdultPrice+totalYouthPrice+totalInfantPrice}" />
	<fmt:formatNumber value="${totalPrice}" pattern="#,##0" var="T__price" />

</c:forEach>
<div>
	<h1 style="padding-bottom: 30px;">상세 매출</h1>
	<div class="show">
		<div class="review__content">
			<c:choose>
				<c:when test="${showList.get(0).getTitle()==null}">
					<h1>주문 목록이 없습니다.</h1>
				</c:when>
				<c:otherwise>
					<div>
						<img src="/images/upload/${showList.get(0).getImgRoute()}" width="350" height="450">
					</div>
					<div class="show__content">
						<h1>${title}</h1>
						<div>
							<p>기간 : ${showList.get(0).getStartDate()}&nbsp&nbsp~&nbsp&nbsp${showList.get(0).getEndDate()}</p>
							<p>성인 요금 : ${showList.get(0).getAdultRate()}원</p>
							<p>청소년 요금 : ${showList.get(0).getYouthRate()}원</p>
						</div>
					</div>
					<div class="total" style="display: flex; justify-content: center;">
						<h3>매출 : ${sum}</h3>
					</div>

				</c:otherwise>
			</c:choose>
		</div>
		<c:forEach var="showList" items="${showList}">

			<div class="money__content">
				<div id="money">
					<div>
						<p>성인 : ${showList.adultCount}명</p>
					</div>
					<div>
						<p>청소년 : ${showList.youthCount}명</p>
					</div>
				</div>
				<h3>매출 : ${T__price}</h3>
			</div>
		</c:forEach>

	</div>
</div>



<%@ include file="/WEB-INF/view/layout/footer.jsp"%>

