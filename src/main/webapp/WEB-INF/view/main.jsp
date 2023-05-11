<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
    </head>
    <style>
        body {
            width: 1200px;
            margin: 30px auto;
        }

        .header {
            flex: 1;
            margin-left: -200px;
            display: flex;
            padding: 5px 40px;
            background-color: white;
            text-align: center;
        }

        .home-menu {
            display: flex;
        }

        .home-menu li {
            width: 200px;
            margin-left: 20px;
        }

        .home-menu li a {
            margin-left: 20px;
            font-size: 30px;
            padding: 0 40px;
        }

        .home-menu:hover .home-menu2 {
            margin-left: -30px;
            height: 400px;
            display: flex;
            flex-direction: column;
            align-items: center;
            border-left: 1px solid #ccc;
        }
        .home-menu:hover #home_menu2 {
            padding-right: 45px;
            height: 400px;
            display: flex;
            flex-direction: column;
            align-items: center;
            border-right: 1px solid #ccc;
        }

        .home-menu2 {
            overflow: hidden;
            width: 100%;
            padding: 0;
            background: #fff;
            height: 0px;
        }

        .home-menu2 a {
            display: block;
            padding: 5px 0;
            text-align: center;
            margin: 10px -20px;
        }

        li {
            list-style: none;
        }

        .home-menu li a {
            font-size: 20px;
            color: black;
            text-decoration: none;
            color: black;
        }

        .home-menu2 li a {
            font-size: 25px;
            color: black;
            text-decoration: none;
        }

        .home-menu li a:hover {
            color: black;
            text-decoration: none;
            font-weight: bold;
        }

        .home-menu2 li a:hover {
            font-weight: bold;
            background-color: #D6E4FF;
            text-decoration: none;
        }
    </style>

    <body>
        <div class="header">
            <div class="header-menu">
                <nav>
                    <ul class="home-menu">
                        <li><a href="#">
                                <h2>공연</h2>
                            </a>
                            <ul class="home-menu2">
                                <li><a href="#">전체일정(달력)</a></li>
                                <li><a href="#">오늘의 공연·전시</a></li>
                                <li><a href="#">예매·취소 안내</a></li>
                            </ul>
                        </li>
                        <ul class="home-menu">
                            <li><a href="#">
                                    <h2>공간·대관</h2>
                                </a>
                                <ul class="home-menu2">
                                    <li><a href="#">공간소개</a></li>
                                    <li><a href="#">공간별 대관안내</a></li>
                                    <li><a href="#">입장권 운영안내</a></li>
                                </ul>
                            </li>
                            <ul class="home-menu">
                                <li><a href="#">
                                        <h2>아카데미</h2>
                                    </a>
                                    <ul class="home-menu2">
                                        <li><a href="#">아카데미 안내</a></li>
                                        <li><a href="#">수강신청</a></li>
                                        <li><a href="#">아카데미 공지사항</a></li>
                                        <li><a href="#">아카데미 FAQ</a></li>
                                        <li><a href="#">오디션 신청</a></li>
                                        <li><a href="#">나의 강좌</a></li>
                                    </ul>
                                </li>
                                <ul class="home-menu">
                                    <li><a href="#">
                                            <h2>소식·이용·참여</h2>
                                        </a>
                                        <ul class="home-menu2">
                                            <li><a href="#">전당 소식</a></li>
                                            <li><a href="#">오시는길·주차안내</a></li>
                                            <li><a href="#">편의서비스</a></li>
                                            <li><a href="#">고객센터</a></li>
                                            <li><a href="#">관람평</a></li>
                                        </ul>
                                    </li>
                                    <ul class="home-menu">
                                        <li><a href="#">
                                                <h2>회원서비스</h2>
                                            </a>
                                            <ul class="home-menu2" id="home_menu2">
                                                <li><a href="#">회원가입</a></li>
                                                <li><a href="#">로그인</a></li>
                                                <li><a href="#">아이디찾기</a></li>
                                                <li><a href="#">패스워드 찾기</a></li>
                                            </ul>
                                        </li>
                                    </ul>
                </nav>
            </div>
        </div>
        <h1>main이에요</h1>
    </body>

    </html>