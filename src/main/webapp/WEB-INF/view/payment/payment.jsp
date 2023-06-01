<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>

<style>
.main {
	height: 1000px;
}

#ticket--title {
	border-bottom: 1px solid #ccc;
}

#ticket--title h2 {
	font-size: 50px;
	margin-bottom: 50px;
	font-weight: 300;
}

.ticketInfo--wrap {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	margin-top: 150px;
	height: 530px;
}

.ticket--content {
	display: flex;
	justify-content: space-around;
	align-items: center;
	border: 1px solid #ccc;
	background-color: #efe3d3;
	margin-bottom: 150px;
	border-radius: 10px;
	width: 1400px;
	height: 530px;
}

.ticket--title h2 {
	font-size: 70px;
	font-weight: 300;
	color: #DB2F1B;
	height: 50px;
}

.ticket--hole h2 {
	font-size: 30px;
	color: #DB2F1B;
	font-weight: 400;
}

.ticket--info {
	margin-right: 200px;
	margin-top: -60px;
	margin-left: -300px;
}

.ticket--info div {
	align-items: center;
	border-bottom: 1px solid black;
	width: 600px;
	display: flex;
}

.ticket--date h2 {
	font-size: 30px;
	color: #d6644d;
	font-weight: 400;
}

.ticket--price h2 {
	font-size: 30px;
	color: #d6644d;
	font-weight: 400;
}

.ticket--button {
	margin-top: 50px;
	margin-left: 750px;
	width: 200px;
	height: 70px;
	border-style: none;
	background-color: rgb(255, 80, 90);
	color: white;
	font-size: 30px;
	border-radius: 10px;
}

.bacode {
	width: 300px;
	height: 300px;
	transform: rotate(270deg);
}

.ticketimg {
	width: 300px;
	margin-left: 20px;
}

.kakao {
	margin-left: 1100px;
	margin-top: -120px;
}

.kakao button {
	border-style: none;
	background-color: white;
}

.ticket--content--info {
	margin-left: 350px;
	width: 400px;
}
.qrcode {
	width: 350px;
	height: 350px;
	transform: rotate(270deg);
	margin-top: 20px;
	margin-left: -70px;
}
</style>


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