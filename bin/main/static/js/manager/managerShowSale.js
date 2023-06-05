$(document).ready(function() {
	Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#292b2c';

	var storedStartDate = localStorage.getItem("startDate");
  if (storedStartDate) {
    $("#startDate").val(storedStartDate);
  }

	function drawChart(response) {
		console.log(response);
		let labels = [];
		let dataAdult = [];
		let dataYouth = [];
		let dataTotal = [];

		for (let i = 0; i < response.length; i++) {
			labels.push(response[i].title);
			let adultCount = parseInt(response[i].adultCount);
			let youthCount = parseInt(response[i].youthCount);
			dataAdult.push(adultCount);
			dataYouth.push(youthCount);
			dataTotal.push(adultCount + youthCount);
		}

		let ctx = document.getElementById("myBarChart").getContext("2d");
		let myBarChart = new Chart(ctx, {
			type: 'bar',
			data: {
				labels: labels,
				datasets: [
					{
						label: "성인",
						backgroundColor: "rgba(2,117,216,1)",
						borderColor: "rgba(2,117,216,1)",
						data: dataAdult,
					},
					{
						label: "청소년 수",
						backgroundColor: "rgba(255,193,7,1)",
						borderColor: "rgba(255,193,7,1)",
						data: dataYouth,
					},
					{
						label: "총 수",
						backgroundColor: "rgba(60,186,159,1)",
						borderColor: "rgba(60,186,159,1)",
						data: dataTotal,
					}
				],
			},
			options: {
				legend: {
					position: 'right'
				},
				scales: {
					x: {
						grid: {
							display: false
						}
					},
					y: {
						ticks: {
							beginAtZero: true,
						},
						grid: {
							display: true,
						}
					}
				},
				plugins: {
					title: {
						display: true,
						text: '공연별 방문자 현황',
						font: {
							size: 30
						},
					},
				},
				tooltips: {
					callbacks: {
						label: function(tooltipItem, data) {
							return tooltipItem.yLabel.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",") + "명";
						}
					},
				},
			}
		});
	}
	
	$.ajax({
		type: 'get',
		url: '/apiShowSale/manager/showSale',
		contentType: 'application/json; charset=utf-8',
	}).done(function(response) {
		drawChart(response.data);
	}).fail(function(error) {
		console.log(error);
		console.log("데이터를 불러오는 데 실패하였습니다.");
	});
});

	$("#search").on("click", function() {
	var title = $("#title").val() ;
	$.ajax({
		type: 'get',
		url: '/apiShowSale/manager/showSaleBySearch/' + title,
		contentType: 'application/json; charset=utf-8',
		dataType: "json"
	}).done(function(response) {
		drawChart(response);
	}).fail(function(error) {
		console.log(error);
		console.log("데이터를 불러오는 데 실패하였습니다.");
	});
});

$("#search").on("click", function() {
	var title = $("#title").val();
	
	// 타이틀이 빈 문자열이면 전달을 못해서 임의로 값을 지정해줌
	if (!title) {
		title = "none";
	}
	
	console.log(title);
	$.ajax({
		type: 'get',
		url: '/apiShowSale/manager/showSaleBySearch/' + title,
		contentType: 'application/json; charset=utf-8',
		dataType: "json"
	}).done(function(response) {
		drawChart(response);
	}).fail(function(error) {
		console.log(error);
		console.log("데이터를 불러오는 데 실패하였습니다.");
	});
});

$("#dateSearch").on("click", function() {
	var startDate = $("#startDate").val();
	localStorage.setItem("startDate", startDate);
	console.log(startDate);
	$.ajax({
		type: 'get',
		url: '/apiShowSale/manager/showSaleByDate/' + startDate,
		contentType: 'application/json; charset=utf-8',
		dataType: "json"
	}).done(function(response) {
		drawChart(response);
	}).fail(function(error) {
		console.log(error);
		console.log("데이터를 불러오는 데 실패하였습니다.");
	});
});