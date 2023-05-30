<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.Arrays"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />

<style>
.show--main {
	margin-top: 100px;
}

.main--content {
	display: flex;
	justify-content: center;
	background-size: cover;
	background-image: linear-gradient(rgba(0, 0, 0, 0.6), rgba(0, 0, 0, 0.6)),
		url('/images/background/mainBackground.png');
	background-position: center;
}

.show--content {
	display: flex;
	justify-content: space-around;
	width: 1500px;
	height: 700px;
}

.show--info {
	display: flex;
	flex-direction: column;
	justify-content: center;
}

.show--info div {
	display: flex;
	flex-direction: row;
}

.show--info h1 {
	font-size: 40px;
	font-weight: 400;
	color: #FAFAFA;
}

.show--info p {
	font-size: 20px;
	color: #FAFAFA;
}

.show--times div {
	display: flex;
	flex-direction: column;
}

.show--title {
	width: 500px;
}

select {
	font-size: 20px;
	background-color: #d4d4d4;
	border-style: none;
}

select option {
	background-color: rgba(0, 0, 0, 0.1);
}

.show--time {
	display: flex;
	justify-content: center;
	align-items: center;
}

.side--container {
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	margin-left: 50px;
	margin-top: -10px;
}

.side--container button {
	width: 300px;
	background-color: #fe3f3f;
	color: white;
	font-size: 20px;
	margin-top: -10px;
	border-style: none;
	height: 80px;
}

.side--container button:hover {
	transform: scale(1.0);
}

.show--introduction div button:hover {
	transform: scale(1.0);
}

.show--review--button:hover {
	transform: scale(1.0);
}

.show--img img {
	width: 300px;
	height: 400px;
}

.list {
	width: 150px;
}

.show--introduction {
	display: flex;
	flex-direction: row;
	justify-content: space-around;
}

.show--introduction div {
	display: flex;
	justify-content: center;
	width: 1000px;
	border: 1px solid #ccc;
}

.show--introduction h2 {
	font-size: 30px;
	font-weight: 200;
}

.show--introduction p {
	font-size: 25px;
}

.show--introduction--content {
	display: flex;
	justify-content: center;
	align-items: center;
	padding: 70px 100px;
	height: auto;
	border-right: 1px solid #ccc;
	border-left: 1px solid #ccc;
	border-bottom: 1px solid #ccc;
}

.show--introduction--content {
	display: flex;
	flex-direction: column;
	font-weight: 300;
	align-items: flex-start;
}

.show--introduction--content h2 {
	font-size: 40px;
	font-weight: 300;
	border-bottom: 1px solid black;
}

.show--introduction--content p {
	font-weight: 300;
	line-height: 60px;
	font-size: 20px;
}

.show--introduction--button {
	border-style: none;
	background-color: #FAFAFA;
	height: 40px;
}

.show--price--button {
	border-style: none;
	background-color: #FAFAFA;
}

.show--introduction--content div {
	padding: 30px 100px;
	width: 1050px;
	border-bottom: 1px solid #ccc;
}

.show--introduction--content div p {
	margin-bottom: 30px;
}

.show--introduction--content:last-child {
	border-bottom: none;
}

.show--review--button {
	border-style: none;
	background-color: #fafafa;
}

.show--introduction button {
	width: 470px;
}
</style>
<div class="show--main">
	<div class="main">
		<div class="main--content">
			<div class="show--content">
				<div class="show--info">
					<div class="show--title">
						<h1>${title}</h1>
					</div>

					<div class="show--period">
						<p class="list">기간</p>
						<p>: ${startDate}&nbsp;~&nbsp;${endDate}</p>
					</div>
					<div class="show--times">
						<p class="list">상연 정보 보기</p>
						<p style="width: 13px;">:</p>
						<div class="show--time">
							<select>
								<c:forEach var="showInfo" items="${showInfo}">
									<option>${showInfo.showDate}&nbsp;${showInfo.showTime}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div>
						<p class="list">장소</p>
						<p>: ${location}&nbsp;${name}</p>
					</div>
					<div>
						<p class="list">입장 연령</p>
						<p>: ${admissionAge}</p>

					</div>
					<div>
						<p class="list">주최</p>
						<p>: ${nickname}</p>
					</div>
					<div>
						<p class="list">문의</p>
						<p>: ${tel}</p>
					</div>
				</div>


				<div class="side--container">
					<div class="show--img">
						<img alt="" src="/images/upload/${imgRoute}">
					</div>
					<c:choose>
						<c:when test="${locationId==1}">
							<button type="button" onclick="goTicketing(${showId})">예매하기</button>
						</c:when>
						<c:otherwise>
							<button type="button" onclick="goTicketing(${showId})">예매하기</button>
						</c:otherwise>
					</c:choose>

				</div>
			</div>

		</div>
		<div class="show--introduction">
			<div class="content--introduction" style="border-right: none;">
				<button class="show--introduction--button">
					<h2>작품소개</h2>
				</button>
			</div>
			<div style="border-right: none;">
				<button class="show--price--button">
					<h2>가격정보</h2>
				</button>
			</div>
			<div>
				<button class="show--review--button">
					<h2>관람평</h2>
				</button>
			</div>
		</div>

		<div class="show--introduction--content">
			<h2>작품소개</h2>
			<p>${content}</p>
		</div>
	</div>
<input type="hidden" name="show_type_id" value="${showTypeId}">
</div>


<script type="text/javascript">
$(document).ready(function() {

	  $(".show--introduction--button").on("click", function() {
		  $(".show--introduction--content").empty();
		  var content = `<h2>작품소개</h2>
		  				<p>${content}</p>`;
		  $(".show--introduction--content").append(content);
	  });
	  $(".show--price--button").on("click", function() {
		  $(".show--introduction--content").empty();
		  var content = `<h2>가격정보</h2>
		  		<p>- 성인 : ${adultRate}</p>
				<p>- 청소년 : ${youthRate}</p>
				<p>- 장애인 복지카드 소지자 (1급~3급/중증) 본인 및 동반 1인 50% (현장결제시)</p>
				<p>- 장애인 복지카드 소지자 (4급~6급/경증) 본인 50% (현장결제시)</p>
				<p>- 국가유공자증, 의상자(1~2급)증 / 소지자 본인 및 동반 1인 50% (현장결제시)</p>
				<p>- 유족증 (국가유공자,의사자), 의상자(3급이하)증 / 소지자 본인 50% (현장결제시)</p>`;
		  $(".show--introduction--content").append(content);
	  });
	  $(".show--review--button").on("click", function() {
		  $.ajax({
	        	type: 'get',
	        	url: '/apiShow/showView/${showId}',
	      	    contentType: 'application/json; charset=utf-8',
	      }).done(function(response) {
		  $(".show--introduction--content").empty();
		  if(${reviewListSize} < 1){
			  var content = `<p>등록된 리뷰가 없습니다.</p>`;
	  			$(".show--introduction--content").append(content);
		  }else{
		  	  var content = `<h2>리뷰</h2>`;
		  	  $(".show--introduction--content").append(content);
		  		for(let i = 0; i< response.length; i++) {
 		  			var content = `<div>
		  						   <p>작성일 : `+response[i].reviewCreationDate+`</p>
		  						   <p>내용 : `+ response[i].content+`</p>
		  						   <p>평점 : `+ response[i].rating +`</p>
		  						   </div>
		  							`;
 		  			$(".show--introduction--content").append(content);
				  }
		  }
	  });
});
});
</script>

<script type="text/javascript" src="/js/movePage.js">

</script>




<%@ include file="/WEB-INF/view/layout/footer.jsp"%>

