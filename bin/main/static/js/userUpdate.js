/**
 * 
 */


var nicknameCheck = false;
var telCheck = false;
$(document)
	.ready(
		function() {
			$(".login").attr("disabled", true), $(".login").css(
				"background-color", "#ccc");

			$(function() {
				$("#nickname")
					.on(
						'keyup',
						function() {
							var formData = $("#nickname")
								.val();
							$
								.ajax({
									type: 'post',
									url: "/user/check/nickname",
									contentType: "application/json; charset=UTF-8",
									data: formData,
									datatype: "json",
									success: function(
										data) {
										let res = data.data;
										if (formData.length <= 1) {
											$(
												"#error--nickname")
												.empty();
											$(
												"#error--nickname")
												.append(
													"닉네임은 최소 2글자입니다.");
											$(
												".login")
												.attr(
													"disabled",
													true),
												$(
													".login")
													.css(
														"background-color",
														"#ccc");
											nicknameCheck = false;
										} else {
											if (res == 1) {
												$(
													"#error--nickname")
													.empty();
												$(
													"#error--nickname")
													.append(
														"해당 닉네임이 존재합니다.");
												$(
													".login")
													.attr(
														"disabled",
														true),
													$(
														".login")
														.css(
															"background-color",
															"#ccc");
												nicknameCheck = false;
											} else {
												$(
													"#error--nickname")
													.empty();
												$(
													"#error--nickname")
													.append(
														"사용할 수 있는 닉네임 입니다.");
												nicknameCheck = true;
												if ($("#nickname").val().length > 0) {
													if (nicknameCheck == true) {
														if (telCheck == true
														) {
															$(".login").attr("disabled", false),
																$(".login").css("background-color", "rgb(255, 80, 90)")
														}
													} else {
														$(".login").attr("disabled", true),
															$(".login").css("background-color", "#ccc");
													}
												}
											}
										}
									},
									error: function(
										error) {
									}
								});
						});
			});
			$(function() {
				$("#tel")
					.on(
						'keyup',
						function() {
							var formData = $("#tel").val();
							$
								.ajax({
									type: 'post',
									url: "/user/check/tel",
									contentType: "application/json; charset=UTF-8",
									data: formData,
									datatype: "json",
									success: function(
										data) {
										let res = data.data;
										if ((formData.length == 11) == false) {
											telCheck = false;
											$(
												"#error--tel")
												.empty();
											$(
												"#error--tel")
												.append(
													"올바른 전화번호가 아닙니다.");
											$(
												".login")
												.attr(
													"disabled",
													true),
												$(
													".login")
													.css(
														"background-color",
														"#ccc");
										} else {
											if (res == 1) {
												telCheck = false;
												$(
													"#error--tel")
													.empty();
												$(
													"#error--tel")
													.append(
														"등록된 전화번호입니다.");
												$(
													".login")
													.attr(
														"disabled",
														true),
													$(
														".login")
														.css(
															"background-color",
															"#ccc");
											} else {
												telCheck = true;
												$(
													"#error--tel")
													.empty();
												$(
													"#error--tel")
													.append(
														"사용할 수 있는 전화번호 입니다.");
												if ($(
														"#nickname")
														.val().length > 0) {
													if ($(
															"#tel")
															.val().length > 10) {
														if (nicknameCheck == true) {
															if (telCheck == true
																) {
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
														} else {
															$(
																".login")
																.attr(
																	"disabled",
																	true),
																$(
																	".login")
																	.css(
																		"background-color",
																		"#ccc");
														}
													}
												}
											}
										}
									},
									error: function(
										error) {
									}
								});
						});
			});

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
	$(this).find('form')[0].reset()
});


var idck = 0;
$(function() {
	$('.info').on(
		'keyup',
		function() {
			if (
				$("#nickname").val().length > 0) {
					if(
						$("#tel").val().length > 10) {
					if ( nicknameCheck == true) {
						if (telCheck == true) {
							$(".login").attr("disabled", false), $(
								".login").css("background-color",
									"rgb(255, 80, 90)")
						}
					} else {
						$(".login").attr("disabled", true), $(".login")
							.css("background-color", "#ccc");
					}
				}
			}
		});
});

