package com.msw.moa.json.common;

/**
 * サブメニュー情報
 * 
 * @author 王磊
 */
public class SubMenu {

	private String subMenuId;
	private String subMenuName;
	private String mainMenuName;

	public String getSubMenuId() {
		return subMenuId;
	}

	public void setSubMenuId(String subMenuId) {
		this.subMenuId = subMenuId;
	}

	public String getSubMenuName() {
		return subMenuName;
	}

	public void setSubMenuName(String subMenuName) {
		this.subMenuName = subMenuName;
	}

	public String getMainMenuName() {
		return mainMenuName;
	}

	public void setMainMenuName(String mainMenuName) {
		this.mainMenuName = mainMenuName;
	}

}
