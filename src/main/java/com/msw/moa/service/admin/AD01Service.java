package com.msw.moa.service.admin;

import java.util.List;

import com.msw.moa.json.admin.AD01UserGroupInfo;
import com.msw.moa.json.admin.AD01UserRegisterInfo;
import com.msw.moa.json.admin.AD01UserResultInfo;

/**
 * ユーザ管理サービス
 * 
 * @author 王磊
 */
public interface AD01Service {

	/**
	 * ユーザ情報を取得する。
	 * 
	 * @return
	 */
	public List<AD01UserResultInfo> getUsers();

	/**
	 * ユーザグループ情報を取得する。
	 * 
	 * @return
	 */
	public List<AD01UserGroupInfo> showUserGroups();

	/**
	 * ユーザID存在チェック
	 * 
	 * @param userId
	 * @return
	 */
	public boolean isUserIdExist(String userId);

	/**
	 * ユーザ登録処理
	 * 
	 * @param user
	 * @return
	 */
	public void addUser(AD01UserRegisterInfo user);
}
