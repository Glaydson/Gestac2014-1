package gestac.testes;

import gestac.apresentacao.InterfaceVeiculos;
import gestac.modelo.veiculos.Veiculo;
import gestac.modelo.veiculos.VeiculoEmpresa;
import gestac.modelo.veiculos.VeiculoFuncionario;

public class TesteIniciarRegistrarVeiculo {

	public static void main(String[] args) {

		try {
			String loginGestor = "gestor1"; // Usu�rio do tipo gestor
			Veiculo veiculo1 = InterfaceVeiculos
					.iniciarRegistrarVeiculo(loginGestor);
			if (veiculo1 instanceof VeiculoEmpresa) {
				System.out.println("Ve�culo Empresa obtido OK.");
			} else {
				System.out.println("Ve�culo Incorreto");
			}
			String loginFunc = "funci1"; // Usu�rio do tipo funcion�rio
			Veiculo veiculo2 = InterfaceVeiculos
					.iniciarRegistrarVeiculo(loginFunc);
			if (veiculo2 instanceof VeiculoFuncionario) {
				System.out.println("Ve�culo Funcion�rio obtido OK.");
			} else {
				System.out.println("Ve�culo Incorreto");
			}
		} catch (Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}

	}

}
