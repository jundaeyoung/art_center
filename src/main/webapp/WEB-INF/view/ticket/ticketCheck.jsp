<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>


<div class="main">

	<div class="ticketInfo--wrap">
		<div class="ticket--title">
			<h2>티켓 정보</h2>
		</div>


		<div class="ticket--content">

			<c:forEach var="ticketListInfo" items="${ticketListInfo}">
				<div class="ticket--img">
					<img alt="" src="/images/${ticketListInfo.imgRoute}">
				</div>

				<form action="/pay/payment/${ticketListInfo.id}" method="get">
					<div class="ticket--info">

						<div class="ticket--title">
							<h4>제목</h4>
							<p>${ticketListInfo.title}</p>

						</div>

						<div class="ticket--date">
							<h3>관람 일자</h3>
							<p>${ticketListInfo.showDate}</p>
						</div>

						<div class="ticket--hour">
							<h5>관람 시간</h5>
							<p>${ticketListInfo.showTime}</p>
						</div>

						<div class="ticket--seat">
							<h2>좌석</h2>
							<p>${ticketListInfo.seatName}</p>
						</div>
						<div class="ticket--price">
							<h2>가격</h2>
							<c:choose>
								<c:when test="${userAge>19}">
									<p>[성인]</p>
									<p>${ticketListInfo.adultRate}</p>
								</c:when>
								<c:otherwise>
									<p>[청소년]</p>
									<p>${ticketListInfo.youthRate}</p>

								</c:otherwise>
							</c:choose>
						</div>

					</div>
					<%-- <input type="hidden" name="ticketingId" value="${ticketListInfo.id}"> --%>
					<button type="submit">결제하기</button>

				</form>

			</c:forEach>

		</div>

	</div>

</div>



<%@ include file="/WEB-INF/view/layout/footer.jsp"%>