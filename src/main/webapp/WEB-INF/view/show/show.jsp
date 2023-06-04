<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="/css/user/show.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript" src="/js/show.js"></script>
<script type="text/javascript" src="/js/main.js"></script>





<div class="show__header"></div>

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
				<a href="/show/showView/${showList.id}"><img src="/images/upload/${showList.imgRoute}" width="230" height="300"></a>
			</div>
			<div class="show__content">
				<h2>${showList.title}&nbsp;(${showList.showType})</h2>
				<p>${showList.content}</p>
				<c:choose>
					<c:when test="${showList.rating==null}">
						<h3>평점이 아직 등록되지 않았습니다.</h3>
					</c:when>
					<c:otherwise>
						<h3>평점 : ${showList.rating}</h3>
					</c:otherwise>
				</c:choose>
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
						<a href="/show/newestShow?currentPage=${i}&begin=${3*(i-1)}&range=3"><p>${i}</p></a>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage==page || currentPage==null}">
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
					<a href="/show/highesRatedShow?currentPage=1&begin=${3*(1-1)}&range=3"><p><</p></a>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage==null}">
				</c:when>
				<c:otherwise>
					<c:forEach var="i" begin="${startPage}" end="${endPage}">
						<a href="/show/highesRatedShow?currentPage=${i}&begin=${3*(i-1)}&range=3"><p>${i}</p></a>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage==page || currentPage==null}">
				</c:when>
				<c:otherwise>
					<a href="/review/highesRatedShow?currentPage=${page}&type=${type}&begin=${3*(page-1)}&range=3"><p>></p></a>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:when test="${message eq '평점 낮은순'}">
			<c:choose>
				<c:when test="${currentPage==1 || currentPage==null}">
				</c:when>
				<c:otherwise>
					<a href="/show/rowestRatedShow?currentPage=1&begin=${3*(1-1)}&range=3"><p><</p></a>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage==null}">
				</c:when>
				<c:otherwise>
					<c:forEach var="i" begin="${startPage}" end="${endPage}">
						<a href="/show/rowestRatedShow?currentPage=${i}&begin=${3*(i-1)}&range=3"><p>${i}</p></a>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage==page || currentPage==null}">
				</c:when>
				<c:otherwise>
					<a href="/show/rowestRatedShow?currentPage=${page}&type=${type}&begin=${3*(page-1)}&range=3"><p>></p></a>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${currentPage==1 || currentPage==null}">
				</c:when>
				<c:otherwise>
					<a href="/show/categoryShow?category=${message}&currentPage=1&begin=${3*(1-1)}&range=3"><p><</p></a>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage==null}">
				</c:when>
				<c:otherwise>
					<c:forEach var="i" begin="${startPage}" end="${endPage}">
						<a href="/show/categoryShow?category=${message}&currentPage=${i}&begin=${3*(i-1)}&range=3"><p>${i}</p></a>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage==page || currentPage==null}">
				</c:when>
				<c:otherwise>
					<a href="/show/categoryShow?category=${message}&currentPage=${page}&type=${type}&begin=${3*(page-1)}&range=3"><p>></p></a>
				</c:otherwise>
			</c:choose>
		</c:otherwise>


	</c:choose>


</div>

<%@ include file="/WEB-INF/view/layout/footer.jsp"%>


