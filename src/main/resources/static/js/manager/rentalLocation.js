/**
 * 작성자 : 김미정
 */
$(function() {
	$('#dateTime').daterangepicker(
		{
			"locale": {
				"format": "YYYY-MM-DD",
				"separator": " ~ ",
				"applyLabel": "확인",
				"cancelLabel": "취소",
				"fromLabel": "From",
				"toLabel": "To",
				"customRangeLabel": "Custom",
				"weekLabel": "W",
				"daysOfWeek": ["월", "화", "수", "목", "금", "토", "일"],
				"monthNames": ["1월", "2월", "3월", "4월", "5월", "6월",
					"7월", "8월", "9월", "10월", "11월", "12월"],
				"firstDay": 0,
			},
			"drops": "down",
			"minDate": moment().startOf('day')
		},
		function(start, end, label) {
			let startDate = start.format('YYYY-MM-DD').replaceAll(/-/g, "");
			let endDate = end.format('YYYY-MM-DD').replaceAll(/-/g, "");
		});
});
function calculatePrice() {
	let data = {
		holeId: $("#locationSelect").val(),
		location: $("#locationId").val(),
		startDate: $("#dateTime").val(),
		price: $("#totalPrice").val(),
		startTime: $("#timeSelect").val(),
		endTime: $("#endTime").val()
	};

	console.log(JSON.stringify(data));
	$.ajax({
		url: '/api/rentalLocation/',
		type: 'POST',
		data: JSON.stringify(data),
		contentType: 'application/json; charset=utf-8',
	}).done(function(response) {
			
		for (var i = 0; i < response.length; i++) {
			console.log(response[i].startTime);
			console.log(response[i].endTime);
			$("#timeSelect option[value*='" + response[i].startTime + "']").attr("disabled", true);
			$("#endTime option[value*='" + response[i].endTime + "']").attr("disabled", true);
		}


		var dateTime = document.getElementById("dateTime").value;
		let test = dateTime;
		test = test.split(" ~ ");

		var re1 = test[0]
		re1 = re1.replaceAll("-", "");
		var re2 = test[1]
		re2 = re2.replaceAll("-", "");

		var startTime = document.getElementById("timeSelect").value;
		var startTime = startTime
		startTime = startTime.replaceAll(":00", "");

		var endTime = document.getElementById("endTime").value;
		var endTime = endTime
		endTime = endTime.replaceAll(":00", "");

		let resultTime = (parseFloat(endTime) - parseFloat(startTime)) / 3;
		console.log(resultTime);

		let result = parseFloat(re2) - parseFloat(re1) + 1
		console.log(result);
		var locationSelect = document.getElementById("locationSelect");
		var selectedOption = locationSelect.options[locationSelect.selectedIndex];


		var price = selectedOption.getAttribute("data-price");
		var totalPrice;
		if (price === price) {
			totalPrice = result * parseInt(price) * resultTime;
		} else {
			totalPrice = parseInt(price);
		}
		var formattedPrice = totalPrice.toLocaleString(); 
		var totalPriceElement = document.getElementById("totalPrice");
		totalPriceElement.innerText = "대관료: " + formattedPrice + "원";
		
		$("#dateTime").on("click", function() {
			console.log("예약 가능한 날짜입니다.");
			for (var i = 0; i < response.length; i++) {
				console.log(response[i].startTime);
				console.log(response[i].endTime);
				$("#timeSelect option[value*='" + response[i].startTime + "']").attr("disabled", false);
				$("#endTime option[value*='" + response[i].endTime + "']").attr("disabled", false);
			}
		});
	}).fail(function(error) {
		console.error('Error 났습니다:', error);
	});





}
