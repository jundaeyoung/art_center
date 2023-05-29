<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>

<style type="text/css">
.show_content {
	margin-top: 20px;
	display: flex;
	flex-direction: column;
	align-items: center;
}

.dfdf {
	width: 1200px;
}
.dd {
	display: flex;
}

.show__detail {
	display: flex;
	width: 1200px;
	border-top: 1px solid black;
	border-bottom: 1px solid black;
}


.show__img {
	width: 150px;
	height: 150px;
	border-radius: 10px;
	margin-top: 20px;
	border: 1px solid #eee;
	margin-bottom: 20px;
}

.show__status {
	border: 1px solid gray;
	width: 80px;
	height: 30px;
	margin-right: 20px;
}

.show__status p {
	margin: 5px;
	text-align: center;
}

.show__sn {
	display: flex;
	align-items: center;
}

.show__all__info {
	margin-left: 20px;
	display: flex;
	flex-direction: column;
	margin-top: 20px;
	margin-bottom: 20px;
}

.rent__title {
	border-bottom: 1px solid #ccc;
}

.rent__info {
	width: 1200px;
	border-bottom: 1px solid black;
}

.myShow__btn__div {
	margin: 30px;
}
.myShow__btn {
	padding: 10px 100px; 
	background-color: white;
	border: 1px solid gray;
}

.reservation__date {
	margin-left: 150px;
}
.show_date {
	color: gray;
	font-weight: bold;
}
</style>
<div class="reservation__date">
<p class="show_date">[신청일] ${detailList.get(0).reservationDate}</p>
</div>
<div class="show_content">
	<div class="show__detail">
		<div class="dfdf">
			<div class="rent__title">
				<h1>공연 정보</h1>
			</div>
			<div class="dd">
				<img alt="" src="/images/upload/${detailList.get(0).imgRoute}"
					class="show__img">

				<div class="show__all__info">
					<div class="show__date">
						<lable>[${detailList.get(0).admissionAge}]&nbsp;${detailList.get(0).startDate}
						~ ${detailList.get(0).endDate}</lable>
					</div>
					<div class="show__sn">
						<div class="show__status">
							<c:choose>
								<c:when test="${detailList.get(0).showStatus == 0}">
									<p>승인대기</p>
								</c:when>
								<c:when test="${detailList.get(0).showStatus == 1}">
									<p>승인완료</p>
								</c:when>
							</c:choose>
						</div>
						<div class="show__name">
							<h2>${detailList.get(0).title}</h2>
						</div>
					</div>
					<label>공연정보 : ${detailList.get(0).content}</label>
				</div>
			</div>
		</div>
	</div>
	<div class="rent__info">
		<div class="rent__title">
			<h1>대관 정보</h1>
		</div>
		<h2>[${detailList.get(0).location}]</h2>
		<p>시간 : ${detailList.get(0).startTime}
			~${detailList.get(0).endTime}</p>
		<p>정보 : ${detailList.get(0).locationInfo}</p>
		<p>대관홀 : ${detailList.get(0).name}</p>
		<c:choose>
			<c:when test="${detailList.get(0).rentPlaceStatus == 0}">
				<p>결제상태 : 결제 미완료</p>
			</c:when>
			<c:when test="${detailList.get(0).rentPlaceStatus == 1}">
				<p>결제상태 : 결제 완료</p>
			</c:when>
		</c:choose>
		<p>문의사항 : ${detailList.get(0).tel}</p>
	</div>
	<div class="myShow__btn__div">
	<button onclick="location.href='/myPage/myShow/${principal.id}'" class="myShow__btn">목록</button>
	</div>
</div>

<%@ include file="/WEB-INF/view/layout/footer.jsp"%>


