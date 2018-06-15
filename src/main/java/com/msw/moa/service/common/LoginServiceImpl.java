package com.msw.moa.service.common;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msw.moa.dao.MtUserDao;
import com.msw.moa.entity.EntMtUser;
import com.msw.moa.entity.EntMtUserGroup;
import com.msw.moa.info.Constants.SystemConfig.UserGroupId;
import com.msw.moa.json.common.LoginUser;
import com.msw.moa.utils.Md5Encrypt;

/**
 * ログインユーザサービス
 * 
 * @author 王磊
 */
@Service
@Transactional
public class LoginServiceImpl implements LoginService {

	/**
	 * ユーザDAO
	 */
	@Resource
	private MtUserDao mtUserDao;

	/**
	 * ログインユーザ情報チェック
	 * 
	 * @param loginUser
	 * @return
	 */
	@Override
	public boolean validateLoginUser(LoginUser loginUser) {
		EntMtUser ent = this.mtUserDao.getValidUser(loginUser.getUserId(), Md5Encrypt.md5(loginUser.getPassword()));
		if (ent != null) {
			// ユーザ名称
			loginUser.setUserName(ent.getUserName());
			EntMtUserGroup entMUG = ent.getEntMtUserGroup();
			// ユーザグループID
			loginUser.setUserGroupId(entMUG.getUserGroupId());
			StringBuilder message = new StringBuilder();
			message.append(loginUser.getUserName());
			message.append("【");
			// ユーザグループ名称
			message.append(entMUG.getUserGroupName());
			message.append("】");
			loginUser.setMessage(message.toString());
			loginUser.setIsAdmin(UserGroupId.ADMIN_USER.equals(entMUG.getUserGroupId()));
			return true;
		} else {
			return false;
		}
	}

}
