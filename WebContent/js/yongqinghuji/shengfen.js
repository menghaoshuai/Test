$(function(){
	//tab切换
	var t1 = 0;
	//设备连接状态
	var jijustatus = 1;
	var addnum = 0;
	var addOrLingQu = 0;//1,添加 2，领取
	nul();
	function nul(){
		if($("table tr").length==1){
			$(".null").show();
			$("table").hide();
		}else{
			$("table").show();
			$(".null").hide();
		}
	}
	//改变领取状态
	$(".focus").click(function(){
		$(this).text("已领取").attr("disabled","disabled").css("background","#ccc");	
	});
	
	 //搜索验证；
	 $(".seacher_btn").click(function(){
		 var biaoqian_seach=$.trim($(".biaoqian_seach").val()).length;
		 if(biaoqian_seach==0){
			 alert("请输入身份证号或姓名");
		 }else{
			 var id = $(".biaoqian_seach").val();
			 window.location.href = "id_input.action?shenFenZheng="+id;
		 }
	 });
	 //添加身份证模态框
	$(".add_name").click(function(){
		Connect();
		if(jijustatus==1){
			addOrLingQu = 1;
			$(".ling_id").animate({"top":"-98px"},100);
			$(".add_id").animate({"top":"0px"},500);
		}
	});
	//领取身份证模态框
	$(".ling_name").click(function(){
		Connect();
		if(jijustatus==1){
			addOrLingQu = 2;
			$(".add_id").animate({"top":"-98px"},100);
			$(".ling_id").animate({"top":"0px"},500);
		}
		
//		$(".men_id").each(function(){
//			var men_id=$(this).text();
//			//a表示设备读取的身份证号；
//			if(a==men_id){
//				$(this).siblings(".ling_btn").find(".focus").text("已领取").attr("disabled","disabled").css("background","#ccc");
//			}
//		});
	});
	$(".close").click(function(){
		$(".add_id,.ling_id").animate({"top":"-98px"},100);
		Disconnect();
	});
	function isIE() { // ie?
		if (!!window.ActiveXObject || "ActiveXObject" in window)
			return true;
		else
			return false;
	}

	function strlen(str) {
		var len = 0;
		for (var i = 0; i < str.length; i++) {
			var c = str.charCodeAt(i);
			// 单字节加1
			if ((c >= 0x0001 && c <= 0x007e) || (0xff60 <= c && c <= 0xff9f)) {
				len++;
			} else {
				len += 2;
			}
		}
		return len;
	}

	function Connect() {// 连接设备
	//	clearForm();
		var resultFlag;
		if (isIE()) {
			resultFlag = CertCtl.CID_IDCARD_OpenDevice();// 连接设备
		} else {
			document.getElementById('pluginobj').focus();
			resultFlag = pluginobj.CID_IDCARD_OpenDevice();// 连接设备
		}
		if (resultFlag == "0") {
			addnum = 0;
			$(".number").text(addnum);
			t1 = window.setInterval(Readcert, 3000);
		} else {
			jijustatus = 0;
			alert("设备连接失败，请检查设备后再试。");
		}

	}

	function Disconnect() { // 断开设备
	// clearForm();
		var resultFlag;
		if (isIE()) {
			resultFlag = CertCtl.CID_IDCARD_CloseDevice();// 断开设备
		} else {
			document.getElementById('pluginobj').focus();
			resultFlag = pluginobj.CID_IDCARD_CloseDevice();// 断开设备
		}
		if (resultFlag == "0") {
			window.clearInterval(t1);
			if(addOrLingQu==1){
				window.location.href = "id_deleteRepeatedData.action?addNum="+addnum;
			}else{
				window.location.reload();
			}
		} else {
			alert("关闭设备失败");
		}

	}

	function Readcert() {// 读取身份证
	// clearForm();
		var infoStr;
		if (isIE()) {
			infoStr = CertCtl.CID_IDCARD_ReadInfo();// 读取身份证
		} else {
			infoStr = pluginobj.CID_IDCARD_ReadInfo();// 读取身份证
		}
		if (strlen(infoStr) > 5) {
			var name;
			var id;
			if (isIE()) {
				name = CertCtl.CID_IDCARD_GetName(infoStr);
				id = CertCtl.CID_IDCARD_GetIDNum(infoStr);
			} else {
				name = pluginobj.CID_IDCARD_GetName(infoStr);
				id = pluginobj.CID_IDCARD_GetIDNum(infoStr);
			}
			if(addOrLingQu==1){
				$.ajax({
				    type : "POST",
				    cache : false,
				    data : {
				    	shenFenZheng : id,
				    	name : name
				    },//传递参数
				    url : "JSON_addAndSelect.action",
				    async : true,//异步请求
				    dataType:"json",
				    success : function(data, textStatus) {
						var idrecord = data.idRrcord;
						var status = idrecord.status;
						var caozuo;
						if(status==1){
							caozuo = "<input type='button' class='focus' value='领取' onclick='lingqu("+idrecord.code+")' /> ";
						}else{
							caozuo = "已领取 ";
						}
						var idtitle = $("#idlisttitle");
						var iddata = "<tr class='tr'>"+
							"<td>0 </td>"+
							"<td class='men_id'>"+idrecord.shenFenZheng+"</td>"+
							"<td>"+idrecord.name+"</td>"+
							"<td>"+idrecord.updateDate+"</td>"+
							"<td class='ling_btn'>"+
							caozuo
							+"</td>"+
						"</tr>";
						$(idtitle).after(iddata);
						$(idtitle).siblings().each(function() {
							var xh = $(this).find("td").eq(0).text();
							$(this).find("td").eq(0).text(parseInt(xh)+1);
						});
						$(".tr").each(function() {
							if($(this).index()>10){
								$(this).remove();
							}
						});
						addnum++;
						$(".number").text(addnum);
				    }
				   }); 
			}else{
				$.ajax({
				    type : "POST",
				    cache : false,
				    data : {
				    	shenFenZheng : id
				    },//传递参数
				    url : "JSON_lingQu.action",
				    async : true,//异步请求
				    dataType:"json",
				    success : function(data, textStatus) {
						addnum++;
						$(".number_ling").text(addnum);
				    }
				   }); 
			}
			
		} else {
		//	alert(infoStr);
		}
	}
});	
