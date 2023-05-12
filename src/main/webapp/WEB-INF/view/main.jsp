<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.Arrays"%>
<%!int i = 0;%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="/css/main.css">
</head>
<style>
</style>
<body>

	<div class="title">
		<div>
			<img alt="" src="/images/mark.png" width="100" height="50">
		</div>
		<div class="user--btn">
			<form action="/user/login" method="get">
				<button type="submit" class="login--btn">로그인</button>
			</form>
			<form action="#" method="get">
				<button type="submit" onclick="#" class="signUp--btn">회원가입</button>
			</form>
		</div>
	</div>


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
						<li><a href="#">관람평</a></li>
					</ul></li>
				<li><a href="#"> 회원 서비스 </a>
					<ul class="sub">
						<li><a href="#"> 회원가입 </a></li>
						<li><a href="#">로그인 </a></li>
						<li><a href="#">아이디 찾기 </a></li>
						<li><a href="#">패스워드 찾기 </a></li>
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
									<h4 style="margin-top: -11px; margin-left: -6px; background-color: white; font-size: 20px; padding: 0 10px 0 10px;">${showList.showType}</h4>
									<h3 style="margin-top: -10px; margin-left: -30px;">🟡 ${showList.location}</h3>
									<h1 style="margin-top: 10px; margin-left: -10px; font-size: 37px;">${showList.title}</h1>
									<h4 style="margin-top: 10px;">${showList.startDate}일~${showList.endDate}일</h4>
								</div>
								<div>
									<a href="#"><img src="images/${showList.imgRoute}" width="300" height="400"></a>
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
							<li><img src="images/${showList.imgRoute}" width="150" height="200"></li>
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
</body>
</html>