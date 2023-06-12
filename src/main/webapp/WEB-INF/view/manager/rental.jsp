<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="/css/manager/rental.css">
<style type="text/css">
</style>
<div class="rental--content">
	<div class="rental-title">
		<p>${show.title}&nbsp;&nbsp;대관신청&nbsp;&nbsp;바로가기</p>
	</div>
	<div class="link--content">
		<c:choose>
			<c:when test="${show.showTypeId==1}">
				<div class="link--box">
					<div class="link--title">
						<img alt="오페라하우스" src="/images/rental/opera.png">
					</div>
					<div class="link--text">
						<h2>오페라하우스</h2>
					</div>
					<a href="/rental/location/1/${show.id}" class="link--btn">바로가기</a>
				</div>
			</c:when>
			<c:when test="${show.showTypeId==2}">
				<div class="link--box">
					<div class="link--title">
						<img alt="미술관" src="/images/rental/gallary.png">
					</div>
					<div class="link--text">
						<h2>아트홀</h2>
					</div>
					<a href="/rental/location/2/${show.id}" class="link--btn">바로가기</a>
				</div>
			</c:when>
			<c:when test="${show.showTypeId==3}">
				<div class="link--box">
					<div class="link--title">
						<img alt="아카데미" src="/images/rental/academy.png">
					</div>
					<div class="link--text">
						<h2>아카데미</h2>
					</div>
					<a href="/rental/location/3/${show.id}" class="link--btn">바로가기</a>
				</div>
			</c:when>
		</c:choose>
	</div>
</div>
<script type="text/javascript" src="/js/manager/rental.js"></script>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>

