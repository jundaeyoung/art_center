<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
여기는 지도자리에요 dd

<div id="map" style="width:500px;height:400px;"></div>
	<script type="text/javascript" src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=66a490fb84d5c8cb6c3fd0e7f1765d51"></script>
	<script>
		var container = document.getElementById('map');
		var options = {
			center: new kakao.maps.LatLng(35.164157, 129.059295), 
			level: 3
		};

		var map = new kakao.maps.Map(container, options);
	</script>
</body>
</html>
