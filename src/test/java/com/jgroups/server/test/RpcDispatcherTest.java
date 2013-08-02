package com.jgroups.server.test;

import java.lang.reflect.Method;

import org.jgroups.JChannel;
import org.jgroups.blocks.MethodCall;
import org.jgroups.blocks.RequestOptions;
import org.jgroups.blocks.ResponseMode;
import org.jgroups.blocks.RpcDispatcher;

public class RpcDispatcherTest {

    JChannel           channel;
    RpcDispatcher      disp;


    public static int print(int number) throws Exception {
  
    	System.out.println(number);
        return number * 2;

    }


    public void start() throws Exception {

    	Method method = getClass().getMethod("print", int.class);
        MethodCall call=new MethodCall(method,20);

        RequestOptions options=new RequestOptions(ResponseMode.GET_ALL, 5000);

        channel=new JChannel("udp.xml");

        disp=new RpcDispatcher(channel, this);

        channel.connect("RpcDispatcherTestGroup");

        Object callRemoteMethod = disp.callRemoteMethod(channel.getAddress(), call, options);

        System.out.println(callRemoteMethod);
          

        }




    public static void main(String[] args) throws Exception {

        new RpcDispatcherTest().start();

    }

}
