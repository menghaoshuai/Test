<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9"> 
<title>永清智能机器人管理后台</title>
<link href="../../css/yongqinghuji/public.css" rel="stylesheet" type="text/css" />
<link href="../../css/yongqinghuji/jqtransform.css" rel="stylesheet" type="text/css" />
<link href="../../css/yongqinghuji/gonggao.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="../../css/yongqinghuji/wenben.css" />
<script type="text/javascript" src="../../js/yongqinghuji/jquery.min.js"></script>
<script type="text/javascript" src="../../js/yongqinghuji/jquery.jqtransform.js"></script>
<script src="../../js/yongqinghuji/wenben.js"></script>
<script src="../../js/yongqinghuji/wenben-zh.js"></script>
<script type="text/javascript" src="../../js/yongqinghuji/index.js"></script>
<script type="text/javascript" src="../../js/yongqinghuji/chanpinfankui.js"></script>
</head>
<body>
<!--[if lt IE 9]>  
	<script type="text/javascript" src="../../js/yongqinghuji/PIE.js"></script>
<![endif]-->
	<div class="full">
		<div id="dcWrap">
			<jsp:include page="public.jsp" flush="true" />
			<div class="left_active">产品反馈</div>
		</div>
		<div id="dcMain">
			<!-- 当前位置 -->
			<div id="urHere">永清智能机器人管理后台 >信息反馈 >产品反馈</div>
			<div id="index" class="mainBox" style="padding-top: 18px">
				<div id="douApi"></div>
				<div class="indexBox">
					<div class="cont_head main">
						<h3>产品反馈</h3>
					</div>
					<div class="main li_p">
						<p>如果您对小乔机器人，以及本后台系统有任何功能上的意见或建议，可在此处反馈给我们，我们会第一时间告知您处理方案及工作进展。</p>
					</div>
					<form class="form main addlanmu">
						<table class="dengji fankui">
							<tr>	
								<td colspan="2" class="t_l">
									<div class="form">
										<select name="select">
											<option value="">小乔机器人</option>
											<option value="">后台系统</option>
											<option value="">其他</option>
										</select>
									</div>
									<input class="lanmu lan" placeholder="" value="" type="text">
									<p class="p_n">还可以输入<span>30</span>个字符</p>
								</td>
							</tr>
							<tr>	
								<td class="td_first"><label class="laebl_4">反馈类型</label><span class="c_o">*</span></td>
								<td>
									<div class="radio1 radio_checked"></div>
									<span  class="f_l">意见或建议</span>
									<div class="radio1"></div>
									<span  class="f_l">故障申报</span>
								</td>
							</tr>
							<tr>
								<td class="td_first"><label class="laebl_4">联系方式</label><span class="c_o">*</span></td>
								<td class="t_l"><input class="lanmu lan phone" placeholder="" value="" type="text"><span class="err_tip"></span></td>
							</tr>
							<tr>
								<td colspan="2" id="textarea">
									<textarea  name="content">
									</textarea>
								</td>
							</tr>
							<tr>
								<td colspan="2" class="t_l yanzheng">
									<span>验证码</span><input type="text" value="" /><img id="validateImg" border="0" class="yan_pic" src="/validateImg" title="看不清？换一张" />
									<a href="javascript:void(0);">看不清，换一张</a><span class="err"></span>
								</td>
							</tr>
							<tr>
								<td class="td_first" colspan="2"><button type="button" class="add fabu">发布</button></td>
							</tr>
						</table>
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
</body>
</html>