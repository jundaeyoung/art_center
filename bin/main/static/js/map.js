/**
 * 김미정
 */

let container = document.getElementById('map');
let options = {
	center: new kakao.maps.LatLng(35.159573, 129.060249),
	level: 3
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
	position: map.getCenter()

});

marker.setMap(map);

let iwContent = '<div style="padding:5px;">아마데우스</div>';
let infowindow = new kakao.maps.InfoWindow({
	content: iwContent
});

kakao.maps.event.addListener(marker, 'mouseover', function() {
	infowindow.open(map, marker);
});

kakao.maps.event.addListener(marker, 'mouseout', function() {
	infowindow.close();
});



function goMap() {
	location.href = "https://map.kakao.com/link/to/아마데우스, 35.159573, 129.060249"
}





