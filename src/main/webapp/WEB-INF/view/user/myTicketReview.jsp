<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="/css/myreview.css">
<link href="/assets/css/star.css" rel="stylesheet"/>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>


<div class="show__header"></div>

<div class="menu">
	<div>
		<span class="material-symbols-outlined"> <a href="/"><button>home</button></a>
		</span>
	</div>
	<div class="newest">
		<a href="/myPage/myReviewShowType?showType=공연"><button id="show" class="s">공연</button></a>
	</div>
	<div class="highes__rated">
		<a href="/myPage/myReviewShowType?showType=전시회"><button id="exhibition">전시회</button></a>
	</div>
	<div class="lowest__rated">
		<a href="/myPage/myReviewShowType?showType=아카데미"><button id="academy">아카데미</button></a>
	</div>
</div>

<div class="show__title">
	<span class="material-symbols-outlined"> square </span>
	<div>
		<h1>관람평</h1>
	</div>
</div>
<div class="show">
	<c:forEach var="myTicketList" items="${myTicketList}">
		<div class="review__content">
			<div>
				<a href="#"><img src="/images/upload/${myTicketList.imgRoute}" width="230" height="300"></a>
			</div>
			<div class="show__content">
				<h2>${myTicketList.title}&nbsp;(${myTicketList.showType})</h2>
				<p>공연일자 : ${myTicketList.showDate}&nbsp;${myTicketList.showTime}</p>
				<p>내용 : ${myTicketList.content}</p>
				<c:choose>
					<c:when test="${myTicketList.reviewContent == null}">
						<form action="/myPage/myReviewWrite?showId=${myTicketList.showId}" class="mb-3" name="myform" id="myform" method="post">
							<div class="star-input" style="width: 120px; margin-left: -20px;">
								<span class="input"> 
								<input type="radio" name="rating" value="1" id="p1"> <label for="p1">1</label> 
								<input type="radio" name="rating" value="2" id="p2"> <label for="p2">2</label> 
								<input type="radio" name="rating" value="3" id="p3"> <label for="p3">3</label> 
								<input type="radio" name="rating" value="4" id="p4"> <label for="p4">4</label>  
								<input type="radio" name="rating" value="5" id="p5"> <label for="p5">5</label>
								</span>
							</div>
							<div>
								<textarea class="reviewContents" rows="6" id="content" name="content" style="width: 650px;"></textarea>
							</div>
							<button type="submit" class="btn" style="margin-left:5px; margin-top: 10px; border: 1px solid #ccc;">글쓰기</button>
						</form>
					</c:when>
					<c:otherwise>
						<p>평점 : ${myTicketList.rating}점
						<p>리뷰 : ${myTicketList.reviewContent}</p>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</c:forEach>
</div>
<script type="text/javascript">
	
</script>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>


