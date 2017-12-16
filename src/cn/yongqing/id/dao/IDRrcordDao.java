package cn.yongqing.id.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.yongqing.base.BaseDao;
import cn.yongqing.base.Pager;
import cn.yongqing.common.UtilCommon;
import cn.yongqing.common.UtilDao;
import cn.yongqing.id.entity.IDRrcord;
import cn.yongqing.json.entity.Json;

public class IDRrcordDao extends BaseDao {

	public List<IDRrcord> selects(Pager pager,IDRrcord model) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		List<IDRrcord> list = new ArrayList<IDRrcord>();
		try {
			conn = getSession().connection();
			st = conn.createStatement();
			String hql = "from " + IDRrcord.class.getName() + " where 1=1 ";
			if(model.getStatus()>0)
				hql += " and status=" + model.getStatus();
			if(!UtilCommon.isNull(model.getShenFenZheng()))
				hql += " and (shenFenZheng='" + model.getShenFenZheng()+"' or name='"+model.getShenFenZheng()+"')";
			
			int total = 0;
			String sql = "select count(code) count from IDRrcord as idr ";
			String where  = hql.substring(hql.indexOf("where"));
			sql += where;
			rs = st.executeQuery(sql);
			if(rs.next()){
				total = rs.getInt("count");
			}
			rs.close();
			int pageSize = pager.getRowsPerPage();
			int totalPage = total / pageSize;
			if(total%pageSize!=0)
				totalPage++;
			hql += " order by updateDate desc";
			list = selects(hql,pager);
			if(list.size()>0){
				list.get(0).setTotalPage(totalPage);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			UtilDao.close(rs);
			UtilDao.close(st);
		}
		
		
		return list;
	}

	public IDRrcord insertId(Json model) {
		IDRrcord idRrcord = null;
		String id = model.getShenFenZheng();
		id = id.toUpperCase();
		if(!UtilCommon.isNull(id)){
			String name = model.getName();
			idRrcord = new IDRrcord();
			idRrcord.setShenFenZheng(id);
			idRrcord.setName(name);
			idRrcord.setStatus((byte) 1);
			idRrcord.setUpdateDate(new Timestamp(System.currentTimeMillis()));
			insert(idRrcord);
		}
		return idRrcord;
		
	}

	@SuppressWarnings("unchecked")
	public void deleteRepeatedData(int addNum) {
//		HibernateTemplate template = getHibernateTemplate();
		String hql = "from " + IDRrcord.class.getName() + " where status=1 order by updateDate desc ";
		Set<String> sfzs = new HashSet<String>();
	//	List<IDRrcord> list = template.find(hql);
		List<IDRrcord> list = selects(hql, 0, addNum);
		for (IDRrcord idRrcord : list) {
			String sfz = idRrcord.getShenFenZheng();
			if(sfzs.contains(sfz)){
				delete(idRrcord);
			}else{
				sfzs.add(sfz);
			}
		}
	}

	public void updateStatus(IDRrcord model) {
		HibernateTemplate template = getHibernateTemplate();
		String sfz = model.getShenFenZheng();
		sfz = sfz.toUpperCase();
		if(!UtilCommon.isNull(sfz)){
			String hql = "from " + IDRrcord.class.getName() + " where shenFenZheng='"+sfz+"'";
			@SuppressWarnings("unchecked")
			List<IDRrcord> list = template.find(hql);
			for (IDRrcord idRrcord : list) {
				idRrcord.setStatus((byte) 2);
				idRrcord.setUpdateDate(new Timestamp(System.currentTimeMillis()));
				update(idRrcord);
			}
		}
		int code = model.getCode();
		if(code>0){
			IDRrcord idRrcord = (IDRrcord) template.get(IDRrcord.class, code);
			idRrcord.setStatus((byte) 2);
			idRrcord.setUpdateDate(new Timestamp(System.currentTimeMillis()));
			update(idRrcord);
		}
	}

	public IDRrcord selectBySFZ(IDRrcord model) {
		HibernateTemplate template = getHibernateTemplate();
		String sfz = model.getShenFenZheng();
		sfz = sfz.toUpperCase();
		IDRrcord idRrcord = null;
		if(!UtilCommon.isNull(sfz)){
			String hql = "from " + IDRrcord.class.getName() + " where shenFenZheng='"+sfz+"' order by updateDate desc";
			@SuppressWarnings("unchecked")
			List<IDRrcord> list = template.find(hql);
			if(list.size()>0){
				idRrcord = list.get(0);
			}
		}
		return idRrcord;
	}

	public IDRrcord updateStatusByRobot(IDRrcord model) {
		HibernateTemplate template = getHibernateTemplate();
		int code = model.getCode();
		IDRrcord idRrcord = (IDRrcord) template.get(IDRrcord.class, code);
		idRrcord.setStatus((byte) 2);
		idRrcord.setUpdateDate(new Timestamp(System.currentTimeMillis()));
		update(idRrcord);
		return idRrcord;
	}

	public IDRrcord updatequeryReplyDetail(IDRrcord model) {
		Connection conn = null;
		Statement st = null;
		HibernateTemplate template = getHibernateTemplate();
		String hql = "from " + IDRrcord.class.getName()
				+ " where code= 1";
		@SuppressWarnings("unchecked")
		List<IDRrcord> list = template.find(hql);
		conn = getSession().connection();
		try {
			st = conn.createStatement();
			String sql = "update IDRrcord set status=1 where code = 1";
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			UtilDao.close(st);
		}
		return list.get(0);
	}

	public IDRrcord updateReplyDetailStatus(IDRrcord model) {
		HibernateTemplate template = getHibernateTemplate();
		IDRrcord idRrcord = (IDRrcord) template.get(IDRrcord.class, 1);
		idRrcord.setStatus((byte)2);
		update(idRrcord);
		return idRrcord;
	}
}
