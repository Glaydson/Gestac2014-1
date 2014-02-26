package gestac.modelo.vaga;

import gestac.modelo.funcionario.Funcionario;
import gestac.modelo.veiculos.Veiculo;
import gestac.modelo.veiculos.VeiculoEmpresa;
import gestac.modelo.veiculos.VeiculoFuncionario;
import gestac.persistencia.VagaDAO;

public class ControleVagas {

	public static void adicionarVagas(int qtde, TipoVaga tipo) throws Exception {

		if (qtde > 0) {
			VagaDAO.adicionarVagas(qtde, tipo);
		} else {
			throw new Exception("Quantidade de Vagas Igual a Zero");
		}

	}

	public static void excluirVagas(int qtde, TipoVaga tipo) throws Exception {
		if (qtde > 0) {
			VagaDAO.excluirVagas(qtde, tipo);
		} else {
			throw new Exception("Quantidade de Vagas Igual a Zero");
		}
	}

	public static void ocuparVaga(Veiculo v) throws Exception {
		TipoVaga tipo = definirTipoVaga(v);
		VagaDAO.ocuparVaga(tipo);
		
	}

	private static TipoVaga definirTipoVaga(Veiculo v) {
		TipoVaga tipo = null;
		if (v instanceof VeiculoEmpresa) {
			tipo = TipoVaga.EMPRESA;
		} else {
			// Veículo de funcionário, verificar se é deficiente
			Funcionario f = ((VeiculoFuncionario) v).getFuncionario();
			if (f.isDeficiente()) {
				tipo = TipoVaga.DEFICIENTE;
			} else {
				tipo = TipoVaga.FUNCIONARIO;
			}
		}
		return tipo;
	}

}
