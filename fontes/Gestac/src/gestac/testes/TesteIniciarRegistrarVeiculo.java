package gestac.testes;

import gestac.apresentacao.InterfaceVeiculos;
import gestac.modelo.veiculos.Veiculo;
import gestac.modelo.veiculos.VeiculoEmpresa;
import gestac.modelo.veiculos.VeiculoFuncionario;

public class TesteIniciarRegistrarVeiculo {

	public static void main(String[] args) {

		try {
			String loginGestor = "gestor1"; // Usuário do tipo gestor
			Veiculo veiculo1 = InterfaceVeiculos
					.iniciarRegistrarVeiculo(loginGestor);
			if (veiculo1 instanceof VeiculoEmpresa) {
				System.out.println("Veículo Empresa obtido OK.");
			} else {
				System.out.println("Veículo Incorreto");
			}
			String loginFunc = "funci1"; // Usuário do tipo funcionário
			Veiculo veiculo2 = InterfaceVeiculos
					.iniciarRegistrarVeiculo(loginFunc);
			if (veiculo2 instanceof VeiculoFuncionario) {
				System.out.println("Veículo Funcionário obtido OK.");
			} else {
				System.out.println("Veículo Incorreto");
			}
		} catch (Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}

	}

}
