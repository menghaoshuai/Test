$(function(){
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
	$(".back").click(function(){
		location.href="duihua.jsp";
	});
	$(".save").click(function(){
		if($(window.frames[0].document).find(".ke-content,.content-img").html()==""){
			alert("答案不能为空");
		}
	});
});