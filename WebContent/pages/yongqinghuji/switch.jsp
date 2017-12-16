<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8"
	language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width" />
<meta name="format-detection" content="telephone=no">
<script src="../../js/yongqinghuji/jquery.min.js"></script>
<title></title>
<style>
.on{
		display:inline-block;
		width:11rem;
		height:5rem;
		line-height:5rem;
		background:#438BE6;
		color:#fff;
		border-radius:5px;
		border:none;
		position: absolute;
		top:0;
		bottom:0;
		left:0;
		right:0;
		margin:auto;
		font-size:15px;
	}

</style>
<script>
	$(function(){
		function resize() {
			var $width = $(document.body).innerWidth();
			var $rem = $width/750;
			$("html, body").css({"font-size":$rem+"rem"});
		};
		$(window).resize(function(){
			resize();
		});
		resize();
		$(".on").click(function(){
			var model = {};
			var dataURL = "id_updateReplyDetailStatus.action";
			jQuery.ajax({
				url : dataURL,
				type : "post",
				data : model,
				success : function(results){
					alert("更新成功");
				}
			});
		});
	});
</script>
</head>
<body>
	<div class="parent">
		<button class="on" type="button">开启</button>
	</div>
</body>

</html>