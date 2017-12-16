package cn.yongqing.converter;

import java.lang.reflect.Member;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import ognl.TypeConverter;
import cn.yongqing.common.UtilCommon;
import cn.yongqing.common.UtilDate;

public class DateConverter implements TypeConverter {

	public Object convertValue(Map context, Object target, Member member, String propertyName, Object value, Class toType) {
		if (UtilCommon.isNull(value)) {
			return null;
		} else if (value instanceof Date) {
			Date date = (Date)value;
			Timestamp timestamp = new Timestamp(date.getTime());
    		String result = UtilDate.timestampTrferStr(timestamp);
    		return result;
    	} else if (Date.class.isAssignableFrom(toType)) {
    		try {
	    		String[] _values = (String[])value;
	    		String _value = _values[0];
	    		Date tate = new Date(UtilDate.strTrferTimestamp(_value).getTime());
	    		return tate;
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
		return null;
	}
}
