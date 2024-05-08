package com.alura.conversormonedas.api;

import com.alura.conversormonedas.modelo.ExchangeRateResponse;
import com.alura.conversormonedas.modelo.ExchangeRateResponseOmbd;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonMethods {
	private Gson gson;

	public GsonMethods() {
		this.gson = new GsonBuilder()
				.setPrettyPrinting()
				.create();
	}
	
	public ExchangeRateResponse getMonedas(String json) {
		ExchangeRateResponseOmbd exchangeRateResponseOmbd = gson.fromJson(json, ExchangeRateResponseOmbd.class);
		ExchangeRateResponse exchangeRateResponse = new ExchangeRateResponse(exchangeRateResponseOmbd);
		return exchangeRateResponse;
	}
}
