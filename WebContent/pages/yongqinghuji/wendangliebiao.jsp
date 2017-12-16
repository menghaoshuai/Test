<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9">
<title>永清智能机器人管理后台  </title>
<link href="../../css/yongqinghuji/public.css" rel="stylesheet" type="text/css" />
<link href="../../css/yongqinghuji/uploadify.css" rel="stylesheet" type="text/css" />
<link href="../../css/yongqinghuji/gonggao.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../../js/yongqinghuji/jquery.min.js"></script>
<script type="text/javascript" src="../../js/yongqinghuji/jquery.uploadify.js"></script>
<script type="text/javascript" src="../../js/yongqinghuji/index.js"></script>
<script type="text/javascript" src="../../js/yongqinghuji/jquery.page.js"></script>
<script type="text/javascript" src="../../js/yongqinghuji/wendangliebiao.js"></script>
</head>
<body>
	<!--[if lt IE 9]>
    	<script type="text/javascript" src="../../js/yongqinghuji/PIE.js"></script>
    <![endif]-->
	<div class="full">
		<div id="dcWrap">
			<jsp:include page="public.jsp" flush="true"/>
			<div class="left_active">文档管理</div>
		</div>
			<div id="dcMain">
				<!-- 当前位置 -->
				<div id="urHere">永清智能机器人管理后台 >公告管理 >公告列表 </div>
				<div id="index" class="mainBox" style="padding-top: 18px">
					<div class="cont_head main">
						<h3>文档列表</h3>
					</div>
					<div class="main li_p">
						<p>您可以在此处添加或删除文档。</p>
					</div>
					<div class="main add_btn">
						<div class="wen1 add" name="uploadify" id="uploadify"></div>
						<input type="text" class="biaoqian_seach" value="" placeholder="请输入关键字搜索">
						<input class="seacher_btn" type="image" src="../../images/yongqinghuji/u1378.png">
					</div>
					<div class="main table_parent">
						<table cellspacing="0" cellpadding="0">
							<tr class="tr">
								<th class="t_l">文档名称</th>
								<th>发布时间</th>
								<th>操作</th>
							</tr>
							<tr class="tr">
								<td class="t_l first_td">公告列表公告列表公告列表公告列表公告列表公告列公告列表公告列表公告列表公告列表公告列表公告列公告列表公告列表公告列表公告列表公告列表公告列表公告列表公告列表公告列表公告列表公告列表公告列表</td>
								<td>2017-3-17</td>
								<td width="80px"><button class="delete">删除</button></td>
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