package cn.yongqing.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * <p>Title: 处理汉字和对应拼音转换的工具类</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: yiyaosou.cc</p>
 * @author 董有红
 * @version 1.0
 */

public class UtilPinYin {

	/**
     * 传入汉字字符串，拼接成对应的拼音,返回拼音字符列表
     * 出现同音字，以list列表呈现
     * 返回的拼音格式是小写字母
     *
     * @param source 被转换的字符串
     * @return 转换后的拼音列表
     */
	public static List<List<String>> getPinYin(String source) {
		source = source.replaceAll("[\\[\\], ]", "");
		// 设置汉字拼音输出的格式
		HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
		format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		format.setVCharType(HanyuPinyinVCharType.WITH_V);
		List<List<String>> list = new ArrayList<List<String>>();

		char[] chars = source.toCharArray();
		for (char _char : chars) {
			List<String> subList = new ArrayList<String>();
			// 判断能否为汉字字符
			String zifu = Character.toString(_char);
			if (zifu.matches("^[\\u4E00-\\u9FA5]$")) {
				try {
					String[] results = PinyinHelper.toHanyuPinyinStringArray(_char, format);
					Map<String, String> map = new TreeMap<String, String>();
					for (String result : results) {
						if (map.containsKey(result)) {
							continue;
						}
						map.put(result, null);
						subList.add(result);
					}
					list.add(subList);
				} catch (BadHanyuPinyinOutputFormatCombination e) {
					e.printStackTrace();
				}
			} else {
				// 如果不是汉字字符，间接取出字符
				subList.add(zifu);
				list.add(subList);
			}
		}
		return list;
	}

	/**
     * 传入汉字字符串，拼接成对应的拼音首字母,返回拼音字符列表
     * 出现同音字，以list列表呈现
     * 返回的拼音格式是大写字母
     *
     * @param source 被转换的字符串
     * @return 转换后的首字母列表
     */
	public static List<List<String>> getJianPin(String source) {
		source = source.replaceAll("[\\[\\], ]", "");
		// 设置汉字拼音输出的格式
		HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
		format.setCaseType(HanyuPinyinCaseType.UPPERCASE);
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		format.setVCharType(HanyuPinyinVCharType.WITH_V);
		List<List<String>> list = new ArrayList<List<String>>();

		char[] chars = source.toCharArray();
		for (char _char : chars) {
			List<String> subList = new ArrayList<String>();
			// 判断能否为汉字字符
			String zifu = Character.toString(_char);
			if (zifu.matches("^[\\u4E00-\\u9FA5]$")) {
				try {
					String[] results = PinyinHelper.toHanyuPinyinStringArray(_char, format);
					Map<String, String> map = new TreeMap<String, String>();
					for (String result : results) {
						result = result.substring(0,1);
						if (map.containsKey(result)) {
							continue;
						}
						map.put(result, null);
						subList.add(result);
					}
					list.add(subList);
				} catch (BadHanyuPinyinOutputFormatCombination e) {
					e.printStackTrace();
				}
			} else {
				// 如果不是汉字字符，间接取出字符
				subList.add(zifu);
				list.add(subList);
			}
		}
		return list;
	}
	
	
	
	public static void main(String[] args) {
		List<List<String>> list = getPinYin("迭代每个汉字的拼, 音数组,该分享来自程序员之家");
		System.out.println(list);
	}


}