<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<style>
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
	border-left:1px solid #ebebeb;
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

</style>
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
						<button type="submit" class="user-type-btn" name="info__category" onclick="location.href='#'">티켓예매내역</button>
					</td>
					<td class="user__ticket">
						<button type="submit" class="user-type-btn" name="info__category" onclick="location.href='#'">관람평</button>
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
 						<button type="submit" class="user-type-btn" name="info__category" onclick="location.href='/myPage/myShow/${principal.id}'">공연내역</button>
					</td>
					<td class="user__ticket">
						<button type="submit" class="user-type-btn" name="info__category" onclick="location.href='#'">대관내역</button>
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
