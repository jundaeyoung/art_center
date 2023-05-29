<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>

<div class="dd" style="height: 100%">  
<div class="content--box">
	<div class="content">
		<ul class="slider">
			<c:forEach var="showList" items="${showsList}">
				<li>
					<div class="content--info">
						<dl class="right">
							<div class="info">
								<p style="margin-top: 180px; margin-left: -30px; background-color: #fff; border: 1px solid #fff; border-radius: 20px; font-size: 20px; font-weight: 400; padding: 0 10px 0 10px;">${showList.showType}</p>
								<h2 style="margin-top: -20px; margin-left: -80px; font-size: 35px; font-weight: 200;">🔔️ ${showList.location}</h2>
								<h1 style="margin-top: 30px; margin-left: -80px; font-size: 57px; font-weight: 200; height: 60px;">${showList.title}</h1>
								<c:choose>
									<c:when test="${showList.rating==null}">
										<h3 style="margin-top: 30px; margin-left: -80px; font-size: 27px; font-weight: 100; height: 60px;">평점이 아직 등록되지 않았습니다.</h3>
									</c:when>
									<c:otherwise>
										<h3 style="margin-top: 30px; margin-left: -50px; font-size: 27px; font-weight: 100; height: 60px;">평점 : ${showList.rating}</h3>
									</c:otherwise>
								</c:choose>
								<h4 style="margin-top: -20px; margin-left: -80px; font-size: 25px; font-weight: 100;">기간 : ${showList.startDate}&nbsp&nbsp&nbsp~&nbsp&nbsp&nbsp${showList.endDate}</h4>
							</div>
							<c:choose>
								<c:when test="${showList.imgRoute.length()>=30}">
									<div>
										<a href="/show/showView/${showList.id}"><img src="/images/upload/${showList.imgRoute}" width="480" height="600"></a>
									</div>
								</c:when>
								<c:otherwise>
									<div>
										<a href="/show/showView/${showList.id}"><img src="/images/${showList.imgRoute}" width="480" height="600"></a>
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
								<li><a href="/show/showView/${showList.id}"><img src="/images/upload/${showList.imgRoute}" width="150" height="200"></a></li>
							</c:when>
							<c:otherwise>
								<li><a href="/show/showView/${showList.id}"><img src="/images/${showList.imgRoute}" width="150" height="200"></a></li>
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
							<div><h2>알림</h2></div>
							<div class="close-area" style="color: black">X</div>
						</div>
						<c:forEach var="noticeList" items="${noticeList}">
							<div class="content" style="display: flex; justify-content: space-between;">
								<div class="msg">${noticeList.notice}</div>
								<form action="/managerNotice/update/${noticeList.id}" method="get">
									<div class="close-area">
										<button type="submit" class="close-area" style="border-radius: 10px; background-color: #A7A7B0;">확인</button>
									</div>
								</form>
							</div>

						</c:forEach>
					</div>
				</div>
			</c:when>
		</c:choose>
	</div>
</div>

<script type="text/javascript" src="/js/main.js">
	
</script>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>

