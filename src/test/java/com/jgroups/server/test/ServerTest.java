package com.jgroups.server.test;

import org.jgroups.JChannel;
import org.jgroups.stack.IpAddress;

public class ServerTest {
	public static void main(String[] args) throws Exception {
		JChannel jChannel = new JChannel("udp.xml");
		jChannel.connect("dms-cluster");
		IpAddress ipAddress = new IpAddress("192.168.17.194", 10010);
		jChannel.send(ipAddress, "aaaaaaaaaaaaaaaaaaaaaaa");
	}
}
