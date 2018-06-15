package com.msw.moa.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.msw.moa.entity.EntMtUser;
import com.msw.moa.info.Constants.Code.ValidFlag;

/**
 * ユーザDAO実装クラス
 * 
 * @author 王磊
 */
@Repository
public class MtUserDaoImpl extends BaseDao<EntMtUser> implements MtUserDao {

	/**
	 * ユーザIDによって有効のユーザデータを取得する。<br>
	 * 
	 * @param userId ユーザID
	 * @param userId パスワード
	 * @return ユーザエンティティ
	 */
	public EntMtUser getValidUser(String userId, String password) {
		DetachedCriteria c = getCriteria();
		// ユーザID
		c.add(Restrictions.eq("userId", userId));
		// パスワード
		c.add(Restrictions.eq("password", password));
		// 有効フラグ
		c.add(Restrictions.eq("validFlag", ValidFlag.VALID_YES));
		// ユーザグループ
		c.createAlias("entMtUserGroup", "m");
		// 有効フラグ
		c.add(Restrictions.eq("m.validFlag", ValidFlag.VALID_YES));
		List<EntMtUser> entList = findByCriteria(c);
		return (entList.size() == 0) ? null : entList.get(0);
	}

	/**
	 * ユーザIDの昇順でユーザ情報を取得する。
	 * 
	 * @return
	 */
	public List<EntMtUser> findAllOrderByUserId() {
		DetachedCriteria c = getCriteria();
		// ユーザID
		c.addOrder(Order.asc("userId"));
		return findByCriteria(c);
	}
}
