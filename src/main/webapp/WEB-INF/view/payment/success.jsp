<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>

<style>
.body {
   width: 1400px;
}

.payment-content {
   display: flex;
   flex-direction: column;
   justify-content: center;
   align-items: center;
   width: 100%;
}

.payment-success {
   display: flex;
   flex-direction: column;
   justify-content: center;
   align-items: center;
   border-bottom: 1px solid #ccc;
   width: 1300px;
}

.payment-info {
   border-top: 3px solid #6F77A7;
   text-align: center;
   width: 1300px;
}

.order-number {
   display: flex;
   justify-content: center;
   color: gray;
   text-align: center;
}

.payment-info h1 {
   text-align: center;
}

.order-number {
   text-align: center;
}

.main {
   display: flex;
   justify-content: center;
}

.content div h3 {
   width: 150px;
}

.myPage-btn {
   display: flex;
   text-decoration: none;
   justify-content: center;
   color: black;
   border: 1px solid #C2CDFF;
   width: 200px;
   height: 40px;
   border-radius: 5px;
   text-align: center;
   align-items: center;
   font-size: 17px;
   margin-bottom: 30px;
   margin-right: 20px;
}

.payment-order {
   width: 1300px;
}

.payment-date {
   border-top: 2px solid black;
}

.product, .payment {
   border-top: 1px solid #ccc;
}

.payment-method {
   border-top: 1px solid #ccc;
   border-bottom: 1px solid #ccc;
}

.btn-class {
   display: flex;
}
</style>


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

