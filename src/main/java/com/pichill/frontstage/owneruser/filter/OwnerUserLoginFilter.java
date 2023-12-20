package com.pichill.frontstage.owneruser.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OwnerUserLoginFilter extends HttpFilter implements Filter {
	private FilterConfig config;

	public void init(FilterConfig config) {
		this.config = config;
	}

	public void destroy() {
		config = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws ServletException, IOException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		// 【取得 session】
		HttpSession session = req.getSession();
		System.out.println("經過過濾器了");
		// 【從 session 判斷此user是否登入過】
		Object account = session.getAttribute("ownerUser");
		if (account == null) {
			System.out.println("找不到會員");
			session.setAttribute("location", req.getRequestURI());
			res.sendRedirect(req.getContextPath() + "/login/oLogin/oUserLogin.jsp");
			return;
		} else {
			chain.doFilter(request, response);
			
		}
	}
}
