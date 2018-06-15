package com.msw.moa.service.common;

import com.msw.moa.json.common.LoginUser;

/**
 * ログインサービス
 * 
 * @author 王磊
 *
 */
public interface LoginService {

	/**
	 * ログインユーザ情報チェック
	 * 
	 * @param loginUser
	 * @return
	 */
	public boolean validateLoginUser(LoginUser loginUser);
}
