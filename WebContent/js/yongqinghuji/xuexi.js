$(function(){
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
	$('.form').jqTransform({
		imgPath : '../../images/'
	});
	$(".btn2 span").click(function() {
		var num = $(".btn2 span").index(this);
		$(this).addClass("active1");
		$(this).siblings().removeClass("active1");
		$(".con").hide();
		$(".con").eq(num).show().siblings("table").hide();
	});
	$(".con").eq(0).show();
 	$(".tabl button").click(function(){
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