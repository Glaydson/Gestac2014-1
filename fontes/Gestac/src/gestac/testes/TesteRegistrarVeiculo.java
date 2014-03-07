package gestac.testes;

import gestac.apresentacao.InterfaceVeiculos;
import gestac.modelo.funcionario.Funcionario;
import gestac.modelo.veiculos.Marca;
import gestac.modelo.veiculos.Modelo;
import gestac.modelo.veiculos.VeiculoEmpresa;
import gestac.modelo.veiculos.VeiculoFuncionario;

public class TesteRegistrarVeiculo {

	public static void main(String[] args) {
		try {
			// Testando a inclus�o de ve�culo da empresa
			VeiculoEmpresa v1 = new VeiculoEmpresa();
			Modelo modelo1 = new Modelo();
			modelo1.setNome("Gol");
			Marca marca1 = InterfaceVeiculos.buscarMarcaPeloNomeModelo(modelo1
					.getNome());
			System.out.println("Marca 1: " + marca1.getNome());
			modelo1.setMarca(marca1);
			v1.setModelo(modelo1);
			v1.setPlaca("AAA-1234");
			v1.setCor("Prata");
			InterfaceVeiculos.registrarVeiculo(v1);
			System.out.println("Ve�culo de empresa registrado com sucesso.");

			// Testando inclus�o de ve�culo de funcion�rio
			VeiculoFuncionario v2 = new VeiculoFuncionario();
			Modelo modelo2 = new Modelo();
			modelo2.setNome("Siena");
			Marca marca2 = InterfaceVeiculos.buscarMarcaPeloNomeModelo(modelo2
					.getNome());
			System.out.println("Marca 2: " + marca2.getNome());
			modelo2.setMarca(marca2);
			v2.setModelo(modelo2);
			v2.setPlaca("BBB-9876");
			v2.setCor("Azul");
			// PROVIS�RIO - O funcion�rio deve ser buscado na tabela de
			// funcion�rios a partir de seu login. Para isto, � preciso que a
			// funcionalidade de registrar funcion�rios esteja pronta e alguns
			// funcion�rios j� cadastrados.
			Funcionario func1 = new Funcionario();
			func1.setMatricula(10);
			func1.setNome("Roberto C�sar");
			func1.setDeficiente(false);
			v2.setFuncionario(func1);
			InterfaceVeiculos.registrarVeiculo(v2);
			System.out
					.println("Ve�culo de funcion�rio registrado com sucesso.");
		} catch (Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}

	}

}
