package com.msw.moa.dao;

import java.util.List;

import com.msw.moa.entity.EntMtAvailableMenu;

/**
 * 使用可能メニューDAO
 * 
 * @author 王磊
 */
public interface MtAvailableMenuDao extends Dao<EntMtAvailableMenu> {

	/**
	 * ユーザグループIDによって使用可能なメニュー情報を取得する。
	 * 
	 * @param userGroupId ユーザグループID
	 * @return
	 */
	public List<EntMtAvailableMenu> findByUserGroupId(Long userGroupId);
}
