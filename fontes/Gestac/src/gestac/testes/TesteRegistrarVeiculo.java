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
			// Testando a inclusão de veículo da empresa
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
			InterfaceVeiculos.registrarVeiculo(v1, "");
			System.out.println("Veículo de empresa registrado com sucesso.");

			// Testando inclusão de veículo de funcionário
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
			// Passando o login como parâmetro - login já deve existir na tabela de usuários
			InterfaceVeiculos.registrarVeiculo(v2, "funci1");
			System.out
					.println("Veículo de funcionário registrado com sucesso.");
		} catch (Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}

	}

}
