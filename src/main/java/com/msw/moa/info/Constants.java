package com.msw.moa.info;

/**
 * 定数定義クラス
 * 
 * @author 王磊
 */
public class Constants {

	public static final class SystemConfig {

		/** コードデータ **/
		public static final String CODE_DATA = "codeData";

		/** チェックコード **/
		public static final String CHECK_CODE = "checkCode";

		/** ログインリクエストURL **/
		public static final String LOGIN_REQ_URL = "/common/login/validateUser";

		/** ログインユーザ **/
		public static final String LOGIN_USER = "loginUser";

		/** Cookie名称 **/
		public static final String COOKIE_LOGIN_USER = "cookieLoginUser";
		/** Cookie名称セパレータ **/
		public static final String COOKIE_SEPARATOR = "=";
		/** Cookie保存時間（秒） **/
		public static final int COOKIE_MAX_AGE = 60 * 60 * 24 * 2;

		/**
		 * ユーザグループ
		 */
		public static final class UserGroupId {

			/** 管理者 **/
			public static final Long ADMIN_USER = new Long(1);
		}
	}

	/**
	 * コード定義
	 */
	public static final class Code {

		/** True **/
		public static final Integer TRUE = new Integer(1);
		/** False **/
		public static final Integer FALSE = new Integer(0);

		/**
		 * 削除フラグ
		 */
		public static final class DelFlag {

			/** 削除済 **/
			public static final Integer DEL_YES = new Integer(1);
			/** 未削除 **/
			public static final Integer DEL_NO = new Integer(0);
		}

		/**
		 * 有効フラグ
		 */
		public static final class ValidFlag {

			/** 有効 **/
			public static final Integer VALID_YES = new Integer(1);
			/** 無効 **/
			public static final Integer VALID_NO = new Integer(0);
		}

		/**
		 * 表示フラグ
		 */
		public static final class DisplayFlag {

			/** 表示 **/
			public static final Integer DISPLAY = new Integer(1);
			/** 非表示 **/
			public static final Integer NOT_DISPLAY = new Integer(0);
		}
	}
}
