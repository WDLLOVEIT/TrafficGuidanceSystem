<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>周边搜索</title>
<script type="text/javascript" src="js/jquery.js"></script>
<style type="text/css">
	body, html,#allmap {width: 100%;height: 100%;overflow: hidden;margin:0;font-family:"微软雅黑";}
	</style>
	<link rel="stylesheet" href="http://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.css" />
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

<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=ANlStFNjxeSILeGMIUq7mpwH"></script>	
<script type="text/javascript" src="http://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.js"></script>



<script type="text/javascript">
	// 百度地图API功能
	$(document).ready(function(){
		var point = new BMap.Point(113.65308,34.7416897);
		var map = new BMap.Map("map",{enableMapClick:false});    // 创建Map实例
		map.centerAndZoom(point, 11);  //初始化地图,设置中心点坐标和地图级别
		map.addControl(new BMap.MapTypeControl());   //添加地图类型控件
		map.setCurrentCity("郑州");          // 设置地图显示的城市 此项是必须设置的
		map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
		var top_right_navigation = new BMap.NavigationControl({anchor: BMAP_ANCHOR_TOP_RIGHT, type: BMAP_NAVIGATION_CONTROL_SMALL});
		//map.addControl(top_right_navigation); 
		//定位
		var navigationControl = new BMap.NavigationControl({
		    // 靠左上角位置
		    anchor: BMAP_ANCHOR_TOP_LEFT,
		    // LARGE类型
		    type: BMAP_NAVIGATION_CONTROL_LARGE,
		    // 启用显示定位
		    enableGeolocation: true
		  });
		  map.addControl(navigationControl);
		  // 添加定位控件
		  var geolocationControl = new BMap.GeolocationControl();
		  geolocationControl.addEventListener("locationSuccess", function(e){
		    // 定位成功事件
		    var address = '';
		    address += e.addressComponent.province;
		    address += e.addressComponent.city;
		    address += e.addressComponent.district;
		    address += e.addressComponent.street;
		    address += e.addressComponent.streetNumber;
		    //alert("当前定位地址为：" + address);
		  });
		  geolocationControl.addEventListener("locationError",function(e){
		    // 定位失败事件
		    alert(e.message);
		  });
		map.addControl(geolocationControl);
		var geolocation = new BMap.Geolocation();
		geolocation.getCurrentPosition(function(r){
			if(this.getStatus() == BMAP_STATUS_SUCCESS){
				var mk = new BMap.Marker(r.point);
				var searchInfoWindow = null;
				var content = "";
				searchInfoWindow = new BMapLib.SearchInfoWindow(map, content, {
						title  : '我的位置',      //标题
						width  : 290,             //宽度
						height : 105,              //高度
						panel  : "panel",         //检索结果面板
						enableAutoPan : true,     //自动平移
						searchTypes   :[
							BMAPLIB_TAB_SEARCH,   //周边检索
						]
					});
				mk.addEventListener("click", function(e){
					searchInfoWindow.open(mk);
				});
				map.addOverlay(mk);
				map.panTo(r.point);
				map.centerAndZoom(r.point, 18);
			}
			else {
				alert('failed'+this.getStatus());
			}        
		},{enableHighAccuracy: true})
		
	});
</script>



</body>
</html>