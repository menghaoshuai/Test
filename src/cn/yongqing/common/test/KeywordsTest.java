package cn.yongqing.common.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;

import cn.yongqing.common.UtilDao;
import cn.yongqing.tools.UtilDatabase;

public class KeywordsTest {
	
	
	private Logger logger;
	public KeywordsTest() {
		logger = Logger.getLogger(getClass());
	}
	
	public void load() {
//		Connection conn = null;
//		PreparedStatement st = null;
//		PreparedStatement ps = null;
//		PreparedStatement pss = null;
//		PreparedStatement yapss = null;
//		ResultSet rss = null;
//		InputStream input = null;
//		try {
//			conn = UtilDatabase.create().connection();
//			
//			String sql = "INSERT INTO `YaoDianYdrug_copyliuzhou`(yaoDianCode,tyNameCode,ydrugCode,jiage,xiaoliang,maoli,shunxu,status,kucun,guige,shengYiBao,shiYiBao,isCore,brand,ydrugName,drugUnit) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
////			ps = conn.prepareStatement(sql);
//			
//			input = new FileInputStream(file);
//			Workbook wb = Workbook.getWorkbook(input);
//			Sheet sheet = wb.getSheet(0);
//			for (int i=1; i<sheet.getRows(); i++) {
//				Cell[] cells = sheet.getRow(i);
//				String one = cells[1].getContents().trim();
//				String two = cells[2].getContents().trim();
//				String three = cells[3].getContents().trim();
//				String name = cells[4].getContents().trim();
//				String img = cells[5].getContents().trim();
//				String gongxiao = cells[6].getContents().trim();
//				String type = cells[7].getContents().trim();
//				String tongyongName = cells[8].getContents().trim();
//				String shangpinName = cells[9].getContents().trim();
//				String yingwenName = cells[10].getContents().trim();
//				String pinYin = cells[11].getContents().trim();
//				String chengFen = cells[12].getContents().trim();
//				String xingZhuang = cells[13].getContents().trim();
//				String shiyingZheng = cells[14].getContents().trim();
//				String guiGe = cells[15].getContents().trim();
//				String yongfa = cells[16].getContents().trim();
//				String buLiang = cells[17].getContents().trim();
//				String jinji = cells[18].getContents().trim();
//				String note = cells[19].getContents().trim();
//				String ertong = cells[20].getContents().trim();
//				String laoNian = cells[21].getContents().trim();
//				String funv = cells[22].getContents().trim();
//				String xiangHu = cells[23].getContents().trim();
//				String guoliang = cells[24].getContents().trim();
//				String duLi = cells[25].getContents().trim();
//				String yaodai = cells[26].getContents().trim();
//				String chuCang = cells[27].getContents().trim();
//				String baozhuang = cells[28].getContents().trim();
//				String youxiaoqi = cells[29].getContents().trim();
//				String appNumber = cells[30].getContents().trim();
//				String brand = cells[31].getContents().trim();
////				String kucun = cells[34].getContents().trim();
////				String jiage = cells[35].getContents().trim();
//				sql = "insert into YDrug(brand,name,minPrice,maxPrice,properties,diseases,symptoms,img,dosage,unEffect,appNumber,taboo,note,interaction,pharmac,component,isChinese,href,hrefInt,effectScore,sideEffectScore,sort,evaluation,hot,barCode,labelType,beizhu,guige,jixing) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
//				pss = conn.prepareStatement(sql,1);
//				pss.setString(1, brand);
//				pss.setString(2, name);
//				pss.setDouble(3, 0);
//				pss.setDouble(4, 0);
//				pss.setString(5, xingZhuang);
//				pss.setString(6, gongxiao);
//				pss.setString(7, shiyingZheng);
//				pss.setString(8, img);
//				if(yongfa.length()>1000)
//					yongfa = yongfa.substring(0, 999);
//				pss.setString(9, yongfa);
//				pss.setString(10, buLiang);
//				pss.setString(11, appNumber);
//				pss.setString(12, jinji);
//				pss.setString(13, note);
//				pss.setString(14, xiangHu);
//				pss.setString(15, duLi);
//				pss.setString(16, chengFen);
//				pss.setByte(17, appNumber.indexOf("Z")>0?(byte)1:(byte)0);
//				pss.setString(18, "");
//				pss.setInt(19, 0);
//				pss.setDouble(20, 5);
//				pss.setDouble(21, 5);
//				pss.setInt(22, 0);
//				pss.setDouble(23, 5);
//				pss.setByte(24, (byte)0);
//				pss.setInt(25, 0);
//				pss.setInt(26, 0);
//				pss.setString(27, "");
//				pss.setString(28, guiGe);
//				pss.setString(29, "");
//				pss.executeUpdate();
//				rss = pss.getGeneratedKeys();
//				int drugCode = 0 ;
//				if(rss.next()){
//					drugCode = rss.getInt(1);
//					sql = "insert into YdrugAllAttribute(drugCode,one,two,three,name,img,gongXiao,type,tongyongName,shangpinName,yingwenName,pinYin,chengFen,xingZhuang,shiyingZheng,guiGe,yongFa,buLiang,jinJi,note,erTong,laoNian,fuNv,xiangHu,guoLiang,duLi,yaoDai,chuCang,baoZhuang,youxiaoQi,appNumber,brand,zhiXing) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
//					yapss = conn.prepareStatement(sql);
//					yapss.setInt(1, drugCode);
//					yapss.setString(2, one);
//					yapss.setString(3, two);
//					yapss.setString(4, three);
//					yapss.setString(5, name);
//					yapss.setString(6, img);
//					yapss.setString(7, gongxiao);
//					if(type.equals("处方药")){
//						yapss.setByte(8, (byte)0);
//					}else if(type.equals("OTC甲类")){
//						yapss.setByte(8, (byte)1);
//					}else if(type.equals("OTC乙类")){
//						yapss.setByte(8, (byte)2);
//					}else{
//						yapss.setByte(8, (byte)3);
//					}
//					yapss.setString(9, tongyongName);
//					yapss.setString(10, shangpinName);
//					yapss.setString(11, yingwenName);
//					yapss.setString(12, pinYin);
//					yapss.setString(13, chengFen);
//					yapss.setString(14, xingZhuang);
//					yapss.setString(15, shiyingZheng);
//					yapss.setString(16, guiGe);
//					yapss.setString(17, yongfa);
//					yapss.setString(18, buLiang);
//					yapss.setString(19, jinji);
//					yapss.setString(20, note);
//					yapss.setString(21, ertong);
//					yapss.setString(22, laoNian);
//					yapss.setString(23, funv);
//					yapss.setString(24, xiangHu);
//					yapss.setString(25, guoliang);
//					yapss.setString(26, duLi);
//					yapss.setString(27, yaodai);
//					yapss.setString(28, chuCang);
//					yapss.setString(29, baozhuang);
//					yapss.setString(30, youxiaoqi);
//					yapss.setString(31, appNumber);
//					yapss.setString(32, brand);
//					yapss.setString(33, "");
//					yapss.executeUpdate();
//				}
////				ps.setInt(1, 1);
////				ps.setInt(2, 0);
////				ps.setInt(3, drugCode);
////				ps.setDouble(4, Double.parseDouble(jiage));
////				ps.setInt(5, 0);
////				ps.setInt(6, 0);
////				ps.setInt(7, 0);
////				ps.setInt(8, 0);
////				ps.setInt(9, Integer.parseInt(kucun));
////				ps.setString(10, guiGe);
//				//ps.executeUpdate();
//				System.out.println(appNumber);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			UtilDao.close(st);
//			UtilDao.close(ps);
//			UtilDao.close(pss);
//			UtilDao.close(yapss);
//		}
	}
	
	public void loadKey(){
		Connection conn = null;
		PreparedStatement ps = null;
		Statement st = null;
		Statement sts = null;
		ResultSet rs = null;
		ResultSet rss = null;
		
		try {
			conn = UtilDatabase.create().connection();
			st = conn.createStatement();
			sts = conn.createStatement();
			String keys = "我要迁户口";
			String sql = "select kw from Keywords where kw like '%" + keys + "%'";
			rs = st.executeQuery(sql);
			while (rs.next()) {
				String key = rs.getString("key");
				System.out.println(key);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			UtilDao.close(rs);
			UtilDao.close(ps);
			UtilDao.close(st);
			UtilDao.close(rss);
			UtilDao.close(sts);
			UtilDao.close(conn);
		}
	}
	
//	public void loadImg() {
//		Connection conn = null;
//		PreparedStatement st = null;
//		ResultSet rs = null;
//		ResultSet rss = null;
//		PreparedStatement ps = null;
//		Statement stm = null;
//		PreparedStatement pss = null;
//		PreparedStatement yapss = null;
////		File file = new File("D:/430yaopinhxcts.xls");
//		File file = new File("D:/changledian0311.xls");
//		InputStream input = null;
//		try {
//			conn = UtilDatabase.create().connection();
//			stm = conn.createStatement();
//			String sql = "update YDrug set img = ? where code = ?";
//			ps = conn.prepareStatement(sql);
//			
//			input = new FileInputStream(file);
//			Workbook wb = Workbook.getWorkbook(input);
//			Sheet sheet = wb.getSheet(0);
//			for (int i=0; i<sheet.getRows(); i++) {
//				Cell[] cells = sheet.getRow(i);
////				String drugCode = cells[1].getContents().trim();
////				String appNumber = cells[6].getContents().trim();
////				String img = cells[8].getContents().trim();
////				sql = "update YdrugAllAttribute set img = ? where drugCode = " + drugCode + " and appNumber = '" + appNumber + "' and code = ?";
////				pss = conn.prepareStatement(sql);
////				
////				sql = "select code,img from YdrugAllAttribute where drugCode = "+ drugCode;
////				rs = stm.executeQuery(sql);
////				while (rs.next()) {
////					int code = rs.getInt("code");
////					String imgUrl = rs.getString("img");
////					if(UtilCommon.isNull(imgUrl)){
////						pss.setString(1, img);
////						pss.setInt(2, code);
////						System.out.println(code+"    "+img);
////						pss.executeUpdate();
////					}
////				}
//				int code = Integer.parseInt(cells[1].getContents().trim());
//				String img = cells[2].getContents().trim();
//				ps.setString(1, img);
//				ps.setInt(2, code);
//				System.out.println(code+"    "+img);
////				ps.executeUpdate();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			UtilDao.close(st);
//			UtilDao.close(conn);
//			UtilDao.close(ps);
//			UtilDao.close(pss);
//			UtilDao.close(yapss);
//			UtilDao.close(rs);
//			UtilDao.close(rss);
//		}
//	}
//	
//	public void loadImgByYDrugAndYDrugALL() {
//		Connection conn = null;
//		PreparedStatement st = null;
//		ResultSet rs = null;
//		ResultSet rss = null;
//		PreparedStatement ps = null;
//		Statement stm = null;
//		PreparedStatement pss = null;
//		PreparedStatement yapss = null;
//		File file = new File("D:/changledian0311.xls");
//		InputStream input = null;
//		try {
//			conn = UtilDatabase.create().connection();
//			stm = conn.createStatement();
////			String sql = "update YDrug set img = ? where code = ?";
//			String sql = "update YdrugAllAttribute set img = ? where code = ?";
//			ps = conn.prepareStatement(sql);
//			int count = 0;
//			input = new FileInputStream(file);
//			Workbook wb = Workbook.getWorkbook(input);
//			Sheet sheet = wb.getSheet(0);
//			for (int i=0; i<sheet.getRows(); i++) {
//				Cell[] cells = sheet.getRow(i);
//				String appNumber = cells[3].getContents().trim();
//				String img = cells[2].getContents().trim();
////				sql = "select code,img from YDrug where appNumber = '"+ appNumber+"'";
//				sql = "select code,img from YdrugAllAttribute where appNumber = '"+ appNumber+"'";
//				rs = stm.executeQuery(sql);
//				while (rs.next()) {
//					int code = rs.getInt("code");
//					String imgUrl = rs.getString("img");
//					if(UtilCommon.isNull(imgUrl)){
//						ps.setString(1, img);
//						ps.setInt(2, code);
//						ps.addBatch();
//						count++;
//					}
//					System.out.println(code+"    "+imgUrl);
//				}
//				
//				System.out.println(count);
//				if(count % 100 == 0){
//					ps.executeBatch();
//					ps.clearBatch();
//				}
//			}
//			ps.executeBatch();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			UtilDao.close(st);
//			UtilDao.close(conn);
//			UtilDao.close(ps);
//			UtilDao.close(pss);
//			UtilDao.close(yapss);
//			UtilDao.close(rs);
//			UtilDao.close(rss);
//		}
//	}
//	
//	public void loads(){
//		Connection conn = null;
//		PreparedStatement ps = null;
//		Statement st = null;
//		Statement sts = null;
//		ResultSet rs = null;
//		ResultSet rss = null;
//		
//		try {
//			conn = UtilDatabase.create().connection();
//			st = conn.createStatement();
//			sts = conn.createStatement();
//			
//			String sql = "select ydrugName from YaoDianYdrug";
//			rs = st.executeQuery(sql);
//			while (rs.next()) {
//				String name = rs.getString("ydrugName");
//				Robot r =new Robot();
//				r.delay(800);
//				System.out.println("药品名称：" + name);
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			UtilDao.close(rs);
//			UtilDao.close(ps);
//			UtilDao.close(st);
//			UtilDao.close(rss);
//			UtilDao.close(sts);
//			UtilDao.close(conn);
//		}
//	}
	
	public static void main(String[] args) {
		try {
			KeywordsTest dataLoad = new KeywordsTest();
			dataLoad.loadKey();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
