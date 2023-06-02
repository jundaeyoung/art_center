<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>

<style>
#btn {
	border: 0;
	background-color: transparent;
	font-size: 16px;
}

.container {
	box-sizing: border-box;
	margin-top: 10px;
	margin-bottom: 50px;
	width: 100%;
	height: 100%;
}

.rental__img {
	display: flex;
	justify-content: center;
	padding: 300px;
	margin-top: 100px;
	background-image: url('/images/myPage.png');
	background-position: bottom;
}

.userName {
	display: flex;
	align-items: center;
	justify-content: center;
}

.user__info {
	display: flex;
	border: 1px solid #ccc;
	height: 200px;
}

.user {
	margin: 10px;
	border: 1px solid #ccc;
	width: 150px;
	height: 30px;
	text-align: center;
}

user__type {
	border-spacing: 0;
}

.user__type {
	display: flex;
	justify-content: center;
	margin: 10px 0 10px 0;
	width: 100%;
}

.user__ticket:nth-of-type(1) {
	border: 1px solid #ebebeb;
	width: 400px;
	height: 60px;
	text-align: center;
}

.user__ticket:nth-of-type(2) {
	border-top: 1px solid #ebebeb;
	border-bottom: 1px solid #ebebeb;
	width: 400px;
	height: 60px;
	text-align: center;
}

.user__ticket:nth-of-type(3) {
	border-left: 1px solid #ebebeb;
	border-top: 1px solid #ebebeb;
	border-bottom: 1px solid #ebebeb;
	width: 400px;
	height: 60px;
	text-align: center;
}

.user__ticket:nth-of-type(4) {
	border: 1px solid #ebebeb;
	width: 400px;
	height: 60px;
	text-align: center;
}

.user-type-btn {
	border: 0;
	outline: 0;
	background: none;
	font-size: 16px;
	color: gray;
}

.user-type-btn:hover {
	color: black;
	font-weight: bold;
}

.info {
	width: 100%;
}

.user_reservation_list {
	width: 100%;
}

<
style>.container {
	box-sizing: border-box;
	display: flex;
	justify-content: center;
	margin-bottom: 50px;
	width: 100%;
	height: 100%;
}

.userName {
	display: flex;
	align-items: center;
	justify-content: center;
	margin-top: 100px;
	width: 800px;
	border: 2px solid black;
}

.my_show_content {
	box-sizing: border-box;
	width: 1500px;
	height: 100%;
	margin-top: 20px;
}

.dd {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	width: 1500px;
	padding: 10px;
}

.myShow {
	margin: 10px;
	border: 1px solid #ccc;
	border-radius: 20px;
	height: 250px;
	width: 800px;
}

.show__title {
	display: flex;
	margin-left: 10px;
}

.show__approve {
	margin: 0 20px;
}

.show__date p {
	margin: 0;
}

.show__img {
	width: 150px;
	height: 150px;
	border-radius: 10px;
	margin: 0 20px;
	border: 1px solid #eee;
}

.show__info__list {
	display: flex;
}

.show__info__ta {
	display: flex;
	width: 500px;
	height: 50px;
	margin-top: 0;
}

.show__info__ta p, h2 {
	margin: 0;
	display: flex;
	align-items: center;
}

.show__age {
	margin: 12px;
}

.show__age p {
	color: gray;
}

.show__schedule__btn {
	display: flex;
	border: 1px solid #568607;
	width: 180px;
	height: 30px;
	align-items: center;
	justify-content: center;
	border-radius: 10px;
	margin-top: 40px;
	margin-right: 20px;
}

.show__schedule {
	display: flex;
	border: 1px solid #568607;
	width: 280px;
	height: 30px;
	align-items: center;
	justify-content: center;
	border-radius: 10px;
	margin-top: 40px;
	margin-right: 20px;
}

.show__btn {
	display: flex;
	margin-top: 10px;
}

.kakao__img {
	width: 50px;
	height: 20px;
}

.btn__a {
	display: flex;
	justify-content: center;
	align-items: center;
}

.page {
	display:  flex;
	justify-content: center;
}

.page p{
	margin-left: 20px;
}
</style>
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
									onclick="location.href='/myPage/myShow/${principal.id}'">공연
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
	<div class="dd">
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
			<a
				href="/myPage/myShow/${principal.id}?currentPage=1&begin=${5*(1-1)}&range=5"><p><<</p></a>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${currentPage==null}">
		</c:when>
		<c:otherwise>
			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				<a
					href="/myPage/myShow/${principal.id}?currentPage=${i}&begin=${5*(i-1)}&range=5"><p>${i}</p></a>
			</c:forEach>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${currentPage==page || currentPage == null}">
		</c:when>
		<c:otherwise>
			<a
				href="/myPage/myShow/${principal.id}?currentPage=${page}&begin=${5*(page-1)}&range=5"><p>>></p></a>
		</c:otherwise>
	</c:choose>
</div>

<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
