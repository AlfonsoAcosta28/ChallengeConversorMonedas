package com.alura.conversormonedas.modelo;

import java.util.Map;

public record ExchangeRateResponseOmbd(
	    String result,
	    String base_code,
	    Map<String, Double> conversion_rates
	) {}
