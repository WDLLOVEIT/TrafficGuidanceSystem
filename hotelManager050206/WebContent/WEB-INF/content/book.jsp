<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link rel="stylesheet" href="styles/homePage/book.css" type="text/css"/>
<link rel="stylesheet" href="styles/homePage/leftFrame.css" type="text/css"/>
<script src="scripts/jquery.js" type="text/javascript"></script>
<script src="scripts/jquery-ui.js" type="text/javascript"></script>
<script src="scripts/homePage/leftFrame.js" type="text/javascript"></script>
<script src="scripts/homePage/book.js" type="text/javascript"></script>
</head>
<body>
<s:hidden value="%{#tip}" id="tip"/>
<!-- 网页头部 -->
<div id="header">
	<!-- 标题 -->
	<div class="title">
		酒店管理系统
	</div>
</div>
<!-- 网页主体 -->
<div id="content">
	<!-- 左侧工具栏 -->
	<jsp:include page="leftFrame.jsp"/>
	<!-- 预约模块 -->
	<jsp:include page="bookModule.jsp"/>
</div>
</body>
</html>