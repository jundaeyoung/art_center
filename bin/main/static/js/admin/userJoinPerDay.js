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

	google.charts.load('current', { 'packages': ['corechart'] });
	google.charts.setOnLoadCallback(drawStuff);

	function drawStuff() {
  let data = new google.visualization.DataTable();
  data.addColumn('string', '날짜');
  data.addColumn('number', '가입자 수');
  
  for (let i = 0; i < joinDateUserList.length; i++) {
    data.addRow([joinDateUserList[i].createdDate, joinDateUserList[i].joinUserPerDate]);
  }
  
  let options = {
    width: 800,
    legend: { position: 'center' },
    title: '일일 가입자 수',
    hAxis: {
      title: '날짜',
      slantedText: true,
      slantedTextAngle: 45
    },
    vAxis: {
      viewWindow: { min: 0, max: 10 }
    },
    series: {
      0: { areaOpacity: 0.7 } // Area 투명도 설정
    }
  };
  
  let chart = new google.visualization.AreaChart(document.getElementById('top_x_div'));
  chart.draw(data, options);
}
}