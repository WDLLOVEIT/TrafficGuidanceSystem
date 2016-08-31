<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="x" uri="/www.11fit.com/tag" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>预约记录</title>
<link rel="stylesheet" href="styles/homePage/leftFrame.css" type="text/css"/>
<link rel="stylesheet" href="styles/homePage/bookRecords.css" type="text/css"/>
<script src="scripts/jquery.js" type="text/javascript"></script>
<script src="scripts/jquery-ui.js" type="text/javascript"></script>
<script src="scripts/homePage/leftFrame.js" type="text/javascript"></script>
<script src="scripts/homePage/bookRecords.js" type="text/javascript"></script>
<script src="scripts/jquery.js" type="text/javascript"></script>
<script src="scripts/jquery-ui.js" type="text/javascript"></script>
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
			<form id="query_form" action="recordsQueryPro?state=0">
			   <span>请选择查询条件:<select name="condition" id="query_condition">
			    <option value='1' selected>预约号 </option>
			    <option value='2'>客户姓名 </option>
			     <option value='3'>客户身份证号</option>
			    <option value='4'>客户手机号</option>
			    <option value='5'>预约时间</option>
			    <option value='6'>预约入住时间 </option>
			    <option value='7'>预约退房时间 </option>
			    <option value='8'>预约房间号 </option>
			    </select>
			    <input type="text" name="value" id="query_value"/>&nbsp;&nbsp;
			    </span>
			</form>
		</div>
	<table class="tablelist"  width="80%">
           <thead>
               <tr>            
                   <th width="5%">预约号</th>
                   <th width="10%">客户姓名</th>
                   <th width="12%">客户身份证号</th>
                   <th width="12%">客户手机号</th>
                   <th width="12%">预约时间</th>
                   <th width="12%">预约入住时间</th>
                   <th width="12%">预约退房时间</th>
                   <th width="7%">预约房间号</th>
                   <th width="7%">预约房间类型</th>
                   <th width="7%">预约房间价格</th>  
                   <th width="7%">预约状态</th> 
               </tr>
               <s:iterator value="books" id="book">
               	<tr>
               		<td><s:property value="#book.id"/></td>
               		<td><s:property value="#session.customers.get(#book.customerId-1).name"/></td>
               		<td><s:property value="#session.customers.get(#book.customerId-1).ic"/></td>
               		<td><s:property value="#session.customers.get(#book.customerId-1).phone"/></td>
               		<td><s:date name="#book.time" format="yyyy-MM-dd"/></td>
               		<td><s:date name="#book.start" format="yyyy-MM-dd"/></td>
               		<td><s:date name="#book.leave" format="yyyy-MM-dd"/></td>
               		<td><s:property value="#session.rooms.get(#book.roomId-1).num"/></td>
               		<td><s:property value="#session.types.get(#session.rooms.get(#book.roomId-1).typeId-1).name"/></td>
               		<td><s:property value="#session.types.get(#session.rooms.get(#book.roomId-1).typeId-1).price"/></td>
               		<s:if test="#book.flag==0">
               			<td>未完成</td>
               		</s:if>
               		<s:elseif test="#book.flag==1">
               			<td>已入住</td>
               		</s:elseif>
               		<s:else>
               			<td>已取消</td>
               		</s:else>
               	</tr>
               </s:iterator>
           </thead>
       </table>
	</div>
</div>
</body>
</html>