package com.pichill.contactus.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.management.loading.PrivateClassLoader;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pichill.contactus.service.ContactUsService;
import com.pichill.contactus.service.ContactUsServiceImpl;

@SuppressWarnings("serial")
@WebServlet("/contactus/DBGifReader")
public class DBGifReaderController extends HttpServlet{
	private ContactUsService contactusSvc;
	@Override
	public void init() throws ServletException {
		// 在 init 方法中進行初始化
		contactusSvc = new ContactUsServiceImpl();
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		

		res.setContentType("image/gif");
		ServletOutputStream out = res.getOutputStream();
		

		try {
			Integer formID = Integer.valueOf(req.getParameter("formID"));
			contactusSvc = new ContactUsServiceImpl();
			out.write(contactusSvc.getOneContactUs(formID).getformPic());
		} catch (Exception e) {
			InputStream in = getServletContext().getResourceAsStream("/resources/NoData/nopic.jpg");
			byte[] buf = new byte[in.available()];
			in.read(buf);
			out.write(buf);
			in.close();

		}
	}
}
