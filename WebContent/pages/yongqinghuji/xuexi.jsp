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
<link href="../../css/yongqinghuji/jqtransform.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="../../css/yongqinghuji/wenben.css" />
<link href="../../css/yongqinghuji/renjiduihua.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../../js/yongqinghuji/jquery.min.js"></script>
<script type="text/javascript" src="../../js/yongqinghuji/jquery.jqtransform.js"></script>
<script type="text/javascript" src="../../js/yongqinghuji/jquery.uploadify.js"></script>
<script src="../../js/yongqinghuji/wenben.js"></script>
<script src="../../js/yongqinghuji/wenben-zh.js"></script>
<script type="text/javascript" src="../../js/yongqinghuji/index.js"></script>
<script type="text/javascript" src="../../js/yongqinghuji/jquery.page.js"></script>
<script type="text/javascript" src="../../js/yongqinghuji/xuexi.js"></script>
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
				<div id="urHere">永清智能机器人管理后台 >人机会话管理>学习问题</div>
				<div id="index" class="mainBox" style="padding-top: 18px">
					<div class="main cont_head">
						<h3>智能对话训练</h3>
					</div>
					<div class="main parent">
						<div class="btn2">
							<span class="active1">智能学习</span><span>未知问题学习</span>
						</div>
						<div class="con">
							<table>
								<tr><td class="w m_l">一级分类</td><td class="tabl"><button class="active1">全部2</button><button>机器人2</button></td></tr>
								<tr><td></td></tr>
								<tr>
									<td colspan="5" class="m_l">待学习列表</td>
								</tr>
								<tr><td colspan="8"><hr /></td></tr>
								<tr>
									<td class="w m_l">#</td>
									<td>标准问法</td>
									<td>分类</td>
									<td>待学习相似问法</td>
									<td>操作</td>
								</tr>
								<tr><td colspan="8"><hr /></td></tr>
								<tr>
									<td class="w m_l">1</td>
									<td>小乔，吃饭了吗？</td>
									<td>日常用语</td>
									<td>妹子，吃饭了吗？</td>
									<td><a class="wen" href="JavaScript:void(0);">学习</a>-<a class="wen" href="JavaScript:void(0);">忽略</a></td>
								</tr>
								<tr><td colspan="8"><hr /></td></tr>
							</table>
						</div>
						<div class="con">
							<table>
								<tr>
									<td class="p_r  m_l" colspan="2">
										<input type="text" class="biaoqian_seach" value="" placeholder="搜索此分类问题">
										<input class="seacher_btn p_a" type="image" src="../../images/yongqinghuji/u1378.png">
									</td>
								</tr>
								<tr><td></td></tr>
								<tr><th><div class="form"><input type="checkbox"></div></th><th>未知问法</th><!-- <th>类型</th> --><th>创建时间</th><th>操作</th></tr>
								<tr><td colspan="8"><hr /></td></tr>
								<tr><td><div class="form"><input type="checkbox"></div></td><td>妹子，吃饭没？</td><!-- <td>日常用语</td> --><td>2016-11-17 14：30：20</td><td><a class="wen" href="JavaScript:void(0);">学习</a>-<a class="wen" href="JavaScript:void(0);">忽略</a></td></tr>
								<tr><td colspan="8"><hr /></td></tr>
							</table>
						</div>
						<div class="null">
								<img src="../../images/yongqinghuji/null.png">
							</div>
							<div class="">
								<div class="tcdPageCode t_r"></div>
								<div class="right_l">
									<input type="text" value="">
									<a href="JavaScript:void(0);">跳转</a>
								</div>
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