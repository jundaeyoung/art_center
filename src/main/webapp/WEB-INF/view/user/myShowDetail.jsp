<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>

<style type="text/css">
.show__img {
	width: 400px;
	height: 500px;
}
</style>

<h1>공연정보</h1>
<img alt="" src="/images/upload/${detailList.get(0).imgRoute}" class="show__img">
<p>공연이름 : ${detailList.get(0).title}</p>
<p>공연정보 : ${detailList.get(0).content}</p>
<p>날짜 : ${detailList.get(0).startDate} ~ ${detailList.get(0).endDate}</p>
<br>
<h1>대관 정보</h1>
<p>시간 : ${detailList.get(0).startTime} ~${detailList.get(0).endTime}</p>
<p>대관 장소 : ${detailList.get(0).location}</p>
<p>대관 장소 : ${detailList.get(0).locationInfo}</p>
<p>대관홀 : ${detailList.get(0).name}</p>
<p>결제상태 : ${detailList.get(0).rentPlaceStatus}</p>
<p>문의사항 : ${detailList.get(0).tel}</p>

<button onclick="location.href='/myPage/myShow/${principal.id}'">목록</button>

<%@ include file="/WEB-INF/view/layout/footer.jsp"%>


