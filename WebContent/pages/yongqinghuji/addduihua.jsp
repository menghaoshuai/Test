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
<link rel="stylesheet" href="../../css/yongqinghuji/wenben.css" />
<link href="../../css/yongqinghuji/renjiduihua.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../../js/yongqinghuji/jquery.min.js"></script>
<script type="text/javascript" src="../../js/yongqinghuji/jquery.uploadify.js"></script>
<script src="../../js/yongqinghuji/wenben.js"></script>
<script src="../../js/yongqinghuji/wenben-zh.js"></script>
<script type="text/javascript" src="../../js/yongqinghuji/index.js"></script>
<script type="text/javascript" src="../../js/yongqinghuji/addduihua.js"></script>
</head>
<body>
	<!--[if lt IE 9]>
    	<script type="text/javascript" src="../../js/yongqinghuji/PIE.js"></script>
    <![endif]-->
	<div class="full">
		<div id="dcWrap">
			<jsp:include page="public.jsp" flush="true"/>
			<div class="left_active">人机会话管理</div>
		</div>
			<div id="dcMain">
				<!-- 当前位置 -->
				<div id="urHere">永清智能机器人管理后台 >人机会话管理>智能对话管理>智能对话训练 </div>
				<div id="index" class="mainBox" style="padding-top: 18px">
					<div class="main cont_head">
						<h3>智能对话训练</h3>
					</div>
					<div class="main parent">
						<div class="btn2">
							<span class="active1">添加问题</span><span>批量导入</span>
						</div>
						<div class="con">
							<form name="duihua">
								<table class="addwenti">
									<tr>
										<td class="td"><label><span class="c_o">*</span>标准问法：</label></td>
										<td><input class="wenti" type="text" /></td>
									</tr>
									<tr class="xs">
										<td class="td"><label>相似问法：</label></td>
										<td class="p_r add_parent">
											<input class="add_xs" value="" type="text" />
											<button type="button" class="file file1 add_child">+</button>
											<span class="err_tip"></span>
										</td>
									</tr>
									<tr>
										<td class="td"><label><span class="c_o">*</span>标准答案：</label></td>
										<td><textarea  name="content"></textarea></td>
									</tr>
									<tr>
										<td class="td"></td>
										<td><button type="button" class="addwenti_btn">添加问题</button></td>
									</tr>
								</table>
							</form>
						</div>
						<div class="con">
							<form class="daoru">
								<div class="update">
									<label>选择导入文件:</label>
									<input class="wen1" type="file" name="uploadify" id="uploadify" value="选择文件"/>
									<div class="file">选择文件</div>
								</div>
								<p>
									点击<a href="../../images/yongqinghuji/a.xlsx">下载模板</a>，按照给定格式，添加知识库，然后上传。
								</p>
								<dl>
									<dt>以下情况会上传失败：</dt>
									<dd>●&nbsp;&nbsp;excel文件格式错误；</dd>
									<dd>●&nbsp;&nbsp;问题总数超过1000条；</dd>
									<dd>●&nbsp;&nbsp;问题已经在知识库中存在；</dd>
									<dd>●&nbsp;&nbsp;问题所属的分类未被创建；</dd>
									<dd>●&nbsp;&nbsp;问题栏数据为空；</dd>
									<dd>●&nbsp;&nbsp;答案栏数据为空；</dd>
								</dl>
								<button>导入</button>
							</form>
						</div>
					</div>
				</div>
				<div class="clear"></div>
				<jsp:include page="footer.jsp" flush="true" />
				</div>
			</div>
			<div class="zhe"></div>
</body>
</html>