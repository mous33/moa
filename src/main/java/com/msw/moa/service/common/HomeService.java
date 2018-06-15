package com.msw.moa.service.common;

import java.util.List;

import com.msw.moa.json.common.MainMenu;

/**
 * ホームページサービス
 * 
 * @author 王磊
 */
public interface HomeService {

	/**
	 * ユーザグループIDによって使用可能メニュー情報を取得する。
	 * 
	 * @param userId
	 * @return
	 */
	public List<MainMenu> getMenus(Long userGroupId);
}
