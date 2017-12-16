package cn.yongqing.office.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.yongqing.base.Base;
import cn.yongqing.base.BaseCache;
import cn.yongqing.base.BaseDao;
import cn.yongqing.office.entity.PeoplePolice;
import cn.yongqing.office.entity.PoliceLikes;
import cn.yongqing.office.entity.PoliceTags;

public class PeoplePoliceDao extends BaseDao {

	@SuppressWarnings("unchecked")
	public PeoplePolice selectPoliceMessage(int code) {
		HibernateTemplate template = getHibernateTemplate();
		List<Base> tags = BaseCache.create().getCache(PoliceTags.class);
		String hql = "from " + PoliceLikes.class.getName() + " where policeCode=" + code;
		List<PoliceLikes> policeLikes = template.find(hql);
		List<PoliceLikes> list = new ArrayList<PoliceLikes>();
		for (Base base : tags) {
			PoliceTags tag = (PoliceTags) base;
			PoliceLikes likes = new PoliceLikes();
			likes.setName(tag.getName());
			int tagCode = tag.getCode();
			likes.setTagCode(tagCode);
			likes.setPoliceCode(code);
			int count = 0;
			for (PoliceLikes pl : policeLikes) {
				if(pl.getTagCode()==tagCode){
					count = pl.getLikedCount();
					break;
				}
			}
			likes.setLikedCount(count);
			list.add(likes);
		}
		PeoplePolice police = new PeoplePolice();
		police.setCode(code);
		police.setPoliceLikes(list);
		return police;
	}

	@SuppressWarnings("unchecked")
	public void updateOrInsertLikedCount(int code, int tagCode) {
		HibernateTemplate template = getHibernateTemplate();
		String hql = "from " + PoliceLikes.class.getName() + " where policeCode=" + code + " and tagCode=" + tagCode;
		List<PoliceLikes> policeLikes = template.find(hql);
		if(policeLikes.size()>0){
			PoliceLikes likes = policeLikes.get(0);
			int likedCount = likes.getLikedCount();
			likedCount++;
			likes.setLikedCount(likedCount);
			update(likes);
		}else{
			PoliceLikes likes = new PoliceLikes();
			likes.setPoliceCode(code);
			likes.setTagCode(tagCode);
			likes.setLikedCount(1);
			insert(likes);
		}
	}

}
