$(function() {
	//自定义跳转分页；
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
		$('.form').jqTransform({
			imgPath : '../../images/'
		});
		 $(".tcdPageCode").createPage({
		        pageCount:20,
		        current:1,
		        backFn:function(p){
		            console.log(p);
		        }
		    });
		$(".wen").each(function(){
			var maxwidth=15;
				if($(this).text().length>maxwidth){
					$(this).text($(this).text().substring(0,maxwidth));
					$(this).html($(this).html()+'…');
				}
			});
		//添加分类
		$(".add_fenlei").click(function(){
			$(".zhe,.dis_none").show();
		});
		$(".zhekou_input").focus(function(){
			$(".par").find(".err_tip").text("");
		});
		//分类确定
		$(".fenlei_sure").click(function(){
			var fenlei=$.trim($(".zhekou_input").val());
			if(fenlei==""){
				$(".par").find(".err_tip").text("请填写分类名称");
			}else{
				$(".add_fenlei").before("<button>"+fenlei+"</button>");
				$(".zhe,.dis_none").hide();
			}
		});
		//取消
		$(".zhe,.fenlei_q").click(function(){
			$(".zhe").hide();
			$(".dis_none").hide();
		});
		$(".add_fe").click(function(){
			window.location.href="addduihua.jsp";
		});
		$(".tabl").on("click","button", function() {
			$(this).addClass("active1").siblings("button").removeClass("active1");
		});
		//全选
		 $("th .jqTransformCheckbox").click(function() {
				var length=$(".jqTransformCheckbox").length;
				var length1=$(".jqTransformChecked").length;
				var length2=$("th .jqTransformChecked").length;
				if(length2==1){
					if(length==length1){
						$(".jqTransformCheckbox").each(function(){
							$("th .jqTransformChecked,td .jqTransformChecked").removeClass("jqTransformChecked");
						});
					}else if(length!=length1){
						$(".jqTransformCheckbox").each(function(){
							$(this).addClass("jqTransformChecked");
						});
					}
				}else if(length2==0){
					if(length==length1){
						$(".jqTransformCheckbox").each(function(){
							$("th .jqTransformChecked,td .jqTransformChecked").addClass("jqTransformChecked");
						});
					}else if(length!=length1){
						$(".jqTransformCheckbox").each(function(){
							$(this).addClass("jqTransformChecked");
						});
					}
				}
			});
			$("td .jqTransformCheckbox").click(function(){
				if($("td .jqTransformCheckbox").length==$("td .jqTransformChecked").length){
					$("th .jqTransformCheckbox").addClass("jqTransformChecked");
				}else if($("td .jqTransformCheckbox").length!=$("td .jqTransformChecked").length){
					$("th .jqTransformCheckbox").removeClass("jqTransformChecked");
				}else if($(this).hasClass("jqTransformChecked")){
					$(this).removeClass("jqTransformChecked");
				}else{
					$(this).addClass("jqTransformChecked");
				};
			});
	});