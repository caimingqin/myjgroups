package com.jgroups.server;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.jgroups.Address;
import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;

public class NodeOne extends ReceiverAdapter implements ServletContextListener {

	public static JChannel jChannel;
	public void contextInitialized(ServletContextEvent sce) {
		try {
			System.out.println("==========================================start JChannel===>>>>>>>>>>");
			jChannel = new JChannel("udp.xml");
			jChannel.setDiscardOwnMessages(true); //不接自己发送的消息
			jChannel.setReceiver(this);
			jChannel.connect("dms-cluster");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void receive(Message msg) {
		Address src = msg.getSrc();
		Address dest = msg.dest();
		System.out.println(dest);
		System.out.println(src);
		System.out.println(msg.getObject());
	}

	@Override
	public void getState(OutputStream output) throws Exception {
		System.out.println("getState====>>" + output);
	}

	@Override
	public void suspect(Address mbr) {
		System.out.println("suspect===>>>" + mbr);
	}

	@Override
	public void viewAccepted(View new_view) {

		System.out.println("** view: " + new_view);
		List<Address> addresses = new_view.getMembers();
		for (Address ad : addresses) {
			System.out.println("ad=====>>" + ad.toString());
		}
	}

	public void contextDestroyed(ServletContextEvent sce) {
		jChannel.close();

	}

}
