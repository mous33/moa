package com.msw.moa.utils;

import com.msw.moa.info.Constants.SystemConfig;
import com.msw.moa.json.common.LoginUser;

/**
 * ユーザユーティリティ
 * 
 * @author 王磊
 */
public class UserUtils {

	/**
	 * ログインユーザ情報をセッションに保存する。
	 * 
	 * @param loginUser ログインユーザ情報
	 */
	public static void setLoginUser(LoginUser loginUser) {
		ContextUtil.getsession().setAttribute(SystemConfig.LOGIN_USER, loginUser);

	}

	/**
	 * セッションからログインユーザ情報を取得する。
	 * 
	 * @return ログインユーザ情報
	 */
	public static LoginUser getLoginUser() {
		return (LoginUser)ContextUtil.getsession().getAttribute(SystemConfig.LOGIN_USER);
	}

	/**
	 * 管理者判定
	 * 
	 * @return 真偽値
	 */
	public static boolean isAdmin() {
		return getLoginUser().isAdmin();
	}

	/**
	 * セッションからログインユーザ情報を削除する。
	 */
	public static void removeLoginUser() {
		ContextUtil.getsession().removeAttribute(SystemConfig.LOGIN_USER);
	}

	/**
	 * ログインユーザIDを取得する。
	 * 
	 * @return ログインユーザID
	 */
	public static String getLoginUserId() {
		return getLoginUser().getUserId();
	}
}
