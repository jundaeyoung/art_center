<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="/css/user/ticketCheck.css">




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
								<c:choose>
									<c:when test="${ticketListInfo.showTypeId==1}">
										<h2>${ticketListInfo.name}&nbsp;&nbsp;&nbsp;&nbsp;${ticketListInfo.seatName}</h2>
									</c:when>
									<c:otherwise>
										<h2>${ticketListInfo.name}</h2>
									</c:otherwise>
								</c:choose>
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
				<img alt="" src="/images/upload/${ticketListInfo.qrCode}.png" class="qrcode">
			</div>
		</c:forEach>


	</div>

</div>



<%@ include file="/WEB-INF/view/layout/footer.jsp"%>




