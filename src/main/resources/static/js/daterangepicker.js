		$(function() {
				$('#startDate').daterangepicker(
						{
							"locale" : {
								"format" : "YYYY-MM-DD",
								"separator" : " ~ ",
								"applyLabel" : "확인",
								"cancelLabel" : "취소",
								"fromLabel" : "From",
								"toLabel" : "To",
								"customRangeLabel" : "Custom",
								"weekLabel" : "W",
								"daysOfWeek" : [ "월", "화", "수", "목", "금", "토",
										"일" ],
								"monthNames" : [ "1월", "2월", "3월", "4월", "5월",
										"6월", "7월", "8월", "9월", "10월", "11월",
										"12월" ],
								"firstDay" : 0
							},
							"startDate" : "2023-06-01",
							"endDate" : "2023-07-01",
							"drops" : "down"
						},
						function(start, end, label) {
							console.log('New date range selected: '
									+ start.format('YYYY-MM-DD') + ' to '
									+ end.format('YYYY-MM-DD')
									+ ' (predefined range: ' + label + ')');
						});
			});