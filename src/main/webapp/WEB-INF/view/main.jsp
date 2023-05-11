<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="/css/slides.css">
</head>
<style>
body {
	width: 1500px;
	margin: 30px auto;
}

a {
	text-decoration: none;
	color: #404040;
}

li {
	list-style: none;
}

/*BODY*/
#nav {
	width: 100%;
}

#nav:after {
	content: "";
	display: block;
	clear: both;
}

.main {
	margin: 30px;
}

.main>li {
	position: relative;
	float: left;
	width: 200px;
	margin: 0 30px;
	height: 60px;
	box-sizing: border-box;
	line-height: 60px;
	text-align: center;
	font-size: 30px;
	height: 60px;
}

.main>li:hover .sub {
	/*display: block;*/
	
}

.main>li a {
	display: block;
	transition: all 0.3s;
}

.main>li a:hover {
	background: #909090;
	color: #fff;
}

.sub {
	display: none;
	position: absolute;
	top: 60px;
	left: 0px;
	width: 160px;
	text-align: center;
	background: #eee;
	z-index: 1;
}

.sub li {
	margin-left: -40px;
	font-size: 20px;
}

.title {
	display: flex;
	justify-content: space-between;
}

.user--btn {
	display: flex;
}

.user--btn button {
	height: 46px;
	border-radius: 17px;
	margin-left: 10px;
	width: 100px;
}

.signUp--btn {
	background-color: #909090;
	border-style: none;
	color: white;
}

.login--btn {
	background-color: #3EC151;
	border-style: none;
	color: white;
}

button {
	transition: all 0.2s linear;
}

button:hover {
	cursor: pointer;
	transform: scale(1.05);
}
</style>

<body>
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
	<div class="title">
		<div>
			<img alt="" src="/images/mark.png" width="100" height="50">
		</div>
		<div></div>
		<div class="user--btn">
			<form action="/login" method="get">
				<button type="submit" class="login--btn">로그인</button>
			</form>
			<form action="#" method="get">
				<button type="submit" onclick="#" class="signUp--btn">회원가입</button>
			</form>
		</div>
	</div>


	<div class="slide_wrapper">
		<ul class="slides">
			<li>slide 01</li>
			<li>slide 02</li>
			<li>slide 03</li>
			<li>slide 04</li>
			<li>slide 05</li>
		</ul>

	</div>

	<p class="controls">
		<span class="prev">prev</span> <span class="next">next</span>
	</p>


	<script type="text/javascript" src="/js/main.js"></script>
</body>
</html>