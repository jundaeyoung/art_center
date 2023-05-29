/**
 * 
 */


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
					type: "GET",
					url: "/user/check/findEmail",
					data: {
						"userEmail": userEmail
					},
					success: function(res) {
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
										type: "POST",
										url: "/user/check/email/sendEmail",
										data: {
											"userEmail": userEmail
										},
										success: function(
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
																			.val().length > 3
																			&& $(
																				"#password")
																				.val().length > 3
																			&& $(
																				"#nickname")
																				.val().length > 3) {
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