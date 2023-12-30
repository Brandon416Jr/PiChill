package com.pichill.frontstage.generaluser.filter;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GeneralUserLoginFilter extends HttpFilter implements Filter {
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

		req.getHeaderNames().asIterator().forEachRemaining(h -> {
			System.out.print(h);
			System.out.print(" : ");
			System.out.println(req.getHeader(h));
		});
		
		String queryString = req.getQueryString();
		Boolean hasEcpay = Objects.isNull(queryString)? false : queryString.contains("ecpay");

		HttpSession session = req.getSession();
		System.out.println("req.getRequestedSessionId()");
		System.out.println(req.getRequestedSessionId());
		System.out.println("經過過濾器了");
		System.out.println("session.getAttribute");
		System.out.println(session.getAttribute("generalUser"));
		System.out.println("res.getStatus()");
		System.out.println(res.getStatus());
		
		
		System.out.println("----------------");

		// 【從 session 判斷此user是否登入過】
		Object account = session.getAttribute("generalUser");
		if (account == null && !hasEcpay ) {
			session.setAttribute("location", req.getRequestURI());
			res.sendRedirect(req.getContextPath() + "/login/gLogin/gUserLogin.jsp");
			return;
		} else {
			chain.doFilter(request, response);
			
		}
	}
}
