package com.yatin.guice.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesProvider {

	private static Properties properties = new Properties();

	static {
		InputStream inputStream = PropertiesProvider.class.getClassLoader().getResourceAsStream("testing.properties");
		
		try {
			properties.load(inputStream);
			
			System.out.println("Val service.host: " + properties.getProperty("service.host"));
			System.out.println("Val servce.url: " + properties.getProperty("servce.url"));
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String key) {
		return properties.getProperty(key);
	}

	public static Properties getProperties() {
		return properties;
	}
}
