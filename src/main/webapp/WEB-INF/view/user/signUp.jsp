<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="utf-8" xmlns:th="http://www.thymeleaf.org"></html>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
<script type="text/javascript" src="/js/main.js"></script>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<link rel="stylesheet" href="/css/user/signUp.css">
<body>
<div class="container">
	<div class="signInContainer">
	<div class="loginContainer">
		<div class="login--title">
			<img alt="" src="/images/background/logo.png" class="loginLogo">
			<h2>Amadeus Login</h2>
		</div>
		<br>
		<form action="/user/signUp" method="post">
			<c:choose>
				<c:when test="${userInfo.id != null}">
					<div class="form-group">
						<input type="hidden" class="form-control" id="userName" name="userName" value="${userInfo.id}">
					</div>
					<div class="form-group">
						<input type="hidden" class="form-control" id="password" name="password" value="${userInfo.id}">
					</div>
				</c:when>
				<c:otherwise>
					<div id="imail">
			<p>아이디 :</p>
				<i class="material-icons">person_outline</i> <input type="text" placeholder="아이디를 입력하세요" name="userName" id="userName" class="info" ><br>
			</div>
			<span class="error--messege" th:if="${valid_userName}">${valid_userName}</span>
			<br>
			<div id="ipw">
			<p>비밀번호 :</p>
				<i class="material-icons">lock_outline</i> <input type="password" placeholder="비밀번호를 입력하세요" name="password" id="password" class="infoPw">
				<br>
			</div>
				</c:otherwise>
			</c:choose>
		
			<span class="error--messege" th:if="${valid_password}">${valid_password}</span>
			<br>
			<div id="ipw">
			<p>닉네임 : </p>
				<i class="material-icons">insert_emoticon</i> <input type="text" placeholder="닉네임을 입력하세요" name="nickname" id="nickname" class="info"><br>
			</div>
			<span class="error--messege" th:if="${valid_nickname}">${valid_nickname}</span>
			<br>
			<div id="ipw">
			<p>이메일 :</p>
				<i class="material-icons">mail_outline</i> <input type="email" placeholder="이메일을 입력하세요" name="email" id="email" class="info"><br>
			</div>
			<span class="error--messege" th:if="${valid_email}">${valid_email}</span>
			<br>
			<div id="ipw">
				<div class="field birth">
				<br>
            <div class="birthDate">
            	<p>생년월일 :</p>
                <input type="number" placeholder="년(4자)" id="year" min="1900" max="2023">                
                <select id="month" style="height: 50px;">
                    <option value="">월</option>
                    <option value="">1월</option>
                    <option value="">2월</option>
                    <option value="">3월</option>
                    <option value="">4월</option>
                    <option value="">5월</option>
                    <option value="">6월</option>
                    <option value="">7월</option>
                    <option value="">8월</option>
                    <option value="">9월</option>
                    <option value="">10월</option>
                    <option value="">11월</option>
                    <option value="">12월</option>
                </select>
                <input type="number" placeholder="일" id="day" min="1" max="31">
            </div>
        </div>
			</div>
			<br>
			<input type="hidden" name="birthDate" id="birthDate">
			<div id="ipw">
				<p>전화번호 : </p>&nbsp;
				<i class="material-icons">phone_android</i> <input type="text" placeholder="전화번호를 입력하세요" name="tel" id="tel" class="info"><br>
			</div>
			<span class="error--messege" th:if="${valid_tel}">${valid_tel}</span>
			<br>
			<c:choose>
			<c:when test="${userInfo.id != null}">
			<input type="hidden" value="${userInfo.id}" id="apiId" name="apiId">
			</c:when>
			<c:otherwise>
			</c:otherwise>
			</c:choose>
			<input type="submit" value="회원가입" class="login" onclick="save()">
		</form>
			</div>
			</div>
			</div>
			<script type="text/javascript">
				function save() {
				    var year = document.getElementById("year").value;
				    var month = document.getElementById("month").value;
				    var day = document.getElementById("day").value;
				    
				    
				    var date = new Date(year, month - 1, day); 
					
				   
				   
				    var birthDate = date.toISOString().slice(0, 10);
				    document.getElementById("birthDate").value = birthDate;
				}
				
				
			</script>
</body>

</html>