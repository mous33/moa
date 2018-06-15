package com.msw.moa.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * コンテキストユーティリティ
 * 
 * @author 王磊
 */
public class ContextUtil {

	/**
	 * セッションを取得する。
	 * 
	 * @return セッション
	 */
	public static HttpSession getsession() {
		return getRequest().getSession();
	}

	/**
	 * リクエストを取得する。
	 * 
	 * @return HTTPリクエスト
	 */
	public static HttpServletRequest getRequest() {
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		return request;
	}
}
