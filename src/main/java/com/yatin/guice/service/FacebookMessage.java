package com.yatin.guice.service;

import javax.inject.Inject;

import com.google.inject.name.Named;

public class FacebookMessage implements MessageService {

	@Inject
	@Named("service.host")
	private String host;
	
	@Inject
	@Named("servce.url")
	private String url;
	
	@Override
	public boolean sendMessage(String message, String userName) {
		
		System.out.println("Facebook Service message:" + message + " username:" + userName);
		System.out.println("Facebook Service message:" + host);
		System.out.println("Facebook Service message:" + url);
		
		return true;
	}

}
