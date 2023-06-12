/**
 * 
 */

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
			success : function(data) {
				let res = data.data;
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