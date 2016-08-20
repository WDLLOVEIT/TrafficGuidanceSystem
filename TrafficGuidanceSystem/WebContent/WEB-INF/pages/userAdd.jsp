<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>用户注册</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<style>
body{height:100%;background:#16a085;overflow:hidden;}
canvas{z-index:-1;position:absolute;}
</style>
<script src="js/jquery.js"></script>
<script src="js/verificationNumbers.js"></script>
<script src="js/Particleground.js"></script>
<script>
$(document).ready(function() {
  //粒子背景特效
  $('body').particleground({
    dotColor: '#5cbdaa',
    lineColor: '#5cbdaa'
  });
  //验证码
  createCode();
  $(".submit_btn").click(function(){
	  if($(":input[name='admin.account']").val()==""){
		  	alert($(":input[name='admin.account']").attr("placeholder"));
			$(":input[name='admin.account']").attr("placeholder","请输入账号");
		  	return false;
	  }
	  if($(":input[name='admin.pw']").val()==""){
			$(":input[name='admin.pw']").attr("placeholder","请输入密码");
		  	return false;
	  }
	  if(validate()){
		  return true;
	  }
	  return false;
	  }); 
});
</script>
</head>
<body>
<form action="userAction" method="post">
	<dl class="admin_login">
	 <dt>
	  <strong>用户注册系统</strong>
	  <em>usersRegister System</em>
	 </dt>
	 <dd class="user_icon">
	  <input type="text" placeholder="账号" class="login_txtbx" name="user.userName"/>
	 </dd>
	 <dd class="pwd_icon">
	  <input type="password" placeholder="密码" class="login_txtbx" name="user.passWord"/>
	 </dd>
	 <dd class="val_icon">
	  <div class="checkcode">
	    <input type="text" id="J_codetext" placeholder="验证码" maxlength="4" class="login_txtbx">
	    <canvas class="J_codeimg" id="myCanvas" onclick="createCode()">对不起，您的浏览器不支持canvas，请下载最新版浏览器!</canvas>
	  </div>
	  <input type="button" value="验证码核验" class="ver_btn" onClick="validate();">
	 </dd>
	 <dd>
	  	<div id="message"><font color="red"><s:property value="exception.message"/></font></div>
	 </dd>
	 <dd>
	  	<input type="submit" value="立即注册" class="submit_btn"/>
	 </dd>
	 
	</dl>
</form>
</body>
</html>