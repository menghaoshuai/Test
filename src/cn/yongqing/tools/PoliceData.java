package cn.yongqing.tools;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import cn.yongqing.common.UtilDao;

public class PoliceData {
//
//	FileInputStream fis = null;
//	CsvReader csvReader = null;
//	File srcFile = new File("d:/民警照片");
//	
//	List<String> csvData = new ArrayList<String>();
//	
//	class PoliceCSVData{
//		private int sex;
//		private String post;
//		private String birthDay;
//		public int getSex() {
//			return sex;
//		}
//		public void setSex(int sex) {
//			this.sex = sex;
//		}
//		public String getPost() {
//			return post;
//		}
//		public void setPost(String post) {
//			this.post = post;
//		}
//		public String getBirthDay() {
//			return birthDay;
//		}
//		public void setBirthDay(String birthDay) {
//			this.birthDay = birthDay;
//		}
//		
//	}
//
//	public static String ToPinyin(String chinese) {
//		String pinyinStr = "";
//		char[] newChar = chinese.toCharArray();
//		HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
//		defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
//		defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
//		for (int i = 0; i < newChar.length; i++) {
//			if (newChar[i] > 128) {
//				try {
//					pinyinStr += PinyinHelper.toHanyuPinyinStringArray(
//							newChar[i], defaultFormat)[0];
//				} catch (BadHanyuPinyinOutputFormatCombination e) {
//					e.printStackTrace();
//				}
//			} else {
//				pinyinStr += newChar[i];
//			}
//		}
//		return pinyinStr;
//	}
//
//	public static boolean Copy(String start, String end) {
//		try {
//			// 要拷贝的图片
//			BufferedInputStream bis = new BufferedInputStream(
//					new FileInputStream(new File(start)));
//			// 目标的地址
//			BufferedOutputStream bos = new BufferedOutputStream(
//					new FileOutputStream(new File(end)));
//			try {
//				int val = -1;
//				while ((val = bis.read()) != -1) {
//
//					bos.write(val);
//				}
//				bos.flush();
//				bos.close();
//				bis.close();
//				return true;
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		return false;
//	}
//
//	public void initCSVData() throws IOException {
//		File f = new File("d:/民警数据", "人员.csv");
//		fis = new FileInputStream(f);
//		// isw = new InputStreamReader(fis, ENCODE);
//		// 创建CSV读对象
//		csvReader = new CsvReader(fis, Charset.forName("GBK"));
//		// CsvReader csvReader1 = new CsvReader("D:/保健品数据/"+file[i].getName(),
//		// ',', Charset.forName("GBK"));
//		// 读表头
//		csvReader.readHeaders();
//		while (csvReader.readRecord()) {
//			String hang = csvReader.getRawRecord();
//			csvData.add(hang);
//		}
//	}
//
//	public void readExcel() throws Exception {
//		/** **********创建工作簿************ */
//		File srcFile = new File("d:/民警照片");
//		System.out.println(csvData.size());
//		File copyToRoot = new File("d:/policePhotos");
//
//		Connection conn = null;
//		PreparedStatement zzSt = null;
//		PreparedStatement lhtynSt = null;
//		Statement st = null;
//		ResultSet rs = null;
//		try {
//
//			boolean bFile = srcFile.exists();
//			if (!bFile || !srcFile.isDirectory() || !srcFile.canRead()) {
//				try {
//					srcFile.createNewFile();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			} else {
//				conn = UtilDatabase.create().connection();
//				st = conn.createStatement();
//
//				File[] file = srcFile.listFiles();
//				String sql = "insert into PoliceOffice (name,aeraCode) values (?,?)";
//				zzSt = conn.prepareStatement(sql,
//						PreparedStatement.RETURN_GENERATED_KEYS);
//				sql = "insert into PeoplePolice (name,photo,post,officeCode,sex,birthDay) values (?,?,?,?,?,?)";
//				lhtynSt = conn.prepareStatement(sql);
//				int officeCode = 0;
//				String photoPrefix = "/images/policePhotos/";
//				String start = "D:/民警照片/";
//				for (int i = 0; i < file.length; i++) {
//					String officeName = file[i].getName();
//					String officePinYin = ToPinyin(officeName);
//					zzSt.setString(1, officeName + "派出所");
//					zzSt.setInt(2, 1);
//					zzSt.executeUpdate();
//					rs = zzSt.getGeneratedKeys();
//					if (rs.next()) {
//						officeCode = rs.getInt(1);
//					}
//					rs.close();
//					// System.out.println(officeName);
//
//					File copyTo = new File(copyToRoot, officePinYin);
//					if (!copyTo.exists()) {
//						copyTo.mkdirs();
//					}
//
//					File f = new File(srcFile, file[i].getName());
//					File[] childfiles = f.listFiles();
//					for (int j = 0; j < childfiles.length; j++) {
//						String policePhotoName = childfiles[j].getName();
//						String policeName = policePhotoName.replaceAll(
//								"\\.[a-zA-Z]+", "");
//						PoliceCSVData data = getCSVData(officeName + "派出所",policeName); 
//						// System.out.println(policeName);
//						// images/policePhotos/yongqing/yuhui.jpg
//						String photo = ToPinyin(policePhotoName);
//						String copyFrom = start + officeName + "/"
//								+ policePhotoName;
//						Copy(copyFrom, copyTo + "/" + photo);
//						photo = photoPrefix + officePinYin + "/" + photo;
//						// System.out.println(photo);
//						lhtynSt.setString(1, policeName);
//						lhtynSt.setString(2, photo);
//						lhtynSt.setString(3, data.getPost());
//						lhtynSt.setInt(4, officeCode);
//						lhtynSt.setInt(5, data.getSex());
//						lhtynSt.setString(6, data.getBirthDay());
//						lhtynSt.executeUpdate();
//
//					}
//				}
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			// input.close();
//			UtilDao.close(rs);
//			UtilDao.close(st);
//			UtilDao.close(zzSt);
//			UtilDao.close(lhtynSt);
//		}
//	}
//
//	private PoliceCSVData getCSVData(String officeName, String policeName) {
//		PoliceCSVData data = new PoliceCSVData();
//		for (String str : csvData) {
//			if(str.indexOf(officeName)>-1&&str.indexOf(policeName)>-1){
////				System.out.println(str);
//				String[] policeDatas = str.split(",");
//				String sex = policeDatas[1];
//				int _sex = 0;
//				System.out.println(sex);
//				if(sex.equals("男")){
//					_sex = 1;
//				}else if(sex.equals("女")){
//					_sex = 2;
//				}
//				data.setSex(_sex);
//				String post = policeDatas[3];
//				data.setPost(post);
//				String birthDay = policeDatas[4];
//				data.setBirthDay(birthDay);
//			}
//		}
//		return data;
//	}
//
//	public static void main(String[] args) {
//		try {
//			PoliceData dataLoad = new PoliceData();
//			dataLoad.initCSVData();
//			dataLoad.readExcel();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

}
