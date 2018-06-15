package com.msw.moa.converter;

import org.apache.commons.beanutils.Converter;

import com.msw.moa.utils.DateUtils;

/**
 * 文字列を日付に変換する
 * 
 * @author user
 */
public class DateConverter implements Converter {

	@SuppressWarnings("unchecked")
	@Override
	public <T> T convert(Class<T> arg0, Object arg1) {
		return (T)DateUtils.stringDate2Date(arg1.toString());
	}

}
