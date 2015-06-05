package com.yatin.guice.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import wiremock.com.fasterxml.jackson.core.JsonParseException;
import wiremock.com.fasterxml.jackson.databind.JsonMappingException;
import wiremock.com.fasterxml.jackson.databind.ObjectMapper;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.yatin.guice.client.ActionClient;
import com.yatin.guice.httpclient.HttpClient;
import com.yatin.guice.service.EmailMessageService;
import com.yatin.guice.service.MessageService;

public class Config extends AbstractModule {

	private static final String DEFAULT_PROPERTIES = "testing.properties";
	private static final String PROPERTY_SERVER_URL = "http://localhost:8088/props";
	
	private Properties properties = new Properties();

	@Override
	protected void configure() {
		
		try {
			properties.putAll(loadDefaultProperties());
			properties.putAll(loadPropertiesFromRemote());

		} catch (IOException e) {
			e.printStackTrace();
		}

		Names.bindProperties(binder(), properties);

		bind(MessageService.class).to(EmailMessageService.class);
		bind(ActionClient.class);
	}

	private Properties loadPropertiesFromRemote() throws JsonParseException, JsonMappingException, IOException {
		HttpClient client = new HttpClient();
		String string = (String) client.get(PROPERTY_SERVER_URL);
		
		Properties newProps = new ObjectMapper().readValue(string, Properties.class);
		return newProps;
	}
	
	private Properties loadDefaultProperties() throws IOException {
		InputStream inputStream = Config.class.getClassLoader().getResourceAsStream(DEFAULT_PROPERTIES);
		
		Properties prop = new Properties(); 
		prop.load(inputStream);
		
		return prop;
	}
}
