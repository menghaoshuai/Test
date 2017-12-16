<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9"> 
<title>永清智能机器人管理后台</title>
<link href="../../css/yongqinghuji/public.css" rel="stylesheet" type="text/css" />
<link href="../../css/yongqinghuji/gonggao.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../../js/yongqinghuji/jquery.min.js"></script>
<script type="text/javascript" src="../../js/yongqinghuji/index.js"></script>
<script type="text/javascript" src="../../js/yongqinghuji/jquery.page.js"></script>
<script type="text/javascript" src="../../js/yongqinghuji/search_list.js"></script>
</head>
<body>
<!--[if lt IE 9]>  
	<script type="text/javascript" src="../../js/yongqinghuji/PIE.js"></script>
<![endif]-->
		<div id="dcWrap">
			<jsp:include page="public.jsp" flush="true" />
			<div class="left_active">查询管理</div>
		</div>
		<div id="dcMain">
			<!-- 当前位置 -->
			<div id="urHere">永清智能机器人管理后台 >查询管理 >查询功能列表</div>
			<div id="index" class="mainBox" style="padding-top: 18px">
				<div id="douApi"></div>
				<div class="indexBox">
					<div class="cont_head main">
						<h3>查询功能列表</h3>
					</div>
					<div class="main li_p">
						<p>您可以在此处开启或关闭查询功能。</p>
					</div>
					<div class="main table_parent">
						<table cellspacing="0" cellpadding="0">
							<tr>
								<th class="t_l">文档名称</th>
								<th>状态</th>
								<th>发布时间</th>
								<th>操作</th>
							</tr>
							<tr>
								<td class="t_l first_td">身份证进度查询</td>
								<td class="show">显示</td>
								<td>2017-3-17</td>
								<td><button class="hide">隐藏</button><td>
							</tr>
						</table>
						<div class="null">
							<img src="../../images/yongqinghuji/null.png">
						</div>
					</div>
					<div class="main">
						<div class="tcdPageCode t_r"></div>
						<div class="right_l">
							<input type="text" value="">
							<a href="JavaScript:void(0);">跳转</a>
						</div>
					</div>
				<jsp:include page="footer.jsp" flush="true" />
			</div>
		</div>
	</div>
	<div class="zhe"></div>
</body>
</html>