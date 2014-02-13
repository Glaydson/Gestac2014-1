package gestac.testes;

import gestac.apresentacao.InterfaceVagas;
import gestac.modelo.vaga.TipoVaga;

public class TesteAdicionarVagas {

	public static void main(String[] args) {
		try {
			InterfaceVagas.adicionarVagas(1, TipoVaga.DEFICIENTE);
			InterfaceVagas.adicionarVagas(5, TipoVaga.EMPRESA);
			InterfaceVagas.adicionarVagas(10, TipoVaga.FUNCIONARIO);
			System.out.println("Vagas Inseridas!");
		} catch (Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}

	}

}
