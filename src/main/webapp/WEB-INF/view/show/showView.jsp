<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.Arrays"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link rel="stylesheet" href="/css/showView.css">

<style>
</style>
<div class="show--main">
	<div class="main">
		<div class="main--content">
			<div class="show--content">
				<div class="show--info">
					<div class="show--title">
						<h1>${showInfo[0].title}</h1>
					</div>

					<div class="show--period">
						<p class="list">기간</p>
						<p>: ${showInfo[0].startDate}&nbsp;~&nbsp;${showInfo[0].endDate}</p>
					</div>
					<div class="show--times">
						<p class="list">상연 정보 보기</p>
						<p style="width: 13px;">:</p>
						<div class="show--time">
							<select>
								<c:forEach var="showInfo" items="${showInfo}">
									<option>${showInfo.formatDate()}&nbsp;${showInfo.formatTime()}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div>
						<p class="list">장소</p>
						<p>: ${showInfo[0].location}&nbsp;${showInfo[0].name}</p>
					</div>
					<div>
						<p class="list">입장 연령</p>
						<p>: ${showInfo[0].admissionAge}</p>

					</div>
					<div>
						<p class="list">주최</p>
						<p>: ${showInfo[0].nickname}</p>
					</div>
					<div>
						<p class="list">문의</p>
						<p>: ${showInfo[0].tel}</p>
					</div>
				</div>


				<div class="side--container">
					<div class="show--img">
						<img alt="" src="/images/upload/${showInfo[0].imgRoute}">
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
			<p>${showInfo[0].content}</p>
		</div>
	</div>
	<input type="hidden" name="show_type_id" value="${showInfo[0].showTypeId}">
</div>


<script type="text/javascript">
$(document).ready(function() {
		  console.log("Ddd");
	  $(".show--introduction--button").on("click", function() {
		  $(".show--introduction--content").empty();
		  console.log("Ddd");
		  let content = `<h2>작품소개</h2>
						<p>${showInfo[0].content}</p>`;
		  $(".show--introduction--content").append(content);
	  });
	  $(".show--price--button").on("click", function() {
		  $(".show--introduction--content").empty();
		  let content = `<h2>가격정보</h2>
		  		<p>- 성인 : ${adultRate} 원 </p>
				<p>- 청소년 : ${youthRate} 원 </p>
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
	      }).done(function(data) {
	    	  let response = data.data;
		  $(".show--introduction--content").empty();
		  if(response.length < 1){
			  var content = `<p>등록된 리뷰가 없습니다.</p>`;
	  			$(".show--introduction--content").append(content);
		  }else{
		  	  let content = `<h2>리뷰</h2>`;
		  	  $(".show--introduction--content").append(content);
		  		for(let i = 0; i< response.length; i++) {
 		  			let content = `<div>
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

<script type="text/javascript" src="/js/movePage.js"></script>


<%@ include file="/WEB-INF/view/layout/footer.jsp"%>

