<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!-- 左侧工具栏 -->
	<div class="leftFrame">
		<!-- 预约房间 -->
		<dl class="module">
			<dt><img src="images/homePage/leftFrame/frame_introduction.png" class="icon"/>
				预约房间
				<img class="arrow"/>
			</dt>
			<dd><a href="bookPro">预约登记</a></dd>
		</dl>
		<!-- 入住登记 -->
		<dl class="module">
			<dt><img src="images/homePage/leftFrame/frame_news.png" class="icon"/>
				出入登记
				<img class="arrow"/>
			</dt>
			<dd><a href="checkInPro">直接入住</a></dd>
			<dd><a href="bookInPro">预约入住</a></dd>
			<dd><a href="checkOutPro">登记退房</a></dd>
		</dl>
		<!-- 客户管理 -->
		<dl class="module">
			<dt><img src="images/homePage/leftFrame/frame_product.png" class="icon"/>
				客户管理
				<img class="arrow"/>
			</dt>
			<dd><a href="customerPro">客户信息</a></dd>
		</dl>
		<!-- 记录查询 -->
		<dl class="module">
			<dt><img src="images/homePage/leftFrame/frame_technology.png" class="icon"/>
				记录查询
				<img class="arrow"/>
			</dt>
			<dd><a href="recordsQueryPro?state=0">预约记录</a></dd>
			<dd><a href="recordsQueryPro?state=1">出入记录</a></dd>
		</dl>
		<!-- 报表统计 -->
		<dl class="module">
			<dt><img src="images/homePage/leftFrame/frame_recurit.png" class="icon"/>
				报表统计
				<img class="arrow"/>
			</dt>
			<dd><a href="reportPro">今日报表</a></dd>
			<dd><a href="#">本月报表</a></dd>
			<dd><a href="#">季度报表</a></dd>
			<dd><a href="#">年度报表</a></dd>
		</dl>
	</div>