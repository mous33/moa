package com.msw.moa.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.msw.moa.info.Constants.SystemConfig;
import com.msw.moa.json.common.LoginUser;

/**
 * ユーザ権限チェックインターセプター
 * 
 * @author 王磊
 */
public class AuthorityInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3) throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		String url = request.getServletPath().toString();
		if (SystemConfig.LOGIN_REQ_URL.equals(url)) {
			return true;
		}
		LoginUser user = (LoginUser)request.getSession().getAttribute(SystemConfig.LOGIN_USER);
		if (user == null) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("{\"isNotLogin\":true}");
			response.getWriter().flush();
			response.getWriter().close();
			return false;
		}
		return true;
	}

}
