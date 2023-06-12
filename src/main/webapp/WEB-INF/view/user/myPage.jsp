<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="/css/myPage.css">


<div class="rental__img"></div>
<div class="container">
	<div class="userName">
		<h1>${principal.nickname}님 안녕하세요!</h1>
	</div>
	<div class="info">
		<c:choose>
		<c:when test="${principal.getRoleId()==1}">
		<div class="user_reservation_list">
			<table class="user__type">
				<tr>
					<td class="user__ticket">
						<button type="submit" class="user-type-btn" name="info__category" onclick="location.href='/myPage/myTicket/${principal.id}'">티켓예매내역</button>
					</td>
					<td class="user__ticket">
						<button type="submit" class="user-type-btn" name="info__category" onclick="location.href='/myPage/myTicketReview'">관람평</button>
					</td>
					<td class="user__ticket">
						<button type="submit" class="user-type-btn" name="info__category" onclick="location.href='/user/update?userName=${principal.userName}'">회원수정</button>
					</td>
					<td class="user__ticket">
						<button type="submit" class="user-type-btn" name="info__category" value="아카데미" onclick="location.href='/user/delete?userName=${principal.userName}'">회원탈퇴</button>
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
 						<button type="submit" class="user-type-btn" name="info__category" onclick="location.href='/myPage/myShow/${principal.id}/1/0/5'">공연 대관 내역</button>
					</td>
					<td class="user__ticket">
						<button type="submit" class="user-type-btn" name="info__category" onclick="location.href='/myPage/rentRefund'">환불내역</button>
					</td>
					<td class="user__ticket">
						<button type="submit" class="user-type-btn" name="info__category" onclick="location.href='/user/update?userName=${principal.userName}'">회원수정</button>
					</td>
					<td class="user__ticket">
						<button type="submit" class="user-type-btn" name="info__category" value="아카데미" onclick="location.href='/user/delete?userName=${principal.userName}'">회원탈퇴</button>
					</td>
				</tr>
			</table>
		</div>
		</c:when>
	</c:choose>
	</div>
</div>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>



