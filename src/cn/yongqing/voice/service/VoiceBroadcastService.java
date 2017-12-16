package cn.yongqing.voice.service;

import cn.yongqing.base.BaseService;
import cn.yongqing.voice.dao.VoiceBroadcastDao;
import cn.yongqing.voice.entity.VoiceBroadcast;

public class VoiceBroadcastService extends BaseService {

	public VoiceBroadcast selectVoiceMessage(VoiceBroadcast model) {
		VoiceBroadcastDao dao = (VoiceBroadcastDao) baseDao;
		int code = model.getCode();
		return dao.selectVoiceMessage(code);
	}
}
