package com.msw.moa.json.admin;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 新規ユーザ情報
 * 
 * @author 王磊
 */
public class AD01UserRegisterInfo {

	@NotBlank
	@Length(min = 6, max = 20)
	private String userId;
	@NotBlank
	@Length(max = 20)
	private String userName;
	@NotBlank
	private String userGroupId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(String userGroupId) {
		this.userGroupId = userGroupId;
	}

}
