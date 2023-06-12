<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="/css/myShow.css">

<div class="rental__img"></div>
<div class="container">
	<div class="info">
		<c:choose>
			<c:when test="${principal.getRoleId()==1}">
				<div class="user_reservation_list">
					<table class="user__type">
						<tr>
							<td class="user__ticket">
								<button type="submit" class="user-type-btn"
									name="info__category"
									onclick="location.href='/myPage/myTicket/${principal.id}'">티켓예매내역</button>
							</td>
							<td class="user__ticket">
								<button type="submit" class="user-type-btn"
									name="info__category"
									onclick="location.href='/myPage/myTicketReview'">관람평</button>
							</td>
							<td class="user__ticket">
								<button type="submit" class="user-type-btn"
									name="info__category"
									onclick="location.href='/user/update?userName=${principal.userName}'">회원수정</button>
							</td>
							<td class="user__ticket">
								<button type="submit" class="user-type-btn"
									name="info__category" value="아카데미"
									onclick="location.href='/user/delete?userName=${principal.userName}'">회원탈퇴</button>
							</td>
						</tr>
					</table>
				</div>
			</c:when>
			<c:when test="${principal != null && principal.getRoleId()==2}">
				<div class="user_reservation_list">
					<table class="user__type">
						<tr>
							<td class="user__ticket">
								<button type="submit" class="user-type-btn"
									name="info__category"
									onclick="location.href='/myPage/myShow/${principal.id}/1/0/5'">공연
									대관 내역</button>
							</td>
							<td class="user__ticket">
								<button type="submit" class="user-type-btn"
									name="info__category"
									onclick="location.href='/myPage/rentRefund'">환불내역</button>
							</td>
							<td class="user__ticket">
								<button type="submit" class="user-type-btn"
									name="info__category"
									onclick="location.href='/user/update?userName=${principal.userName}'">회원수정</button>
							</td>
							<td class="user__ticket">
								<button type="submit" class="user-type-btn"
									name="info__category" value="아카데미"
									onclick="location.href='/user/delete?userName=${principal.userName}'">회원탈퇴</button>
							</td>
						</tr>
					</table>
				</div>
			</c:when>
		</c:choose>
	</div>
</div>

<div class="my_show_content">
	<div class="content-myshow">
		<c:forEach var="myRegistrationInfoDto" items="${myShowList}">
			<div class="myShow">
				<div class="show__approve">
					<c:choose>
						<c:when test="${myRegistrationInfoDto.showStatus == 0}">
							<h3 style="color: #ccc; font-weight: bold;">승인대기</h3>
						</c:when>
						<c:when test="${myRegistrationInfoDto.showStatus == 1}">
							<c:choose>
								<c:when test="${myRegistrationInfoDto.rentPlaceStatus == 1}">
									<h3 style="font-weight: bold;">승인완료 (결제 완료)</h3>
								</c:when>
								<c:when test="${myRegistrationInfoDto.rentPlaceStatus == 0}">
									<h3 style="font-weight: bold;">승인완료 (결제 미완료)</h3>
								</c:when>
							</c:choose>
						</c:when>
					</c:choose>
				</div>
				<div class="show__info__list">
					<div>
						<a href="/myPage/showDetail/${myRegistrationInfoDto.id}"><img
							alt="" src="/images/upload/${myRegistrationInfoDto.imgRoute}"
							class="show__img"></a>
					</div>

					<div>
						<div class="show__date">
							<p>${myRegistrationInfoDto.startDate}&nbsp;~&nbsp;${myRegistrationInfoDto.endDate}</p>
						</div>
						<div class="show__info__ta">
							<h2>
								<a href="/myPage/showDetail/${myRegistrationInfoDto.id}">${myRegistrationInfoDto.title}</a>
							</h2>
							<div class="show__age">
								<p>${myRegistrationInfoDto.admissionAge}</p>
							</div>
						</div>
						<c:choose>
							<c:when test="${myRegistrationInfoDto.showStatus == 0}">
								<div class="show__btn">
									<div class="show__schedule">
										<a href="/manager/schedule">공연일정&nbsp;(달력)</a>
									</div>
									<div class="show__schedule">
										<a href="/myPage/showDetail/${myRegistrationInfoDto.id}">예약
											정보</a>
									</div>
								</div>
							</c:when>
							<c:when test="${myRegistrationInfoDto.rentPlaceStatus == 0}">
								<div class="show__btn">
									<div class="show__schedule__btn">
										<a href="/manager/schedule">공연일정&nbsp;(달력)</a>
									</div>
									<div class="show__schedule__btn">
										<a href="/myPage/showDetail/${myRegistrationInfoDto.id}">예약
											정보</a>
									</div>
									<div class="show__schedule__btn">
										<a href="/kakao/ready?rentId=${myRegistrationInfoDto.rentId}"
											class="btn__a"><img alt=""
											src="/images/kakao/payment_icon_yellow_medium.png"
											class="kakao__img"> &nbsp;결제 하기</a>
									</div>
								</div>
							</c:when>

							<c:when test="${myRegistrationInfoDto.rentPlaceStatus == 1}">

								<div class="show__btn">
									<div class="show__schedule__btn">
										<a href="/manager/schedule">공연일정&nbsp;(달력)</a>
									</div>
									<div class="show__schedule__btn">
										<a href="/myPage/showDetail/${myRegistrationInfoDto.id}">예약
											정보</a>
									</div>
									<div class="show__schedule__btn">
										<form
											action="/kakao/refund/${myRegistrationInfoDto.getMPaymentId()}"
											method="post">
											<div>
												<input type="hidden" name="id"
													value="${myRegistrationInfoDto.id}">
												<button type="submit" class="btn__a" id="btn">
													<img alt=""
														src="/images/kakao/payment_icon_yellow_medium.png"
														class="kakao__img"> &nbsp;&nbsp;환불요청
												</button>
											</div>
										</form>
									</div>


								</div>
							</c:when>
							<c:otherwise>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>
<div class="page">
	<c:choose>
		<c:when test="${currentPage==1 || currentPage==null}">
		</c:when>
		<c:otherwise>
			<a href="/myPage/myShow/${principal.id}/1/${5*(1-1)}/5"><p><</p></a>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${currentPage==null}">
		</c:when>
		<c:otherwise>
			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				<a href="/myPage/myShow/${principal.id}/${i}/${5*(i-1)}/5"><p>${i}</p></a>
			</c:forEach>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${(currentPage!=page || currentPage != null) && currentPage>1 }">
			<a href="/myPage/myShow/${principal.id}/${page}/${5*(page-1)}/5"><p>></p></a>
		</c:when>
	</c:choose>
</div>

<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
