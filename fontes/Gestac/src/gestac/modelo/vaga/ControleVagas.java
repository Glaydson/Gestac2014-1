package gestac.modelo.vaga;

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

}
