<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="/css/refund.css">

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

