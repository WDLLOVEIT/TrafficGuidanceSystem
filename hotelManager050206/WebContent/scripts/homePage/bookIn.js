$(function(){
	$(window).load(function(){
		//入住、取消操作
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
		
		//预约入住
		$(".book_in").click(function(){
			var bookId=$(this).parent().parent().find(".bookId").html();
			location.href="bookOptionPro?option=0&&bookId="+bookId;
		});
		$(".book_cancle").click(function(){
			var bookId=$(this).parent().parent().find(".bookId").html();
			location.href="bookOptionPro?option=1&&bookId="+bookId;
		});
	});
});