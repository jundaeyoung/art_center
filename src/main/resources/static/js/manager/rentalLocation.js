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
			"startDate": $("#startDate").val(),
			"endDate": $("#endDate").val(),
			"drops": "down"
		},
		function(start, end, label) {
			let startDate = start.format('YYYY-MM-DD').replaceAll(/-/g, "");
			let endDate = end.format('YYYY-MM-DD').replaceAll(/-/g, "");
		});
});
function calculatePrice() {
	let data = {
		holeId: $("#locationSelect").val(),
		locationId: $("#locationId").val(),
		startDate: $("#dateTime").val(),
		Sprice: $("#totalPrice").val(),
		startTime: $("#timeSelect").val(),
		endTime: $("#endTime").val()
	};

	console.log(JSON.stringify(data));
	$.ajax({
		url: '/api/rentalLocation/',
		type: 'POST',
		data: JSON.stringify(data),
		contentType: 'application/json; charset=utf-8',
	}).done(function(data) {
		var response = data.data;
		$('option').removeAttr('disabled');
		for (var i = 0; i < response.length; i++) {
			for (var j = response[i].startTime; j < response[i].endTime; j++) {
				$("#timeSelect option[value*='" + response[i].startTime + "']").attr("disabled", true);
				$("#endTime option[value*='" + response[i].endTime + "']").attr("disabled", true);
			}
		}

		let dateTime = document.getElementById("dateTime").value;
		let date = dateTime;
		date = date.split(" ~ ");
		
		var date_arr = date[0].split("-");

		var stDate = new Date(date_arr[0], date_arr[1]-1, date_arr[2]);

		var endDate_arr = date[1].split("-");
		var endDate = new Date(endDate_arr[0], endDate_arr[1]-1, endDate_arr[2]);
		
		let startTime = document.getElementById("timeSelect").value;
		let startTime2 = startTime
		startTime2 = startTime2.replaceAll(":00", "");

		let endTime = document.getElementById("endTime").value;
		let endTime2 = endTime
		endTime2 = endTime2.replaceAll(":00", "");

		let resultTime = (parseFloat(endTime2) - parseFloat(startTime2)) / 3;

		var btMs = endDate.getTime() - stDate.getTime();
		var result = btMs / (1000 * 60 * 60 * 24);


		let locationSelect = document.getElementById("locationSelect");
		let selectedOption = locationSelect.options[locationSelect.selectedIndex];

		let price = selectedOption.getAttribute("data-price");
		let totalPrice;
		if (price === price) {
			totalPrice = result * parseInt(price) * resultTime;
		} else {
			totalPrice = parseInt(price);
		}
		let formattedPrice = totalPrice.toLocaleString();
		let totalPriceElement = document.getElementById("totalPrice");
		let totalPriceElement2 = document.getElementById("totalPrice2");
		if (totalPrice <= 0) {
			totalPriceElement.innerText = "시간 선택이 잘못되었습니다.";
		} else {
			totalPriceElement.innerText = "대관료: " + formattedPrice + "원";
			totalPriceElement2.value = formattedPrice;
		}

		$("#dateTime").on("click", function() {
			for (let i = 0; i < response.length; i++) {
				$("#timeSelect option[value*='" + response[i].startTime + "']").attr("disabled", false);
				$("#endTime option[value*='" + response[i].endTime + "']").attr("disabled", false);
			}
		});
		for (let i = 0; i < response.length; i++) {
			for (let j = parseInt(response[i].startTime); j <= parseInt(response[i].endTime); j++) {
				$("#timeSelect option[value*='" + j + ":00:00" + "']").attr("disabled", true);
				$("#endTime option[value*='" + j + ":00:00" + "']").attr("disabled", true);
			}
		}

		$("#endTime").on("click", function() {
			let startDate = $("#timeSelect option:selected").val();
			for (let i = 9; i <= parseInt(startDate); i++) {
				console.log(i);
				$("#endTime option[value*='" + i + ":00:00" + "']").attr("disabled", true);
			}

		});

	}).fail(function(error) {
		console.error('Error 났어?:', error);
	});

}
