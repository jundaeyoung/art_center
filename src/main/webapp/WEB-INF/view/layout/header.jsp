<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page import="java.util.Arrays"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AMADEUS - 당신의 꿈을 펼쳐라</title>
<link rel="shortcut icon" sizes="90x90" type="image/x-icon" href="/images/background/logo_mini.png">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="/css/main.css">
</head>
<style>
</style>
<body>
	<div class="body--content--main">
		<div id="body__header" style="margin-left: -120px;">
			<div class="title">
				<div>
					<a href="/"><img alt="" src="/images/background/logo.png" width="140" height="120"></a>
				</div>
				<c:choose>
					<c:when test="${principal == null}">
						<div class="user--btn">
							<form action="/user/login" method="get">
								<button type="submit" class="login--btn" style="font-size: 20px;">로그인</button>
							</form>
							<form action="/user/signUp" method="get">
								<button type="submit" onclick="#" class="signUp--btn" style="font-size: 20px;">회원가입</button>
							</form>
						</div>
					</c:when>
					<c:when test="${principal != null && principal.getRoleId()==2}">
						<div class="user--btn">
							<form>
								<button class="open-area" style="font-size: 20px;">알림</button>
							</form>
							<form action="/myPage/info" method="get">
								<button type="submit" class="logout--btn" style="font-size: 20px;">내정보</button>
							</form>
							<form action="#" method="get">
								<button type="submit" class="logout--btn">
									<a href="/user/logout" style="font-size: 20px;">로그아웃</a>
								</button>
							</form>
							&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
							<p style="font-size: 20px; margin-top: 20px;">${principal.nickname}매니저 님 반갑습니다</p>
						</div>
					</c:when>
					<c:when test="${principal.apiId != null}">
						<c:set var="apiType" value="${principal.apiId}" />
						<c:if test="${fn:contains(apiType, 'kakao')}">
							<div class="user--btn">
								<button type="submit" class="logout--btn">
									<a href="https://kauth.kakao.com/oauth/logout?client_id=2b8daa8c6238674fc9d677d8c51dd08f&logout_redirect_uri=http://localhost:8080/kakaologout&response_type=code" style="font-size: 20px;">로그아웃</a>
								</button>
								&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
								<p style="font-size: 20px; margin-top: 20px;">반갑습니다. ${principal.nickname} 님</p>
							</div>


						</c:if>
						<c:if test="${fn:contains(apiType, 'naver')}">
							<div class="user--btn">
								<button type="submit" class="logout--btn">
									<a href="#" onclick="naverLogout(); return false;" class="apilogout" style="font-size: 20px;">로그아웃</a>
								</button>
								&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
								<p style="font-size: 20px; margin-top: 20px;">반갑습니다. ${principal.nickname} 님</p>
							</div>
						</c:if>
						<c:if test="${fn:contains(apiType, 'google')}">
							<div class="user--btn">
								<button type="submit" class="logout--btn">
									<a href="#" onclick="googleLogout(); return false" class="apilogout" style="font-size: 20px;">로그아웃</a>
								</button>
								&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
								<p style="font-size: 20px; margin-top: 20px;">반갑습니다. ${principal.nickname} 님</p>
							</div>
						</c:if>
					</c:when>
					<c:otherwise>
						<div class="user--btn">
							<form action="/myPage/info" method="get">
								<button type="submit" class="logout--btn" style="font-size: 20px;">내정보</button>
							</form>
							<form action="#" method="get">
								<button type="submit" class="logout--btn">
									<a href="/user/logout" style="font-size: 20px;">로그아웃</a>
								</button>
							</form>
							&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
							<p style="font-size: 20px; margin-top: 20px;">반갑습니다. ${principal.nickname} 님</p>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
			<c:choose>
				<c:when test="${principal != null && principal.getRoleId()==2}">
					<nav>
						<div id="nav">
							<ul class="main">
								<li><a href="#"> 공연 </a>
									<ul class="sub">
										<li><a href="/schedule">전체 공연 일정(달력)</a></li>
										<li><a href="/manager/schedule">나의 공연 일정(달력)</a></li>
										<li><a href="/manager/showSale?currentPage=1&begin=0&range=5">나의 공연 매출</a></li>
										<li><a href="/manager/signUpShow">공연 등록</a></li>
									</ul></li>
								<li><a href="#"> 대관 </a>
									<ul class="sub">
										<li><a href="/rental">대관 신청</a></li>
									</ul></li>
								<li><a href="#"> 고객센터</a>
									<ul class="sub">
										<li><a href="/announcement">공지사항</a></li>
										<li><a href="/quest/search?searchText=&currentPage=1&begin=0&range=5">QnA</a></li>
										<li><a href="/notice/faq">FAQ</a></li>
									</ul></li>
								<li><a href="#"> 이용서비스 </a>
									<ul class="sub">
										<li><a href="/map">오시는길</a></li>
										<li><a href="/review/newestReview?currentPage=1&begin=0&range=3">관람평</a></li>
									</ul></li>
								<li><a href="#"> 회원 서비스 </a>
									<ul class="sub">
										<c:choose>
											<c:when test="${principal == null}">
												<li><a href="/user/signUp"> 회원가입 </a></li>
												<li><a href="/user/login">로그인 </a></li>
												<li><a href="#">아이디 찾기</a></li>
												<li><a href="/user/findPw">비밀번호 찾기</a></li>
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
				</c:when>
				<c:otherwise>
					<nav>
						<div id="nav">
							<ul class="main">
								<li><a href="#">일정</a>
									<ul class="sub">
										<li><a href="/schedule">전체 일정(달력) </a></li>
									</ul></li>
								<li><a href="#">공연</a>
									<ul class="sub">
										<li><a href="/show/newestShow?currentPage=1&begin=0&range=3">공연·전시 예매 </a></li>
									</ul></li>
								<li><a href="#">고객센터</a>
									<ul class="sub">
										<li><a href="/announcement">공지사항</a></li>
										<li><a href="/quest/search?searchText=&currentPage=1&begin=0&range=5">QnA</a></li>
										<li><a href="/notice/faq">FAQ</a></li>
									</ul></li>
								<li><a href="#">이용서비스</a>
									<ul class="sub">
										<li><a href="/map">오시는길</a></li>
										<li><a href="/review/newestReview?currentPage=1&begin=0&range=3">관람평</a></li>
									</ul></li>
								<li><a href="#"> 회원 서비스 </a>
									<ul class="sub">
										<c:choose>
											<c:when test="${principal == null}">
												<li><a href="/user/signUp"> 회원가입 </a></li>
												<li><a href="/user/login">로그인 </a></li>
												<li><a href="/user/findId">아이디 찾기</a></li>
												<li><a href="/user/findPw">비밀번호 찾기</a></li>
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
			<iframe width=0 height=0 name="hiddenframe" src="https://mail.google.com/mail/u/0/?logout&hl=en"></iframe>
		</div>
		<script type="text/javascript" src="/js/header.js"></script>
		
		
		