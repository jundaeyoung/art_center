<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<style>
.refund-main {
	height: 600px;
}
.refund-content {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	
}

.info {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	border-top: 3px solid #6F77A7;
	width: 1300px;
	border-bottom: 1px solid #ccc;
	text-align: center;
	height: 250px;
}

.btn-class {
	display: flex;
}

.refund-btn {
	display: flex;
	text-decoration: none;
	justify-content: center;
	color: black;
	border: 1px solid #C2CDFF;
	width: 350px;
	height: 40px;
	border-radius: 5px;
	text-align: center;
	align-items: center;
	font-size: 17px;
	margin-bottom: 30px;
}

.refund-order {
	width: 1300px;
}

.refund-date {
	border-top: 2px solid black;
}

.refund-amount {
	border-top: 1px solid #ccc;
}

.refund-method {
	border-top: 1px solid #ccc;
	border-bottom: 1px solid #ccc;
}
</style>

<div class="refund-main">
	<div class="refund-content">

		<div class="info">
			<div class="refund-info">
				<h1>결제가 취소 되었습니다.</h1>
			</div>

			<div class="refund-detail">
				<p>취소 내역 : ${kakaoRefundResponse.itemName}</p>
			</div>

			<div class="btn-class">
				<a href="/myPage/info" class="refund-btn">마이페이지</a>
			</div>
		</div>

		<div class="refund-order">
			<div class="refund">
				<h2>취소 정보</h2>
			</div>
			<div class="refund-date">
				<p>취소 일시 : ${kakaoRefundResponse.canceledAt}</p>
			</div>

			<div class="refund-amount">
				<p>취소 금액 : ${kakaoRefundResponse.canceledAmount.total}</p>
			</div>

			<div class="refund-method">
				<p>결제 수단 : ${kakaoRefundResponse.paymentMethodType}</p>
			</div>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
