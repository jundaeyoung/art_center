<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.Arrays"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link rel="stylesheet" href="/css/user/review.css">
<script type="text/javascript" src="/js/main.js"></script>
<script type="text/javascript" src="/js/review.js"></script>

<div class="review__header"></div>

<div class="menu">
	<div>
		<span class="material-symbols-outlined"> <a href="/"><button>home</button></a>
		</span>
	</div>
	<div class="newest">
		<a><button id="show" class="s">공연</button></a>
	</div>
	<div class="highes__rated">
		<a><button id="exhibition">전시회</button> </a>
	</div>
	<div class="lowest__rated">
		<a><button id="academy" >아카데미</button> </a>
	</div>
	<div class="newest">
		<a><button id="newest" >최신순</button></a>
	</div>
	<div class="highes__rated">
		<a><button id="highes__rated" >평점 높은순</button></a>
	</div>
	<div class="lowest__rated" style="border-style: none;">
		<a><button id="lowest__rated" >평점 낮은순</button></a>
	</div>
</div>


<script type="text/javascript">

	</script>

<div class="review__title">
	<span class="material-symbols-outlined"> square </span>
	<div>
		<h1>리뷰</h1>
		<h2>${message}</h2>
	</div>

</div>
<div class="search" id="hide__search__box">
	<form action="/review/search" method="get">
		<input type="text" class="textbox" name="showName"> <input type="hidden" name="currentPage" value="1"> <input type="hidden" name="begin" value="0"> <input type="hidden"
			name="range" value="5"> <input type="submit" class="submit" value="검&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp색">
	</form>
</div>
<div class="review">
	<c:forEach var="reviewList" items="${reviewList}">
		<div class="review__content">
			<div>
				<a href="/show/showView/${reviewList.showId}"><img src="/images/${reviewList.imgRoute}" width="230" height="300"></a>
			</div>
			<div class="show__content">
				<h2>${reviewList.title}&nbsp&nbsp&nbsp&nbsp(${reviewList.showType})</h2>
				<p>${reviewList.reviewContent}</p>
				<div class="review__content__info">
					<h4 class="review__content__username">${reviewList.userName}&nbsp&nbsp&nbsp&nbsp&nbsp|&nbsp&nbsp&nbsp&nbsp&nbsp${reviewList.reviewCreationDate}</h4>
				</div>
				<h3>평점 : ${reviewList.rating}</h3>
			</div>
		</div>
	</c:forEach>
</div>
<div class="page">
	<c:choose>
		<c:when test="${message eq '최신순'}">
			<c:choose>
				<c:when test="${currentPage==1 || currentPage==null}">
				</c:when>
				<c:otherwise>
					<a href="/review/newestReview?currentPage=1&begin=${3*(1-1)}&range=3"><p><</p></a>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage==null}">
				</c:when>
				<c:otherwise>
					<c:forEach var="i" begin="${startPage}" end="${endPage}">
						<a href="/review/newestReview?currentPage=${i}&begin=${3*(i-1)}&range=3"><p>${i}</p></a>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage==page || currentPage >= 2}">
				</c:when>
				<c:otherwise>
					<a href="/review/newestReview?currentPage=${page}&type=${type}&begin=${3*(page-1)}&range=3"><p>></p></a>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:when test="${message eq '평점 높은순'}">
			<c:choose>
				<c:when test="${currentPage==1 || currentPage==null}">
				</c:when>
				<c:otherwise>
					<a href="/review/highestRatedReview?currentPage=1&begin=${3*(1-1)}&range=3"><p><</p></a>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage==null}">
				</c:when>
				<c:otherwise>
					<c:forEach var="i" begin="${startPage}" end="${endPage}">
						<a href="/review/highestRatedReview?currentPage=${i}&begin=${3*(i-1)}&range=3"><p>${i}</p></a>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage==page || currentPage==null}">
				</c:when>
				<c:otherwise>
					<a href="/review/highestRatedReview?currentPage=${page}&type=${type}&begin=${3*(page-1)}&range=3"><p>></p></a>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:when test="${message eq '평점 낮은순'}">
			<c:choose>
				<c:when test="${currentPage==1 || currentPage==null}">
				</c:when>
				<c:otherwise>
					<a href="/review/rowestRatedReview?currentPage=1&begin=${3*(1-1)}&range=3"><p><</p></a>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage==null}">
				</c:when>
				<c:otherwise>
					<c:forEach var="i" begin="${startPage}" end="${endPage}">
						<a href="/review/rowestRatedReview?currentPage=${i}&begin=${3*(i-1)}&range=3"><p>${i}</p></a>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage==page || currentPage==null}">
				</c:when>
				<c:otherwise>
					<a href="/review/rowestRatedReview?currentPage=${page}&type=${type}&begin=${3*(page-1)}&range=3"><p>></p></a>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${currentPage==1 || currentPage==null}">
				</c:when>
				<c:otherwise>
					<a href="/review/categoryReview?category=${message}&currentPage=1&begin=${3*(1-1)}&range=3"><p><</p></a>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage==null}">
				</c:when>
				<c:otherwise>
					<c:forEach var="i" begin="${startPage}" end="${endPage}">
						<a href="/review/categoryReview?category=${message}&currentPage=${i}&begin=${3*(i-1)}&range=3"><p>${i}</p></a>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage==page || currentPage >= 2}">
				</c:when>
				<c:otherwise>
					<a href="/review/categoryReview?category=${message}&currentPage=${page}&type=${type}&begin=${3*(page-1)}&range=3"><p>></p></a>
				</c:otherwise>
			</c:choose>
		</c:otherwise>
	</c:choose>


</div>

<%@ include file="/WEB-INF/view/layout/footer.jsp"%>



