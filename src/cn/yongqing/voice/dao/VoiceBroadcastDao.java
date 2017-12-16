package cn.yongqing.voice.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.yongqing.base.BaseDao;
import cn.yongqing.voice.entity.VoiceBroadcast;

public class VoiceBroadcastDao extends BaseDao{

	public VoiceBroadcast selectVoiceMessage(int code) {
		HibernateTemplate template = getHibernateTemplate();
		String hql = "from " + VoiceBroadcast.class.getName() + " where policeCode=" + code;
		List<VoiceBroadcast> voices = template.find(hql);
		VoiceBroadcast voice = new VoiceBroadcast();
		if(voices.size()>0)
			voice = voices.get(0);
		return  voice;
	}
	
}
