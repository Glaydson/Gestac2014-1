package gestac.apresentacao;

import gestac.modelo.veiculos.ControleVeiculos;
import gestac.modelo.veiculos.Veiculo;

public class InterfaceVeiculos {
	
	
	public static void iniciarRegistrar(String login) throws Exception { //Esse � o mesmo que IniciarRegistratVeiculo(): void??? E tb, colocamos um parametro pra entrar com o valor:login que eu nao tinha antes.
		ControleVeiculos.obterVeiculoInclusao(login);
	}
	
	public static void registrarVeiculo(Veiculo veiculo) {
		
	}

}
