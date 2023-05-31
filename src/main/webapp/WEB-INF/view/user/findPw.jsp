<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
<script type="text/javascript" src="/js/main.js"></script>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<link rel="stylesheet" href="/css/user/signIn.css">



<div class="signInContainer" style="margin-top:150px; margin-bottom: 200px;margin-left: 400px;">
	<div class="loginContainer">
		<div style="color: #ac2925; margin-bottom: 50px; font-size: 30px;">
			<p style="margin-left: 60px;margin-bottom: 50px;">입력된 정보로 임시 비밀번호가 전송됩니다.</p>
		</div>
		<div class="login--title">
			<img alt="" src="/images/background/logo.png" class="loginLogo">
		</div>
		<br>
		<form role="form">
			<div id="imail">
				<i class="material-icons">alternate_email</i> <span class="glyphicon glyphicon-user"></span> <input type="text" class="info" id="userEmail" placeholder="가입시 등록한 이메일을 입력하세요.">
			</div>
			<div id="ipw">
				<i class="material-icons">person_outline</i> <span class="glyphicon glyphicon-eye-open"></span> <input type="text" class="info" id = "userName" placeholder="가입시 등록한 이름을 입력하세요.">
			</div>
		</form>
		<button type="button" class="login" id="checkEmail" style="width: 605px;">OK</button>
		<div class="selectIdAndPw" style="font-size: 20px; margin-left: 340px;">
			<a href="/user/login">로그인</a>
			<p>|</p>
			<a href="/user/signUp">회원가입</a>
			<p>|</p>
			<a>아이디 찾기</a>
		</div>
		<div class="logobox">

			<div class="naverLogo">
				<a href="https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=q3WIWBEaLw_SUTxgY8kb&state=randomtext&redirect_uri=http://localhost:8080/auth/naver/callback"> <img alt=""
					src="/images/btn_naver.png" class="naverLogo"></a>
			</div>

			<div class="googleLogo">
				<a
					href="https://accounts.google.com/o/oauth2/v2/auth
		?client_id=101775853902-vpcpe0bdhvfndednj00mn5bsvij135m5.apps.googleusercontent.com
		&redirect_uri=http://localhost:8080/google/callback
		&response_type=code&scope=https://www.googleapis.com/auth/userinfo.email"><img
					alt="" src="/images/btn_google_light_normal_ios.png"></a>
			</div>
			<div class="kakaoLogo">
				<a href="https://kauth.kakao.com/oauth/authorize?client_id=2b8daa8c6238674fc9d677d8c51dd08f&redirect_uri=http://localhost:8080/auth/kakao/callback&response_type=code"> <img alt=""
					src="/images/kakaoLogo-removebg-preview.png">
				</a>
			</div>

		</div>

	</div>



</div>




<script>
	$('.modal').on('hidden.bs.modal', function(e) {
		console.log('modal close');
		$(this).find('form')[0].reset()
	});

	$("#checkEmail").click(function() {
		let userEmail = $("#userEmail").val();
		let userName = $("#userName").val();
		console.log(userEmail);
		$.ajax({
			type : "GET",
			url : "/user/check/findPw",
			data : {
				"userEmail" : userEmail,
				"userName" : userName
			},
			success : function(res) {
				if (res['check']) {
					console.log(res);
					alert("발송 완료!", "입력하신 이메일로 임시비밀번호가 발송되었습니다.", "success")
					if ('check') {
						$.ajax({
							type : "POST",
							url : "/user/check/findPw/sendEmail",
							data : {
								"userEmail" : userEmail,
								"userName" : userName
							}
						})
						window.location = "/user/login";
					}

					$('#checkMsg').html('<p style="color:darkblue"></p>');
				} else {
					alert("발송 실패!", "", "success")
				}
			}
		})
	})
</script>

<%@ include file="/WEB-INF/view/layout/footer.jsp"%>


