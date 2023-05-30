<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<style>
.container {
	margin: 0;
	padding: 0;
	height: 100%;
	width: 100%;
	box-sizing: border-box;
}

.myTicket {
	border: 3px solid #eee;
	display: flex;
}

button {
	-webkit-appearance: none;
	-moz-appearance: none;
	appearance: none;
}
</style>


<div class="container">
	<div class="userName">
		<h1>${principal.nickname}님&nbsp;공연예매&nbsp;내역입니다</h1>
	</div>

	<div class="content">
		<div class="dd">
			<c:forEach var="myTicketList" items="${myTicketList}">
				<div class="myTicket">
					<c:choose>
						<c:when test="${myTicketList.paymentStatus == 0}">
							<div class="ticket--approve">
								<h3 style="color: #ccc; font-weight: bold;">결제대기</h3>
							</div>
							<div class="ticketing--img">
								<img alt="" src="/images/upload/${myTicketList.imgRoute}">
							</div>
							<div class="ticketing--date">
								<p>예매일</p>
								<p>${myTicketList.ticketingDate}</p>
							</div>
							<div class="ticketing--num">
								<p>예매 번호</p>
								<p>${myTicketList.id}</p>
							</div>
							<div class="ticket--title">
								<h2>
									<a href="/show/showView/${myTicketList.showId}">${myTicketList.title}</a>
								</h2>
							</div>

							<div class="ticket--btn">
								<div class="ticket--detail--btn">
									<a href="/myPage/myTicketDetail/${myTicketList.id}">예매 정보</a>
								</div>
								<div class="ticket--pay--btn">
									<form action="/kakao/ready" method="get">
										<button type="submit" class="kakao--btn">
											<img alt="" src="/images/kakao/payment_icon_yellow_small.png">
										</button>
									</form>
								</div>
							</div>
						</c:when>
						<c:when test="${myTicketList.paymentStatus == 1}">
							<div class="ticket--approve">
								<h3 style="font-weight: bold;">결제완료</h3>
							</div>
							<div class="ticketing--img">
								<img alt="" src="/images/upload/${myTicketList.imgRoute}">
							</div>
							<div class="ticketing--date">
								<p>예매일</p>
								<p>${myTicketList.paymentDate}</p>

							</div>
							<div class="ticketing--num">
								<p>예매 번호</p>
								<p>${myTicketList.paymentId}</p>
							</div>
							<div class="ticket--title">
								<h2>
									<a href="/show/showView/${myTicketList.showId}">${myTicketList.title}</a>
								</h2>
							</div>

							<div class="ticket--btn">
								<div class="ticket--detail--btn">
									<a href="/myPage/myTicketDetail/${myTicketList.id}">예매 정보</a>
								</div>
								<div class="ticket--refund--btn">
									<form action="/kakao/refund" method="post">
										<button type="submit">예매 취소</button>
									</form>
								</div>
							</div>
						</c:when>
					</c:choose>
				</div>
			</c:forEach>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/view/layout/footer.jsp"%>