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
<script type="text/javascript" src="../../js/yongqinghuji/wenti.js"></script>
</head>
<body>
<!--[if lt IE 9]>  
	<script type="text/javascript" src="../../js/yongqinghuji/PIE.js"></script>
<![endif]-->
	<div class="full">
		<div id="dcWrap">
			<jsp:include page="public.jsp" flush="true" />
			<div class="left_active">人机会话管理</div>
		</div>
		<div id="dcMain">
			<!-- 当前位置 -->
			<div id="urHere">永清智能机器人管理后台 >公告管理 >编辑公告</div>
			<div id="index" class="mainBox" style="padding-top: 18px">
				<div id="douApi"></div>
				<div class="indexBox">
					<div class="cont_head main">
						<h3>问题详情</h3>
					</div>
					<form class="form main addlanmu">
						<table class="dengji">
							<tr>	
								<td class="p_first"><label class="laebl_4">标准问题</label><span class="c_o">*</span></td>
								<td class="t_l"><p class="lanmu lm p_first">怎么换二代身份证？</p></td>
							</tr>
							<tr>	
								<td><label class="laebl_4">相似问题</label><span class="c_o">*</span></td>
								<td class="t_l"><p class="lanmu lm">我要换二代身份证？</p></td>
							</tr>
							<tr>	
								<td></td>
								<td class="t_l"><p class="lanmu lm">我要更换二代身份证？</p></td>
							</tr>
							<tr>	
								<td></td>
								<td class="t_l"><p class="lanmu lm">怎么换身份证？</p></td>
							</tr>
							<tr>	
								<td></td>
								<td class="t_l"><a class="m_l_t" href="xiangshi.jsp">查看更多相似问题</a></td>
							</tr>
							<tr>	
								<td><label class="laebl_4">标准答案</label><span class="c_o">*</span></td>
								<td id="textarea">
									<textarea  name="content">
									</textarea>
								</td>
							</tr>
						</table>
						<div class="btns"><button type="button" class="add back">返回</button><button type="button" class="add save">保存</button></div>
					</form>
				</div>
				<jsp:include page="footer.jsp" flush="true" />
			</div>
		</div>
	</div>
	<div class="zhe"></div>
</body>
</html>