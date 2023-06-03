<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>


<style>
.main div div {
	display: flex;
	align-items: center;
}
</style>

<div class="main">

	<div>

		<h1>예매 취소</h1>
		<div>
			<h3>취소 내역 :</h3>
			<p>${kakaoRefundResponse.itemName}</p>
		</div>
		<div>
			<h3>취소 일시 :</h3>
			<p>${kakaoRefundResponse.canceledAt}</p>
		</div>
		<div>
			<h3>취소 금액 :</h3>
			<p>${kakaoRefundResponse.canceledAmount.total}</p>

		</div>
		<div>
			<h3>결제 수단 :</h3>
			<p>${kakaoRefundResponse.paymentMethodType}</p>
		</div>
	</div>


</div>








<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
