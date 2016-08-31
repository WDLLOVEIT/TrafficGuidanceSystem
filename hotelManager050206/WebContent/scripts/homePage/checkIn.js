$(function(){
	$(window).load(function(){
		//预约成功弹窗
		if($("#tip").val()=="入住成功！"){
			alert($("#tip").val());
		}
		
		//设置左侧选项栏默认选项
		var $module0=$("#content .leftFrame .module:eq(1)");
		$module0.addClass("frame_selected").css({background:"rgb(20,120,170)"});
		$module0.find("dd").show();
		$module0.find("dt .arrow")
			.prop("src","images/homePage/leftFrame/frame_icon_down.png");
		//用户预约时间暂存
		var save_last=$("#save_last").val();
		
		if(checkIn_last!=undefined){
			$("#checkIn_last").val(save_last);
		}
		$("#checkIn_form input").each(function(){
			$(this).change(function(){
				var flag=true;
				$("#checkIn_last").each(function(){
					if($(this).val()==""){
						flag=false;
						return false;
					}
				});
				if(flag){
					$("#checkIn_form").trigger("submit");
				}
			});
		});
		//楼层选择按钮
		$("#room_floor span").mouseenter(function(){
			if(!$(this).hasClass("rf_selected")){
				$("#room_floor span").each(function(){
					if($(this).hasClass("rf_selected")){
						var index=$("#room_floor span").index($(this));
						$("#room_floor span:eq("+index+")")
							.removeClass("rf_selected").css({background:"rgb(10,160,220)",color:"white"});
						$("#room_inf .room_0"+(index+1)).hide();
						$("#room_inf").css("opacity","0");
					}
				});
				$(this).addClass("rf_selected")
					.css({background:"white",color:"rgb(10,160,220)"});
				var index=$("#room_floor span").index($(this));
				$("#room_inf .room_0"+(index+1)).css({display:"inline-block",opacity:"0"})
					.animate({opacity:"1"},500);
				$("#rb_arrow").css("left",(100+100*index)+"px");
				if(!$("#room_inf").is(":animated")){
					$("#room_inf").animate({opacity:"1"},300);
				}
			}
		});
		var ri_inf=null;
		//楼层信息弹窗
		$("#room_inf .room").mouseenter(function(){
			$(this).css({background:"white",color:"rgb(10,160,220)"});
		}).mouseleave(function(){
			$(this).css({background:"rgb(10,160,220)",color:"white"});
		}).click(function(){
			$("#rf_pop").show(500).find(".pop .info").append($(this).html());
			//填写房间信息到表单
			ri_inf=$(this).find(".ri_id").html();
			$("#roomId").val(ri_inf);
			ri_inf=$(this).find(".ri_type").html();
			$("#typeName").val(ri_inf);
			ri_inf=$(this).find(".ri_price").html();
			$("#typePrice").val(ri_inf);
		});
		$("#rf_pop .pop .close").click(function(){
			$("#rf_pop").hide().find(".pop .info").html("");
		});
		//预约按钮事件
		$("#rf_pop_btn").click(function(){
			$("#checkIn_choose").hide();
			$("#checkIn_table").show(300);
			
			//填写表单默认输入
			$("#last").val($("#checkIn_last").val());
			var date=new Date();
			$("#intime").val(date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate());
			
		});
		//浮动弹窗设置
		var pop_top=$("#rf_pop .pop").offset().top;
		$(window).scroll(function(){
			var scrollTop=$(this).scrollTop();
			if($("#rf_pop").prop("display")==undefined){
				$("#rf_pop .pop").css({"top":(80+pop_top+scrollTop)+"px"});
			}
		});
		
		/*预约表单提交*/
		$("#bt_back").click(function(){
			$("#checkIn_choose").show(300);
			$("#checkIn_table").hide();
		});
		
		/*预约表单提交*/
		var save_flag=true;
		/*表单自动生成*/
		$("#ic").blur(function(){
			var ic_val=$(this).val();
			if(ic_val!=""){
				//检测身份证格式是否正确
				if(ic_val.length!=18){
					$("#id_tip").remove();
					var $input_tip=$("<span class='tip' id='id_tip'>" +
						"身份证格式不正确</span>");
					$(this).after($input_tip);
					regist_flag=false;
				}else{
					$("#id_tip").remove();
					regist_flag=true;
				$.ajax({
					type:"POST",
					url:"autoCompletePro",
					data:{
						ic:ic_val,
					},
					success:function(data,statusText){
						if(data!=" "){
							var complete=data.split('@');
							$("#name").val(complete[0]);
							$("#phone").val(complete[1]);
							$("#sex").val(complete[2]);
							$(".tip").remove();
						}else{
							$("#name").val("");
							$("#phone").val("");
							$("#sex").val("");
							$(".tip").remove();
						}
					}
				});
				}
			}else{
				$("#id_tip").remove();
				var $input_tip=$("<span class='tip' id='id_tip'>" +
					"身份证不能为空</span>");
				$(this).after($input_tip);
				regist_flag=false;
			}
		});
		/*检测姓名格式是否正确*/
		$("#name").blur(function(){
			var name=$(this).val();
			//姓名不为空
			if(name==""){
				$("#name_tip").remove();
				var $input_tip=$("<span class='tip' id='name_tip'>" +
					"姓名不能为空</span>");
				$(this).after($input_tip);
				regist_flag=false;
			}else{
				$("#name_tip").remove();
				regist_flag=true;
				//姓名为英文名
				var checkNum=/^[A-Za-z]+$/;
				if(!checkNum.test(name)){
					//姓名为中文名
					var checkNum=/^[\u4e00-\u9fa5]+$/;
					if(!checkNum.test(name)){
						$("#name_tip").remove();
						var $input_tip=$("<span class='tip' id='name_tip'>" +
							"姓名格式不正确</span>");
						$(this).after($input_tip);
						regist_flag=false;
					}else{
						$("#name_tip").remove();
						regist_flag=true;
					}
				}else{
					$("#name_tip").remove();
					regist_flag=true;
				}
			}
		});
		/*检测手机号是否正确*/
		$("#phone").blur(function(){
			var phone=$(this).val();
			if(phone==""){
				$("#phone_tip").remove();
				var $input_tip=$("<span class='tip' id='phone_tip'>" +
					"手机号不能为空</span>");
				$(this).after($input_tip);
				regist_flag=false;
			}else{
				regist_flag=true;
				//检测手机号格式是否正确
				var checkNum=/^[1][0-9]{10}$/;
				if(!checkNum.test(phone)){
					$("#phone_tip").remove();
					var $input_tip=$("<span class='tip' id='phone_tip'>" +
					"手机号格式不正确</span>");
					$("#phone").after($input_tip);
					regist_flag=false;
				}else{
					$("#phone_tip").remove();
					regist_flag=true;
				}
			}
		});
		
		$("#bt_save").click(function(){
			//检测各项内容是否为空
			$("#book_table table input").each(function(){
				if($(this).val()==""){
					save_flag=false;
					return false;
				}
			});
			if(save_flag==false){
				return false;
			}
		});
	});
});