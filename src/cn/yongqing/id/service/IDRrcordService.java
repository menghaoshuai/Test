package cn.yongqing.id.service;

import java.util.List;

import cn.yongqing.base.BaseService;
import cn.yongqing.base.Pager;
import cn.yongqing.id.dao.IDRrcordDao;
import cn.yongqing.id.entity.IDRrcord;
import cn.yongqing.json.entity.Json;

public class IDRrcordService extends BaseService {

	public List<IDRrcord> selects(Pager pager,IDRrcord model) {
		IDRrcordDao dao = (IDRrcordDao) baseDao;
		return dao.selects(pager,model);
	}

	public IDRrcord insertId(Json model) {
		IDRrcordDao dao = (IDRrcordDao) baseDao;
		return dao.insertId(model);
	}

	public void deleteRepeatedData(int addNum) {
		IDRrcordDao dao = (IDRrcordDao) baseDao;
		dao.deleteRepeatedData(addNum);
	}

	public void updateStatus(IDRrcord model) {
		IDRrcordDao dao = (IDRrcordDao) baseDao;
		dao.updateStatus(model);
	}

	public IDRrcord selectBySFZ(IDRrcord model) {
		IDRrcordDao dao = (IDRrcordDao) baseDao;
		return dao.selectBySFZ(model);
	}

	public IDRrcord updateStatusByRobot(IDRrcord model) {
		IDRrcordDao dao = (IDRrcordDao) baseDao;
		return dao.updateStatusByRobot(model);
	}

	public IDRrcord updatequeryReplyDetail(IDRrcord model) {
		IDRrcordDao dao = (IDRrcordDao) baseDao;
		return dao.updatequeryReplyDetail(model);
	}

	public IDRrcord updateReplyDetailStatus(IDRrcord model) {
		IDRrcordDao dao = (IDRrcordDao) baseDao;
		return dao.updateReplyDetailStatus(model);
	}
}
