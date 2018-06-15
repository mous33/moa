package com.msw.moa.utils;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 文字列ユーティリティ
 * 
 * @author 王磊
 */
public class StringUtils {

	// Mailフォーマット
	private static final String MAIL_FORMAT = "^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\\.([a-zA-Z0-9_-])+)+$";

	/**
	 * Mailフォーマットチェック
	 * 
	 * @param mail
	 * @return
	 */
	public static boolean isMail(String mail) {
		Pattern p = Pattern.compile(MAIL_FORMAT);
		Matcher m = p.matcher(mail);
		return m.matches();
	}

	/**
	 * 先頭文字埋め処理
	 * 
	 * @param target
	 * @param length
	 * @param c
	 * @return
	 */
	public static String leftPadd(String target, int length, char c) {
		if (target == null || "".equals(target)) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		int len = target.length();
		while (sb.length() < length - len) {
			sb.append(c);
		}
		sb.append(target);
		return sb.substring(0, length);
	}

	/**
	 * 末尾文字埋め処理
	 * 
	 * @param target
	 * @param length
	 * @param c
	 * @return
	 */
	public static String rightPadd(String target, int length, char c) {
		if (target == null || "".equals(target)) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		sb.append(target);
		while (sb.length() < length) {
			sb.append(c);
		}
		return sb.substring(0, length);
	}

	/**
	 * 金額フォーマット処理
	 * 
	 * @param num
	 * @return
	 */
	public static String number2FormatAmount(Number num) {
		DecimalFormat format = new DecimalFormat("#,###");
		format.setParseBigDecimal(true);
		format.setRoundingMode(RoundingMode.UNNECESSARY);
		String strAmount = format.format(num);
		return strAmount;
	}
}
