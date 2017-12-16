$(function(){
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
		});
	//点击返回
	$(".back").click(function(){
		location.href="wenti_list.jsp";
	});
	//点击保存
	$(".save").click(function(){
		var wenti=$.trim($(".wenti").val());
		var daAn=$(window.frames[0].document).find(".ke-content,.content-img").html()
		if(wenti=="" || daAn==""){
			alert("请认真填写问题");
		}
	});
});