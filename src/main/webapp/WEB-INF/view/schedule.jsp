<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.css">
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/locales-all.js"></script>
<script type="text/javascript"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.min.js"></script>
<link rel="stylesheet" href="/css/schedule.css">
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
	<div class="show-content">
		<div class="show-title">
			<h2>
				<a href="/schedule">전체일정</a>
			</h2>
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
		
		<div class="modal" id="myModal">
		<div class="modal-content">
			<span class="close" id="close" onclick="close()">&times;</span>
			<input type="hidden" class="id" id="id" name="id">
			<h3 class="modal-title" id="title"></h3>
			<span class="startDate" id="startDate"></span> ~ 
			<span class="endDate" id="endDate"></span> 
			<p class="holeName" id="holeName"></p>
			<p class="imgRoute"  id="imgRoute"><img alt="" id="images" width="210", height="280" ></p>
			<button class="btn" onclick = "location.href='#'">자세히보기</button>
		</div>
	</div>
		
		
		
		<div id='calendar'></div>
	</div>

	<script type="text/javascript">
		document.addEventListener('DOMContentLoaded', function() {
			let calendarEl = document.getElementById('calendar');
			let calendar = new FullCalendar.Calendar(calendarEl, {
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
				// editable : true,
				nowIndicator : true, // 현재 시간 마크
				allDay: true,
				locale : 'ko', // 한국어 설정
			 	events: [
			 		<c:forEach items="${lists}" var="list">
			 		 <c:choose>
			         <c:when test="${list.holeName == '1층'}">
			             <c:set var="backgroundColor" value="#FFE3D5" />
			             <c:set var="borderColor" value="#FFE3D5" />
			         </c:when>
			         <c:when test="${list.holeName == '2층'}">
			             <c:set var="backgroundColor" value="#8DC6ED" />
			             <c:set var="borderColor" value="#8DC6ED" />
			         </c:when>
			         <c:when test="${list.holeName == '3층'}">
			             <c:set var="backgroundColor" value="#EAFCD4" />
			             <c:set var="borderColor" value="#EAFCD4" />
			         </c:when>
			         <c:when test="${list.holeName == '전시실A'}">
			             <c:set var="backgroundColor" value="#FFF3D9" />
			             <c:set var="borderColor" value="#FFF3D9" />
			         </c:when>
			         <c:when test="${list.holeName == '전시실b'}">
			             <c:set var="backgroundColor" value="#DAE5FB" />
			             <c:set var="borderColor" value="#DAE5FB" />
			         </c:when>
			         <c:when test="${list.holeName == '전시실c'}">
			             <c:set var="backgroundColor" value="#895DAE" />
			             <c:set var="borderColor" value="#895DAE" />
			         </c:when>
			         <c:when test="${list.holeName == '전시실d'}">
			             <c:set var="backgroundColor" value="#FFA17E" />
			             <c:set var="borderColor" value="#FFA17E" />
			         </c:when>
			         <c:when test="${list.holeName == '인문실'}">
			             <c:set var="backgroundColor" value="#5CE390" />
			             <c:set var="borderColor" value="#5CE390" />
			         </c:when>
			         <c:when test="${list.holeName == '과학실'}">
			             <c:set var="backgroundColor" value="#94F7ED" />
			             <c:set var="borderColor" value="#94F7ED" />
			         </c:when>
			         <c:when test="${list.holeName == '미술실'}">
			             <c:set var="backgroundColor" value="#F4F4FE" />
			             <c:set var="borderColor" value="#F4F4FE" />
			         </c:when>
			         <c:when test="${list.holeName == '어린이'}">
			             <c:set var="backgroundColor" value="#DCF19A" />
			             <c:set var="borderColor" value="#DCF19A" />
			         </c:when>
			         <c:otherwise>
			             <c:set var="backgroundColor" value="" />
			             <c:set var="borderColor" value="" />
			         </c:otherwise>
			     </c:choose>
			     
			     {
			    	 id: '${list.id}',
			         title: '${list.holeName} ${list.title}',
			         start: '${list.startDate}',
			         end: '${list.endDate}',
			         imageurl: '${list.imgRoute}',
			         backgroundColor: '${backgroundColor}',
			         borderColor: '${borderColor}',
			         textColor: 'black'
			         
			     },
		            </c:forEach>
                    
	                <c:forEach items="${categoryLists}" var="categoryList">
	                <c:choose>
			         <c:when test="${categoryList.holeName == '1층'}">
			             <c:set var="backgroundColor" value="#FFE3D5" />
			             <c:set var="borderColor" value="#FFE3D5" />
			         </c:when>
			         <c:when test="${categoryList.holeName == '2층'}">
			             <c:set var="backgroundColor" value="#8DC6ED" />
			             <c:set var="borderColor" value="#8DC6ED" />
			         </c:when>
			         <c:when test="${categoryList.holeName == '3층'}">
			             <c:set var="backgroundColor" value="#EAFCD4" />
			             <c:set var="borderColor" value="#EAFCD4" />
			         </c:when>
			         <c:when test="${categoryList.holeName == '전시실A'}">
			             <c:set var="backgroundColor" value="#FFF3D9" />
			             <c:set var="borderColor" value="#FFF3D9" />
			         </c:when>
			         <c:when test="${categoryList.holeName == '전시실b'}">
			             <c:set var="backgroundColor" value="#DAE5FB" />
			             <c:set var="borderColor" value="#DAE5FB" />
			         </c:when>
			         <c:when test="${categoryList.holeName == '전시실c'}">
			             <c:set var="backgroundColor" value="#895DAE" />
			             <c:set var="borderColor" value="#895DAE" />
			         </c:when>
			         <c:when test="${categoryList.holeName == '전시실d'}">
			             <c:set var="backgroundColor" value="#FFA17E" />
			             <c:set var="borderColor" value="#FFA17E" />
			         </c:when>
			         <c:when test="${categoryList.holeName == '인문실'}">
			             <c:set var="backgroundColor" value="#5CE390" />
			             <c:set var="borderColor" value="#5CE390" />
			         </c:when>
			         <c:when test="${categoryList.holeName == '과학실'}">
			             <c:set var="backgroundColor" value="#94F7ED" />
			             <c:set var="borderColor" value="#94F7ED" />
			         </c:when>
			         <c:when test="${categoryList.holeName == '미술실'}">
			             <c:set var="backgroundColor" value="#F4F4FE" />
			             <c:set var="borderColor" value="#F4F4FE" />
			         </c:when>
			         <c:when test="${categoryList.holeName == '어린이'}">
			             <c:set var="backgroundColor" value="#DCF19A" />
			             <c:set var="borderColor" value="#DCF19A" />
			         </c:when>
			         <c:otherwise>
			             <c:set var="backgroundColor" value="" />
			             <c:set var="borderColor" value="" />
			         </c:otherwise>
			     </c:choose>
			     
			     {
			    	 id: '${categoryList.id}',
			         title: '${categoryList.holeName} ${categoryList.title}',
			         start: '${categoryList.startDate}',
			         end: '${categoryList.endDate}',
			         backgroundColor: '${backgroundColor}',
			         borderColor: '${borderColor}',
			         textColor: 'black'
			     },
		            </c:forEach>
	            ],	
	            eventClick:function(event) {
	            	// 모달 창 열기
	                var modal = document.getElementById('myModal');
	                modal.style.display = 'block';
	                let id = event.event.id;
	                console.log(id);
	                $.ajax({
							url: '/api/scheduleDetail/'+ id,
							type: "GET",
							contentType: 'application/json; charset=utf-8',
							dataType: 'json',
							success: function(event) {
									console.log(event)
									$("#id").val(event.id),
									$("#title").text(event.title);
									$("#startDate.startDate").text(event.startDate);
									$("#endDate.endDate").text(event.endDate);
									$("#holeName.holeName").text(event.holeName);
									$("#images").attr("src", "/images/" + event.imgRoute);	
								}
		                });
	                // 모달 창 닫기 버튼 클릭 핸들러
	                var closeBtn = modal.querySelector('.close');
	                closeBtn.addEventListener('click', function() {
	                  // 모달 창 닫기
	                  modal.style.display = 'none';
	                });
	            },
				eventDataTransform: function(eventData) {
				  if (eventData.end) {
				    eventData.end = moment(eventData.end).subtract(-1, 'day').format('YYYY-MM-DD');
				  }
				  return eventData;
				}
			});
			calendar.render();
		});
		
		// 상단 메뉴바 드롭다운
		$(document).ready(function() {
			$(".main>li").mouseover(function() {
				$(this).children(".sub").stop().slideDown(200);
			});
			$(".main>li").mouseleave(function() {
				$(this).children(".sub").stop().slideUp(200);
			});
		});
</script>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
