$(function(){
		var height=$(document).height();
		$(".full").css("height",height);
		if (window.PIE) {
	        $('.border').each(function() {
	            PIE.attach(this);
	        });
	    }
		$(".in").focus(function(){
			$(".err_tip").text("");
		});
		$(".login_btn").click(function(){
			login();
		});
		$(document).bind('keypress',function(event){
	        if(event.keyCode == "13"){
	           login();
	        }
	    });
		function login(){
			var pa=$(".lock").val();
			var ph=$(".phone").val();
			if($.trim(pa) == "") {
				$(".err_tip").text("密码不能为空");
				return false;
			}else if($.trim(ph) == "") {
				$(".err_tip").text("用户名不能为空");
				return false;
			}else{
				var mobile = $(".phone").val();
				var password = $(".lock").val();
				var model = {};
				model["name"] = mobile;
				model["password"] = password;
				var dataURL = "";
					jQuery.ajax({
						url : dataURL,
						type: 'POST',
						data : model,
						success : function(results) {
							if(results.indexOf("错误")>0){
								$(".err_tip").text("用户名与密码不匹配");
								return false;
							}else{
								location.href = "index.jsp";
							}
						}
					});
			}
		}
	});