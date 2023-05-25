<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<style>
.content {
	box-sizing: border-box;
	width: 1500px;
	height: 100%;
	margin-top: 100px;
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
	height: 200px;
	width: 1000px;
}

.show__title {
	display: flex;
	margin-left: 10px;
}

.show__approve {
	margin: 10px;
}

.show__date {
	margin-left: 10px;
}
</style>

<div class="content">
	<div class="dd">
		<c:forEach var="myShowList" items="${myShowList}">
			<div class="myShow">
				<div class="show__title">
					<h2>
						<a href="/myPage/ShowDetail/${myShowList.id}">${myShowList.title}</a>
					</h2>
					<div class="show__approve">
						<c:choose>
							<c:when test="${myShowList.showStatus == 0}">
								<p style="color: #ccc; font-weight: bold;">승인대기</p>
							</c:when>
							<c:when test="${myShowList.showStatus == 1}">
								<p style="font-weight: bold;">승인완료</p>
							</c:when>
						</c:choose>
					</div>
				</div>
				<div class="show__date">
					<p>${myShowList.startDate}&nbsp;~&nbsp;${myShowList.endDate}</p>
				</div>
			</div>
		</c:forEach>
	</div>
</div>

<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
