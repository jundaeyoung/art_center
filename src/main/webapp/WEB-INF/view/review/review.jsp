<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.Arrays"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link rel="stylesheet" href="/css/user/review.css">


<div class="question__title">
	<c:choose>
		<c:when test="${message eq '최신순'}">
			<h1>최&nbsp&nbsp&nbsp&nbsp신&nbsp&nbsp&nbsp&nbsp순</h1>
		</c:when>
		<c:when test="${message eq '평점높은순'}">
			<h1>평&nbsp&nbsp점&nbsp&nbsp&nbsp&nbsp높&nbsp&nbsp은&nbsp&nbsp순</h1>
		</c:when>
		<c:otherwise>
			<h1>평&nbsp&nbsp점&nbsp&nbsp&nbsp&nbsp낮&nbsp&nbsp은&nbsp&nbsp순</h1>
		</c:otherwise>
	</c:choose>
</div>
<div class="menu">
	<div>
		<span class="material-symbols-outlined"> <a href="/">home</a>
		</span>
	</div>
	<div class="newest">
		<a href="/review/newestReview?currentPage=1&begin=0&range=3">최신순</a>
	</div>
	<div class="highes__rated">
		<a href="/review/highesRatedReview?currentPage=1&begin=0&range=3">평점
			높은순</a>
	</div>
	<div class="lowest__rated">
		<a href="/review/rowestRatedReview?currentPage=1&begin=0&range=3">평점
			낮은순</a>
	</div>
</div>
<div class="review">
	<c:forEach var="reviewList" items="${reviewList}">
		<div class="review__content">
			<div>
				<a href="#"><img src="/images/${reviewList.imgRoute}"
					width="230" height="300"></a>
			</div>
			<div class="show__content">
				<h2>${reviewList.title}</h2>
				<p>${reviewList.content}</p>
			</div>
		</div>
	</c:forEach>
</div>
<div class="page">
	<c:choose>
		<c:when test="${currentPage==1 || currentPage==null}">
		</c:when>
		<c:otherwise>
			<a href="/review/newestReview?currentPage=1&begin=${3*(1-1)}&range=3"><p><<</p></a>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${currentPage==null}">
		</c:when>
		<c:otherwise>
			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				<a
					href="/review/newestReview?currentPage=${i}&begin=${3*(i-1)}&range=3"><p>${i}</p></a>
			</c:forEach>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${currentPage==page}">
		</c:when>
		<c:otherwise>
			<a
				href="/review/newestReview?currentPage=${page}&type=${type}&begin=${3*(page-1)}&range=3"><p>>></p></a>
		</c:otherwise>
	</c:choose>
</div>

<%@ include file="/WEB-INF/view/layout/footer.jsp"%>


