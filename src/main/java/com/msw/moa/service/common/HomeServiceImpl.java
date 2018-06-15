package com.msw.moa.service.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msw.moa.dao.MtAvailableMenuDao;
import com.msw.moa.dao.MtMainMenuDao;
import com.msw.moa.entity.EntMtAvailableMenu;
import com.msw.moa.entity.EntMtMainMenu;
import com.msw.moa.entity.EntMtSubMenu;
import com.msw.moa.info.Constants.Code.ValidFlag;
import com.msw.moa.info.Constants.SystemConfig.UserGroupId;
import com.msw.moa.json.common.MainMenu;
import com.msw.moa.json.common.SubMenu;

/**
 * ホームページサービス
 * 
 * @author 王磊
 */
@Service
@Transactional
public class HomeServiceImpl implements HomeService {

	@Resource
	MtMainMenuDao mtMainMenuDao;

	@Resource
	MtAvailableMenuDao mtAvailableMenuDao;

	/**
	 * ユーザIDによって使用可能メニュー情報を取得する。
	 * 
	 * @param userId
	 * @return
	 */
	public List<MainMenu> getMenus(Long userGroupId) {
		List<MainMenu> mainMenus = new ArrayList<MainMenu>();
		// メインメニューを取得する。
		List<EntMtMainMenu> mainMenuList = this.mtMainMenuDao.findAllByPriority();
		for (EntMtMainMenu entMainMenu : mainMenuList) {
			List<SubMenu> subMenus = new ArrayList<SubMenu>();
			Set<EntMtSubMenu> entSubMenus = entMainMenu.getEntMtSubMeuns();
			for (EntMtSubMenu entSubMenu : entSubMenus) {
				// 管理者の場合、すべてのメニューを表示する。
				if (UserGroupId.ADMIN_USER.equals(userGroupId)) {
					SubMenu subMenu = new SubMenu();
					subMenu.setSubMenuId(entSubMenu.getSubMenuId());
					subMenu.setSubMenuName(entSubMenu.getSubMenuName());
					subMenu.setMainMenuName(entMainMenu.getMainMenuName());
					subMenus.add(subMenu);
					// 管理者以外のユーザに対して、有効メニューしか表示しない。(機能追加する時、管理者が利用できる。)
				} else if (ValidFlag.VALID_YES.equals(entSubMenu.getValidFlag())) {
					List<EntMtAvailableMenu> am = mtAvailableMenuDao.findByUserGroupId(userGroupId);
					for (EntMtAvailableMenu availableMenu : am) {
						if (entSubMenu.getSubMenuId().equals(availableMenu.getEntMtSubMenu().getSubMenuId())) {
							SubMenu subMenu = new SubMenu();
							subMenu.setSubMenuId(entSubMenu.getSubMenuId());
							subMenu.setSubMenuName(entSubMenu.getSubMenuName());
							subMenu.setMainMenuName(entMainMenu.getMainMenuName());
							subMenus.add(subMenu);
							break;
						}
					}
				}
			}
			// 使用可能なサブメニューが存在しない場合、メインメニューを表示しない。
			if (subMenus.size() != 0) {
				MainMenu mainMenu = new MainMenu();
				mainMenu.setMainMenuId(entMainMenu.getMainMenuId());
				mainMenu.setMainMenuName(entMainMenu.getMainMenuName());
				mainMenu.setSubMenus(subMenus);
				mainMenus.add(mainMenu);
			}
		}
		return mainMenus;
	}
}
