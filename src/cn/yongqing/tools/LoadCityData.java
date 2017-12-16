package cn.yongqing.tools;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;

import cn.yongqing.common.UtilCommon;
import cn.yongqing.common.UtilDao;

public class LoadCityData {
	
	public void load() {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = UtilDatabase.create().connection();
			
			String sql = "insert into City (code,name,parentCode,shortName,grade,zone,zip,pinyin) values (?,?,?,?,?,?,?,?)";
			st = conn.prepareStatement(sql);
			
			String filename = UtilCommon.getFullPathRelateClass("content.txt", this.getClass());
			File file = new File(filename);
			String[] lines = UtilCommon.readInput(file).split("[\r\n]+");
			
			for (String line : lines) {
				String[] items = line.split("\t");
				st.setString(1, items[0]);
				st.setString(2, items[1]);
				st.setString(3, items[2]);
				st.setString(4, items[3]);
				st.setString(5, items[4]);
				st.setString(6, items[5]);
				st.setString(7, items[6]);
				st.setString(8, items[7]);
				st.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			UtilDao.close(st);
		}
	}
	
	public static void main(String[] args) {
		try {
			LoadCityData dataLoad = new LoadCityData();
			dataLoad.load();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
