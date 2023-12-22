package com.pichill.frontstage.generaluser.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.pichill.frontstage.generaluser.service.GeneralUserServiceFront;
import com.pichill.generaluser.entity.GeneralUser;
import java.io.IOException;
import java.util.Map;
import com.google.gson.Gson;
import redis.clients.jedis.Jedis;

@WebServlet("/verifyguser")
public class GeneralUserActiveSuccess extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		GeneralUser generalUser = (GeneralUser) session.getAttribute("generalUser");
		// 從req.getParameter拿到驗證碼
		String code = req.getParameter("verificationCode");
		System.out.println("verificationCode is " + code);
		
		GeneralUserServiceFront gUserSvcF = new GeneralUserServiceFront();
		
		Jedis jedis = null;
		try {			
			String email = generalUser.getgEmail();
			System.out.println("email is " + email);
			
			jedis = new Jedis("localhost", 6379);
			jedis.select(4);
			String getCode = jedis.get(email);
			System.out.println("getCode is " + getCode);
			
			generalUser = gUserSvcF.getGeneralUserBygEmail(email);
			
			Gson gson = new Gson();
			Map map = gson.fromJson(getCode, Map.class);
			String redisCode = (String)map.get("verificationCode");
			System.out.println("redisCode is " + redisCode);
			if (email != null) {
				if (redisCode.equals(code)) {
					System.out.println("兩者值相同! 讚啦");
					generalUser.setStatus(1);
					gUserSvcF.updateGeneralUsers(generalUser);
				} else {
					System.out.println("兩者值不匹配");
				}
			} else {
				System.out.println("取不出驗證碼");
			}

		} catch (Exception e) {
			// 異常處理
			e.printStackTrace();

		} finally {

			if (jedis != null) {
				jedis.close();
			}

		}
		res.sendRedirect(req.getContextPath() + "/login/gLogin/gUserLogin.jsp");

	}
}