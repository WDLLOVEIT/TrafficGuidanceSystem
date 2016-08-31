<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 功能模块 -->
<div class="show">
<div id="customerInfModule" class="module">
	<table class="tablelist"  width="100%">
           <thead>
               <tr>             
                   <th width="5%">客户id</th>
                   <th width="10%">客户姓名</th>
                    <th width="10%">客户性别</th>
                   <th width="12%">客户身份证号</th>
                   <th width="12%">客户手机号</th>                        
               </tr>
               <s:iterator value="customers" id="customer">
               	<tr>
               		<td><s:property value="#customer.id"/></td>
               		<td><s:property value="#customer.name"/></td>
               		<s:if test="#customer.sex==true">
               		<td>男</td>
               		</s:if>
               		<s:else>
               		<td>女</td>
               		</s:else>
               		<td><s:property value="#customer.ic"/></td>
               		<td><s:property value="#customer.phone"/></td>            
               	</tr>
               </s:iterator>
           </thead>
       </table>
</div>
</div>