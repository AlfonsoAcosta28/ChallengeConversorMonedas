package com.alura.conversormonedas.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ConversorMonedasAPI {

	private HttpClient client;
	private HttpRequest request;
	private HttpResponse<String> response;

//	String json = response.body();

	public ConversorMonedasAPI() {
		this.client = HttpClient.newHttpClient();
	}

	public String convert(String coin) {
		String direccion = "https://v6.exchangerate-api.com/v6/bda0bef8f1d2c3c1c9a1ed68/latest/"+coin;

		try {

			this.request = HttpRequest.newBuilder(
					URI.create(direccion))
					.build();

			this.response = client.send(request, HttpResponse.BodyHandlers.ofString());
			
			return response.body();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

		return "";
	}
}
