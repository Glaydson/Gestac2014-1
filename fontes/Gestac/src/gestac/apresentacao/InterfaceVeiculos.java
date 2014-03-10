package gestac.apresentacao;

import gestac.modelo.veiculos.ControleVeiculos;
import gestac.modelo.veiculos.Marca;
import gestac.modelo.veiculos.Veiculo;

public class InterfaceVeiculos {

	// Esse é o mesmo que IniciarRegistratVeiculo(): void?? E tb, colocamos um
	// parametro pra entrar com o valor:login que eu nao tinha antes.
	//
	// R - Sim, é o mesmo, e alterei o nome do método para ficar igual ao
	// diagrama e alterei também o tipo de retorno para poder testar o método.
	public static Veiculo iniciarRegistrarVeiculo(String login)
			throws Exception {
		return ControleVeiculos.obterVeiculoInclusao(login);
	}

	// Adicionando parâmetro login enquanto não temos sistemática de login
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
