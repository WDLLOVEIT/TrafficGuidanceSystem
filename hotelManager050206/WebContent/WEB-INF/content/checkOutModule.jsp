<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!-- 功能模块 -->
<div class="show">
<div id="bookInModule" class="module">
	<div id="book_query">
			<form id="query_form" action="ioQueryPro">
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
                   <th width="5%">入住号</th>
                   <th width="10%">客户姓名</th>
                   <th width="12%">客户身份证号</th>
                   <th width="12%">客户手机号</th>             
                   <th width="12%">入住时间</th>
                   <th width="7%">入住时长(小时)</th>
                   <th width="7%">入住房间号</th>
                   <th width="7%">入住房间类型</th>
                   <th width="7%">入住房间价格</th>  
                   <th width="7%">退房</th> 
                   <th width="14%">续住(天)</th>          
               </tr>
               <s:iterator value="ios" id="io">
               	<tr>
               		<td><span class="ioId"><s:property value="#io.id"/></span></td>
               		<td><s:property value="#session.customers.get(#io.customerId-1).name"/></td>
               		<td><s:property value="#session.customers.get(#io.customerId-1).ic"/></td>
               		<td><s:property value="#session.customers.get(#io.customerId-1).phone"/></td>
               		<td><s:date name="#io.intime" format="yyyy-MM-dd"/></td>
               		<td><s:property value="#io.last"/></td>
               		<td><s:property value="#session.rooms.get(#io.roomId-1).num"/></td>
               		<td><s:property value="#session.types.get(#session.rooms.get(#io.roomId-1).typeId-1).name"/></td>
               		<td><s:property value="#session.types.get(#session.rooms.get(#io.roomId-1).typeId-1).price"/></td>
               		<td><input type="button" value="退房" class="bi_btn io_out"/></td>
               		<td><select class="renew_value">
               			<option>1</option><option>2</option><option>3</option><option>4</option><option>5</option><option>6</option><option>7</option>
               		</select>
               		<input type="button" value="确认" class="bi_btn io_renew"/></td>
               	</tr>
               </s:iterator>
           </thead>
       </table>
</div>
</div>