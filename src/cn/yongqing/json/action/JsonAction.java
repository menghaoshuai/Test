package cn.yongqing.json.action;

import cn.yongqing.base.BaseAction;
import cn.yongqing.id.entity.IDRrcord;
import cn.yongqing.id.service.IDRrcordService;
import cn.yongqing.json.entity.Json;

public class JsonAction extends BaseAction {
	
	private static final long serialVersionUID = 39844632223691L;


	public JsonAction() {
		base = new Json();
	}
	
	public String result ="";
	
	
	public String getResult() {
		return result;
	}


	public String addAndSelect() {
		Json model = (Json) base;
		IDRrcordService service = (IDRrcordService)baseService;
		IDRrcord id = service.insertId(model);
		model.setIdRrcord(id);
		base = model;
		result = base.toString();
		return SUCCESS;
	}
	
	public String lingQu() {
		Json model = (Json) base;
		IDRrcordService service = (IDRrcordService)baseService;
		String sfz = model.getShenFenZheng();
		IDRrcord idRrcord = new IDRrcord();
		idRrcord.setShenFenZheng(sfz);
		service.updateStatus(idRrcord);
		base = model;
		result = base.toString();
		return SUCCESS;
	}
	
}
