<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<style>

#btn{
  border: 0;
  background-color: transparent;
  font-size: 16px;
}

.rental__img {
   display: flex;
   justify-content: center;
   padding: 300px;
   margin-top: 100px;
   background-image: url('/images/myPage.png');
   background-position: bottom;
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

.my_show_content {
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
   height: 230px;
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
   border: 1px solid #eee;
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

.show__schedule__btn {
   display: flex;
   border: 1px solid #568607;
   width: 180px;
   height: 30px;
   align-items: center;
   justify-content: center;
   border-radius: 10px;
   margin-top: 40px;
   margin-right: 20px;
}

.show__schedule {
   display: flex;
   border: 1px solid #568607;
   width: 280px;
   height: 30px;
   align-items: center;
   justify-content: center;
   border-radius: 10px;
   margin-top: 40px;
   margin-right: 20px;
}

.show__btn {
   display: flex;
   margin-top: 10px;
}

.kakao__img {
   width: 50px;
   height: 20px;
}

.btn__a {
   display: flex;
   justify-content: center;
   align-items: center;
}

.show__info__list {
   margin-top: 40px;
}
</style>
<div class="rental__img"></div>
<div class="container">
   <div class="info">
      <c:choose>
      <c:when test="${principal.getRoleId()==1}">
      <div class="user_reservation_list">
         <table class="user__type">
            <tr>
               <td class="user__ticket">
                  <button type="submit" class="user-type-btn" name="info__category" onclick="location.href='/myPage/myTicket/${principal.id}'">티켓예매내역</button>
               </td>
               <td class="user__ticket">
                  <button type="submit" class="user-type-btn" name="info__category" onclick="location.href='/myPage/myTicketReview'">관람평</button>
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
                   <button type="submit" class="user-type-btn" name="info__category" onclick="location.href='/myPage/myShow/${principal.id}?currentPage=1&begin=0&range=5'">공연 대관 내역</button>
               </td>
               <td class="user__ticket">
                  <button type="submit" class="user-type-btn" name="info__category" onclick="location.href='/myPage/rentRefund'">환불내역</button>
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

<div class="my_show_content">
   <div class="dd">
      <c:forEach var="myrentList" items="${myrentList}">
         <div class="myShow">
            <div class="show__info__list">
               <div>
                  <a href="/myPage/showDetail/${myrentList.id}"><img alt="" src="/images/upload/${myrentList.imgRoute}" class="show__img"></a>
               </div>

               <div>
                  <div class="show__date">
                     <p>${myrentList.startDate}&nbsp;~&nbsp;${myrentList.endDate}</p>
                  </div>
                  <div class="show__info__ta">
                     <h2>
                        <a href="/myPage/showDetail/${myrentList.id}">${myrentList.title}</a>
                     </h2>
                     <div class="show__age">
                        <p>${myrentList.admissionAge}</p>
                     </div>
                  </div>
                        <div class="show__btn">
                           <div class="show__schedule__btn">
                              <a href="/manager/schedule/${principal.id}">공연일정&nbsp;(달력)</a>
                           </div>
                           <div class="show__schedule__btn">
                              <a href="/myPage/showDetail/${myrentList.id}">예약 정보</a>
                           </div>
                           <div class="show__schedule__btn">
                              <div>
                                 <button type="submit" class="btn__a" id="btn">
                                    <img alt="" src="/images/kakao/payment_icon_yellow_medium.png" class="kakao__img"> &nbsp;&nbsp;환불완료
                                 </button>
                              </div>
                           </div>


                        </div>

               </div>
            </div>
         </div>
      </c:forEach>
   </div>
</div>


<%@ include file="/WEB-INF/view/layout/footer.jsp"%>