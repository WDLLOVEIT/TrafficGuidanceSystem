<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>报表统计</title>
<link rel="stylesheet" href="styles/homePage/report.css" type="text/css"/>
<link rel="stylesheet" href="styles/homePage/leftFrame.css" type="text/css"/>
<script src="scripts/jquery.js" type="text/javascript"></script>
<script src="scripts/jquery-ui.js" type="text/javascript"></script>
<script src="scripts/homePage/leftFrame.js" type="text/javascript"></script>
<script src="scripts/homePage/report.js" type="text/javascript"></script>
<head/>
<body>
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
	<!-- 功能模块 -->
	<div class="show">
	<div id="book_query">
			<form id="book_form" action="file:///C|/Documents and Settings/Administrator/桌面/homePagePro">
			   <span>请选择查询条件:<select name="s1">
			    <option vlaue='001' selected>今日报表 </option>
			    <option vlaue='002'>本月报表 </option>
			    <option vlaue='003'>季度报表</option>
			    <option vlaue='004'>年度报表</option>
			    </select>          
			    </span>
			</form>
		</div>
	<table class="tablelist"  width="100%">
                <thead>
                    <tr>               
                        <th width="15%">报表编号</th>
                        <th width="18%">报表日期</th>
                        <th width="18%">预约订单数</th>
                        <th width="18%">直接入住总数</th>                  
                        <th width="15%">营业额</th>                         
                    </tr>
					<s:iterator value="reports" id="report">
						<tr>
							<td><s:property value="#report.id"/></td>
							<td><s:date name="#report.date" format="yyyy-MM-dd"/></td>
							<td><s:property value="#report.ordersum"/></td>
							<td><s:property value="#report.checkin"/></td>
							<td><s:property value="#report.income"/></td>				
						</tr>
					</s:iterator>
                </thead>
            </table>       
	</div>
</div>
</body>
</html>