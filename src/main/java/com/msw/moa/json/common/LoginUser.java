package com.msw.moa.json.common;

import org.hibernate.validator.constraints.NotBlank;

/**
 * ログインユーザ情報
 * 
 * @author 王磊
 */
public class LoginUser {

	@NotBlank
	private String userId;
	@NotBlank
	private String password;
	private String checkCode;
	private boolean saveToCookie;
	private String userName;
	private boolean isAdmin;
	private Long userGroupId;
	private String message;

	private String sessionId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	public boolean isSaveToCookie() {
		return saveToCookie;
	}

	public void setSaveToCookie(boolean saveToCookie) {
		this.saveToCookie = saveToCookie;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Long getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(Long userGroupId) {
		this.userGroupId = userGroupId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

}
