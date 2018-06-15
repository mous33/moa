package com.msw.moa.controller.common;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.msw.moa.controller.BaseController;
import com.msw.moa.json.JsonData;
import com.msw.moa.json.common.LoginUser;
import com.msw.moa.json.common.MainMenu;
import com.msw.moa.service.common.HomeService;
import com.msw.moa.utils.UserUtils;

/**
 * ホームページコントローラー
 * 
 * @author 王磊
 */
@Controller
@RequestMapping("/common/home")
public class HomeController extends BaseController {

	/**
	 * ホームページサービス
	 */
	@Resource
	HomeService homeService;

	/**
	 * メニュー情報を表示する。
	 * 
	 * @return JSONデータ
	 */
	@RequestMapping("/showMenus")
	@ResponseBody
	public JsonData showHomePage() {
		LoginUser loginUser = UserUtils.getLoginUser();
		// ログインユーザのユーザグループIDをもとに使用可能なメニュー情報を取得する。
		List<MainMenu> menus = homeService.getMenus(loginUser.getUserGroupId());
		return new JsonData(menus);
	}

}
