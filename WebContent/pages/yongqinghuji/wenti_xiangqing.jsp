<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9">
<title>永清智能机器人管理后台  </title>
<link href="../../css/yongqinghuji/public.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="../../css/yongqinghuji/wenben.css" />
<link href="../../css/yongqinghuji/renjiduihua.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../../js/yongqinghuji/jquery.min.js"></script>
<script src="../../js/yongqinghuji/wenben.js"></script>
<script src="../../js/yongqinghuji/wenben-zh.js"></script>
<script type="text/javascript" src="../../js/yongqinghuji/index.js"></script>
<script type="text/javascript" src="../../js/yongqinghuji/wenti_xiangqing.js"></script>
</head>
<body>
	<!--[if lt IE 9]>
    	<script type="text/javascript" src="../../js/yongqinghuji/PIE.js"></script>
    <![endif]-->
	<div class="full">
		<div id="dcWrap">
			<jsp:include page="public.jsp" flush="true"/>
			<div class="left_active">常用问题管理</div>
		</div>
			<div id="dcMain">
				<!-- 当前位置 -->
				<div id="urHere">永清智能机器人管理后台 >常见问题管理>常见问题列表>常见问题详情 </div>
				<div id="index" class="mainBox" style="padding-top: 18px">
					<div class="main cont_head">
						<h3>常见问题详情</h3>
					</div>
					<div class="main parent">
						<form name="duihua">
							<table class="addwenti">
								<tr>
									<td><label class="p_o_t"><span class="c_o">*</span>常见问题：</label></td>
									<td><input class="p_o_t wenti" type="text" /></td>
								</tr>
								<tr>
									<td><label><span class="c_o">*</span>标准答案：</label></td>
									<td><textarea  name="content"></textarea></td>
								</tr>
								<tr>
									<td></td>
									<td><div class="btns"><button type="button" class="add add2 back">返回</button><button type="button" class="add add2 save">保存</button></div></td>
								</tr>
							</table>
						</form>
					</div>
				</div>
				<div class="clear"></div>
				<jsp:include page="footer.jsp" flush="true" />
				</div>
			</div>
			<div class="zhe"></div>
</body>
</html>