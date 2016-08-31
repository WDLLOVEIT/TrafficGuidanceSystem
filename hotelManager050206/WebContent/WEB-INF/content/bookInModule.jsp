<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!-- 功能模块 -->
<div class="show">
<div id="bookInModule" class="module">
	<div id="book_query">
			<form id="query_form" action="bookQueryPro">
			   <span>请选择查询条件:<select name="condition" id="query_condition">
			    	<option value='1' selected>预约号 </option>		   
			    	<option value='2'>客户身份证号</option>		   
			   	 	</select>
			    	<input type="text" name="value" id="query_value"/>&nbsp;&nbsp;
			    </span>
			</form>
		</div>
	<table class="tablelist" width="100%">
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
                   <th width="7%">入住</th> 
                   <th width="7%">取消</th>          
               </tr>
               <s:iterator value="books" id="book">
               	<tr>
               		<td><span class="bookId"><s:property value="#book.id"/></span></td>
               		<td><s:property value="#session.customers.get(#book.customerId-1).name"/></td>
               		<td><s:property value="#session.customers.get(#book.customerId-1).ic"/></td>
               		<td><s:property value="#session.customers.get(#book.customerId-1).phone"/></td>
               		<td><s:date name="#book.time" format="yyyy-MM-dd"/></td>
               		<td><s:date name="#book.start" format="yyyy-MM-dd"/></td>
               		<td><s:date name="#book.leave" format="yyyy-MM-dd"/></td>
               		<td><s:property value="#session.rooms.get(#book.roomId-1).num"/></td>
               		<td><s:property value="#session.types.get(#session.rooms.get(#book.roomId-1).typeId-1).name"/></td>
               		<td><s:property value="#session.types.get(#session.rooms.get(#book.roomId-1).typeId-1).price"/></td>
               		<td><input type="button" value="入住" class="bi_btn book_in"/></td>
               		<td><input type="button" value="取消" class="bi_btn book_cancle"/></td>
               	</tr>
               </s:iterator>
           </thead>
       </table>
</div>
</div>