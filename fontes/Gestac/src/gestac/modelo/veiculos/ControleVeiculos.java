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
			// n�o entendemos o que significa <<create>> CreateMessage();
			// vf:Veiculo Funcionario <<Entity>>>
			//
			// R - O estere�tipo <<create>> significa exatamente o que vcs
			// fizeram, a cria��o de uma nova inst�ncia da classe
		} else {
			VeiculoFuncionario vf = new VeiculoFuncionario();
			return vf;
		}
	}
	
	//NOVO-Georgia 16:00 - 07/03
	public static void registrarVeiculo(Veiculo veiculo){
		// DUVIDA - esse metodo de valida��o � pra saber se o carro esta registrado no banco de dados, ou se ele � pra verificar se o carro � registrado??
		//E nesses casos, ele n�o deveria retornar um boolean, true ou false???
	}

	public static Marca buscarMarcaPeloNomeModelo(String modelo)
			throws Exception {
		return VeiculoDAO.buscarMarcaPeloNomeModelo(modelo);
	}

}
