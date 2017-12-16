$(function(){
		//单选
		$(".radio1").click(function(){
			$(this).addClass("radio_checked");
			$(this).siblings(".radio1").removeClass("radio_checked");
		});
		$(".dengji tr td").eq(0).css("width","100px");
		$(".dengji tr td label").css("width","80px");
	});
	//文本框
	var editor;
		KindEditor.ready(function(K) {
			editor = K.create('textarea[name="content"]', {
				resizeType : 1,
				allowPreviewEmoticons : false,
				allowImageUpload : true,
				items : [
					'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
					'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
					'insertunorderedlist', '|', 'emoticons', 'image', 'link']
			});
	//点击发布，预览
	function yan(){
		var wenti=$.trim($(".lanmu").val());
		var daAn=$(window.frames[0].document).find(".ke-content,.content-img").html();
		if(wenti=="" || daAn==""){
			alert("请认真填写问题");
		}
	}
	$(".fabu").click(function(){
		yan();
		//alert($(window.frames[0].document).find(".ke-content,.content-img").html());
	});
	$(".yulan").click(function(){
		var wenti=$.trim($(".lanmu").val());
		var daAn=$(window.frames[0].document).find(".ke-content,.content-img").html()
		if(wenti=="" || daAn==""){
			alert("请认真填写问题");
			return false;
		}else{
			$(".zhe,.yulan_parent").show();
			var h1=$(".lanmu").val();
			$(".yulan_parent h1").text(h1);
			$(".cont").append($(window.frames[0].document).find(".ke-content,.content-img").html());
		}
	});
	//取消
	$(".quxiao").click(function(){
		$(window.frames[0].document.body).html("");
		$(".cont").html("");
		$(".lanmu").val("");
		$(".zhe,.yulan_parent").hide();
	});
});