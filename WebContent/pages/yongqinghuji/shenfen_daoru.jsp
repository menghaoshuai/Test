<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9"> 
<title>永清智能机器人管理后台  </title>
<link href="../../css/yongqinghuji/public.css" rel="stylesheet" type="text/css" />
<link href="../../css/yongqinghuji/gonggao.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../../js/yongqinghuji/jquery.min.js"></script>
<script type="text/javascript" src="../../js/yongqinghuji/index.js"></script>
<script type="text/javascript" src="../../js/yongqinghuji/jquery.page.js"></script>
<script type="text/javascript" src="../../js/yongqinghuji/shengfen.js"></script>
</head>
<script type="text/javascript">
$(function(){
	var totalPage = '<s:property value="%{totalPage}"/>';
	var page = '<s:property value="%{pager.page}"/>';
	var status = $("#idstatus").val();
	if(status==0){
		addandremoveclass(0);
	}else if(status==1){
		addandremoveclass(1);
	}else{
		addandremoveclass(2);
	}
	function addandremoveclass(i){
		$(".btn2 span").eq(i).addClass("active1");
		$(".btn2 span").eq(i).siblings().removeClass("active1");
	}
	$("#dailingid").click(function() {
		window.location.href = "id_input.action?status="+1;
	});
	$("#yilingid").click(function() {
		window.location.href = "id_input.action?status="+2;
	});
	$("#allid").click(function() {
		window.location.href = "id_input.action";
	});
	//分页
	 $(".tcdPageCode").createPage({
       pageCount:parseInt(totalPage),
       current:parseInt(page),
       backFn:function(p){
    	   window.location.href = "id_input.action?status="+status+"&pager.page="+p;
       }
   });
	$("._href").click(function(){
		var page_diy=parseInt($.trim($(".page_diy").val()));
		if(page_diy>totalPage || page_diy<=0 || isNaN(page_diy) || page_diy==""){
			alert("您输入有误");
		}else{
			window.location.href = "id_input.action?status="+status+"&pager.page="+page_diy;
		}
	});
});	

function lingqu(code){
	 window.location.href = "id_lingQu.action?code="+code;
}

</script>
<body>
	<!--[if lt IE 9]>
    	<script type="text/javascript" src="../../js/yongqinghuji/PIE.js"></script>
    <![endif]-->
	<object id='CertCtl' name='CertCtl' width="0" height="0"
		classid="CLSID:BC044A60-23CC-4F5C-8C16-476648435AC1">
		<embed id="pluginobj" type="application/CID7000id-plugin" width="0"
			height="0">
		</embed>
	</object>
	<div class="full">
		<div id="dcWrap">
			<jsp:include page="public.jsp" flush="true"/>
			<div class="left_active">查询管理</div>
		</div>
			<div id="dcMain">
				<!-- 当前位置 -->
				<div class="add_id p_a">
					<p>请在读卡器上逐个扫描身份证，已完成身份证信息录入</p>
					<p>已录入<span class="number">0</span>张</p>
					<img class="close p_a" src="../../images/yongqinghuji/close.png">
				</div>
				<div class="ling_id p_a">
					<p>请在读卡器上逐个扫描身份证，已完成身份证领取。</p>
					<p>已领取<span class="number_ling">0</span>张</p>
					<img class="close p_a" src="../../images/yongqinghuji/close.png">
				</div>
				<div id="urHere">永清智能机器人管理后台 >查询管理 >身份证管理</div>
				<div id="index" class="mainBox" style="padding-top: 18px">
					<div class="cont_head main">
						<h3>身份证管理</h3>
					</div>
					<div class="main li_p">
						<p>您可以在此处批量添加待领取的居民身份证，便于用户在机器人端查询是否可以领取。</p>
					</div>
					<div class="main add_btn">
						<button type="button" class="add add_name">添加身份证</button>
						<button type="button" class="add ling_name">领取身份证</button>
						<input type="text" class="biaoqian_seach" value="" placeholder="请输入身份证号或姓名">
						<input class="seacher_btn" type="image" src="../../images/yongqinghuji/u1378.png">
					</div>
					<div class="main p_r table_parent">
						<div class="btn2">
							<span class="active1" id="allid">全部</span><span id="dailingid">待领取</span><span id="yilingid">已领取</span>
							<input id="idstatus" type="hidden" value="<s:property value='status' />">
						</div>
						<table cellspacing="0" cellpadding="0">
							<tr class="tr" id="idlisttitle">
								<th>序号</th>
								<th>身份证号码</th>
								<th>姓名</th>
								<th>添加时间</th>
								<th>操作</th>
							</tr>
						<s:iterator value="list" status="st">
							<tr class="tr">
								<td><s:property value='#st.index+1'/> </td>
								<td class="men_id"><s:property value='shenFenZheng' /></td>
								<td><s:property value='name' /></td>
								<td><s:property value='updateDate' /></td>
								<td class="ling_btn">
								<s:if test='status==1'><input type="button" class="focus" value="领取" onclick="lingqu(<s:property value='code' />)" /> </s:if> 
								<s:elseif test='status==2'>已领取 </s:elseif> 
								</td>
							</tr>
						</s:iterator>
						<!-- <tr class="tr">
							<td>0</td>
							<td class="men_id">130637198210045380</td>
							<td>颜靖桐</td>
							<td>2017-05-19 14:23:30</td>
							<td class="ling_btn"><button type="button" class="focus">领取</button></td>
						</tr>
					 --></table>
						<div class="null">
							<img src="../../images/yongqinghuji/null.png">
						</div>
					</div>
					<div class="main">
						<div class="tcdPageCode t_r"></div>
						<div class="right_l">
							<input type="text" class="page_diy" value="">
							<a href="JavaScript:void(0);" class="_href">跳转</a>
						</div>
					</div>
					<jsp:include page="footer.jsp" flush="true" />
				</div>
			</div>
		</div>
	</body>
</html>