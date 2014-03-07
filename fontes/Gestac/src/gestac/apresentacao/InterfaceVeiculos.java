package gestac.apresentacao;

import gestac.modelo.veiculos.ControleVeiculos;
import gestac.modelo.veiculos.Marca;
import gestac.modelo.veiculos.Veiculo;

public class InterfaceVeiculos {

	// Esse � o mesmo que IniciarRegistratVeiculo(): void?? E tb, colocamos um
	// parametro pra entrar com o valor:login que eu nao tinha antes.
	//
	// R - Sim, � o mesmo, e alterei o nome do m�todo para ficar igual ao
	// diagrama e alterei tamb�m o tipo de retorno para poder testar o m�todo.
	public static Veiculo iniciarRegistrarVeiculo(String login)
			throws Exception {
		return ControleVeiculos.obterVeiculoInclusao(login);
	}

	public static void registrarVeiculo(Veiculo veiculo) throws Exception {
		throw new Exception("Falta implementar o registro de ve�culo");

	}

	public static Marca buscarMarcaPeloNomeModelo(String modelo)
			throws Exception {
		return ControleVeiculos.buscarMarcaPeloNomeModelo(modelo);
	}
}
