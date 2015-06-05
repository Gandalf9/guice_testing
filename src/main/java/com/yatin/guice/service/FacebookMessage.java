package com.yatin.guice.service;

public class FacebookMessage implements MessageService {

	@Override
	public boolean sendMessage(String message, String userName) {
		
		System.out.println("Facebook Service message:" + message + " username:" +  userName);
		
		return true;
	}

}
