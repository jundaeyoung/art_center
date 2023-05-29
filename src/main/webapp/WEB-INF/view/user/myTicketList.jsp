<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>


<div class="container">
	<div class="userName">
		<h1>${principal.nickname}님공연예매 내역입니다</h1>
	</div>
</div>
<div class="content">
	<div class="dd">
		<c:forEach var="myTicketList" items="${myTicketList}">
			<div class="myTicket">
				<div>
				<p></p>
				</div>
				<%-- <div class="ticket__approve">
						<c:choose>
							<c:when test="${myTicketList.showStatus == 0}">
								<h3 style="color: #ccc; font-weight: bold;">승인대기</h3>
							</c:when>
							<c:when test="${myShowList.showStatus == 1}">
								<h3 style="font-weight: bold;">승인완료</h3>
							</c:when>
						</c:choose>
					</div> --%>

						<div class="show__info__ta">
							<h2>
								<a href="/myPage/myTicketDetail/${myTicketList.id}">${myTicketList.title}</a>
							</h2>

						</div>
						<%-- <div class="show__btn">
							<div class="show__schedule">
								<a href="/manager/schedule/${principal.id}">공연일정 보러가기&nbsp;(달력)</a>
							</div>
							<div class="show__schedule">
								<a href="/myPage/showDetail/${myShowList.id}">예약 정보</a>
							</div>
						</div> --%>
			</div>
		</c:forEach>
	</div>
</div>







<%@ include file="/WEB-INF/view/layout/footer.jsp"%>