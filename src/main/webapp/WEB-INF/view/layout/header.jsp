<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.Arrays"%>
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
	<div id="body__header"style="margin-left: -120px;">
		<div class="title">
			<div>
				<a href="/"><img alt="" src="/images/background/logo.png" width="140" height="120"></a>
			</div>
			<c:choose>
				<c:when test="${principal == null}">
					<div class="user--btn">
						<form action="/user/loginTest" method="get">
							<button type="submit" class="login--btn" style="font-size: 20px;">로그인</button>
						</form>
						<form action="#" method="get">
							<button type="submit" onclick="#" class="signUp--btn" style="font-size: 20px;">회원가입</button>
						</form>
					</div>
				</c:when>
				<c:when test="${principal != null && principal.getRoleId()==2}">
					<div class="user--btn">
						<form action="/manager/notice" method="get">
							<button type="submit" class="logout--btn" style="font-size: 20px;">알림</button>
						</form>
						<form action="#" method="get">
							<button type="submit" class="logout--btn" style="font-size: 20px;">내정보</button>
						</form>
						<form action="#" method="get">
							<button type="submit" class="logout--btn">
								<a href="/user/logout" style="font-size: 20px;">로그아웃</a>
							</button>
						</form>
						&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
						<p style="font-size: 20px;">반갑습니다. ${principal.nickname} 매니저 님</p>
					</div>
				</c:when>
				<c:otherwise>
					<div class="user--btn">
						<form action="#" method="get">
							<button type="submit" class="logout--btn" style="font-size: 20px;">내정보</button>
						</form>
						<form action="#" method="get">
							<button type="submit" class="logout--btn">
								<a href="/user/logout" style="font-size: 20px;">로그아웃</a>
							</button>
						</form>
						&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
						<p style="font-size: 20px;">반갑습니다. ${principal.nickname} 님</p>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
		<c:choose>
			<c:when test="${principal != null && principal.getRoleId()==2}">
				<nav>
					<div id="nav" style="margin-left: 280px;">
						<ul class="main">
							<li><a href="#">공연</a>
								<ul class="sub">
									<li><a href="/schedule">전체 공연 일정(달력)</a></li>
									<li><a href="#">나의 공연 일정(달력)</a></li>
									<li><a href="#">나의 공연 매출</a></li>
									<li><a href="/manager/signUpShow">공연 등록</a></li>
								</ul></li>
							<li><a href="#">전시회</a>
								<ul class="sub">
									<li><a href="#">전시회 전체 일정</a></li>
									<li><a href="#">내 전시회 일정</a></li>
									<li><a href="#">내 전시회 매출</a></li>
									<li><a href="#">전시회 등록</a></li>
								</ul></li>
							<li><a href="#">아카데미 </a>
								<ul class="sub">
									<li><a href="#">아카데미 전체 일정</a></li>
									<li><a href="#">내 아카데미 일정</a></li>
									<li><a href="#">수강 신청 관리</a></li>
									<li><a href="#">아카데미 등록</a></li>
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
											<li><a>공지사항 작성</a></li>
										</c:otherwise>
									</c:choose>
								</ul></li>
						</ul>
					</div>
				</nav>
			</c:when>
			<c:otherwise>
				<nav>
					<div id="nav">
						<ul class="main">
							<li><a href="#">공연</a>
								<ul class="sub">
									<li><a href="/schedule">전체 일정(달력) </a></li>
									<li><a href="/show/newestShow?currentPage=1&begin=0&range=3">공연·전시 </a></li>
									<li><a href="#">예매·취소안내 </a></li>
								</ul></li>
							<li><a href="#">공간·대관 </a>
								<ul class="sub">
									<li><a href="#">공간 소개 </a></li>
									<li><a href="#">공간별 대관 안내 </a></li>
									<li><a href="#">입장권 운영 안내 </a></li>
								</ul></li>
							<li><a href="#">아카데미 </a>
								<ul class="sub">
									<li><a href="#">아카데미 안내 </a></li>
									<li><a href="#">수강신청 </a></li>
									<li><a href="#">아카데미 공지 사항 </a></li>
									<li><a href="#">아카데미 FAQ</a></li>
									<li><a href="#">오디션 신청</a></li>
								</ul></li>
							<li><a href="#">소식·이용·참여</a>
								<ul class="sub">
									<li><a href="#">전당 소식</a></li>
									<li><a href="#">오시는길·주차 안내</a></li>
									<li><a href="/quest/search?searchText=&currentPage=1&begin=0&range=5">QnA</a></li>
									<li><a href="#">고객센터</a></li>
									<li><a href="/review/newestReview?currentPage=1&begin=0&range=3">관람평</a></li>
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
			</c:otherwise>
		</c:choose>
	</div>