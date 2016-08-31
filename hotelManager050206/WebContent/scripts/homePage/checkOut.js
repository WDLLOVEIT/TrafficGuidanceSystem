$(function(){
	$(window).load(function(){
		//操作成功弹窗
		if($("#tip").val()!=""){
			alert($("#tip").val());
		}
		
		//设置左侧选项栏默认选项
		var $module0=$("#content .leftFrame .module:eq(1)");
		$module0.addClass("frame_selected").css({background:"rgb(20,120,170)"});
		$module0.find("dd").show();
		$module0.find("dt .arrow")
			.prop("src","images/homePage/leftFrame/frame_icon_down.png");
		
		//精确查询提交
		$("#query_value").change(function(){
			var value=$(this).val();
			if(value!=""){
				$("#query_form").trigger("submit");
			}
		});
		
		//退房续住
		$(".io_out").click(function(){
			var ioId=$(this).parent().parent().find(".ioId").html();
			location.href="ioOptionPro?option=0&&ioId="+ioId;
		});
		$(".io_renew").click(function(){
			var ioId=$(this).parent().parent().find(".ioId").html();
			location.href="ioOptionPro?option=1&&ioId="+ioId+"&&value="+$(".renew_value").val();
		});
	});
});