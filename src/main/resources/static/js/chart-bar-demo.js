$(document).ready(function() {
  Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
  Chart.defaults.global.defaultFontColor = '#292b2c';


  function drawChart(response) {
  var labels = [];
  var data = [];

  for (var i = 0; i < response.length; i++) {
    labels.push(response[i].title);
    var value = parseInt(response[i].totalshowSales);
    data.push(value);
  }

  var ctx = document.getElementById("myBarChart").getContext("2d");
  var myBarChart = new Chart(ctx, {
    type: 'bar',
    data: {
      labels: labels,
      datasets: [{
        label: "공연 티켓 총매출",
        backgroundColor: "rgba(2,117,216,1)",
        borderColor: "rgba(2,117,216,1)",
        data: data,
      }],
    },
    options: {
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
            display: true
          }
        }
      },
      plugins: {
        title: {
          display: true,
          text: '공연 티켓 총 매출',
          font: {
            size: 30
          },
        }
      },
      tooltips: { 
               callbacks: { 
                   label: function(tooltipItem, data) {
                       return tooltipItem.yLabel.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",") + "원"; 
                       } 
    	    	},
    		},
    }
  });
}

  $.ajax({
    type: 'get',
    url: '/apiAdminShowSale/admin/showSale',
    contentType: 'application/json; charset=utf-8',
  }).done(function(response) {
    drawChart(response);
  }).fail(function(error) {
    console.log(error);
    console.log("데이터를 불러오는 데 실패하였습니다.");
  });
});