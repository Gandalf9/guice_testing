package com.yatin.guice.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.yatin.guice.client.ActionClient;
import com.yatin.guice.service.EmailMessageService;
import com.yatin.guice.service.MessageService;

public class Config extends AbstractModule {

	private static Properties properties = new Properties();

	@Override
	protected void configure() {
		InputStream inputStream = Config.class.getClassLoader().getResourceAsStream("testing.properties");

		try {
			properties.load(inputStream);

		} catch (IOException e) {
			e.printStackTrace();
		}

		Names.bindProperties(binder(), properties);

		bind(MessageService.class).to(EmailMessageService.class);
		bind(ActionClient.class);
	}
}
