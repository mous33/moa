package com.msw.moa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MT_USER")
public class EntMtUser extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String userId;
	private String password;
	private String userName;
	private EntMtUserGroup entMtUserGroup;
	private Integer validFlag;

	@Id
	@Column(name = "USER_ID", unique = true, nullable = false, length = 20)
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "PASSWORD", nullable = false, length = 100)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "USER_NAME", nullable = false, length = 20)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_GROUP_ID", nullable = false)
	public EntMtUserGroup getEntMtUserGroup() {
		return entMtUserGroup;
	}

	public void setEntMtUserGroup(EntMtUserGroup entMtUserGroup) {
		this.entMtUserGroup = entMtUserGroup;
	}

	@Column(name = "VALID_FLAG", nullable = false, precision = 1, scale = 0)
	public Integer getValidFlag() {
		return validFlag;
	}

	public void setValidFlag(Integer validFlag) {
		this.validFlag = validFlag;
	}

}
