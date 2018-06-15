package com.msw.moa.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * エンティティ基底クラス
 * 
 * @author 王磊
 */
@MappedSuperclass
public class AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 更新ユーザ。
	 */
	private String updUser = null;
	/**
	 * 更新日時。
	 */
	private Timestamp updateTimestamp = null;
	/**
	 * 作成ユーザ。
	 */
	private String createUser = null;
	/**
	 * 作成日時。
	 */
	private Timestamp createTimestamp = null;

	@Column(name = "UPD_USER", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public String getUpdUser() {
		return updUser;
	}

	public void setUpdUser(String updUser) {
		this.updUser = updUser;
	}

	@Column(name = "UPD_TS", unique = false, nullable = false, insertable = true, updatable = true, precision = 3)
	public Timestamp getUpdateTimestamp() {
		return updateTimestamp;
	}

	public void setUpdateTimestamp(Timestamp updateTimestamp) {
		this.updateTimestamp = updateTimestamp;
	}

	@Column(name = "CRT_USER", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	@Column(name = "CRT_TS", unique = false, nullable = false, insertable = true, updatable = true, precision = 3)
	public Timestamp getCreateTimestamp() {
		return createTimestamp;
	}

	public void setCreateTimestamp(Timestamp createTimestamp) {
		this.createTimestamp = createTimestamp;
	}
}
