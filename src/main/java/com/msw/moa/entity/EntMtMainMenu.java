package com.msw.moa.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "MT_MAIN_MENU")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Immutable
public class EntMtMainMenu extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String mainMenuId;
	private String mainMenuName;
	private Integer priority;
	private Set<EntMtSubMenu> entMtSubMeuns = new HashSet<EntMtSubMenu>(0);

	@Id
	@Column(name = "MAIN_MENU_ID", unique = true, nullable = false, length = 20)
	public String getMainMenuId() {
		return mainMenuId;
	}

	public void setMainMenuId(String mainMenuId) {
		this.mainMenuId = mainMenuId;
	}

	@Column(name = "MAIN_MENU_NAME", nullable = false, length = 50)
	public String getMainMenuName() {
		return mainMenuName;
	}

	public void setMainMenuName(String mainMenuName) {
		this.mainMenuName = mainMenuName;
	}

	@Column(name = "PRIORITY", nullable = true, length = 5)
	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "entMtMainMenu")
	@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
	@OrderBy("priority asc")
	public Set<EntMtSubMenu> getEntMtSubMeuns() {
		return entMtSubMeuns;
	}

	public void setEntMtSubMeuns(Set<EntMtSubMenu> entMtSubMeuns) {
		this.entMtSubMeuns = entMtSubMeuns;
	}

}
