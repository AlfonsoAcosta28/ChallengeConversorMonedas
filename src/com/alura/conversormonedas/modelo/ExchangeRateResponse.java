package com.alura.conversormonedas.modelo;

import java.util.Map;

public class ExchangeRateResponse {
	private String result;
	private String code;
	private Map<String, Double> conversionRates;
	
	
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Map<String, Double> getConversionRates() {
		return conversionRates;
	}
	public void setConversionRates(Map<String, Double> conversionRates) {
		this.conversionRates = conversionRates;
	}
	
	public ExchangeRateResponse(ExchangeRateResponseOmbd exchangeRateResponseOmbd) {
		this.result = exchangeRateResponseOmbd.result();
		this.conversionRates = exchangeRateResponseOmbd.conversion_rates();
		this.code = exchangeRateResponseOmbd.base_code();
	}
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "ExchangeRateResponse [result=" + result + ", code=" + code + ", conversionRates=" + conversionRates
				+ "]";
	}

}
