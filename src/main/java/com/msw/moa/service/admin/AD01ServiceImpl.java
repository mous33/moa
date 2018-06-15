package com.msw.moa.service.admin;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msw.moa.dao.MtUserDao;
import com.msw.moa.dao.MtUserGroupDao;
import com.msw.moa.entity.EntMtUser;
import com.msw.moa.entity.EntMtUserGroup;
import com.msw.moa.info.Constants.Code.ValidFlag;
import com.msw.moa.json.admin.AD01UserGroupInfo;
import com.msw.moa.json.admin.AD01UserRegisterInfo;
import com.msw.moa.json.admin.AD01UserResultInfo;
import com.msw.moa.utils.BeanCopyUtils;
import com.msw.moa.utils.Md5Encrypt;

/**
 * ユーザ管理サービス
 * 
 * @author 王磊
 */
@Service
@Transactional
public class AD01ServiceImpl implements AD01Service {

	@Resource
	MtUserDao mtUserDao;

	@Resource
	MtUserGroupDao mtUserGroupDao;

	/**
	 * ユーザ情報を取得する。
	 * 
	 * @return
	 */
	public List<AD01UserResultInfo> getUsers() {
		List<AD01UserResultInfo> userList = new ArrayList<>();
		// ユーザ情報を取得する。
		List<EntMtUser> entList = this.mtUserDao.findAllOrderByUserId();
		for (EntMtUser ent : entList) {
			AD01UserResultInfo user = new AD01UserResultInfo();
			BeanCopyUtils.copyProperties(user, ent);
			user.setUserGroupName(ent.getEntMtUserGroup().getUserGroupName());
			userList.add(user);
		}
		return userList;
	}

	/**
	 * ユーザグループ情報を取得する。
	 * 
	 * @return
	 */
	public List<AD01UserGroupInfo> showUserGroups() {
		List<AD01UserGroupInfo> list = new ArrayList<>();
		List<EntMtUserGroup> entList = this.mtUserGroupDao.findValid();
		for (EntMtUserGroup ent : entList) {
			AD01UserGroupInfo info = new AD01UserGroupInfo();
			BeanCopyUtils.copyProperties(info, ent);
			list.add(info);
		}
		return list;
	}

	/**
	 * ユーザID存在チェック
	 * 
	 * @param userId
	 * @return
	 */
	public boolean isUserIdExist(String userId) {
		EntMtUser ent = this.mtUserDao.findById(userId);
		return ent != null;
	}

	/**
	 * ユーザ登録処理
	 * 
	 * @param user
	 * @return
	 */
	public void addUser(AD01UserRegisterInfo user) {
		EntMtUser ent = new EntMtUser();
		ent.setUserId(user.getUserId());
		// 初期パスワードをユーザIDと同じよに設定する。
		ent.setPassword(Md5Encrypt.md5(user.getUserId()));
		ent.setUserName(user.getUserName());
		EntMtUserGroup entMtUserGroup = new EntMtUserGroup();
		entMtUserGroup.setUserGroupId(Long.valueOf(user.getUserGroupId()));
		ent.setEntMtUserGroup(entMtUserGroup);
		// 有効
		ent.setValidFlag(ValidFlag.VALID_YES);
		this.mtUserDao.persist(ent);
	}
}
