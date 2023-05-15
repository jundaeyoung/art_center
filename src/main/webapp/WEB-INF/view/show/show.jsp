<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="/css/user/show.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<script type="text/javascript" src="/js/main.js"></script>

<div class="show__header"></div>

<div class="menu">
	<div>
		<span class="material-symbols-outlined"> <a href="/">home</a>
		</span>
	</div>
	<div class="newest">
		<a href="/show/categoryShow?category=공연&currentPage=1&begin=0&range=3">공연</a>
	</div>
	<div class="highes__rated">
		<a
			href="/show/categoryShow?category=전시회&currentPage=1&begin=0&range=3">전시회
		</a>
	</div>
	<div class="lowest__rated">
		<a
			href="/show/categoryShow?category=아카데미&currentPage=1&begin=0&range=3">아카데미
		</a>
	</div>
	<div class="newest">
		<a href="/show/newestShow?currentPage=1&begin=0&range=3">최신순</a>
	</div>
	<div class="highes__rated">
		<a href="/show/highesRatedShow?currentPage=1&begin=0&range=3">평점
			높은순</a>
	</div>
	<div class="lowest__rated">
		<a href="/show/rowestRatedShow?currentPage=1&begin=0&range=3">평점
			낮은순</a>
	</div>
</div>
<div class="show__title">
	<span class="material-symbols-outlined"> square </span>
	<div>
		<h1>Show</h1>
		<h2>${message}</h2>
	</div>
</div>
<div class="show">
	<c:forEach var="showList" items="${showList}">
		<div class="review__content">
			<div>
				<a href="#"><img src="/images/${showList.imgRoute}"
					width="230" height="300"></a>
			</div>
			<div class="show__content">
				<h2>${showList.title}&nbsp&nbsp&nbsp&nbsp(${showList.showType})</h2>
				<p>${showList.content}</p>
				<h3>평점 : ${showList.rating}</h3>
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
					<a href="/show/newestShow?currentPage=1&begin=${3*(1-1)}&range=3"><p><</p></a>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage==null}">
				</c:when>
				<c:otherwise>
					<c:forEach var="i" begin="${startPage}" end="${endPage}">
						<a
							href="/show/newestShow?currentPage=${i}&begin=${3*(i-1)}&range=3"><p>${i}</p></a>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage==page || currentPage==null}">
				</c:when>
				<c:otherwise>
					<a
						href="/review/newestReview?currentPage=${page}&type=${type}&begin=${3*(page-1)}&range=3"><p>></p></a>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:when test="${message eq '평점높은순'}">
			<c:choose>
				<c:when test="${currentPage==1 || currentPage==null}">
				</c:when>
				<c:otherwise>
					<a
						href="/show/highesRatedShow?currentPage=1&begin=${3*(1-1)}&range=3"><p><</p></a>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage==null}">
				</c:when>
				<c:otherwise>
					<c:forEach var="i" begin="${startPage}" end="${endPage}">
						<a
							href="/show/highesRatedShow?currentPage=${i}&begin=${3*(i-1)}&range=3"><p>${i}</p></a>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage==page || currentPage==null}">
				</c:when>
				<c:otherwise>
					<a
						href="/review/highesRatedShow?currentPage=${page}&type=${type}&begin=${3*(page-1)}&range=3"><p>></p></a>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:when test="${message eq '평점낮은순'}">
			<c:choose>
				<c:when test="${currentPage==1 || currentPage==null}">
				</c:when>
				<c:otherwise>
					<a
						href="/show/rowestRatedShow?currentPage=1&begin=${3*(1-1)}&range=3"><p><</p></a>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage==null}">
				</c:when>
				<c:otherwise>
					<c:forEach var="i" begin="${startPage}" end="${endPage}">
						<a
							href="/show/rowestRatedShow?currentPage=${i}&begin=${3*(i-1)}&range=3"><p>${i}</p></a>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage==page || currentPage==null}">
				</c:when>
				<c:otherwise>
					<a
						href="/show/rowestRatedShow?currentPage=${page}&type=${type}&begin=${3*(page-1)}&range=3"><p>></p></a>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${currentPage==1 || currentPage==null}">
				</c:when>
				<c:otherwise>
					<a
						href="/show/categoryShow?category=${message}&currentPage=1&begin=${3*(1-1)}&range=3"><p><</p></a>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage==null}">
				</c:when>
				<c:otherwise>
					<c:forEach var="i" begin="${startPage}" end="${endPage}">
						<a
							href="/show/categoryShow?category=${message}&currentPage=${i}&begin=${3*(i-1)}&range=3"><p>${i}</p></a>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage==page || currentPage==null}">
				</c:when>
				<c:otherwise>
					<a
						href="/show/categoryShow?category=${message}&currentPage=${page}&type=${type}&begin=${3*(page-1)}&range=3"><p>></p></a>
				</c:otherwise>
			</c:choose>
		</c:otherwise>


	</c:choose>


</div>

<%@ include file="/WEB-INF/view/layout/footer.jsp"%>


