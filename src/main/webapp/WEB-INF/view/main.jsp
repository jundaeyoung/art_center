<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.Arrays"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>

<nav>
	<div id="nav">
		<ul class="main">
			<li><a href="#">공연</a>
				<ul class="sub">
					<li><a href="#">전체일정(달력) </a></li>
					<li><a href="#">오늘의 공연·전시 </a></li>
					<li><a href="#">예매·취소안내 </a></li>
				</ul></li>
			<li><a href="#">공간·대관 </a>
				<ul class="sub">
					<li><a href="#">공간소개 </a></li>
					<li><a href="#">공간별 대관안내 </a></li>
					<li><a href="#">입장권 운영안내 </a></li>
				</ul></li>
			<li><a href="#">아카데미 </a>
				<ul class="sub">
					<li><a href="#">아카데미 안내 </a></li>
					<li><a href="#">수강신청 </a></li>
					<li><a href="#">아카데미 공지사항 </a></li>
					<li><a href="#">아카데미 FAQ</a></li>
					<li><a href="#">오디션 신청</a></li>
				</ul></li>
			<li><a href="#">소식·이용·참여</a>
				<ul class="sub">
					<li><a href="#">전당 소식</a></li>
					<li><a href="#">오시는길·주차안내</a></li>
					<li><a href="#">편의 서비스</a></li>
					<li><a href="#">고객센터</a></li>
					<li><a href="/review/home">관람평</a></li>
				</ul></li>
			<li><a href="#"> 회원 서비스 </a>
				<ul class="sub">
					<c:choose>
					<c:when test="${principal == null}">
					<li><a href="/user/signUp"> 회원가입 </a></li>
					<li><a href="/user/login">로그인 </a></li>
					<li><a>아이디 찾기</a></li>
					<li><a>비밀번호 찾기</a></li>
					</c:when>
					<c:otherwise>
					<li><a href="/user/update?userName=${principal.userName}">회원정보 수정 </a></li>
					<li><a href="/user/delete?userName=${principal.userName}">회원탈퇴 </a></li>
					</c:otherwise>
					</c:choose>
				</ul></li>
		</ul>
	</div>
</nav>




<div class="content--box">
	<div class="content">
		<ul class="slider">
			<c:forEach var="showList" items="${showsList}">
				<li>
					<div class="content--info">
						<dl class="right">
							<div class="info">
								<h4
									style="margin-top: 160px; margin-left: 0; background-color: white; font-size: 30px; font-weight: 400; padding: 0 10px 0 10px;">${showList.showType}</h4>
								<h3
									style="margin-top: -10px; margin-left: -70px; font-size: 30px; font-weight: 200;">🟡
									${showList.location}</h3>
								<h1
									style="margin-top: 10px; margin-left: -120px; font-size: 57px; font-weight: 400; height: 60px;">${showList.title}</h1>
								<h4
									style="margin-top: 100px; margin-left: -70px; font-size: 25px; font-weight: 100;">${showList.startDate}일~${showList.endDate}일</h4>
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

