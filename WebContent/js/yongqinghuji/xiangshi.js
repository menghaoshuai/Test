$(function(){
	$(".bianji").click(function(){
		location.href="wenti.jsp";
	});
	$(".dengji tr td").eq(0).css("width","100px");
	$(".dengji tr td label").css("width","80px");
	var number=Math.floor($(".first_td").width()/18)-3;
	$(".first_td").each(function(){
		var maxwidth=number;
		if($(this).text().length>maxwidth){
			$(this).text($(this).text().substring(0,maxwidth));
			$(this).html($(this).html()+'…');
		}
	});
});