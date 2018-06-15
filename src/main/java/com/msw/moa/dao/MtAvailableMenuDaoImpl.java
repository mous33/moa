package com.msw.moa.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.springframework.stereotype.Repository;

import com.msw.moa.entity.EntMtAvailableMenu;

/**
 * 使用可能メニューDAO
 * 
 * @author 王磊
 */
@Repository
public class MtAvailableMenuDaoImpl extends BaseDao<EntMtAvailableMenu> implements MtAvailableMenuDao {

	/**
	 * ユーザグループIDによって使用可能なメニュー情報を取得する。
	 * 
	 * @param userGroupId 用户组
	 * @return
	 */
	public List<EntMtAvailableMenu> findByUserGroupId(Long userGroupId) {
		DetachedCriteria c = getCriteria();
		// ユーザグループID
		c.createAlias("entMtUserGroup", "m");
		c.add(Property.forName("m.userGroupId").eq(userGroupId));
		return findByCriteria(c);
	}

}
