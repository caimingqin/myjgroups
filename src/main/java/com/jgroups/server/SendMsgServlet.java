package com.jgroups.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jgroups.Message;

public class SendMsgServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
              doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String msg = req.getParameter("msg");
		System.out.println("msg===========>>>"+msg);
//		IpAddress ipAddress = new IpAddress("192.168.17.199", 10199);
		Message message = new Message(null, new User("00008888", "caimingqin"));
		try {
			NodeOne.jChannel.send(message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
