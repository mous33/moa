package com.msw.moa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "MT_AVAILABLE_MENU")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Immutable
public class EntMtAvailableMenu extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private Long availableMenuId;
	private EntMtUserGroup entMtUserGroup;
	private EntMtSubMenu entMtSubMenu;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "AVAILABLE_MENU_ID", unique = true, nullable = false, length = 10)
	public Long getAvailableMenuId() {
		return availableMenuId;
	}

	public void setAvailableMenuId(Long availableMenuId) {
		this.availableMenuId = availableMenuId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_GROUP_ID", nullable = false)
	public EntMtUserGroup getEntMtUserGroup() {
		return entMtUserGroup;
	}

	public void setEntMtUserGroup(EntMtUserGroup entMtUserGroup) {
		this.entMtUserGroup = entMtUserGroup;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUB_MENU_ID", nullable = false)
	public EntMtSubMenu getEntMtSubMenu() {
		return entMtSubMenu;
	}

	public void setEntMtSubMenu(EntMtSubMenu entMtSubMenu) {
		this.entMtSubMenu = entMtSubMenu;
	}

}
