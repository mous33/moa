package com.msw.moa.controller.admin;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.msw.moa.controller.BaseController;
import com.msw.moa.info.Message;
import com.msw.moa.json.JsonData;
import com.msw.moa.json.admin.AD01UserGroupInfo;
import com.msw.moa.json.admin.AD01UserRegisterInfo;
import com.msw.moa.json.admin.AD01UserResultInfo;
import com.msw.moa.service.admin.AD01Service;

/**
 * ユーザ管理コントローラー
 * 
 * @author 王磊
 */
@Controller
@RequestMapping("/admin/ad01")
public class AD01Controller extends BaseController {

	/**
	 * ユーザ管理サービス
	 */
	@Resource
	AD01Service ad01Service;

	/**
	 * ユーザ情報を表示する。
	 * 
	 * @return JSONデータ
	 */
	@RequestMapping("/showUsers")
	@ResponseBody
	public JsonData showUsers() {
		// ユーザIDの昇順でユーザ情報を取得する。
		List<AD01UserResultInfo> users = ad01Service.getUsers();
		return new JsonData(users);
	}

	/**
	 * ユーザグループ情報を取得する。
	 * 
	 * @return JSONデータ
	 */
	@RequestMapping("/showUserGroups")
	@ResponseBody
	public JsonData showUserGroups() {
		// ユーザIDの昇順で有効なユーザグループ情報を取得する。
		List<AD01UserGroupInfo> userGroups = ad01Service.showUserGroups();
		return new JsonData(userGroups);
	}

	/**
	 * 新規ユーザ登録
	 * 
	 * @return JSONデータ
	 */
	@RequestMapping("/addUser")
	@ResponseBody
	public JsonData addUser(@Valid @RequestBody AD01UserRegisterInfo user) {
		// ユーザID存在チェック
		if (this.ad01Service.isUserIdExist(user.getUserId())) {
			return new JsonData(false, getMessage(Message.E_AD0101));
		} else {
			// ユーザ登録処理
			this.ad01Service.addUser(user);
			return new JsonData(true, getMessage(Message.I_000003));
		}
	}
}
