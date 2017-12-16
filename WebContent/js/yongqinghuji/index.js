$(function(){
	//页面改变刷新页面
	$(window).resize(function(){
		location=location;
	});
	 $(".right_l input").focus(function(){
			$(this).val("");
		});
	//遮罩
	var width=$(document).width();
	var height=$(document).height();
	 $(".zhe").css({"width":width,"height":height,"overflow":"hidden"});
	//给左侧导航加选中样式；
	var left_active=$(".left_active").text();
	if(left_active=="人机会话管理"){
		$("#menu .ti").removeClass("top");
		$("#menu .ti").eq(4).addClass("top");
	}else if(left_active=="查询管理"){
		$("#menu .ti").removeClass("top");
		$("#menu .ti").eq(3).addClass("top");
	}else if(left_active=="公告管理"){
		$("#menu .ti").removeClass("top");
		$("#menu .ti").eq(1).addClass("top");
	}else if(left_active=="常用问题管理"){
		$("#menu .ti").removeClass("top");
		$("#menu .ti").eq(5).addClass("top");
	}else if(left_active=="文档管理"){
		$("#menu .ti").removeClass("top");
		$("#menu .ti").eq(2).addClass("top");
	}else if(left_active=="产品反馈"){
		$("#menu .ti").removeClass("top");
		$("#menu .ti").eq(6).addClass("top");
	};
	//获取当前时间
	var d = new Date();
	  var vYear = d.getFullYear();
	  var vMon = d.getMonth() + 1;
	  var vDay = d.getDate();
	  var h = d.getHours(); 
	  var m = d.getMinutes(); 
	  s=vYear+"-"+(vMon<10 ? "0" + vMon : vMon)+"-"+(vDay<10 ? "0"+ vDay : vDay);
	  $(".cont_head p span").text(s);
	var width=$(document).width();
	//超出部分变省略号；
	$(".xiaoxi .cont").each(function(){
		var maxwidth=25;
			if($(this).text().length>maxwidth){
				$(this).text($(this).text().substring(0,maxwidth));
				$(this).html($(this).html()+'…');
			}
		});
	//左侧手风琴；
	$(".top .zl ol li").css({"display":"block","height":"50px"});
	$(".top .down img").attr("src","../../images/yongqinghuji/up.png");
	$(".ti").click(function(event){
		$(this).addClass("top");
		$(this).siblings().removeClass("top");
		$(this).find(".down img").attr("src","../../images/yongqinghuji/up.png");
		$(this).siblings("ul").find(".down img").attr("src","../../images/yongqinghuji" +
				"" +
				"/down.png");
   	 	$(this).find(".zl ol li").stop().animate({height:"50px"},500);
   	 	$(this).find(".zl ol li").show();
   	 	$(this).find(".zl ol li a").css("display","block");
   	 	$(this).siblings().find(".zl ol li a").css("display","none");
   	 	$(this).siblings().find(".zl ol li,.zl ol li a").stop().animate({height:"0px"},500);
   	 	event.stopPropagation();
    });
	/*主要内容宽度设置*/
	$("#dcMain").css("width",width-240);
	$(".main").css("width",width-290);
	/*点击跳转退出*/
	$("#head .nav .noRight p").click(function(){
		window.location.href="login.jsp";
	});
	/*左边显示隐藏*/
	$(".nav_bar").click(function(){
		if($("#dcMain").css("left")=="0px"){
			$("#dcLeft").animate({"left":"0px"},500);
			$(this).attr("src","../../images/yongqinghuji/u438.png");
			$("#dcMain").animate({"left":"240px"},500);
			$(".main").animate({"width":width-290},500);
		}else{	
			$(this).attr("src","../../images/yongqinghuji/u442.png");
			$("#dcLeft").animate({"left":"-245px"},500);
			$("#dcMain").animate({"left":"0"},500);
			$(".main").animate({"width":width-50},500);
		}	
	});
	/*通知栏设置*/	
	$(document).click(function (event) { $('.nav ul li ol').slideUp('slow'); });
	$(".nav ul li a").click(function(event){
		event.stopPropagation();
		$(this).parent().siblings("li").find("ol").slideUp('slow');
		$(this).siblings("ol").slideToggle();
	});
	if(width<=1400){
		$(".dingdan,.ul li .span").css("font-size","12px");
		$("table,.taba .con a,.seacher_parent label,.first,.addbiaoqian td,.addbiaoqian th,.addbiaoqian button").css("font-size","14px");
		$(".btn1 span,.head_t").css({"height":"45px","line-height":"45px"});
		$(".add").css({"top":"48px","right":"-26px"});
		$(".seacher_parent label").css("width","180px");
	}
	if (window.PIE) {
        $('.border').each(function() {
            PIE.attach(this);
        });
    }
	$("[type='text']").focus(function(){
		$(this).css("border","1px solid #438be6");
	});
	$("[type='text']").blur(function(){
		$(this).css("border","1px solid #ccc");
	});
});