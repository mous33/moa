package com.msw.moa.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.msw.moa.entity.EntMtSubMenu;

/**
 * サブメニューDAO実装クラス
 * 
 * @author 王磊
 */
@Repository
public class MtSubMenuDaoImpl extends BaseDao<EntMtSubMenu> implements MtSubMenuDao {

	/**
	 * 表示順によってメニューを検索する。
	 * 
	 * @return
	 */
	public List<EntMtSubMenu> findAllByPriority() {
		DetachedCriteria c = getCriteria();
		c.createAlias("entMtMainMenu", "m");
		c.addOrder(Order.asc("m.priority"));
		c.addOrder(Order.asc("priority"));
		return findByCriteria(c);
	}
}
