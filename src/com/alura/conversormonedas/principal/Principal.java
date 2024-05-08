package com.alura.conversormonedas.principal;

import java.util.Scanner;

import com.alura.conversormonedas.api.ConversorMonedasAPI;
import com.alura.conversormonedas.api.GsonMethods;
import com.alura.conversormonedas.modelo.Coin;
import com.alura.conversormonedas.modelo.ExchangeRateResponse;

public class Principal {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String menu = "1.- Dolar		==>	Peso Mexicano\n"
				+ "2.- Peso Mexicano	==>	Dolar\n"
				+ "3.- Dolar		==>	Peso Argentino\n"
				+ "4.- Peso Argentino	==>	Dolar\n"
				+ "Para salir escriba 'Salir'";
		ConversorMonedasAPI conversor = new ConversorMonedasAPI();
		GsonMethods gsonMethods = new GsonMethods();
		ExchangeRateResponse exchangeRateResponse = null;
		while (true) {

			System.err.println("JAIR ALFONSO ACOSTA DURAN");
			System.out.println("**************************");
			System.out.println(menu);
			System.out.println("**************************");
			var op = scan.nextLine();

			if (op.equalsIgnoreCase("salir")) {
				break;
			}

			String response = "";
			Coin coinToCompere = null;
			Coin coin = null;
			boolean find = true;
			
			switch (op) {
			case "1":
				coin = Coin.USD;
				coinToCompere = Coin.MXN;
				response = conversor.convert(coin.name());
				break;
			case "2":
				coin = Coin.MXN;
				coinToCompere = Coin.USD;
				response = conversor.convert(coin.name());
				break;
			case "3":
				coin = Coin.USD;
				coinToCompere = Coin.ARS;
				response = conversor.convert(coin.name());
				break;
			case "4":
				coin = Coin.ARS;
				coinToCompere = Coin.USD;
				response = conversor.convert(coin.name());
				break;

			default:
				System.err.println("Opcion no encontrada");
				find = false;
			}
			
			if(find) {
				double cant;
				while (true) {
					System.out.println("Ingresa la cantidad a convertir");
					try {
						cant = Double.parseDouble(scan.nextLine());
						break;
					} catch (Exception e) {
						System.err.println("Valor invalido (Digite nuevamente)");
					}
				}
				exchangeRateResponse = gsonMethods.getMonedas(response);			
				var value = exchangeRateResponse.getConversionRates().get(coinToCompere.name());
				double conversion = cant * value;
				System.out.println("\nEl valor de "+cant+" ["+coin.name()+"] "
						+ "corresponde al valor final de ==> "
						+ conversion +"["+coinToCompere.name()+"]\n");
				
			}
		}
	}
}
