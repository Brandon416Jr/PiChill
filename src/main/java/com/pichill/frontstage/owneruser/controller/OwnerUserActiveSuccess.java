package com.pichill.frontstage.owneruser.controller;
import java.io.IOException;
import java.util.Map;
import com.google.gson.Gson;
import com.pichill.frontstage.generaluser.service.GeneralUserServiceFront;
import com.pichill.generaluser.entity.GeneralUser;
import com.pichill.frontstage.owneruser.service.OwnerUserServiceFront;
import com.pichill.owneruser.entity.OwnerUser;
import redis.clients.jedis.Jedis;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/verifyouser")
public class OwnerUserActiveSuccess extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		OwnerUser ownerUser = (OwnerUser) session.getAttribute("ownerUser");
		// 從req.getParameter拿到驗證碼
		String code = req.getParameter("verificationCode");
		System.out.println("verificationCode is " + code);
		
		OwnerUserServiceFront oUserSvcF = new OwnerUserServiceFront();
		
		Jedis jedis = null;
		try {			
			String email = ownerUser.getoEmail();
			System.out.println("email is " + email);
			
			jedis = new Jedis("localhost", 6379);
			jedis.select(5);
			String getCode = jedis.get(email);
			System.out.println("getCode is " + getCode);
			
			ownerUser = oUserSvcF.getOwnerUserByoEmail(email);
			
			Gson gson = new Gson();
			Map map = gson.fromJson(getCode, Map.class);
			String redisCode = (String)map.get("verificationCode");
			System.out.println("redisCode is " + redisCode);
			if (email != null) {
				if (redisCode.equals(code)) {
					System.out.println("兩者值相同! 讚啦");
					ownerUser.setoStatus(1);
					oUserSvcF.updateOwnerUsers(ownerUser);
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
		res.sendRedirect(req.getContextPath() + "/login/oLogin/oUserLogin.jsp");

	}
}
