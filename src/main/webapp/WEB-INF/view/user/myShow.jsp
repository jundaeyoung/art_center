<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<style>
.container {
	display: flex;
	justify-content: center;
	box-sizing: border-box;
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

.content {
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

.show__schedule {
	display: flex;
	border: 1px solid #568607;
	width: 250px;
	height: 30px;
	align-items: center;
	justify-content: center;
	border-radius: 10px;
	margin-top: 40px;
	margin-right: 20px;
}

.show__btn {
	display: flex;
}
</style>
	<div class="container">
		<div class="userName">
			<h1>${principal.nickname}님공연 신청 내역입니다</h1>
		</div>
	</div>
	<div class="content">
		<div class="dd">
			<c:forEach var="myShowList" items="${myShowList}">
				<div class="myShow">
					<div class="show__approve">
						<c:choose>
							<c:when test="${myShowList.showStatus == 0}">
								<h3 style="color: #ccc; font-weight: bold;">승인대기</h3>
							</c:when>
							<c:when test="${myShowList.showStatus == 1}">
								<h3 style="font-weight: bold;">승인완료</h3>
							</c:when>
						</c:choose>
					</div>
					<div class="show__info__list">
						<div>
							<a href="/myPage/showDetail/${myShowList.id}"><img alt=""
								src="/images/upload/${myShowList.imgRoute}" class="show__img"></a>
						</div>

						<div>
							<div class="show__date">
								<p>${myShowList.startDate}&nbsp;~&nbsp;${myShowList.endDate}</p>
							</div>
							<div class="show__info__ta">
								<h2>
									<a href="/myPage/showDetail/${myShowList.id}">${myShowList.title}</a>
								</h2>
								<div class="show__age">
									<p>${myShowList.admissionAge}</p>
								</div>
							</div>
							<div class="show__btn">
								<div class="show__schedule">
									<a href="/manager/schedule/${principal.id}">공연일정
										보러가기&nbsp;(달력)</a>
								</div>
								<div class="show__schedule">
									<a href="/myPage/showDetail/${myShowList.id}">예약 정보</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>