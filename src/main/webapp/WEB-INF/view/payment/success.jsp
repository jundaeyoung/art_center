<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>

<div class="main">

	<div class="">

		<h1>결제성공</h1>
		
		<h3>결제 일시 : </h3><p>${kakaoApprove.createdAt}</p>
		<h3>주문 번호 :</h3><p>${kakaoApprove.partnerOrderId}</p>
		<h3>상품명 :</h3><p>${kakaoApprove.itemName}</p>
		<h3>결제 금액 :</h3><p>${kakaoApprove.amount.total}</p>
		<h3>결제 방법 :</h3><p>${kakaoApprove.paymentMethodType}</p>
	</div>




</div>




<%@ include file="/WEB-INF/view/layout/footer.jsp"%></html>