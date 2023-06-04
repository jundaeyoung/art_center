<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<style>
#ticket--title {
	border-bottom: 1px solid #ccc;
}

#ticket--title h1 {
	font-size: 50px;
	margin-bottom: 50px;
	font-weight: 300;
}

.ticketInfo--wrap {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	margin-top: 50px;
}

.ticket--content {
	display: flex;
	justify-content: space-around;
	align-items: center;
	border: 1px solid #ccc;
	background-color: #efe3d3;
	margin-bottom: 150px;
	border-radius: 10px;
	width: 1350px;
	height: 450px;
}

.myTicket {
	display: flex;
	width: 1300px;
	height: 600px;
	align-items: center;
}

.ticket--info {
	margin-left: 50px;
	margin-top: -50px;
}

.ticket--info div {
	border-bottom: 1px solid black;
	width: 600px;
}

.ticket--title {
	display: flex;
	justify-content: flex-start;
	align-items: flex-end;
	width: 800px;
}

.ticket--title p {
	width: 400px;
	font-weight: 300;
	max-height: 100px;
	color: #DB2F1B;
	font-size: 70px;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
	margin-bottom: 10px;;
}

.ticket--title h2 {
	width: 300px;
	font-weight: 300;
	height: 50px;
	color: black;
	font-size: 40px;
}

.ticketing--date {
	display: flex;
}

.ticketing--date h2 {
	font-size: 23px;
	font-weight: 300;
	color: #DB2F1B;
}

.ticket--hole h2 {
	font-size: 30px;
	color: #DB2F1B;
	font-weight: 400;
}

.ticket--date h2 {
	font-size: 30px;
	color: #d6644d;
	font-weight: 400;
}

.btn {
	width: 1100px;
	justify-content: flex-end;
	align-items: flex-start;
	display: flex;
	margin-top: -150px;
	margin-bottom: 100px;
}
</style>

<c:set var="todayDate" value="<%=new java.util.Date()%>" />
<fmt:formatDate value="${todayDate}" pattern="yyyy-MM-dd" />



<div class="container">
	<div class="userName" id="ticket--title">
		<h1>${principal.nickname}님&nbsp;공연예매&nbsp;내역입니다</h1>
	</div>
	<div class="ticketInfo--wrap">
		<c:forEach var="myTicketList" items="${myTicketList}">
			<div class="ticket--content">
				<div class="myTicket">
					<div class="ticketing--img">
						<img alt="" src="/images/upload/${myTicketList.imgRoute}"
							width="300" height="400">
					</div>
					<div class="ticket--info">
						<div class="ticket--title">
							<a href="/show/showView/${myTicketList.showId}"><p>${myTicketList.title}</p>
							</a>
							<c:choose>
								<c:when test="${myTicketList.paymentStatus == 0 && myTicketList.showDate >= todayDate}">
									<h2>(결제대기)</h2>
								</c:when>
								<c:when
									test="${myTicketList.cancelStatus == 0 && myTicketList.paymentStatus == 1}">
									<h2>(결제완료)</h2>
								</c:when>
								<c:when
									test="${myTicketList.showDate <= todayDate && myTicketList.paymentStatus == 0}">
									<h2>(결제불가)</h2>
								</c:when>
								<c:when test="${myTicketList.cancelStatus == 1}">
									<h2>(취소완료)</h2>
								</c:when>
							</c:choose>
						</div>
						<div class="ticket--hole">
							<h2>${myTicketList.name}&nbsp&nbsp&nbsp${myTicketList.seatName}</h2>
						</div>
						<div class="ticket--date">
							<h2>날짜 : ${myTicketList.showDate}&nbsp;&nbsp;&nbsp;&nbsp;시간
								: ${myTicketList.showTime}</h2>
						</div>
						<div class="ticketing--date">
							<a href="/myPage/myTicketDetail/${myTicketList.id}"
								class="ticketingId">
								<h2>예매일&nbsp&nbsp:&nbsp&nbsp</h2>
							</a> <a href="/myPage/myTicketDetail/${myTicketList.id}"
								class="ticketingId"> </a>
							<h2>${myTicketList.ticketingDate}&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</h2>
							<a href="/myPage/myTicketDetail/${myTicketList.id}"
								class="ticketingId"> </a>
							<h2>예매 번호&nbsp&nbsp:&nbsp&nbsp</h2>
							<a href="/myPage/myTicketDetail/${myTicketList.id}"
								class="ticketingId"> </a>
							<h2>${myTicketList.id}</h2>
							<a href="/myPage/myTicketDetail/${myTicketList.id}"
								class="ticketingId"> </a>
						</div>
					</div>
					<img alt="" src="/images/upload/${myTicketList.qrCode}.png"
						class="bacode">
				</div>
			</div>
			<div class="btn">
				<c:choose>
					<c:when test="${myTicketList.paymentStatus == 0 && myTicketList.showDate >= todayDate}">
						<form action="/kakao/ready" method="get">
							<input type="hidden" name="ticketingId"
								value="${myTicketList.id}">
							<button type="submit" class="kakao--btn">
								<img alt="" src="/images/kakao/payment_icon_yellow_small.png">
							</button>
						</form>
					</c:when>
					<c:when test="${myTicketList.paymentStatus == 1}">
						<form action="/kakao/refund/${myTicketList.paymentId}"
							method="post">
							<c:choose>
								<c:when test="${myTicketList.cancelStatus == 1}">
								</c:when>
								<c:when test="${myTicketList.showDate <= todayDate}">
								</c:when>
								<c:otherwise>
									<button type="submit">예매 취소</button>
								</c:otherwise>
							</c:choose>
						</form>
					</c:when>
				</c:choose>
				<div class="ticket--refund--btn"></div>
			</div>
		</c:forEach>
	</div>
</div>

<%@ include file="/WEB-INF/view/layout/footer.jsp"%>


