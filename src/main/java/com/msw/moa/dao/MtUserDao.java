package com.msw.moa.dao;

import java.util.List;

import com.msw.moa.entity.EntMtUser;

/**
 * ユーザDAOインターフェース
 * 
 * @author 王磊
 */
public interface MtUserDao extends Dao<EntMtUser> {

	/**
	 * ユーザIDによって有効のユーザデータを取得する。<br>
	 * 
	 * @param userId ユーザID
	 * @param userId パスワード
	 * @return ユーザエンティティ
	 */
	public EntMtUser getValidUser(String userId, String password);

	/**
	 * ユーザIDの昇順でユーザ情報を取得する。
	 * 
	 * @return
	 */
	public List<EntMtUser> findAllOrderByUserId();

}
