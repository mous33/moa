package com.msw.moa.dao;

import java.util.List;

import com.msw.moa.entity.EntMtSubMenu;

/**
 * サブメニューDAOインターフェース。
 * 
 * @author 王磊
 */
public interface MtSubMenuDao extends Dao<EntMtSubMenu> {

	/**
	 * 表示順によってメニューを検索する。
	 * 
	 * @return
	 */
	public List<EntMtSubMenu> findAllByPriority();
}
