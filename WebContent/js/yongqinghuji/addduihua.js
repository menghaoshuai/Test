$(function() {
			$(".con").eq(0).show();
			$(".btn2 span").click(function() {
				var num = $(".btn2 span").index(this);
				$(this).addClass("active1");
				$(this).siblings().removeClass("active1");
				$(".con").hide();
				$(".con").eq(num).show().siblings("table").hide();
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
			});
			//点击添加相似问题；
			$(".addwenti").on("click",".file1",function(){
				var add_xs= $.trim($(this).siblings(".add_xs").val());
				if(add_xs==""){
					$(this).siblings(".err_tip").text("请添加相似问题");
				}else{
					$(".xs:last").after("<tr class='xs'><td class='td'><label></label></td><td class='td p_r'><input type='text' value='' class='add_xs' /><button type='button' class='file file1 add_child'>+</button><span class='err_tip'></span></td></tr>");
					$(this).attr("disabled","disabled");
				}
			});
			$(".addwenti").on("focus",".add_xs",function(){
				$(this).siblings(".err_tip").text("");
			});
			//点击添加问题
			$(".addwenti_btn").click(function(){
				var wenti=$.trim($(".wenti").val());
				var daAn=$(window.frames[0].document).find(".ke-content,.content-img").html()
				if(wenti=="" || daAn==""){
					alert("请认真填写问题");
					return false;
				}
				//alert($(window.frames[0].document).find(".ke-content").text());
				//alert($(window.frames[0].document).find("img").attr("src"));
			});
			//上传文件
			 $("#uploadify").uploadify({
	                //指定swf文件
	                'swf': '../../js/yongqinghuji/uploadify.swf',
	                'uploader': '',
	                'buttonText': '选择文件',
	                'progressData': 'percentage',
	               	'fileSizeLimit' : '5210KB',
	       			'fileTypeExts'  : '*.iso;*.xls;*.xlsx;',
	                'auto': false,
	                'requeueErrors': true,
	                'multi': false,
	                'onUploadStart':function(file, data, response){
	                },
	                'onUploadSuccess': function (file, data, response) {
	                	//alert(data);
	                	var json = JSON.parse($.trim(data));
	                	$("#uploadify").val(json.data.kucun);
	                    $('#' + file.id).find('.data').html(' 上传成功');
	                    alert(response);
	                } ,
	                'onUploadError': function(file, data, response){
	                	$('#' + file.id).find('.data').html(' 上传失败');
	                	$('.shangchuan').html('重新上传');
	                },
	                'fileObjName':'file'
	            });
				$(".quxiao").click(function(){
					$(".dialog").hide();
					$(".zhe").hide();
					return false;
				  });
			 $(".zhe").click(function(){
				 $(this).hide();	
				 $(".dialog").hide();
			 });
		});