package cn.yongqing.voice.action;

import cn.yongqing.base.BaseAction;
import cn.yongqing.voice.entity.VoiceBroadcast;
import cn.yongqing.voice.service.VoiceBroadcastService;

public class VoiceBroadcastAction extends BaseAction{

	private static final long serialVersionUID = -8979038356964176559L;
	public VoiceBroadcastAction() {
		base = new VoiceBroadcast();
	}
	
	public String input() {
		VoiceBroadcastService service = (VoiceBroadcastService)baseService;
		VoiceBroadcast model = (VoiceBroadcast) base;
		model = service.selectVoiceMessage(model);
		
		base = model;
		boolean result = json();
		if (result) {
			return JSON;
		}
		return JSON;
	}
	

}
