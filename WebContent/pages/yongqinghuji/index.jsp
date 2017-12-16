<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9">
<title>永清智能机器人管理后台  </title>
<link href="../../css/yongqinghuji/public.css" rel="stylesheet" type="text/css" />
<link href="../../css/yongqinghuji/index.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="../../js/yongqinghuji/jquery.min.js"></script>
<script type="text/javascript" src="../../js/yongqinghuji/index_t.js"></script>
<script type="text/javascript" src="../../js/yongqinghuji/index.js"></script>
<script type="text/javascript" src="../../js/yongqinghuji/js/echarts.js"></script>
</head>
<body>
	<!--[if lt IE 9]>
    	<script type="text/javascript" src="../../js/yongqinghuji/PIE.js"></script>
    <![endif]-->
	<div class="full">
		<div id="dcWrap">
			<jsp:include page="public.jsp" flush="true"/>
		</div>
			<div id="dcMain">
				<!-- 当前位置 -->
				<div id="urHere">永清智能机器人管理后台  </div>
				<div id="index" class="mainBox" style="padding-top: 18px">


					<div id="douApi"></div>
					<div class="indexBox">
						<div class="cont_head main">
							<h3>实时指标</h3>
							<p>
								更新时间：<span></span>
							</p>
						</div>
						<ul class="main">
							<li>
								<div class="shiparent">
									<img src="../../images/yongqinghuji/fangwen.png">
									<h4>86</h4>
									<span>今日访问次数</span>
									<div class="border-right"></div>
								</div>
							</li>
							<li>
								<div class="shiparent">
									<img src="../../images/yongqinghuji/pipei.png">
									<h4>3117</h4>
									<span>一次匹配累计</span>
									<div class="border-right"></div>
								</div>
							</li>
							<li>
								<div class="shiparent">
									<img src="../../images/yongqinghuji/dayin.png">
									<h4>43</h4>
									<span>累计打印纸张</span>
									<div class="border-right"></div>
								</div>
							</li>
							<li>
								<div class="shiparent">
									<img src="../../images/yongqinghuji/weixin.png">
									<h4>1232</h4>
									<span>累计微信扫描</span>
									<div class="border-right"></div>
								</div>
							</li>
							<li>
								<div class="shiparent">
									<img src="../../images/yongqinghuji/fuwu.png">
									<h4>2386</h4>
									<span>累计服务居民</span>
									<div class="border-right"></div>
								</div>
							</li>
						</ul>
						<div class="main">
							<div class="left5 border">
								<div class="cont_head">
									<h3>各功能使用率分析</h3>
									<p>
										更新时间：<span></span>
									</p>
								</div>
							</div>
							<div class="right5 border">
								<div class="cont_head">
									<h3>7日使用次数</h3>
									<p>
										更新时间：<span></span>
									</p>
								</div>
							</div>
						</div>
						<div class="main">
							<div class="left5 border" id="chart"></div>
							<div class="right5 border" id="main"></div>
						</div>
					</div>
					<jsp:include page="footer.jsp" flush="true" />
				</div>
			</div>
		</div>
</body>
</html>