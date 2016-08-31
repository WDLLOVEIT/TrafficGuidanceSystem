<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>入住登记</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="scripts/jquery.js"></script>
<link rel="stylesheet" href="styles/homePage/checkOut.css" type="text/css"/>
<link rel="stylesheet" href="styles/homePage/leftFrame.css" type="text/css"/>
<script src="scripts/homePage/leftFrame.js" type="text/javascript"></script>
<script src="scripts/homePage/checkOut.js" type="text/javascript"></script>
</head>
<body>
<s:hidden value="%{#tip}" id="tip"/>
<!-- 页面头部 -->
<div id="header">
	<!-- 标题 -->
	<div class="title">
		酒店管理系统
	</div>
</div>
<!-- 页面主体 -->
<div id="content">
<!-- 左侧工具栏 -->
<jsp:include page="leftFrame.jsp"/>
<!-- 退房登记模块 -->
<jsp:include page="checkOutModule.jsp"/>
</div> 
<!-- 页面注脚 -->
<div id="footer">

</div>
</body>
</html>