<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<style>
.container {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	margin-top: 100px;
	height: 800px;
	margin-top: 100px;
}

</style>

<div class="container">
	<div id="map" style="width: 500px; height: 400px;"></div>
	<h1>여기는 지도자리에요</h1>
	<script type="text/javascript"
		src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=66a490fb84d5c8cb6c3fd0e7f1765d51"></script>
	<script>
		let container = document.getElementById('map');
		let options = {
			center : new kakao.maps.LatLng(35.159573, 129.060249),
			level : 3
		};

		let map = new kakao.maps.Map(container, options);

		let zoomControl = new kakao.maps.ZoomControl();
		map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

		kakao.maps.event.addListener(map, 'zoom_changed', function(){
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
