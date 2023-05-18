<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
<style>
.rental__img {
	display: flex;
	justify-content: center;
	padding: 300px;
	margin-top: 100px;
	background-image: url('/images/rental/rental.png');
	background-position: bottom;
}

.rental__title {
	display: flex;
	justify-content: center;
	margin-bottom: 50px;
}

.rental__title h1 {
	text-align: center;
	margin-right: 200px;
	width: 280px;
	border-bottom: 3px solid black;
}

.rental__info {
	border-bottom: 3px solid #ccc;
}

.content {
	width: 100%;
	height: 800px;
	margin-top: 100px;
}

.rental__info_content {
	margin-top: 50px;
	height: 500px;
}

.daterangepicker .drp-calendar.right .calendar-table {
	margin-left: 30px !important;
}
/* Month 글자 크기 */
.month {
	font-size: 20px !important;
}

.table-condensed td {
	font-size: 17px !important;
}

.rental__btn {
	display: flex;
	justify-content: center;
	align-items: flex-end; 
	margin: 10px;
	padding: 10px;
}

.ok {
	margin-left: 0;
	border: none;
	width: 200px;
	height: 40px;
	background-color: #DBE4EB;
	cursor: pointer;
	margin: 0 10px;
}

.back {
	margin-left: 0;
	border: none;
	width: 200px;
	height: 40px;
	background-color: #FFA883;
	cursor: pointer;
}
</style>
<div class="rental__img"></div>

<div class="content">
	<div class="rental__title">
		<h1>${location}대관</h1>
	</div>
	<div class="rental__info">
		<h1>신청 정보</h1>
	</div>
	<form action="/rental/reservation" method="post">
	<div class="rental__info_content">
	<div class="location">
	<label>대관 장소 : ${location}</label></div>
	<label>대관 신청 기간 : </label>
	<input type="text" id="dateTime" name="dateTime" value="" style="width: 160px;" onchange="calculatePrice()"/>
	<div>
	<label>대관 홀 : </label>
	<select id="locationSelect" onchange="calculatePrice()">
		<c:forEach var="locationLists" items="${locationLists}">
			<option value="${locationLists.id}" data-price="${locationLists.price}">${locationLists.name}</option>
		</c:forEach>
	</select>
	</div>
	<div>
	<p id="totalPrice"></p>
	<label>대관 시간 : </label>
	<select>
		<c:forEach var="timeList" items="${timeList}">
			<option value="${timeLists.id}">${timeList.startTime} ~ ${timeList.endTime}</option>
		</c:forEach>
	</select>
	</div>
	<div class="rental__btn">
		<input type="submit" class="ok" value="신청하기">
	</div>
	</div>
	</form>
		<button class="back" onclick="location.href='/rental'">취소하기</button>
	<script type="text/javascript">
	$(function() {
		$('#dateTime').daterangepicker(
				{
					"locale" : {
						"format" : "YYYY-MM-DD",
						"separator" : " ~ ",
						"applyLabel" : "확인",
						"cancelLabel" : "취소",
						"fromLabel" : "From",
						"toLabel" : "To",
						"customRangeLabel" : "Custom",
						"weekLabel" : "W",
						"daysOfWeek" : [ "월", "화", "수", "목", "금", "토", "일" ],
						"monthNames" : [ "1월", "2월", "3월", "4월", "5월", "6월",
								"7월", "8월", "9월", "10월", "11월", "12월" ],
						"firstDay" : 0
					},
					"drops" : "down"
				},
				function(start, end, label) {
					console.log('New date range selected: '
							+ start.format('YYYY-MM-DD') + ' to '
							+ end.format('YYYY-MM-DD') + ' (predefined range: '
							+ label + ')');
				});
	});
    function calculatePrice() {
        var dateTime = document.getElementById("dateTime").value;
        let test = dateTime;
        test = test.split(" ~ "); 

        var re1 = test[0]
        	re1 = re1.replaceAll("-", ""); 
        var re2 = test[1]
        	re2 = re2.replaceAll("-", ""); 

        	let result = parseFloat(re2)-parseFloat(re1) + 1
        	console.log(result);
        var locationSelect = document.getElementById("locationSelect");
        var selectedOption = locationSelect.options[locationSelect.selectedIndex];

        var price = selectedOption.getAttribute("data-price");
        var totalPrice;

        if (price === price) {
            totalPrice =  result * parseInt(price);
        } else {
            totalPrice = parseInt(price); 
        }
        var totalPriceElement = document.getElementById("totalPrice");
        totalPriceElement.innerText = "대관료: " + totalPrice + "원";
    }
	
	</script>

</div>
<script type="text/javascript" src="/js/manager/rental.js"></script>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>