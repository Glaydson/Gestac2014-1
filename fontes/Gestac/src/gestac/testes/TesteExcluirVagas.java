package gestac.testes;

import gestac.apresentacao.InterfaceVagas;
import gestac.modelo.vaga.TipoVaga;

public class TesteExcluirVagas {

	public static void main(String[] args) {
		try {
			InterfaceVagas.excluirVagas(1, TipoVaga.DEFICIENTE);
			InterfaceVagas.excluirVagas(1, TipoVaga.EMPRESA);
			InterfaceVagas.excluirVagas(1, TipoVaga.FUNCIONARIO);
			System.out.println("Vagas Excluídas!");
		} catch (Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}

	}

}
