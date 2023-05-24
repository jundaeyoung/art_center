<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<style>
h1 {
	text-align: center;
}

.map__all {
	border-bottom: 2px solid black;
	margin-bottom: 10px;
}
.container {
	margin-top: 100px;
	height: 800px;
}

.map__btn {
	display: flex;
    justify-content: center;
    align-items: center;
	background-color: #fff;
	border: 1px solid #ccc;
	margin: 30px;
	width: 200px;
}

.map__info {
	display: flex;
	justify-content: space-between;
	margin-bottom: 10px;
	border: 1px solid #ccc;
}

.address, .building {
	margin: 10px;

}

.info {
	margin: 20px;
}
</style>
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
		<div class="map__btn" >
			<a  href="https://map.kakao.com/link/to/아마데우스, 35.159573, 129.060249">아마데우스 찾아오기</a>
	</div>
	</div>
	</div>
	<div id="map" style="width: 100%; height: 500px;"></div>
	<script type="text/javascript"
		src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=?"></script>
	<script>
		let container = document.getElementById('map');
		let options = {
			center : new kakao.maps.LatLng(35.159573, 129.060249),
			level : 3
		};

		let map = new kakao.maps.Map(container, options);

/* 		map.addOverlayMapTypeId(kakao.maps.MapTypeId.ROADVIEW);
 */
		let zoomControl = new kakao.maps.ZoomControl();
		map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

		kakao.maps.event.addListener(map, 'zoom_changed', function() {
			let level = map.getLevel();

		});

		let marker = new kakao.maps.Marker({
			position : map.getCenter()

		});

		marker.setMap(map);

		let iwContent = '<div style="padding:5px;">아마데우스</div>';
		let infowindow = new kakao.maps.InfoWindow({
			content : iwContent
		});

		kakao.maps.event.addListener(marker, 'mouseover', function() {
			infowindow.open(map, marker);
		});

		kakao.maps.event.addListener(marker, 'mouseout', function() {
			infowindow.close();
		});
	</script>
</div>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
