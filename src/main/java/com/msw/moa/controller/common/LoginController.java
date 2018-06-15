package com.msw.moa.controller.common;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.msw.moa.controller.BaseController;
import com.msw.moa.info.Message;
import com.msw.moa.json.JsonData;
import com.msw.moa.json.common.LoginUser;
import com.msw.moa.service.common.LoginService;
import com.msw.moa.utils.UserUtils;

/**
 * ログインコントローラー
 * 
 * @author 王磊
 */
@Controller
@RequestMapping("/common/login")
public class LoginController extends BaseController {

	/**
	 * ログインサービス
	 */
	@Resource
	LoginService loginService;

	/**
	 * ログインユーザチェック
	 * 
	 * @return JSONデータ
	 */
	@ResponseBody
	@PostMapping("/validateUser")
	public JsonData validateUser(@Valid @RequestBody LoginUser loginUser) {
		if (loginService.validateLoginUser(loginUser)) {
			// ログインユーザ情報をセッションに保存する。
			UserUtils.setLoginUser(loginUser);
			return new JsonData(loginUser);
		} else {
			// ログイン情報チェックにエラーが発生した場合
			return new JsonData(false, getMessage(Message.E_000001));
		}
	}
}
