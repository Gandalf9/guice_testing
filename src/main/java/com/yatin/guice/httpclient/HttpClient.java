package com.yatin.guice.httpclient;

import static com.yatin.guice.utils.Exceptions.uncheck;

import javax.ws.rs.core.MediaType;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

public class HttpClient {
	public Object get(String url) {
        HttpResponse httpResponse = uncheck(() -> Unirest.get(url)
                .header("Content-type", MediaType.APPLICATION_JSON)
                .asString());
        return httpResponse.getBody();
    }
}
