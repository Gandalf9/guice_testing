package com.yatin.guice.client;

import org.nnsoft.guice.rocoto.Rocoto;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.yatin.guice.config.Config;

public class MyApp {
	
	public static void main(String[] args) {
		
		Injector injector = Guice.createInjector(Rocoto.expandVariables(new Config()));
		
		ActionClient client = injector.getInstance(ActionClient.class);
		client.doSomething();
	}
}
