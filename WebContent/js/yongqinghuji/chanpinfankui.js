$(function(){
		//设置输入个数
		$('.lan').focus(function () {
		        interval = setInterval(number_text, 100);
		 });
		$('.lan').blur(
		    function () {
		    	clearInterval(interval);
		   });
		function number_text(){
			var num_ber=30-$.trim($(".lan").val()).length;
			if(num_ber<0){
				$(".p_n").text("您说的太多了我记不住呀").css("color","red");
			}else{
				$(".p_n").text("还可以输入"+num_ber+"个字符").css("color","#666");
			}
		}
		$(".yanzheng a").click(function(){
			var _date = new Date();
			var src = "/validateImg?" + _date.getTime();
			$("#validateImg").attr("src", src);
		});
		$('.form').jqTransform({
			imgPath : '../../images/'
		});
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
		//点击发布判断
		$(".fabu").click(function(){
		var phone=$.trim($(".phone").val());
		if(phone==""){
			$(".err_tip").text("请填写联系方式");
		}else if(!/(^(\d{3,4}-)?\d{7,8})$|(1[3|5|7|8]\d{9})/.test(phone)){
			$(".err_tip").text("请正确填写联系方式，我们会尽快和你联系");
		}else{
			$(".err_tip").text("");
			}
		});
		$(".phone").focus(function () {
		$(".err_tip").text("");
	});
});