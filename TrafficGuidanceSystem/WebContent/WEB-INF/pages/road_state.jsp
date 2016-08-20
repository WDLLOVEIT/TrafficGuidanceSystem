<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>实时路况</title>
<script type="text/javascript" src="js/jquery.js"></script>
<style type="text/css">
	body, html,#allmap {width: 100%;height: 100%;overflow: hidden;margin:0;font-family:"微软雅黑";}
	</style>
	<link rel="stylesheet" href="http://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.css" />
	<link href="http://api.map.baidu.com/library/TrafficControl/1.4/src/TrafficControl_min.css" rel="stylesheet" type="text/css" />
</head>

<body>
<table>
<tr>
<td>
<div id="allmap" style="width:1200px;height:500px;"></div>
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
<script type="text/javascript" src="http://api.map.baidu.com/library/TrafficControl/1.4/src/TrafficControl_min.js"></script>


<script type="text/javascript">
	// 百度地图API功能
	$(document).ready(function(){
		var point = new BMap.Point(113.65308,34.7416897);
		var map = new BMap.Map("allmap",{enableMapClick:false});    // 创建Map实例
		map.centerAndZoom(point, 11);  //初始化地图,设置中心点坐标和地图级别
		map.addControl(new BMap.MapTypeControl());   //添加地图类型控件
		map.setCurrentCity("郑州");          // 设置地图显示的城市 此项是必须设置的
		map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
		var ctrl = new BMapLib.TrafficControl({
			showPanel: false //是否显示路况提示面板
		});      
		map.addControl(ctrl);
		ctrl.setAnchor(BMAP_ANCHOR_BOTTOM_RIGHT);  
		$("#tcBtn").trigger("click");
		var geolocation = new BMap.Geolocation();
		geolocation.getCurrentPosition(function(r){
			if(this.getStatus() == BMAP_STATUS_SUCCESS){
				var mk = new BMap.Marker(r.point);
				map.addOverlay(mk);
				map.panTo(r.point);
				map.centerAndZoom(r.point, 13);
			}
			else {
				alert('failed'+this.getStatus());
			}        
		},{enableHighAccuracy: true})
		
		map.enableContinuousZoom();
		var size = new BMap.Size(60, 20);
		map.addControl(new BMap.CityListControl({
		    anchor: BMAP_ANCHOR_TOP_LEFT,
		    offset: size,
		    // 切换城市之间事件
		    // onChangeBefore: function(){
		    //    alert('before');
		    // },
		    // 切换城市之后事件
		    // onChangeAfter:function(){
		    //   alert('after');
		    // }
		}));
		
		//搜索
		function SearchControll(){
			this.defaultAnchor = BMAP_ANCHOR_TOP_LEFT;
			this.defaultOffset = new BMap.Size(600, 20);
		}
		
		SearchControll.prototype = new BMap.Control();
		SearchControll.prototype.initialize = function(map){
			var div = document.createElement("div");
			$(div).html("<span style='background-color:white;'>搜索：</span><input type='text' id='search_input'/><div id='searchResultPanel' style='border:1px solid #C0C0C0;width:150px;height:auto; display:none;'></div>");
			map.getContainer().appendChild(div);
			$("#searchResultPanel").focus(function(){
				$(this).val("");
			});
			var ac = new BMap.Autocomplete(    //建立一个自动完成的对象
					{"input" : "search_input"
					,"location" : map
				});
			  // 将DOM元素返回
			function G(id) {
				return document.getElementById(id);
			}

			ac.addEventListener("onhighlight", function(e) {  //鼠标放在下拉列表上的事件
				var str = "";
					var _value = e.fromitem.value;
					var value = "";
					if (e.fromitem.index > -1) {
						value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
					}    
					str = "FromItem<br />index = " + e.fromitem.index + "<br />value = " + value;
					
					value = "";
					if (e.toitem.index > -1) {
						_value = e.toitem.value;
						value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
					}    
					str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = " + value;
					G("searchResultPanel").innerHTML = str;
				});

			var myValue;
			ac.addEventListener("onconfirm", function(e) {    //鼠标点击下拉列表后的事件
			var _value = e.item.value;
				myValue = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
				G("searchResultPanel").innerHTML ="onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue;
				
				setPlace(myValue);
			});
	
			function setPlace(myValue){
				map.clearOverlays();    //清除地图上所有覆盖物
				function myFun(){
					var pp = local.getResults().getPoi(0).point;    //获取第一个智能搜索的结果
					map.centerAndZoom(pp, 18);
					var mark_search = new BMap.Marker(pp);
					var searchInfoWindow = null;
					var content = "";
					searchInfoWindow = new BMapLib.SearchInfoWindow(map, content, {
							title  : myValue,      //标题
							width  : 290,             //宽度
							height : 105,              //高度
							panel  : "panel",         //检索结果面板
							enableAutoPan : true,     //自动平移
							searchTypes   :[
								BMAPLIB_TAB_SEARCH,   //周边检索
								BMAPLIB_TAB_TO_HERE,  //到这里去
								BMAPLIB_TAB_FROM_HERE //从这里出发
							]
						});
					mark_search.addEventListener("click", function(e){
						searchInfoWindow.open(mark_search);
					});
					map.addOverlay(mark_search);    //添加标注
				}
				var local = new BMap.LocalSearch(map, { //智能搜索
				  onSearchComplete: myFun
				});
				local.search(myValue);
			}
			return div;
		}
		
		
		var searchCtrl = new SearchControll();
		map.addControl(searchCtrl);
	});
</script>



</body>
</html>