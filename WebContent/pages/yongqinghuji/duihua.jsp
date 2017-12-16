<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9">
<title>永清智能机器人管理后台  </title>
<link href="../../css/yongqinghuji/public.css" rel="stylesheet" type="text/css" />
<link href="../../css/yongqinghuji/jqtransform.css" rel="stylesheet" type="text/css" />
<link href="../../css/yongqinghuji/renjiduihua.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../../js/yongqinghuji/jquery.min.js"></script>
<script type="text/javascript" src="../../js/yongqinghuji/jquery.jqtransform.js"></script>
<script type="text/javascript" src="../../js/yongqinghuji/jquery.page.js"></script>
<script type="text/javascript" src="../../js/yongqinghuji/index.js"></script>
<script type="text/javascript" src="../../js/yongqinghuji/duihua.js"></script>
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
				<div id="urHere">永清智能机器人管理后台 >人机会话管理>智能对话管理 </div>
				<div id="index" class="mainBox" style="padding-top: 18px">
					<div class="cont_head main">
						<h3>问题管理</h3>
					</div>
					<div >
						
						<table class="main dui_hua">
							<tr><td class="fenlei m_l" colspan="5">分类选择</td></tr>
							<tr><td class="m_l"><button class="active2 add_fe">添加</button></td></tr>
							<tr><td class="w m_l">一级分类</td><td colspan="5" class="tabl"><button class="active1">全部2</button><button>机器人2</button><a class="active2 add_fenlei">添加分类</a></td><td></td><td></td></tr>
							<tr>
								<td colspan="3" class="m_l">问题列表</td>
								<td class="t_r sea_p p_r" colspan="3">
									<input type="image" class="p_a images" src="../../images/yongqinghuji/u1378.png">
									<input class="p_a search" type="text" value="" placeholder="搜索此类的问题">
									<button type="button" class="p_a active2">导出数据</button>
								</td>
							</tr>
							<tr><td colspan="8"><hr /></td></tr>
							<tr>
								<th>
									<div class="form">
										<input class="all" type="checkbox">
									</div>
								</th>
								<th>问题</th>
								<th>
									<div class="form">
										<select name="select">
											<option value="">分类</option>
										</select>
									</div>
								</th>
								<th><a class="down_time down_1" href="JavaScript:void(0);">更新时间</a></th>
								<th><a class="down_time" href="JavaScript:void(0);">全部</a></th>
								<th>相似问法</th>
							</tr>
							<tr><td colspan="8"><hr /></td></tr>
							<tr>
								<td>
									<div class="form">
										<input type="checkbox">
									</div>
								</td>
								<td>
									<a class="wen" href="addduihua.jsp">15岁可以服用汇仁肾宝片的吗？</a>
								</td>
								<td>机器人</td>
								<td>2016-11-17 14：30：20</td>
								<td>启用</td><td>0</td>
							</tr>
							<tr><td colspan="8"><hr /></td></tr>
							<tr>
								<td>
									<div class="form">
										<input type="checkbox">
									</div>
								</td>
								<td>
									<a  class="wen" href="addduihua.jsp">一顾反馈服用肾宝片后呕吐腹泻严重一顾反馈服用肾宝片后呕吐腹泻严重一顾反馈服用肾宝片后呕吐腹泻严重腹泻严重</a>
								</td>
								<td>机器人</td>
								<td>2016-11-17 14：30：20</td>
								<td>启用</td><td>0</td>
							</tr>
							<tr><td colspan="8"><hr /></td></tr>
						</table>
						<div class="main null">
							<img src="../../images/yongqinghuji/null.png">
						</div>
					</div>
				</div>
				<div class="clear"></div>
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
			<div class="zhe"></div>
			<div class="dis_none">
				<div class="par">
					<span class="la zhekou">添加分类：</span>
					<input type="text" class="zhekou_input" placeholder="" />
					<span class="err_tip"></span>
				</div>
				<div class="sure_btn"><button class="fenlei_sure">确定</button><button class="fenlei_q">取消</button></div>
			</div>
</body>
</html>