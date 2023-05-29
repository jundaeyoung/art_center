<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<html lang="utf-8" xmlns:th="http://www.thymeleaf.org"></html>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
<script type="text/javascript" src="/js/main.js"></script>
<script type="text/javascript"
	src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.11.3.min.js"></script>

<link rel="stylesheet" href="/css/user/signUp.css">



<div class="container">
	<div class="signInContainer">
		<div class="loginContainer">
			<div class="login--title">
				<img alt="" src="/images/background/logo.png" class="loginLogo">
			</div>
			<br>
			<form action="/user/signUp" method="post">
				<div class="content">
					<c:choose>
						<c:when test="${userInfo.id != null}">
							<div class="form-group">
								<input type="hidden" class="form-control" id="userName"
									name="userName" value="${userInfo.id}">
							</div>
							<div class="form-group">
								<input type="hidden" class="form-control" id="password"
									name="password" value="${userInfo.id}">
							</div>
						</c:when>
						<c:otherwise>
							<div id="imail">
								<p>아이디 :</p>
								<i class="material-icons">person_outline</i> <input type="text"
									placeholder="아이디를 입력하세요" name="userName" id="userName"
									class="info"><br>
								<button id="overlappedID" type="button">중복확인</button>
								<br> <span id="olmessage"></span>
							</div>
							<span class="error--messege" th:if="${valid_userName}">${valid_userName}</span>
							<br>
							<div id="ipw">
								<p>비밀번호 :</p>
								<i class="material-icons">lock_outline</i> <input
									type="password" placeholder="비밀번호를 입력하세요" name="password"
									id="password" class="info"> <br>
							</div>
						</c:otherwise>
					</c:choose>

					<span class="error--messege" th:if="${valid_password}">${valid_password}</span>
					<br>
					<div id="ipw">
						<p>닉네임 :</p>
						<i class="material-icons">insert_emoticon</i> <input type="text"
							placeholder="닉네임을 입력하세요" name="nickname" id="nickname"
							class="info"><br>
					</div>
					<span class="error--messege" th:if="${valid_nickname}">${valid_nickname}</span>
					<br>
					<div id="ipw" class="email">
						<p>이메일 :</p>
						<i class="material-icons" style="margin-left: 450px;">mail_outline</i>
						<input type="email" placeholder="이메일을 입력하세요" name="email"
							id="email" class="info"><br>
						<button type="button" id="checkEmail" style="margin-left: 10px;">이메일
							인증</button>
					</div>
					<span class="error--messege" th:if="${valid_email}">${valid_email}</span>
					<br>
					<div id="ipw" class="email">
						<p>인증번호 :</p>
						<i class="material-icons" style="margin-left: 450px;">mail_outline</i>
						<input type="text" placeholder="이메일 인증번호를 입력하세요" name="text"
							id="emailCheck" class="info"><br>
						<button type="button" id="checkEmailNumber"
							style="margin-left: 10px;">이메일 인증</button>
					</div>
					<span class="error--messege" th:if="${valid_email}">${valid_email}</span>
					<br>
					<div id="ipw" style="margin-top: 30px;">
						<div class="field birth">
							<br>
							<div class="birthDate">
								<p>생년월일 :</p>
								<input type="number" placeholder="년(4자)" id="year" min="1900"
									max="2023" class="info"> <select id="month">
									<option value="">월</option>
									<option value="1">1월</option>
									<option value="2">2월</option>
									<option value="3">3월</option>
									<option value="4">4월</option>
									<option value="5">5월</option>
									<option value="6">6월</option>
									<option value="7">7월</option>
									<option value="8">8월</option>
									<option value="9">9월</option>
									<option value="10">10월</option>
									<option value="11">11월</option>
									<option value="12">12월</option>
								</select> <input type="number" placeholder="일" id="day" min="1" max="31">
							</div>
						</div>
					</div>
					<br> <input type="hidden" name="birthDate" id="birthDate">
					<div id="ipw">
						<p>전화번호 :</p>
						&nbsp; <i class="material-icons">phone_android</i> <input
							type="text" placeholder="전화번호를 입력하세요" name="tel" id="tel"
							class="info"><br>
					</div>
					<span class="error--messege" th:if="${valid_tel}">${valid_tel}</span>
					<br>
					<c:choose>
						<c:when test="${userInfo.id != null}">
							<input type="hidden" value="${userInfo.id}" id="apiId"
								name="apiId">
						</c:when>
						<c:otherwise>
						</c:otherwise>
					</c:choose>
					<input type="submit" value="회원가입" class="login" onclick="save()">
				</div>
			</form>
		</div>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(
			function() {
				$(".login").attr("disabled", true), $(".login").css(
						"background-color", "#ccc");

			});

	function save() {
		var year = document.getElementById("year").value;
		var month = document.getElementById("month").value;
		var day = document.getElementById("day").value;

		var date = new Date(year, month - 1, day);

		var birthDate = date.toISOString().slice(0, 10);
		document.getElementById("birthDate").value = birthDate;
	}

	$('.modal').on('hidden.bs.modal', function(e) {
		console.log('modal close');
		$(this).find('form')[0].reset()
	});

	$("#checkEmail")
			.click(
					function() {
						let userEmail = $("#email").val();
						if (userEmail.length < 5) {
							alert("잘못된 이메일 형식입니다.")
							return false;
						}
						$
								.ajax({
									type : "GET",
									url : "/user/check/findEmail",
									data : {
										"userEmail" : userEmail
									},
									success : function(res) {
										if (res['check']) {
											if ('check') {
												alert(
														"발송 완료!",
														"입력하신 이메일로 인증번호가 발송되었습니다.",
														"success")
											}
											if ('check') {
												$
														.ajax({
															type : "POST",
															url : "/user/check/email/sendEmail",
															data : {
																"userEmail" : userEmail
															},
															success : function(
																	res) {
																console
																		.log(res);
																$(
																		"#checkEmailNumber")
																		.click(
																				function() {
																					let checkCode = $(
																							"#emailCheck")
																							.val()
																					if (res == checkCode) {
																						alert("인증 되었습니다.")
																						$(
																								'.info')
																								.on(
																										'keyup',
																										function() {
																											if ($(
																													"#userName")
																													.val().length > 0
																													&& $(
																															"#password")
																															.val().length > 0
																													&& $(
																															"#nickname")
																															.val().length > 0) {
																												if ($(
																														"#year")
																														.val().length > 0
																														&& $(
																																"#month")
																																.val().length > 0
																														&& $(
																																"#day")
																																.val().length > 0
																														&& $(
																																"#tel")
																																.val().length > 10) {
																															$(
																																	".login")
																																	.attr(
																																			"disabled",
																																			false),
																															$(
																																	".login")
																																	.css(
																																			"background-color",
																																			"rgb(255, 80, 90)")
																												}
																											}
																										});
																					} else {
																						alert("인증번호가 일치하지 않습니다.")
																					}
																				});
															}
														});
											}

											$('#checkMsg')
													.html(
															'<p style="color:darkblue"></p>');
										} else {
											alert("해당이메일이 존재합니다.", "success")
										}
									}
								})
					})
</script>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
