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

	// Adicionando par�metro login enquanto n�o temos sistem�tica de login
	// implantada
	public static void registrarVeiculo(Veiculo veiculo, String login)
			throws Exception {
		ControleVeiculos.registrarVeiculo(veiculo, login);

	}

	public static Marca buscarMarcaPeloNomeModelo(String modelo)
			throws Exception {
		return ControleVeiculos.buscarMarcaPeloNomeModelo(modelo);
	}
}
