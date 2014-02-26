package gestac.apresentacao;

import gestac.modelo.veiculos.ControleVeiculos;

public class InterfaceCancela {

	public static void autenticarVeiculo(String placa) {

	}

	public static void registrarEntrada(String placa) throws Exception {
		
		ControleVeiculos.registrarEntrada(placa);

	}

	public static void registrarSaida(String placa) {

	}

}
