<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="/css/success.css">


<div class="main">
   <div class="payment-content">
      <div class="payment-success">
         <div class="payment-info">
            <h2>결제가 성공적으로 완료되었습니다.</h2>
         </div>
         <div class="order-number">
            <p>주문 번호 : ${kakaoApprove.partnerOrderId}</p>
         </div>
         <div class="btn-class">
            <a href="/myPage/info" class="myPage-btn">마이페이지</a> <a
               href="/quest/search?searchText=&currentPage=1&begin=0&range=5" class="myPage-btn">QnA</a>
         </div>
      </div>

      <div class="payment-order">
         <div class="order">
            <h2>주문 정보</h2>
         </div>
         <div class="payment-date">
            <p>결제 일시 : ${kakaoApprove.createdAt}</p>
         </div>

         <div class="product">
            <p>상품명 : ${kakaoApprove.itemName}</p>
         </div>

         <div class="payment">
            <p>결제 금액 : ${kakaoApprove.amount.total}</p>
         </div>

         <div class="payment-method">
            <p>결제 방법 : ${kakaoApprove.paymentMethodType}</p>
         </div>

      </div>
   </div>
</div>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%></html>

