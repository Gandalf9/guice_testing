package com.yatin.guice.client;

import com.github.tomakehurst.wiremock.WireMockServer;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

/**
 * This class uses WireMockServer to serve some properties 
 * 
 * @author yatinmistry
 *
 */
public class Server {

	public static void main(String[] args) {
		 jsonServer();
//		plainTextServer();
	}

	private static void plainTextServer() {
		WireMockServer wireMockServer = new WireMockServer(wireMockConfig().port(8089));
		wireMockServer.start();

		wireMockServer.stubFor(get(urlEqualTo("/props"))
				.willReturn(aResponse()
						.withHeader("Content-Type", "plain/text")
						.withBody("db.host=prod.com\ndb.port=5432")));
	}

	private static void jsonServer() {
		WireMockServer wireMockServer = new WireMockServer(wireMockConfig().port(8088));
		wireMockServer.start();

		wireMockServer.stubFor(get(urlEqualTo("/props"))
				.willReturn(aResponse()
						.withHeader("Content-Type", "application/json")
						.withBody("{\"service.host\": \"prod.com\", \"db.port\":\"5432\"}")));
	}
}
