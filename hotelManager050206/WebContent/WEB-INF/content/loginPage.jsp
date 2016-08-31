<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

    <head>    
        <title>登录</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
        <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
        <meta name="author" content="Codrops" />
<link rel="shortcut icon" href="../favicon.ico"> 
<link rel="stylesheet" type="text/css" href="styles/demo.css" />
<link rel="stylesheet" type="text/css" href="styles/style2.css" />
<link rel="stylesheet" type="text/css" href="styles/animate-custom.css" />
<script src="scripts/jquery.js" type="text/javascript"></script>
<script src="scripts/jquery-ui.js" type="text/javascript"></script>
<script src="scripts/loginPage.js" type="text/javascript"></script>
    </head>
    <body>
       
   <div id="header">
   <!-- 标题 -->
	<div class="title">
		酒店管理系统
	</div>
   </div>
			<section>				
                <div id="container_demo" >
                    <!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                    <div id="wrapper">
                        <div id="login" class="animate form">
                            <form  action="loginPro" autocomplete="on" method="post"> 
                                <h1>管理员登录</h1> 
                                <p class="tip"><s:property value="#tip"/></p>
                                <p> 
                                    <label for="userName" class="uname"> 用户名: </label>
                                    <input id="userName" name="userName" type="text"/>
                                </p>
                                <p> 
                                    <label for="password" class="youpasswd"> 密&nbsp;&nbsp;&nbsp;&nbsp;码: </label>
                                    <input id="password" name="password" required="required" type="password"   /> 
                                </p>                                
                                <p class="login button"> 
                                    <input type="submit" value="登录" /> 
								</p>
                            </form>
                        </div>
                    </div>
                </div>  
            </section>
			<div style="text-align:center;clear:both">
</div>	
        </div>
    </body>
</html>
