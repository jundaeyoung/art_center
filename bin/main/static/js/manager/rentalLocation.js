/**
 * 작성자 : 김미정
 */
$(function() {
	
	console.log("111111");
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
			console.log('New date range selected: '
				+ startDate + ' to '
				+ endDate + ' (predefined range: '
				+ start + ')');
		});
});
function calculatePrice() {
	let data = {
		holeId: $("#locationSelect").val(),
		location: $("#locationId").val(),
		startDate: $("#dateTime").val(),
		price:$("#totalPrice").val(),
		startTime:$("#timeSelect").val(),
		endTime:$("#endTime").val()
	};
	
	console.log(JSON.stringify(data));
	$.ajax({
		url: '/api/rentalLocation/',
		type: 'POST',
		data: JSON.stringify(data),
		contentType: 'application/json; charset=utf-8',
	}).done(function(response) {
		
		console.log('들어옴:', response);
		console.log(typeof response);
		console.log(response.holeId);
		
	}).fail(function(error) {
		console.error('Error 났어?:', error);
	});

	var dateTime = document.getElementById("dateTime").value;
	let test = dateTime;
	test = test.split(" ~ ");

	var re1 = test[0]
	re1 = re1.replaceAll("-", "");
	var re2 = test[1]
	re2 = re2.replaceAll("-", "");

	let result = parseFloat(re2) - parseFloat(re1) + 1
	console.log(result);
	var locationSelect = document.getElementById("locationSelect");
	var selectedOption = locationSelect.options[locationSelect.selectedIndex];

	var price = selectedOption.getAttribute("data-price");
	var totalPrice;

	if (price === price) {
		totalPrice = result * parseInt(price);
	} else {
		totalPrice = parseInt(price);
	}
	var totalPriceElement = document.getElementById("totalPrice");
	totalPriceElement.innerText = "대관료: " + totalPrice + "원";
	
	// js 오브젝트 만들기 
	// js 오브젝트를 json 문자열로 변환해서 던지기 
	
}
