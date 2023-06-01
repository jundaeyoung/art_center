<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.css">
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/locales-all.js"></script>
<script type="text/javascript"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.min.js"></script>
<link rel="stylesheet" href="/css/manager/managerSchedule.css">
<script src="https://www.gstatic.com/charts/loader.js"></script>
<script
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=YOUR_APP_KEY&libraries=services"></script>

<div class="dd" style="height: 100%">
	<c:choose>
		<c:when test="${principal==null || principal.roleId==1}">
			<div class="content--box">
				<div class="content">
					<ul class="slider">
						<c:forEach var="showList" items="${showsList}">
							<li>
								<div class="content--info">
									<dl class="right">
										<div class="info">
											<p
												style="margin-top: 180px; margin-left: -330px; background-color: #fff; border: 1px solid #fff; border-radius: 20px; font-size: 20px; font-weight: 400; padding: 0 10px 0 10px;">${showList.showType}</p>
											<h2
												style="margin-top: -20px; margin-left: -330px; font-size: 35px; font-weight: 200;">🔔️
												${showList.location}</h2>
											<h1
												style="margin-top: 30px; margin-left: -330px; font-size: 57px; font-weight: 200; height: 60px;">${showList.title}</h1>
											<c:choose>
												<c:when test="${showList.rating==null}">
													<h3
														style="margin-top: 30px; margin-left: -330px; font-size: 27px; font-weight: 100; height: 60px;">평점이
														아직 등록되지 않았습니다.</h3>
												</c:when>
												<c:otherwise>
													<h3
														style="margin-top: 30px; margin-left: -150px; font-size: 27px; font-weight: 100; height: 60px;">평점
														: ${showList.rating}</h3>
												</c:otherwise>
											</c:choose>
											<h4
												style="margin-top: -20px; margin-left: -330px; font-size: 25px; font-weight: 100;">기간
												:
												${showList.startDate}&nbsp&nbsp&nbsp~&nbsp&nbsp&nbsp${showList.endDate}</h4>
										</div>
										<c:choose>
											<c:when test="${showList.imgRoute.length()>=30}">
												<div>
													<a href="/show/showView/${showList.id}"><img
														src="/images/upload/${showList.imgRoute}" width="480"
														height="600"></a>
												</div>
											</c:when>
											<c:otherwise>
												<div>
													<a href="/show/showView/${showList.id}"><img
														src="/images/${showList.imgRoute}" width="480"
														height="600"></a>
												</div>
											</c:otherwise>
										</c:choose>
									</dl>
								</div>
							</li>
						</c:forEach>
					</ul>
					<div class="slide_wrapper_box">
						<div class="slide_wrapper">
							<ul class="slides">
								<c:forEach var="showList" items="${showsList}">
									<c:choose>
										<c:when test="${showList.imgRoute.length()>=30}">
											<li><a href="/show/showView/${showList.id}"><img
													src="/images/upload/${showList.imgRoute}" width="150"
													height="200"></a></li>
										</c:when>
										<c:otherwise>
											<li><a href="/show/showView/${showList.id}"><img
													src="/images/${showList.imgRoute}" width="150" height="200"></a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</ul>
						</div>
						<div class="btn">
							<button type="button" id="prev" class="button"><</button>
							<button type="button" id="next" class="button">></button>
						</div>
					</div>
				</div>
				<c:choose>
					<c:when test="${principal.roleId==2 && message!=0}">
						<div id="modal" class="modal-overlay">
							<div class="modal-window">
								<div class="title">
									<div>
										<h2>알림</h2>
									</div>
									<div class="close-area" style="color: black">X</div>
								</div>
								<c:forEach var="noticeList" items="${noticeList}">
									<div class="content"
										style="display: flex; justify-content: space-between;">
										<div class="msg">${noticeList.notice}</div>
										<form action="/managerNotice/update/${noticeList.id}"
											method="get">
											<div class="close-area">
												<button type="submit" class="close-area"
													style="border: 1px solid gray; border-radius: 10px; background-color: #eee;">확인</button>
											</div>
										</form>
									</div>

								</c:forEach>
							</div>
						</div>
					</c:when>
				</c:choose>
			</div>
		</c:when>
		<c:otherwise>
		</c:otherwise>
	</c:choose>

	<c:choose>
		<c:when test="${pricipal!=null || principal.roleId==2}">
			<div class="show-content">
				<div class="modal" id="myModal">
					<div class="modal-content">
						<span class="close" id="close" onclick="close()">&times;</span> <input
							type="hidden" class="showId" id="showId" name="showId">
						<h3 class="modal-title" id="title"></h3>
						<span class="showDate" id="showDate"></span> <span
							class="showTime" id="showTime"></span>
						<p class="holeName" id="holeName"></p>
						<p class="imgRoute" id="imgRoute">
							<img alt="" id="images" width="210" , height="280">
						</p>
						<button class="showView" id="showView" onclick="showView()"
							style="text-align: center;">자세히보기</button>
					</div>
				</div>

				<div id='calendar-container'
					style="display: flex; width: 1500px; justify-content: space-between; align-items: center; margin-left: -100px;">
					<div id='calendar' style="width: 800px; height: 500px;"></div>
					<div id="columnchart_material"
						style="width: 700px; height: 600px; margin-left: 50px; margin-top: 150px;"></div>
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<div class="show-content">
				<div class="modal" id="myModal">
					<div class="modal-content" style="margin: 0;">
						<span class="close" id="close" onclick="close()">&times;</span> <input
							type="hidden" class="showId" id="showId" name="showId">
						<h3 class="modal-title" id="title"></h3>
						<span class="showDate" id="showDate"></span> <span
							class="showTime" id="showTime"></span>
						<p class="holeName" id="holeName"></p>
						<p class="imgRoute" id="imgRoute">
							<img alt="" id="images" width="210" , height="280">
						</p>
						<button class="showView" id="showView" onclick="showView()"
							style="text-align: center;">자세히보기</button>
					</div>
				</div>

				<div id='user-calendar-container'>
					<div id='userCalendar' style="width: 700px; height: 600px;"></div>
					<div class="main-map">
						<h2>찾아오는 길</h2>
						<div id='map'
							style="width: 700px; height: 520px; margin-right: 30px;"></div>
					</div>
				</div>
			</div>
		</c:otherwise>
	</c:choose>




	<div class="main__notice">
		<div class="main_notice_title">
			<span>Notice</span>
		</div>
		<div class="notice__title">
			<h1>공지사항</h1>
			<h1>
				<a href="/announcement">더보기 +</a>
			</h1>
		</div>
		<div class="no_content">
			<a href="/announcement"> <c:forEach var="selectAnnouncement"
					items="${selectAnnouncement}">
					<div class="notice__content">
						<ul style="padding: 0 20px;">
							<li class="item"><span style="font-size: 30px;">${selectAnnouncement.title}</span>
							</li>
						</ul>
					</div>
				</c:forEach>
			</a>
		</div>
	</div>
</div>



<script type="text/javascript" src="/js/main.js"></script>
<c:choose>
	<c:when test="${pricipal!=null || principal.roleId==2}">
		<script type="text/javascript">
$(document).ready(function() {
    $.ajax({
        type: 'get',
        url: '/apiShowSale/manager/showSale',
          contentType: 'application/json; charset=utf-8',
   }).done(function(response) {
      google.charts.load('current', {'packages':['bar']});
       google.charts.setOnLoadCallback(drawChart);

       function drawChart() {
         var data = google.visualization.arrayToDataTable([
           ['title', '성인 ', '청소년 수','총 수'],
           [response[0].title, response[0].adultCount, response[0].youthCount,response[0].adultCount+response[0].youthCount],
         ]);
           for(var i=1; i<response.length;i++){
            data.addRows([
              [response[i].title, response[i].adultCount, response[i].youthCount,response[i].adultCount+response[i].youthCount],
             ]);
           }

         var options = {
           chart: {
             title: '공연별 방문자 현황',
           },
            bar : {
              groupWidth : '300%' // 예제에서 이 값을 수정
           },
           fontSize: 30   ,
           
         };

         var chart = new google.charts.Bar(document.getElementById('columnchart_material'));

         chart.draw(data, google.charts.Bar.convertOptions(options));
             
             
       /* var data = new google.visualization.arrayToDataTable([
       data.addColumn('string', '요일');
       data.addColumn('number', '방문자수(명)');
       for(var i=0; i<response.length;i++){
          data.addRows([
          [ response[i].title, response[i].adultCount ],
          [ response[i].title, response[i].youthCount ],
          ]);
       }
       var options = {
          title : '공연별 방문자 현황',
          hAxis : {
             title : '요일',
             viewWindow : {
                min : [ 7, 30, 0 ],
                max : [ 17, 30, 0 ]
             }
          },
          vAxis : {
             title : '방문자수(명)'
          }
          isStacked: true,
       }; */
       var chart = new google.visualization.ColumnChart(
       document.getElementById('chart_div'));
       chart.draw(data, options);

    }
   });
 });

      document.addEventListener('DOMContentLoaded', function() {
         let calendarEl = document.getElementById('calendar');
         let calendar = new FullCalendar.Calendar(calendarEl, {
             locale : 'ko',    
             timezone : "local", 
             slotMinTime: '08:00', // Day 캘린더에서 시작 시간
              slotMaxTime: '25:00', // Day 캘린더에서 종료 시간
            initialView : 'timeGridWeek', // 초기 로드 될때 보이는 캘린더 화면(기본 설정: 달)
            headerToolbar : { // 헤더에 표시할 툴 바
               start : 'prev next today',
               center : 'title',
               end : 'dayGridMonth,timeGridWeek,timeGridDay'
            },
            
            titleFormat : function(date) {
               return date.date.year + '년 '
                     + (parseInt(date.date.month) + 1) + '월';
            },
/*             initialDate: '2023-05-04', // 초기 날짜 설정 (설정하지 않으면 오늘 날짜가 보인다.) 나중엔 해제해야함
 */            navLinks: true,
            selectable : true, // 달력 일자 드래그 설정가능
            droppable : true,
            // editable : true,
            nowIndicator : true, // 현재 시간 마크
            allDay: true,
            locale : 'ko', // 한국어 설정
             events: [
                <c:forEach items="${lists}" var="list">
                 <c:choose>
                 <c:when test="${list.holeName == '1관'}">
                      <c:set var="backgroundColor" value="#FFE3D5" />
                        <c:set var="borderColor" value="#FFE3D5" />
                  </c:when>
                  <c:when test="${list.holeName == '2관'}">
                      <c:set var="backgroundColor" value="#8DC6ED" />
                      <c:set var="borderColor" value="#8DC6ED" />
                  </c:when>
                  <c:when test="${list.holeName == '3관'}">
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
                  start: '${list.startDate}T${list.startTime}',
                  imageurl: '${list.imgRoute}',
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
                   $.ajax({
                     url: '/api/scheduleDetail/'+ id,
                     type: "GET",
                     contentType: 'application/json; charset=utf-8',
                     dataType: 'json',
                     success: function(event) {
                           $("#id").val(event.id),
                           $("#title").text(event.title);
                           $("#showDate").text(event.startDate);
                           $("#showTime").text(event.showTime);
                           $("#holeName").text(event.holeName);
                           $("#images").attr("src", "/images/upload/" + event.imgRoute);   
                        }
                      });
                   // 모달 창 닫기 버튼 클릭 핸들러
                   var closeBtn = modal.querySelector('.close');
                   closeBtn.addEventListener('click', function() {
                     // 모달 창 닫기
                     modal.style.display = 'none';
                   });
                   let showViewBtn = modal.querySelector('.showView');
                  showViewBtn.addEventListener('click',function(){
                     location.href="/show/showView/" + id;
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
</script>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
	document.addEventListener('DOMContentLoaded', function() {
			let calendarEl = document.getElementById('userCalendar');
			let calendar = new FullCalendar.Calendar(calendarEl, {
				initialView : 'dayGridMonth', // 초기 로드 될때 보이는 캘린더 화면(기본 설정: 달)
				headerToolbar : { // 헤더에 표시할 툴 바
					start : 'prev next today',
					center : 'title',
					end : 'dayGridMonth'
				},
				titleFormat : function(date) {
					return date.date.year + '년 '
							+ (parseInt(date.date.month) + 1) + '월';
				},
				selectable : true, // 달력 일자 드래그 설정가능
				droppable : true,
				nowIndicator : true, // 현재 시간 마크
				allDay: true,
				locale : 'ko', // 한국어 설정
			 	events: [
			 		<c:forEach items="${lists}" var="list">
			 		 <c:choose>
			         <c:when test="${list.holeName == '1관'}">
			             <c:set var="backgroundColor" value="#FFE3D5" />
			             <c:set var="borderColor" value="#FFE3D5" />
			         </c:when>
			         <c:when test="${list.holeName == '2관'}">
			             <c:set var="backgroundColor" value="#8DC6ED" />
			             <c:set var="borderColor" value="#8DC6ED" />
			         </c:when>
			         <c:when test="${list.holeName == '3관'}">
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
	                $.ajax({
							url: '/api/scheduleDetail/'+ id,
							type: "GET",
							contentType: 'application/json; charset=utf-8',
							dataType: 'json',
							success: function(event) {
									$("#id").val(event.id),
									$("#title").text(event.title);
									$("#startDate.startDate").text(event.startDate);
									$("#endDate.endDate").text(event.endDate);
									$("#holeName.holeName").text(event.holeName);
									$("#images").attr("src", "/images/upload/" + event.imgRoute);	
								}
		                });
	                // 모달 창 닫기 버튼 클릭 핸들러
	                let closeBtn = modal.querySelector('.close');
	                closeBtn.addEventListener('click', function() {
	                  // 모달 창 닫기
	                  modal.style.display = 'none';
	                });
					let showViewBtn = modal.querySelector('.showView');
		            showViewBtn.addEventListener('click',function(){
							location.href="/show/showView/" + id;
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
			
			let container = document.getElementById('map');
			let options = {
				center : new kakao.maps.LatLng(35.159573, 129.060249),
				level : 1
			};
				
			let map = new kakao.maps.Map(container, options);

			
		});

			
		</script>
		<script type="text/javascript"
			src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=4a629c7c8013b10fbb2593c6f394603a"></script>
	</c:otherwise>
</c:choose>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
