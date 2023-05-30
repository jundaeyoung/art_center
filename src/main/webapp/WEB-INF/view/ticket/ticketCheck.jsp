<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>

<style>
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
	margin-top: 70px;
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

.ticket--content form {
	width: 500px;
}
</style>


<div class="main">

	<div id="ticket--title">
		<h2>티켓 정보</h2>
	</div>
	<div class="ticketInfo--wrap">
		<c:forEach var="ticketListInfo" items="${ticketListInfo}">
			<div class="ticket--content">
				<div>
					<div class="ticket--img">
						<img alt="" src="/images/upload/${ticketListInfo.imgRoute}" width="300" height="400">
					</div>
				</div>
				<div class="ticket--content--info">
					<form action="/pay/payment/${ticketListInfo.id}" method="get">
						<div class="ticket--info">

							<div class="ticket--title">
								<h2>${ticketListInfo.title}</h2>
							</div>
							<div class="ticket--hole">
								<h2>${ticketListInfo.name}&nbsp;&nbsp;&nbsp;&nbsp;${ticketListInfo.seatName}</h2>
							</div>
							<div class="ticket--date">
								<h2>날짜 : ${ticketListInfo.showDate}&nbsp;&nbsp;&nbsp;&nbsp;시간 : ${ticketListInfo.showTime}</h2>
							</div>
							<div class="ticket--price">
								<c:choose>
									<c:when test="${ticketListInfo.ageGroupId==3}">
										<h2>[성인]&nbsp;&nbsp;&nbsp;&nbsp;${ticketListInfo.adultRate}</h2>
									</c:when>
									<c:otherwise>
										<h2>[청소년]&nbsp;&nbsp;&nbsp;&nbsp;${ticketListInfo.youthRate}</h2>
									</c:otherwise>
								</c:choose>
							</div>
						</div>
						<button type="submit" class="ticket--button">결제하기</button>
					</form>
				</div>
				<div></div>
				<img alt="" src="/images/bacode.png" class="bacode">
			</div>
		</c:forEach>


	</div>

</div>



<%@ include file="/WEB-INF/view/layout/footer.jsp"%>