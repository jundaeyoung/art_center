<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="/css/map.css">

<div class="container">
	<h1>찾아오시는 길</h1>
	<div class="map__all">
		<div class="map__info">
			<div class="info">
				<div class="address">
					<strong>주소</strong> <span>부산광역시 부산진구 중앙대로 751</span>
				</div>

				<div class="building">
					<strong>건물명</strong> <span>아마데우스 - Art Center</span>
				</div>
			</div>
			<div class="map__btn">
				<a href="https://map.kakao.com/link/to/아마데우스, 35.159573, 129.060249">아마데우스
					찾아오기</a>
			</div>
		</div>
	</div>
	<div id="map" style="width: 100%; height: 500px;"></div>

	<div>
		<div class="sb__1">
			<div class="sb__2">
				<h2>지하철</h2>
			</div>
			<div class="sb">
				<div class="sb__location" style="border-bottom: 1px solid #ccc">
					<div class="sb__line" style="background-color: #FEE8E8">
						<div class="station">
							<p>서면역</p>
							<p class="station__1">1</p>
							<p class="station__2">2</p>
						</div>
					</div>

					<div class="sb__exit">
						<p>서면역 15번출구</p>
					</div>
				</div>

				<div class="sb__location" style="border-bottom: 1px solid black">
					<div class="sb__line" style="background-color: #FEE8E8">
						<div class="station">
							<p>부전역</p>
							<p class="station__1">1</p>
						</div>
					</div>

					<div class="sb__exit">
						<p>부전역 2번출구</p>
					</div>
				</div>
			</div>
		</div>

		<div class="sb__1">
			<div class="sb__2">
				<h2>버스</h2>
			</div>
			<div class="sb">
				<div class="sb__location">
					<div class="sb__line" style="background-color: #FFFCD3">
						<p>부전시장</p>
					</div>

					<div class="sb__exit">
						<p>101-1</p>
						<p>124</p>
						<p>129-1</p>
						<p>141</p>
						<p>20</p>
					</div>
				</div>
				<div class="sb__location">
					<div class="sb__line" style="background-color: #FFFCD3">
						<p>서면역 12번출구</p>
					</div>

					<div class="sb__exit">
						<p>부산진구 12-1</p>
					</div>
				</div>

				<div class="sb__location">
					<div class="sb__line" style="background-color: #FFFCD3">
						<p>전포초등학교</p>
					</div>

					<div class="sb__exit">
						<p>20</p>
						<p>24</p>
						<p>66</p>
						<p>83</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="https://dapi.kakao.com/v2/maps/sdk.js?appkey="></script>
	</div>

<script type="text/javascript" src="/js/map.js"></script>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
