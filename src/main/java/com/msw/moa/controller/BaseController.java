package com.msw.moa.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

/**
 * コントローラー基底クラス
 * 
 * @author 王磊
 */
public class BaseController {

	@Autowired
	private MessageSource messageSource;

	public String getMessage(String messageId) {
		return messageSource.getMessage(messageId, null, Locale.getDefault());
	}
}
