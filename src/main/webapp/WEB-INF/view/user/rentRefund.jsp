<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="/css/rentRefund.css">



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
	<div class="show__content">
		<c:forEach var="myrentList" items="${myrentList}">
			<div class="myShow">
				<div class="show__info__list">
					<div>
						<a href="/myPage/showDetail/${myrentList.id}"><img alt=""
							src="/images/upload/${myrentList.imgRoute}" class="show__img"></a>
					</div>

					<div>
						<div class="show__date">
							<p>${myrentList.startDate}&nbsp;~&nbsp;${myrentList.endDate}</p>
						</div>
						<div class="show__info__ta">
							<h2>
								<a href="/myPage/showDetail/${myrentList.id}">${myrentList.title}</a>
							</h2>
							<div class="show__age">
								<p>${myrentList.admissionAge}</p>
							</div>
						</div>
						<div class="show__btn">
							<div class="show__schedule__btn">
								<a href="/manager/schedule/${principal.id}">공연일정&nbsp;(달력)</a>
							</div>
							<div class="show__schedule__btn">
								<a href="/myPage/showDetail/${myrentList.id}">예약 정보</a>
							</div>
							<div class="show__schedule__btn">
								<div>
									<button type="submit" class="btn__a" id="btn">
										<img alt="" src="/images/kakao/payment_icon_yellow_medium.png"
											class="kakao__img"> &nbsp;&nbsp;환불완료
									</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>


<%@ include file="/WEB-INF/view/layout/footer.jsp"%>



