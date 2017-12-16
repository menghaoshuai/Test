package cn.yongqing.converter;

import java.lang.reflect.Member;
import java.sql.Timestamp;
import java.util.Map;

import ognl.TypeConverter;
import cn.yongqing.common.UtilCommon;
import cn.yongqing.common.UtilDate;

public class TimestampConverter implements TypeConverter {

	public Object convertValue(Map context, Object target, Member member, String propertyName, Object value, Class toType) {
		if (UtilCommon.isNull(value)) {
			return null;
		} else if (value instanceof Timestamp) {
			Timestamp timestamp = (Timestamp)value;
    		String result = UtilDate.timestampTrferStr(timestamp);
    		return result;
    	} else if (Timestamp.class.isAssignableFrom(toType)) {
    		try {
	    		String[] _values = (String[])value;
	    		String _value = _values[0];
	    		Timestamp timestamp = new Timestamp(UtilDate.strTrferTimestamp(_value).getTime());
	    		return timestamp;
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
		return null;
	}
}
