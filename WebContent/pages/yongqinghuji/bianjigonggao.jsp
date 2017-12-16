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
<script type="text/javascript" src="../../js/yongqinghuji/bianjigonggao.js"></script>
</head>
<body>
<!--[if lt IE 9]>  
	<script type="text/javascript" src="../../js/yongqinghuji/PIE.js"></script>
<![endif]-->
	<div class="full">
		<div id="dcWrap">
			<jsp:include page="public.jsp" flush="true" />
			<div class="left_active">公告管理</div>
		</div>
		<div id="dcMain">
			<!-- 当前位置 -->
			<div id="urHere">永清智能机器人管理后台 >公告管理 >编辑公告</div>
			<div id="index" class="mainBox" style="padding-top: 18px">
				<div id="douApi"></div>
				<div class="indexBox">
					<div class="cont_head main">
						<h3>添加活动信息</h3>
					</div>
					<form class="form main addlanmu">
						<table class="dengji">
							<tr>	
								<td><label class="laebl_4">公告标题</label><span class="c_o">*</span></td>
								<td class="t_l"><input class="lanmu" placeholder="" value="" type="text"></td>
							</tr>
							<tr>	
								<td><label class="laebl_4">展示位置</label><span class="c_o">*</span></td>
								<td>
									<div class="radio1 radio_checked"></div>
									<span  class="f_l">按创建时间插入</span>
									<div class="radio1"></div>
									<span  class="f_l">置顶显示</span>
								</td>
							</tr>
							<tr>	
								<td><label class="laebl_4">活动内容</label><span class="c_o">*</span></td>
								<td id="textarea">
									<textarea  name="content">
									</textarea>
								</td>
							</tr>
						</table>
						<div class="btns"><button type="button" class="add yulan">预览</button><button type="button" class="add fabu">发布</button></div>
					</form>
				</div>
				<div class="yulan_parent">
					<h1></h1>
					<div class="cont"></div>
					<div class="btns"><button type="button" class="add sure">确定</button><button type="button" class="add quxiao">取消</button></div>
				</div>
				<jsp:include page="footer.jsp" flush="true" />
			</div>
		</div>
	</div>
	<div class="zhe"></div>
</body>
</html>