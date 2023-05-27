<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>

<div class="content">
	<div class="dd">
		<div class="myTicket">
			<div class="ticket--title">
				<h2>${ticketInfo.title}</h2>
			</div>
			<div class="ticket__info__list">
				<div class="show--img">
					<img alt="" src="/images/upload/${ticketInfo.imgRoute}" class="show__img">
				</div>
				<div>
					<div>
						<p>예약자명</p>
						<p>${userName}</p>
					</div>
					<div class="reserve--num">
						<p>예매번호</p>
						<p>${ticketInfo.paymentId}</p>
					</div>
					<div class="ticket--date">
						<p>관람일</p>
						<p>${ticketInfo.showDate}&nbsp;${ticketInfo.showTime}</p>
					</div>
					<div>
						<p>장소</p>
						<p>${ticketInfo.location}&nbsp;${ticketInfo.name}</p>
					</div>
					<div>
						<p>좌석</p>
						<p>${ticketInfo.seatName}</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>




</div>



</div>



<%@ include file="/WEB-INF/view/layout/footer.jsp"%>