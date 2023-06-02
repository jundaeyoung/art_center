<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="/css/success.css">

<style>

</style>



<div class="main">

	<div class="content">
		<h1>결제성공</h1>
		<div>
			<h3>결제 일시 : </h3>
			<p>${kakaoApprove.createdAt}</p>
		</div>
		<div>
			<h3>주문 번호 : </h3>
			<p>${kakaoApprove.partnerOrderId}</p>
		</div>
		<div>
			<h3>상품명 : </h3>
			<p>${kakaoApprove.itemName}</p>
		</div>
		<div>
			<h3>결제 금액 : </h3>
			<p>${kakaoApprove.amount.total}</p>
		</div>
		<div>
			<h3>결제 방법 : </h3>
			<p>${kakaoApprove.paymentMethodType}</p>
		</div>


	</div>
</div>

<%@ include file="/WEB-INF/view/layout/footer.jsp"%></html>

