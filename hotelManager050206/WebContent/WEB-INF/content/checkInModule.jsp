<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!-- 功能模块 -->
<div class="show">
<div id="checkInModule" class="module">
<!-- 预约房间选择 -->
<div id="checkIn_choose">
	<!-- 查询选项 -->
	<div id="checkIn_query">
		<s:form id="checkIn_form" action="checkInPro">
			<span>入住时长（小时）：</span><input type="text" name="last" id="checkIn_last"/>
			<s:hidden value="%{#checkIn_last}" id="save_last"/>
		</s:form>
	</div>
	<hr/>
	<!-- 空房显示 -->
	<div>
		<!-- 楼层排版 -->
		<div id="room_floor">
			<span class="rf_selected">第一层</span>
			<span>第二层</span>
			<span>第三层</span>
			<span>第四层</span>
			<span>第五层</span>
			<span>第六层</span>
		</div>
		<!-- 房间信息 -->
		<div id="rb_arrow">
			<img src="images/homePage/show/icon_arrow.png"/>
		</div>
		<div id="room_inf">
			<s:iterator value="rooms" id="room">
				<s:if test="#room.floor==1">
					<div class="room room_01">
						<div>房间号：<span class="ri_id"><s:property value="#room.num"/></span></div>
						<div>房间状态：<s:property value="#room.state"/></div>
						<div>房间类型：
							<span class="ri_type"><s:property value="#session.types.get(#room.typeId-1).name"/></span>
						</div>
						<div>房间价格：
							<span class="ri_price"><s:property value="#session.types.get(#room.typeId-1).price"/></span>
						</div>
					</div>
				</s:if>
				<s:elseif test="#room.floor==2">
					<div class="room room_02">
						<div>房间号：<span class="ri_id"><s:property value="#room.num"/></span></div>
						<div>房间状态：<s:property value="#room.state"/></div>
						<div>房间类型：
							<span class="ri_type"><s:property value="#session.types.get(#room.typeId-1).name"/></span>
						</div>
						<div>房间价格：
							<span class="ri_price"><s:property value="#session.types.get(#room.typeId-1).price"/></span>
						</div>
					</div>
				</s:elseif>
				<s:elseif test="#room.floor==3">
					<div class="room room_03">
						<div>房间号：<span class="ri_id"><s:property value="#room.num"/></span></div>
						<div>房间状态：<s:property value="#room.state"/></div>
						<div>房间类型：
							<span class="ri_type"><s:property value="#session.types.get(#room.typeId-1).name"/></span>
						</div>
						<div>房间价格：
							<span class="ri_price"><s:property value="#session.types.get(#room.typeId-1).price"/></span>
						</div>
					</div>
				</s:elseif>
				<s:elseif test="#room.floor==4">
					<div class="room room_04">
						<div>房间号：<span class="ri_id"><s:property value="#room.num"/></span></div>
						<div>房间状态：<s:property value="#room.state"/></div>
						<div>房间类型：
							<span class="ri_type"><s:property value="#session.types.get(#room.typeId-1).name"/></span>
						</div>
						<div>房间价格：
							<span class="ri_price"><s:property value="#session.types.get(#room.typeId-1).price"/></span>
						</div>
					</div>
				</s:elseif>
				<s:elseif test="#room.floor==5">
					<div class="room room_05">
						<div>房间号：<span class="ri_id"><s:property value="#room.num"/></span></div>
						<div>房间状态：<s:property value="#room.state"/></div>
						<div>房间类型：
							<span class="ri_type"><s:property value="#session.types.get(#room.typeId-1).name"/></span>
						</div>
						<div>房间价格：
							<span class="ri_price"><s:property value="#session.types.get(#room.typeId-1).price"/></span>
						</div>
					</div>
				</s:elseif>
				<s:elseif test="#room.floor==6">
					<div class="room room_06">
						<div>房间号：<span class="ri_id"><s:property value="#room.num"/></span></div>
						<div>房间状态：<s:property value="#room.state"/></div>
						<div>房间类型：
							<span class="ri_type"><s:property value="#session.types.get(#room.typeId-1).name"/></span>
						</div>
						<div>房间价格：
							<span class="ri_price"><s:property value="#session.types.get(#room.typeId-1).price"/></span>
						</div>
					</div>
				</s:elseif>
			</s:iterator>
			<div id="rf_pop">
				<div class="screen"></div>
				<div class="pop">
					<img src="images/homePage/show/close.png" class="close">
					<div class="info">
					
					</div>
					<div class="btn">
						<input type="button" value="登记入住" id="rf_pop_btn" class="button"/>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- 入住表单填写 -->
<div id="checkIn_table">
	<div>
		<s:form action="checkInRegistPro">
	 	<table>
			<tr height="40px">
	                  <td width="45%" align="right">身份证号码：</td>
	                  <td><input type="text" name="customer.ic" id="ic" /></td>
	              </tr>
	        <tr height="40px">
	            <td width="45%" align="right">姓名：</td>
	            <td><input type="text" name="customer.name" id="name" /></td>
	        </tr>
			<tr height="40px">
	                  <td width="45%" align="right">电话：</td>
	                  <td><input type="text" name="customer.phone" id="phone"/></td>
	              </tr>
			<tr height="40px">
	                  <td width="45%" align="right">性别：</td>
	                  <td>
	                  	<select name="customer.sex">
		                  	<option value="true">男</option>
		                  	<option value="false">女</option>
		              	</select>
		              </td>
	              </tr>
			<tr height="40px">
	                  <td width="45%" align="right">房间编号：</td>
	                  <td><input type="text" name="roomId" id="roomId"/></td>
	              </tr>
			<tr height="40px">
	                  <td width="45%" align="right">入住时间：</td>
	                  <td><input type="text" name="intime" id="intime" /></td>
	              </tr>
	       <tr height="40px">
	                  <td width="45%" align="right">入住时长：</td>
	                  <td><input type="text" name="last" id="last" /></td>
	              </tr>
	        		<tr height="40px">
	                  <td width="45%" align="right">房间类型：</td>
	                  <td><input type="text" disabled="disabled" id="typeName"  /></td>
	              </tr>
			<tr height="40px">
	            <td width="45%" align="right">房间价格：</td>
	            <td><input type="text" disabled="disabled" id="typePrice"/></td>
	        </tr>
		</table>
		<div id="bt_btn">
		    <input type="submit" value="保存 " class="button" id="bt_save"/>
		    <input type="button" value="返回" class="button" id="bt_back"/>
		</div>
		</s:form>
	</div>
</div>
</div>
</div>