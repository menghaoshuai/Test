package cn.yongqing.wechat.action;

import java.util.Arrays;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import cn.yongqing.base.BaseAction;
import cn.yongqing.common.SHA1;
import cn.yongqing.common.UtilWX;
import cn.yongqing.problem.entity.ReplyDetail;
import cn.yongqing.wechat.entity.ActionInfo;
import cn.yongqing.wechat.entity.DaiCanErWeiMa;
import cn.yongqing.wechat.entity.Scene;
import cn.yongqing.wechat.entity.WeixinUtil;
import cn.yongqing.wechat.service.InvitationcodeService;

public class InvitationcodeAction extends BaseAction {

	private static final long serialVersionUID = 3369955875561L;
	private static String TOKEN = "yqere3453sefs";


	public void index() throws Exception {
		String echostr = ServletActionContext.getRequest().getParameter(
				"echostr");
		if (null == echostr || echostr.isEmpty()) {
			// xml请求解析
			InvitationcodeService service = (InvitationcodeService) baseService;
			String respMessage = service.operateRequest(ServletActionContext.getRequest());// 回复内容
			this.print(respMessage);
		} else {
			if (this.checkSignature()) {
				this.print(echostr);
			} else {
				this.print("error");
			}
		}
	}

	// 向请求端发送返回数据
	public void print(String content) {
		try {
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			ServletActionContext.getResponse().setContentType("text/xml");
			ServletActionContext.getResponse().getWriter().print(content);
			ServletActionContext.getResponse().getWriter().flush();
			ServletActionContext.getResponse().getWriter().close();
		} catch (Exception e) {

		}
	}

	// 微信接口验证
	public boolean checkSignature() {
		String signature = ServletActionContext.getRequest().getParameter(
				"signature");
		String timestamp = ServletActionContext.getRequest().getParameter(
				"timestamp");
		String nonce = ServletActionContext.getRequest().getParameter("nonce");
		String[] str = { TOKEN, timestamp, nonce };
		Arrays.sort(str); // 字典序排序
		String bigStr = str[0] + str[1] + str[2];
		String digest = new SHA1().getDigestOfString(bigStr.getBytes())
				.toLowerCase();
		if (digest.equals(signature)) {
			return true;
		} else {
			return false;
		}
	}
	
	public String erweima() {
		int ansCode = 2;
		String token = UtilWX.accessToken();
		DaiCanErWeiMa canErWeiMa = new DaiCanErWeiMa();
		ActionInfo actionInfo = new ActionInfo();
		Scene scene = new Scene();
		scene.setScene_id(ansCode);
		actionInfo.setScene(scene);
		canErWeiMa.setAction_info(actionInfo);
		JSONObject jsonObject = WeixinUtil.getDaicanerweima(token, canErWeiMa);
		System.out.println(jsonObject.getString("ticket"));
		String ticket = jsonObject.getString("ticket");
		ServletActionContext.getRequest().setAttribute("imgurl", ticket);
		return "erweima";
	}
	
	public String daan() {
		int ansCode = 1;
		InvitationcodeService service = (InvitationcodeService) baseService;
		ReplyDetail detail = service.selectAns(ansCode);
		ServletActionContext.getRequest().setAttribute("model", detail);
		return "daan";
	}

}
