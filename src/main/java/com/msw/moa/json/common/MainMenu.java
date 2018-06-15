package com.msw.moa.json.common;

import java.util.ArrayList;
import java.util.List;

/**
 * メインメニュー情報
 * 
 * @author 王磊
 */
public class MainMenu {

	private String mainMenuId;
	private String mainMenuName;
	private List<SubMenu> submMnus = new ArrayList<SubMenu>();

	public String getMainMenuId() {
		return mainMenuId;
	}

	public void setMainMenuId(String mainMenuId) {
		this.mainMenuId = mainMenuId;
	}

	public String getMainMenuName() {
		return mainMenuName;
	}

	public void setMainMenuName(String mainMenuName) {
		this.mainMenuName = mainMenuName;
	}

	public List<SubMenu> getSubMenus() {
		return submMnus;
	}

	public void setSubMenus(List<SubMenu> submMnus) {
		this.submMnus = submMnus;
	}

}
