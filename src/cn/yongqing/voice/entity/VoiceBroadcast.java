package cn.yongqing.voice.entity;

import cn.yongqing.base.Base;

public class VoiceBroadcast extends Base{
	
	private static final long serialVersionUID = -7857702746986860595L;
	
	/**语音内容*/
	private String voiceContent ;
	
	/**文件地址*/
	private String fileAddress;
	
	/**所属派出所*/
	private int policeCode;
	

	public String getVoiceContent() {
		return voiceContent;
	}

	public void setVoiceContent(String voiceContent) {
		this.voiceContent = voiceContent;
	}

	public String getFileAddress() {
		return fileAddress;
	}

	public void setFileAddress(String fileAddress) {
		this.fileAddress = fileAddress;
	}

	public int getPoliceCode() {
		return policeCode;
	}

	public void setPoliceCode(int policeCode) {
		this.policeCode = policeCode;
	}

}
