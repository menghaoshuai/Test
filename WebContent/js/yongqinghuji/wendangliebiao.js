$(function(){
	//获取当前时间
	var d = new Date();
	var vYear = d.getFullYear();
	var vMon = d.getMonth() + 1;
	var vDay = d.getDate();
	s=vYear+"-"+(vMon<10 ? "0" + vMon : vMon)+"-"+(vDay<10 ? "0"+ vDay : vDay);
	$("table tr:last").find("td").css("border-bottom","none");
	 $(".tcdPageCode").createPage({
	        pageCount:20,
	        current:1,
	        backFn:function(p){
	            console.log(p);
	        }
	    });
	 $(".right_l a").click(function(){
			var num=$(".right_l input").val();
			if($.trim(num) == ""){
				alert("请输入要跳转的页面数");
			}else if(!/^\+?[1-9][0-9]*$/.test($.trim(num))){
				alert("请输入正确的数字");
			}else{
				window.location.href="tmDrugManage_initAllDrugsManage.action?page="+num+"&shangpinName="+searcher+"&code="+drugStatus;
			}
		});
	$(".table_parent").on("click",".delete",function(){
		$(this).parents("tr").remove();
	});
	var number=Math.floor($(".first_td").width()/18)-3;
	$(".first_td").each(function(){
		var maxwidth=number;
			if($(this).text().length>maxwidth){
				$(this).text($(this).text().substring(0,maxwidth));
				$(this).html($(this).html()+'…');
			}
		});
	//上传图片
	 $("#uploadify").uploadify({
            //指定swf文件
            'swf': '../../js/yongqinghuji/uploadify.swf',
            'uploader': '',
            'buttonText': '添加文档',
            'progressData': 'percentage',
           	'fileSizeLimit' : '5210KB',
   			'fileTypeExts'  : '*.doc;*.docx;',
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
                $(".uploadify-queue").hide();
				$(".zhe").hide();
				$(".tr:last").after("<tr>"+"<td>"+file.name+"</td><td>"+s+"</td><td><button class='delete'>删除</button></td></tr>")
            } ,
            'onUploadError': function(file, data, response){
            	$('#' + file.id).find('.data').html(' 上传失败');
            	$('.shangchuan').html('重新上传');
            	 $(".uploadify-queue").hide();
					$(".zhe").hide();
					$(".tr:last").after("<tr>"+"<td class='t_l'>"+file.name+"</td><td>"+s+"</td><td><button class='delete'>删除</button></td></tr>")
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