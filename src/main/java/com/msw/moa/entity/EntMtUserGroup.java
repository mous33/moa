package com.msw.moa.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MT_USER_GROUP")
public class EntMtUserGroup extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private Long userGroupId;
	private String userGroupName;
	private Integer validFlag;
	private Set<EntMtUser> entMtUsers = new HashSet<EntMtUser>(0);
	private Set<EntMtAvailableMenu> entMtAvailableMenus = new HashSet<EntMtAvailableMenu>(0);

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_GROUP_ID", unique = true, nullable = false, precision = 3, scale = 0)
	public Long getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(Long userGroupId) {
		this.userGroupId = userGroupId;
	}

	@Column(name = "USER_GROUP_NAME", nullable = false, length = 50)
	public String getUserGroupName() {
		return userGroupName;
	}

	public void setUserGroupName(String userGroupName) {
		this.userGroupName = userGroupName;
	}

	@Column(name = "VALID_FLAG", nullable = false, precision = 1, scale = 0)
	public Integer getValidFlag() {
		return validFlag;
	}

	public void setValidFlag(Integer validFlag) {
		this.validFlag = validFlag;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "entMtUserGroup")
	public Set<EntMtUser> getEntMtUsers() {
		return entMtUsers;
	}

	public void setEntMtUsers(Set<EntMtUser> entMtUsers) {
		this.entMtUsers = entMtUsers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "entMtUserGroup")
	public Set<EntMtAvailableMenu> getEntMtAvailableMenus() {
		return entMtAvailableMenus;
	}

	public void setEntMtAvailableMenus(Set<EntMtAvailableMenu> entMtAvailableMenus) {
		this.entMtAvailableMenus = entMtAvailableMenus;
	}

}
