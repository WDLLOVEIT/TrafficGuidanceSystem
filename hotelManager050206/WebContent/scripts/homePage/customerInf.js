$(function(){
	$(window).load(function(){
		//设置左侧选项栏默认选项
		var $module0=$("#content .leftFrame .module:eq(2)");
		$module0.addClass("frame_selected").css({background:"rgb(20,120,170)"});
		$module0.find("dd").show();
		$module0.find("dt .arrow")
			.prop("src","images/homePage/leftFrame/frame_icon_down.png");
	});
});