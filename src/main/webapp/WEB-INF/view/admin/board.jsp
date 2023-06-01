<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/adminHeader.jsp"%>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<div id="layoutSidenav_content">
	<main>
		<a href="/sales/showGrape">공연 매출 그래프</a>
		<div id="columnchart_material" style="width: 1200px; height: 800px; margin-left: 150px; padding: 100px;"></div>
		<div class="container-fluid px-4">
			<ol class="breadcrumb mb-4">
			</ol>
			<div class="review__content" style="margin-left: -30px;"></div>


			<%@ include file="/WEB-INF/view/layout/adminFooter.jsp"%>



			<script type="text/javascript">
			$(document).ready(function() {
		          $.ajax({
		            type: 'get',
		            url: '/apiAdminShowSale/admin/rentSale',
		            contentType: 'application/json; charset=utf-8',
		            success: function(response) {
		              var labels = response.map(function(data) { return data.title; });
		              var data = response.map(function(data) { return data.totalPrice; });

		              var ctx = document.getElementById('columnchart_material').getContext('2d');
		              var chart = new Chart(ctx, {
		                type: 'bar',
		                data: {
		                  labels: labels,
		                  datasets: [{
		                    label: '총매출',
		                    data: data,
		                    backgroundColor: 'rgba(2,117,216,0.2)',
		                    borderColor: 'rgba(2,117,216,1)',
		                    borderWidth: 2,
		                    hoverBackgroundColor: 'rgba(2,117,216,1)',
		                    hoverBorderColor: 'rgba(255,255,255,0.8)'
		                  }]
		                },
		                options: {
		                  plugins: {
		                    title: {
		                      display: true,
		                      text: '대관 총 매출 (공연별)',
		                      font: {
		                        size: 30
		                      }
		                    },
		                    tooltip: {
		                      callbacks: {
		                        label: function(context) {
		                          return '₩' + context.parsed.y.toLocaleString();
		                        }
		                      }
		                    }
		                  },
		                  scales: {
		                    x: {
		                      grid: {
		                        display: false
		                      }
		                    },
		                    y: {
		                      ticks: {
		                        callback: function(value, index, values) {
		                          return '₩' + value.toLocaleString();
		                        }
		                      },
		                      grid: {
		                        color: 'rgba(0, 0, 0, .125)'
		                      }
		                    }
		                  }
		                }
		              });
		            },
		            error: function(error) {
		              console.log(error);
		            }
		          });
		        });
			</script>