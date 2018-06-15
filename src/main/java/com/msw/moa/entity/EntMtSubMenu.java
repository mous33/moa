package com.msw.moa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "MT_SUB_MENU")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Immutable
public class EntMtSubMenu extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String subMenuId;
	private String subMenuName;
	private EntMtMainMenu entMtMainMenu;
	private Integer priority;
	private Integer validFlag;

	@Id
	@Column(name = "SUB_MENU_ID", unique = true, nullable = false, length = 6)
	public String getSubMenuId() {
		return subMenuId;
	}

	public void setSubMenuId(String subMenuId) {
		this.subMenuId = subMenuId;
	}

	@Column(name = "SUB_MENU_NAME", nullable = false, length = 50)
	public String getSubMenuName() {
		return subMenuName;
	}

	public void setSubMenuName(String subMenuName) {
		this.subMenuName = subMenuName;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MAIN_MENU_ID", nullable = false)
	public EntMtMainMenu getEntMtMainMenu() {
		return entMtMainMenu;
	}

	public void setEntMtMainMenu(EntMtMainMenu entMtMainMenu) {
		this.entMtMainMenu = entMtMainMenu;
	}

	@Column(name = "PRIORITY", nullable = true, precision = 5, scale = 0)
	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	@Column(name = "VALID_FLAG", nullable = false, precision = 1, scale = 0)
	public Integer getValidFlag() {
		return validFlag;
	}

	public void setValidFlag(Integer validFlag) {
		this.validFlag = validFlag;
	}

}
