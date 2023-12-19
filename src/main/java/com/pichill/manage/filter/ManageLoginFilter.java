package com.pichill.manage.filter;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ManageLoginFilter extends HttpFilter implements Filter {
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
		Object account = session.getAttribute("manage");
		if (account == null) {
			System.out.println("找不到admin");
			session.setAttribute("location", req.getRequestURI());
			res.sendRedirect(req.getContextPath() + "/login/mLogin/manageLogin.jsp");
			return;
		} else {
			chain.doFilter(request, response);
			
		}
	}

}