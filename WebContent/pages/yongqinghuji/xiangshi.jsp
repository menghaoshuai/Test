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
<link rel="stylesheet" href="../../css/yongqinghuji/wenben.css" />
<script type="text/javascript" src="../../js/yongqinghuji/jquery.min.js"></script>
<script src="../../js/yongqinghuji/wenben.js"></script>
<script src="../../js/yongqinghuji/wenben-zh.js"></script>
<script type="text/javascript" src="../../js/yongqinghuji/index.js"></script>
<script type="text/javascript" src="../../js/yongqinghuji/xiangshi.js"></script>
</head>
<body>
<!--[if lt IE 9]>  
	<script type="text/javascript" src="../../js/yongqinghuji/PIE.js"></script>
<![endif]-->
		<div id="dcWrap">
			<jsp:include page="public.jsp" flush="true" />
			<div class="left_active">人机会话管理</div>
		</div>
		<div id="dcMain">
			<!-- 当前位置 -->
			<div id="urHere">永清智能机器人管理后台 >人机会话管理 >问题详情>相似问题管理</div>
			<div id="index" class="mainBox" style="padding-top: 18px">
				<div id="douApi"></div>
				<div class="indexBox">
					<div class="cont_head main">
						<h3>相似问题管理</h3>
					</div>
					<div class="main li_p">
						<p>您可以在此处添加并修改问题的相似问题。</p>
					</div>
					<div class="main">
						<h2 class="wenti">标准问题：<span>怎么更换二代身份证？</span></h2>
					</div>
					<div class="main add_btn">
						<a class="add add1" href="addduihua.jsp">添加相似问题</a>
						<input type="text" class="biaoqian_seach" value="" placeholder="请输入关键字搜索">
						<input class="seacher_btn" type="image" src="../../images/yongqinghuji/u1378.png">
					</div>
					<div class="main table_parent">
						<table cellspacing="0" cellpadding="0">
							<tr>
								<th class="t_l">相似问题</th>
								<th>发布时间</th>
								<th>操作</th>
							</tr>
							<tr>
								<td class="t_l first_td">公告列表公告列表公告列表公告列表公告列表公告列公告列表公告列表公告列表公告列表公告列表公告列公告列表公告列表公告列表公告列表公告列表公告列表公告列表公告列表公告列表公告列表公告列表公告列表</td>
								<td>2017-3-17</td>
								<td><button class="bianji">编辑</button>-<button class="delete">删除</button></td>
							</tr>
						</table>
						<div class="null">
							<img src="../../images/yongqinghuji/null.png">
						</div>
					</div>
				<jsp:include page="footer.jsp" flush="true" />
			</div>
		</div>
	</div>
	<div class="zhe"></div>
</body>
</html>