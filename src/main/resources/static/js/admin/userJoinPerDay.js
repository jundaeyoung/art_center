/**
 * @author 손주이
 */


$.ajax({
	type: "get",
	url: "/api/admin/userjoinPerDate",
	contentType: "application/json; charset=utf-8"
}).done(function(joinDateUserList) {

	joinPerDate(joinDateUserList);

}).fail(function(error) {
	console.log(error);
	console.log("정보를 불러오는 데 실패하였습니다.");
});


function joinPerDate(joinDateUserList) {

	google.charts.load('current', { 'packages': ['bar'] });
	google.charts.setOnLoadCallback(drawStuff);

	function drawStuff() {

		let data = new google.visualization.arrayToDataTable([
			['Move', '가입자 수'],
			[joinDateUserList[0].createdDate, joinDateUserList[0].joinUserPerDate]]);
		for (let i = 1; i < joinDateUserList.length; i++) {
			data.addRows([[joinDateUserList[i].createdDate, joinDateUserList[i].joinUserPerDate]]);
		}

		let options = {
			width: 800,
			legend: {
				position: 'center'
			},
			chart: {
				title: '일일 가입자 수',
			},
			axes: {
				x: {
					0: {
						side: 'bottom',
						label: '날짜'
					}
					// Top x-axis.
				},
			},
			bar: {
				groupWidth: "90%"
			},
			vAxis: {
				viewWindow: {
					min: 0, // y축의 최소값
					max: 10 // y축의 최대값
				}
			}
		};

		let chart = new google.charts.Bar(document.getElementById('top_x_div'));
		// Convert the Classic options to Material options.
		chart.draw(data, google.charts.Bar.convertOptions(options));
	}
	;
}