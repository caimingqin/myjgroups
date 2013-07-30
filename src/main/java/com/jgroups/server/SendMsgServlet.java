package com.jgroups.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jgroups.Message;
import org.jgroups.stack.IpAddress;

public class SendMsgServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String msg = req.getParameter("msg");
		System.out.println("msg===========>>>"+msg);
		IpAddress ipAddress = new IpAddress("192.168.17.199", 10199);
		Message message = new Message(ipAddress, "send to 192.168.17.199 10199 ");
		try {
			NodeOne.jChannel.send(message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
