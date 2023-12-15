package com.pichill.manage.controller;

import com.pichill.util.VerifyCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/valistr")
public class ValiImgServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //禁止瀏覽器快取驗證碼
        res.setDateHeader("Expires",-1);
        res.setHeader("Cache-Control","no-cache");
        res.setHeader("Pragma","no-cache");
        //生成驗證碼
        VerifyCode vc = new VerifyCode();
        //輸出驗證碼
        vc.drawImage(res.getOutputStream());
        //獲取驗證碼的值，儲存到session中
        String valistr = vc.getCode();
        HttpSession session = req.getSession();
        session.setAttribute("valistr",valistr);
        //列印到控制檯
        System.out.println(valistr);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doPost(req, res);
    }
}
