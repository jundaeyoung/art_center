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
				<div class="ticket--info">
					<table>
						<tr>
							<th>제목</th>
							<td>${ticketListInfo.title}</td>
						</tr>
						<tr>
							<th>관람 일자</th>
							<td>${ticketListInfo.showDate}</td>
						</tr>
						<tr>
							<th>관람 시간</th>
							<td>${ticketListInfo.showTime}</td>
						</tr>
						<tr>
							<th>좌석</th>
							<td>${ticketListInfo.seatName}</td>
						</tr>
					</table>

				</div>

				<form action="/ticket/ticketing/${showId}" method="get">
					<button type="button" onclick="goTicketing(${showId})">예매하기</button>
				</form>

			</c:forEach>

		</div>

	</div>

</div>



<%@ include file="/WEB-INF/view/layout/footer.jsp"%>