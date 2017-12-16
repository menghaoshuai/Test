package cn.yongqing.wechat.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import cn.yongqing.base.BaseService;
import cn.yongqing.common.UtilCommon;
import cn.yongqing.problem.entity.ReplyDetail;
import cn.yongqing.wechat.dao.InvitationcodeDao;
import cn.yongqing.wechat.entity.Article;
import cn.yongqing.wechat.entity.MessageUtil;
import cn.yongqing.wechat.entity.RespNewsMessage;
import cn.yongqing.wechat.entity.RespTextMessage;

public class InvitationcodeService extends BaseService {

	public String operateRequest(HttpServletRequest request) {
		String respMessage = null;
		try {
			// 默认返回的文本消息内容
			String respContent = "您好，很高兴为您服务";

			// xml请求解析
			Map<String, String> requestMap = MessageUtil.parseXml(request);

			// 发送方帐号（open_id）
			String fromUserName = requestMap.get("FromUserName");
			// 公众帐号
			String toUserName = requestMap.get("ToUserName");
			// 消息类型
			String msgType = requestMap.get("MsgType");
			// 消息内容
			String Content = requestMap.get("Content");
			// 回复文本消息
			RespTextMessage textMessage = new RespTextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			textMessage.setFuncFlag(0);

			// 文本消息
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
				return "success";
			}
			// 事件推送
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				// 事件类型
				String eventType = requestMap.get("Event");
				// 订阅
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
					String eventKey = requestMap.get("EventKey");
					if (!UtilCommon.isNull(eventKey)) {
						System.out.println(eventKey);
						eventKey = eventKey.substring(
								eventKey.indexOf("_") + 1, eventKey.length());
						int code = Integer.parseInt(eventKey);
						if (code > 0) {
							respMessage = tuWenMessage(code, fromUserName,
									toUserName);
							return respMessage;
						}
					}
				}
				// 扫描事件
				else if (eventType.equals(MessageUtil.EVENT_TYPE_SCAN)) {
					String eventKey = requestMap.get("EventKey");
					if (!UtilCommon.isNull(eventKey)) {
						System.out.println(eventKey);
//						eventKey = eventKey.substring(
//								eventKey.indexOf("_") + 1, eventKey.length());
						int code = Integer.parseInt(eventKey);
						if (code > 0) {
							respMessage = tuWenMessage(code, fromUserName,
									toUserName);
							return respMessage;
						}
					}
				}
				// 取消订阅
				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
					// TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
				}
				// 自定义菜单VIEW类型
				else if (eventType.equals(MessageUtil.EVENT_TYPE_VIEW)) {
				}
				// 自定义菜单点击事件
				else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
					// 事件KEY值，与创建自定义菜单时指定的KEY值对应

				}
			}
			textMessage.setContent(respContent);
			respMessage = MessageUtil.textMessageToXml(textMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return respMessage;
	}

	public ReplyDetail selectAns(int ansCode) {
		InvitationcodeDao dao = (InvitationcodeDao) baseDao;
		return dao.selectAns(ansCode);
	}

	public String tuWenMessage(int code, String fromUserName, String toUserName) {
		String respMessage = "";
		System.out.println(code+"%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		ReplyDetail detail = selectAns(code);
		// 创建图文消息
		RespNewsMessage newsMessage = new RespNewsMessage();
		newsMessage.setToUserName(fromUserName);
		newsMessage.setFromUserName(toUserName);
		newsMessage.setCreateTime(new Date().getTime());
		newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
		newsMessage.setFuncFlag(0);

		List<Article> articleList = new ArrayList<Article>();
		// 单图文消息---不含图片
		Article article = new Article();
		article.setTitle(detail.getTitle());
		// 图文消息中可以使用QQ表情、符号表情
		article.setDescription(detail.getIntroduce());
		// 将图片置为空
		article.setPicUrl("");
//		article.setUrl("http://tyq.tunnel.qydev.com/yqwechat_daan.action?code="
//				+ code);
		articleList.add(article);
		newsMessage.setArticleCount(articleList.size());
		newsMessage.setArticles(articleList);
		respMessage = MessageUtil.newsMessageToXml(newsMessage);
		return respMessage;
	}

}
