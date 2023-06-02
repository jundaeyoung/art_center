<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="/css/payment.css">


<div class="main">

	<div id="ticket--title">
		<h2>결제</h2>
	</div>
	<div class="ticketInfo--wrap">
		<div class="ticket--content">
			<div class="ticketimg">
				<div class="ticket--img">
					<img alt="" src="/images/upload/${ticket.imgRoute}" width="300" height="400">
				</div>
			</div>
			<div class="ticket--content--info">
				<div>
					<div class="ticket--info">

						<div class="ticket--title">
							<h2>${ticket.title}</h2>
						</div>
						<div class="ticket--hole">
							<h2>${ticket.name}&nbsp;&nbsp;&nbsp;&nbsp;${ticket.seatName}</h2>
						</div>
						<div class="ticket--date">
							<h2>날짜 : ${ticket.showDate}&nbsp;&nbsp;&nbsp;&nbsp;시간 : ${ticket.showTime}</h2>
						</div>
						<div class="ticket--price">
							<c:choose>
								<c:when test="${ticket.ageGroupId==3}">
									<h2>[성인]&nbsp;&nbsp;&nbsp;&nbsp;${ticket.adultRate}</h2>
								</c:when>
								<c:otherwise>
									<h2>[청소년]&nbsp;&nbsp;&nbsp;&nbsp;${ticket.youthRate}</h2>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
			</div>
			<div></div>
			<img alt="" src="/images/upload/${ticket.qrCode}.png" class="qrcode">
		</div>
		<div class="kakao">
			<form action="/kakao/ready" method="get">
				<button type="submit">
					<img alt="" src="/images/kakao/payment_icon_yellow_medium.png">
				</button>
			</form>
		</div>

	</div>


</div>

<%@ include file="/WEB-INF/view/layout/footer.jsp"%>