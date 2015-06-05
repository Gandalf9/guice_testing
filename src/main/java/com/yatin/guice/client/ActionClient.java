package com.yatin.guice.client;

import javax.inject.Inject;

import com.yatin.guice.service.MessageService;

public class ActionClient {
	
	@Inject
	private MessageService service; 
	
	public void doSomething() {
		service.sendMessage("Action Done", "Bob");
	}
}
