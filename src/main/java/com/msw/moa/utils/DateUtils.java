package com.msw.moa.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日付処理ユーティリティ
 * 
 * @author 王磊
 */
public class DateUtils {

	/** (yyyy) */
	private static final SimpleDateFormat DATE_Y = new SimpleDateFormat("yyyy");

	/** (yyyy-MM) */
	private static final SimpleDateFormat DATE_YM = new SimpleDateFormat("yyyy-MM");

	/** (yyyy-MM-dd) */
	private static final SimpleDateFormat DATE_YMD = new SimpleDateFormat("yyyy-MM-dd");

	public static int getMonths(Date date1, Date date2) {
		int iMonth = 0;
		try {

			Calendar objCalendarDate1 = Calendar.getInstance();
			objCalendarDate1.setTime(date1);

			Calendar objCalendarDate2 = Calendar.getInstance();
			objCalendarDate2.setTime(date2);
			if (objCalendarDate2.equals(objCalendarDate1)) {
				return 0;
			}
			if (objCalendarDate1.after(objCalendarDate2)) {
				Calendar temp = objCalendarDate1;
				objCalendarDate1 = objCalendarDate2;
				objCalendarDate2 = temp;
			}
			if (objCalendarDate2.get(Calendar.YEAR) > objCalendarDate1.get(Calendar.YEAR)) {
				iMonth = ((objCalendarDate2.get(Calendar.YEAR) - objCalendarDate1.get(Calendar.YEAR)) * 12 + objCalendarDate2.get(Calendar.MONTH)) - objCalendarDate1.get(Calendar.MONTH);
			} else {
				iMonth = objCalendarDate2.get(Calendar.MONTH) - objCalendarDate1.get(Calendar.MONTH);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return iMonth;
	}

	public static Date addMonth(Date date, int addMonth) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, addMonth);
		return cal.getTime();
	}

	public static Integer date2IntegerYear(Date date) {
		return date2IntegerDate(date, "yyyy");
	}

	public static Integer date2IntegerYm(Date date) {
		return date2IntegerDate(date, "yyyyMM");
	}

	public static Integer date2IntegerYmd(Date date) {
		return date2IntegerDate(date, "yyyyMMdd");
	}

	private static Integer date2IntegerDate(Date d, String pattern) {
		if (d == null) {
			return null;
		}
		DateFormat df = new SimpleDateFormat(pattern);
		df.setLenient(false);
		String strYMD = df.format(d);
		return Integer.valueOf(strYMD);
	}

	public static Date stringDate2Date(String date) {
		try {
			int len = date.length();
			String pattern = null;
			if (len == 4) {
				pattern = "yyyy";
			} else if (len == 7) {
				pattern = "yyyy-MM";
			} else if (len == 10) {
				pattern = "yyyy-MM-dd";
			} else {
				throw new Exception("日付のフォーマットが誤る");
			}
			DateFormat df = new SimpleDateFormat(pattern);
			return df.parse(date);
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	public static String date2StringYear(Date date) {
		return getDateY().format(date);
	}

	public static String date2StringYm(Date date) {
		return getDateYm().format(date);
	}

	public static String date2StringYmd(Date date) {
		return getDateYmd().format(date);
	}

	static SimpleDateFormat getDateY() {
		return (SimpleDateFormat)DATE_Y.clone();
	}

	static SimpleDateFormat getDateYm() {
		return (SimpleDateFormat)DATE_YM.clone();
	}

	static SimpleDateFormat getDateYmd() {
		return (SimpleDateFormat)DATE_YMD.clone();
	}
}
