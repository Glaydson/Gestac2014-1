package gestac.modelo.funcionario;

import gestac.modelo.veiculos.Veiculo;
import gestac.modelo.veiculos.VeiculoFuncionario;
import gestac.persistencia.FuncionarioDAO;

public class ControleFuncionario {

	public static Funcionario obterFuncionario(String login) throws Exception {
		return FuncionarioDAO.obterFuncionario(login);
	}

	public static int obterQtdVeiculo(String login) {
		return obterQtdVeiculo(login);
	}

	public static Funcionario obterSegundoVeiculo(Veiculo v) {
		return obterSegundoVeiculo(v);
	}

	public static Funcionario obterProprietario(Veiculo v) {
		return obterProprietario(v);
	}

	/*
	 * public static List<VeiculoFuncionario> obterListaVeiculo(int
	 * v.getFuncionario().getMatricula()){ return
	 * obterListaVeiculo(v.getFuncionario().getMatriculo()); }
	 */

	public static void registrarFuncionario(Funcionario func) {
		// TODO Validar e registrar o funcionário, criando sua lista de veículos
		// vazia.

	}

	public static boolean validar(Funcionario func) {
		return validar(func);
	}

	public static void adicionarVeiculo(Funcionario func, VeiculoFuncionario v) {

	}
}