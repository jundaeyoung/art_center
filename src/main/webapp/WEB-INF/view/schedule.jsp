<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href='/resources/fullcalendar-5.6.0/lib/main.css' rel='stylesheet' />
<script src='/resources/fullcalendar-5.6.0/lib/main.js'></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.css">
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/locales-all.js"></script>
<script type="text/javascript"></script>
<style>
body {
	width: 100%;
}

.show-content {
	max-width: 1280px;
	margin: 0 auto;
}

.show-title {
	position: relative;
	font-size: 30px;
	line-height: 35px;
	padding: 5px 0 20px 20px;
	margin-bottom: 30px;
	border-bottom: 1px solid black;
}

.show-title a {
	text-decoration: none;
	color: black;
}

.show-type {
	border-spacing: 0;
}

.category-list-table {
	display: flex;
	justify-content: center;
	margin: 10px 0 10px 0;
	width: 100%;
}

.category-list:nth-of-type(1) {
	border: 1px solid #ebebeb;
	width: 400px;
	height: 60px;
	text-align: center;
}

.category-list:nth-of-type(2) {
	border-top: 1px solid #ebebeb;
	border-bottom: 1px solid #ebebeb;
	width: 400px;
	height: 60px;
	text-align: center;
}

.category-list:nth-of-type(3) {
	border: 1px solid #ebebeb;
	width: 400px;
	height: 60px;
	text-align: center;
}

.show-type-btn {
	border: 0;
	outline: 0;
	background: none;
	font-size: 16px;
	color: gray;
}

.show-type-btn:hover {
	color: black;
	font-weight: bold;
}

#calendar {
	margin-top: 100px;
}
</style>
</head>
<body>
	<div class="show-content">
		<div class="show-title">
			<h2><a href="/schedule">전체일정</a></h2>
		</div>
		<div class="category-list-table">
			<table class="show-type">
				<tr>
					<td class="category-list">
						<button type="submit" class="show-type-btn" name="category"
							value="오페라하우스" onclick="location.href='/schedule/category/1'">오페라하우스</button>
					</td>
					<td class="category-list">
						<button type="submit" class="show-type-btn" name="category"
							value="디자인미술관" onclick="location.href='/schedule/category/2'">디자인미술관</button>
					</td>
					<td class="category-list">
						<button type="submit" class="show-type-btn" name="category"
							value="아카데미" onclick="location.href='/schedule/category/3'">아카데미</button>
					</td>
				</tr>
			</table>
		</div>
		<div id='calendar'></div>
	</div>
	<script type="text/javascript">
		document.addEventListener('DOMContentLoaded', function() {
			var calendarEl = document.getElementById('calendar');
			var calendar = new FullCalendar.Calendar(calendarEl, {
				initialView : 'dayGridMonth', // 초기 로드 될때 보이는 캘린더 화면(기본 설정: 달)
				headerToolbar : { // 헤더에 표시할 툴 바
					start : 'prev next today',
					center : 'title',
					end : 'dayGridMonth,dayGridWeek,dayGridDay'
				},
				titleFormat : function(date) {
					return date.date.year + '년 '
							+ (parseInt(date.date.month) + 1) + '월';
				},
				//initialDate: '2021-07-15', // 초기 날짜 설정 (설정하지 않으면 오늘 날짜가 보인다.)
				selectable : true, // 달력 일자 드래그 설정가능
				droppable : true,
				//editable : true,
				nowIndicator : true, // 현재 시간 마크
				locale : 'ko', // 한국어 설정
			 	events: [
			 		<c:forEach items="${lists}" var="list">
		                {
		                  title: '${list.holeName} '+'${list.title}',
		                  start: '${list.startDate}',
		                  backgroundColor: '#8DC6ED',
		                  borderColor: '#8DC6ED'
		                 },
		            </c:forEach>
                    
	                <c:forEach items="${categoryLists}" var="categoryList">
		                {
		                  title: '${categoryList.holeName} '+'${categoryList.title}',
		                  start: '${categoryList.startDate}',
		                  backgroundColor: '#8DC6ED',
		                  borderColor: '#8DC6ED',
		                 },
		            </c:forEach>
	            ],
			});
			calendar.render();
		});
	</script>
</body>
</html>