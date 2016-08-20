<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery.js"></script>
<link rel="stylesheet" href="http://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.css" />
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=ANlStFNjxeSILeGMIUq7mpwH"></script>
<script type="text/javascript" src="http://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.js"></script>
<title>系统主页</title>
</head>

<body>
<table>
<tr>
<td>
<div id="map" style="width:1200px;height:500px;"></div>
</td>


<td>
<div>
	<button onclick="window.location.href='arroundSearch'"><h2>周边搜索</h2></button>
	<br><br><br>
	<button onclick="window.location.href='guidence'"><h2>开始导航</h2></button>
	<br><br><br>
	<button onclick="window.location.href='roadState'"><h2>实时路况</h2></button>
	<br><br><br>
	<button onclick="window.location.href='quit'"><h2>退出系统</h2></button>
</div>
</td>
</tr>
</table>




<script type="text/javascript">
	// 百度地图API功能
	$(document).ready(function(){
		var point = new BMap.Point(113.65308,34.7416897);
		var map = new BMap.Map("map",{enableMapClick:false});    // 创建Map实例
		map.centerAndZoom(point, 11);  //初始化地图,设置中心点坐标和地图级别
		map.addControl(new BMap.MapTypeControl());   //添加地图类型控件
		map.setCurrentCity("郑州");          // 设置地图显示的城市 此项是必须设置的
		map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
		var geolocation = new BMap.Geolocation();//获取当前位置
		geolocation.getCurrentPosition(function(r){
			if(this.getStatus() == BMAP_STATUS_SUCCESS){
				var mk = new BMap.Marker(r.point);
				var geoc = new BMap.Geocoder();
				map.addOverlay(mk);
				geoc.getLocation(r.point, function(rs){
					var addComp = rs.addressComponents;
					var address = "当前位置："+addComp.province + " " + addComp.city + " " + addComp.district + " " + addComp.street + " " + addComp.streetNumber;
					var label = new BMap.Label(address,{offset:new BMap.Size(-60,-20)});
					mk.setLabel(label);
				});        
				map.panTo(r.point);
				map.centerAndZoom(r.point, 18);
			}
			else {
				alert('failed'+this.getStatus());
			}        
		},{enableHighAccuracy: true});
		
	});
	

</script>


</body>
</html>