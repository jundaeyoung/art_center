<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>


<div class="content--box">
	<div class="content">
		<ul class="slider">
			<c:forEach var="showList" items="${showsList}">
				<li>
					<div class="content--info">
						<dl class="right">
							<div class="info">
								<h4
									style="margin-top: 155px; margin-left: -50px; background-color: #fff; font-size: 30px; font-weight: 400; padding: 0 10px 0 10px;">${showList.showType}</h4>
								<h3
									style="margin-top: -10px; margin-left: -70px; font-size: 30px; font-weight: 200;">🔔️
									${showList.location}</h3>
								<h1
									style="margin-top: 30px; margin-left: -120px; font-size: 57px; font-weight: 200; height: 60px;">${showList.title}</h1>
								<h4
									style="margin-top: 60px; margin-left: -70px; font-size: 25px; font-weight: 100;">${showList.startDate}&nbsp&nbsp&nbsp~&nbsp&nbsp&nbsp${showList.endDate}</h4>
							</div>
							<div>
								<a href="#"><img src="images/${showList.imgRoute}"
									width="480" height="600"></a>
							</div>
						</dl>
					</div>
				</li>
			</c:forEach>
		</ul>
		<div class="slide_wrapper_box">
			<div class="slide_wrapper">
				<ul class="slides">
					<c:forEach var="showList" items="${showsList}">
						<li><img src="images/${showList.imgRoute}" width="150"
							height="200"></li>
					</c:forEach>
				</ul>
			</div>
			<div class="btn">
				<button type="button" id="prev" class="button"><</button>
				<button type="button" id="next" class="button">></button>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="/js/main.js"></script>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>

