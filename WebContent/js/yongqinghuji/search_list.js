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
				//$(".tcdPageCode").attr(current,num);
				//window.location.href="tmDrugManage_initAllDrugsManage.action?page="+num+"&shangpinName="+searcher+"&code="+drugStatus;
			}
		});
	$(".dengji tr td").eq(0).css("width","100px");
	var number=Math.floor($(".first_td").width()/18)-3;
	$(".first_td").each(function(){
		var maxwidth=number;
			if($(this).text().length>maxwidth){
				$(this).text($(this).text().substring(0,maxwidth));
				$(this).html($(this).html()+'…');
			}
		});
	$(".hide").click(function(){
		if($(this).text()=="隐藏"){
			$(this).text("显示");
			$(this).parent("td").siblings(".show").text("隐藏");
		}else{
			$(this).text("隐藏");
			$(this).parent("td").siblings(".show").text("显示");
		}
	});
});