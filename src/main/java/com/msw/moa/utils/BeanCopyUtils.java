package com.msw.moa.utils;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.BigDecimalConverter;
import org.apache.commons.beanutils.converters.DoubleConverter;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.beanutils.converters.LongConverter;

import com.msw.moa.converter.DateConverter;
import com.msw.moa.converter.JsonConverter;

/**
 * オブジェクトのプロパティをコピーするユーティリティ。
 * 
 * @author user
 */
public class BeanCopyUtils extends BeanUtils {

	static {
		ConvertUtils.register(new LongConverter(null), Long.class);
		ConvertUtils.register(new IntegerConverter(null), Integer.class);
		ConvertUtils.register(new DoubleConverter(null), Double.class);
		ConvertUtils.register(new BigDecimalConverter(null), BigDecimal.class);
		ConvertUtils.register(new DateConverter(), Date.class);
		ConvertUtils.register(new JsonConverter(), String.class);
	}

	public static void copyProperties(Object dest, Object orig) {
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (Exception ex) {
			throw new IllegalArgumentException(ex);
		}

	}

}
