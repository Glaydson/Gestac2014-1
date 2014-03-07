package gestac.modelo.veiculos;

import gestac.modelo.usuario.ControleUsuario;
import gestac.modelo.usuario.TipoUsuario;
import gestac.modelo.vaga.ControleVagas;
import gestac.persistencia.VeiculoDAO;

public class ControleVeiculos {

	public static void registrarEntrada(String placa) throws Exception {
		Veiculo v = VeiculoDAO.buscarVeiculoPelaPlaca(placa);
		ControleVagas.ocuparVaga(v);

	}

	public static Veiculo obterVeiculoInclusao(String login) throws Exception {
		TipoUsuario tipoUsuario = ControleUsuario.obterTipoUsuario(login);
		if (tipoUsuario == TipoUsuario.GESTOR) {
			VeiculoEmpresa ve = new VeiculoEmpresa();
			return ve;
			// não entendemos o que significa <<create>> CreateMessage();
			// vf:Veiculo Funcionario <<Entity>>>
			//
			// R - O estereótipo <<create>> significa exatamente o que vcs
			// fizeram, a criação de uma nova instância da classe
		} else {
			VeiculoFuncionario vf = new VeiculoFuncionario();
			return vf;
		}
	}

	public static Marca buscarMarcaPeloNomeModelo(String modelo)
			throws Exception {
		return VeiculoDAO.buscarMarcaPeloNomeModelo(modelo);
	}

}
