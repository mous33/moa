package com.msw.moa.converter;

import java.util.Date;

import org.apache.commons.beanutils.Converter;

import com.msw.moa.utils.DateUtils;

/**
 * 文字列を日付に変換する
 * 
 * @author user
 */
public class JsonConverter implements Converter {

	@SuppressWarnings("unchecked")
	@Override
	public <T> T convert(Class<T> arg0, Object obj) {
		if (obj instanceof Long || obj instanceof Integer || obj instanceof Double) {
			return (T)(obj == null ? null : obj.toString());
		} else if (obj instanceof Date) {
			return (T)DateUtils.date2StringYmd((Date)obj);
		}
		return (T)obj;
	}

}
