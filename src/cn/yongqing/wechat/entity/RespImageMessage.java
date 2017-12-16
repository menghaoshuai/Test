package cn.yongqing.wechat.entity;

import cn.yongqing.base.RespBaseMessage;

public class RespImageMessage extends RespBaseMessage {

	private RespImgMessage Image;

	public RespImgMessage getImage() {
		return Image;
	}

	public void setImage(RespImgMessage image) {
		Image = image;
	}
}
