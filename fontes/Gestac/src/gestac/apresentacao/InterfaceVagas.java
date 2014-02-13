package gestac.apresentacao;

import gestac.modelo.vaga.ControleVagas;
import gestac.modelo.vaga.TipoVaga;

public class InterfaceVagas {

	public static void adicionarVagas(int qtde, TipoVaga tipo) throws Exception {

		ControleVagas.adicionarVagas(qtde, tipo);

	}

	public static void excluirVagas(int qtde, TipoVaga tipo) throws Exception {
		ControleVagas.excluirVagas(qtde, tipo);
	}

}
