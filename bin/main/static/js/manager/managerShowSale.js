$(document).ready(function() {
	$.ajax({
		type: 'get',
		url: '/apiShowSale/manager/showSale',
		contentType: 'application/json; charset=utf-8',
	}).done(function(data) {
		google.charts.load('current', { 'packages': ['bar'] });
		google.charts.setOnLoadCallback(drawChart);

		let response = data.data;
		function drawChart() {
			var data = google.visualization.arrayToDataTable([
				['title', '성인 ', '청소년 수', '총 수'],
				[response[0].title, response[0].adultCount, response[0].youthCount, response[0].adultCount + response[0].youthCount],
			]);
			for (var i = 1; i < response.length; i++) {
				data.addRows([
					[response[i].title, response[i].adultCount, response[i].youthCount, response[i].adultCount + response[i].youthCount],
				]);
			}

			var options = {
				chart: {
					title: '공연별 방문자 현황',
				},
				bar: {
					groupWidth: '50%' // 예제에서 이 값을 수정
				},
				fontSize: 30,

			};

			var chart = new google.charts.Bar(document.getElementById('columnchart_material'));

			chart.draw(data, google.charts.Bar.convertOptions(options));
		}

	});

});

