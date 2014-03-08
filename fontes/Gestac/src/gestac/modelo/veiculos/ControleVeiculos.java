package gestac.modelo.veiculos;

import gestac.modelo.funcionario.Funcionario;
import gestac.modelo.usuario.ControleUsuario;
import gestac.modelo.usuario.TipoUsuario;
import gestac.modelo.vaga.ControleVagas;
import gestac.persistencia.VeiculoDAO;

public class ControleVeiculos {

	public static void registrarEntrada(String placa) throws Exception {
		Veiculo v = VeiculoDAO.buscarVeiculoPelaPlaca(placa);
		ControleVagas.ocuparVaga(v);

	}

	public static Veiculo obterVeiculoInclusao(String login) throws Exception {
		TipoUsuario tipoUsuario = ControleUsuario.obterTipoUsuario(login);
		if (tipoUsuario == TipoUsuario.GESTOR) {
			VeiculoEmpresa ve = new VeiculoEmpresa();
			return ve;
			// não entendemos o que significa <<create>> CreateMessage();
			// vf:Veiculo Funcionario <<Entity>>>
			//
			// R - O estereótipo <<create>> significa exatamente o que vcs
			// fizeram, a criação de uma nova instância da classe
		} else {
			VeiculoFuncionario vf = new VeiculoFuncionario();
			return vf;
		}
	}
	
	//NOVO-Georgia 16:00 - 07/03
	public static void registrarVeiculo(Veiculo veiculo){
		// DUVIDA - esse metodo de validação é pra saber se o carro esta registrado no banco de dados, ou se ele é pra verificar se o carro é registrado??
		//E nesses casos, ele não deveria retornar um boolean, true ou false???
	}

	public static Marca buscarMarcaPeloNomeModelo(String modelo)
			throws Exception {
		return VeiculoDAO.buscarMarcaPeloNomeModelo(modelo);
	}

	public static void registrarVeiculos(Veiculo veiculo){
		
		
		
	}
	
	public static void adicionarMovimentacao(){
		
	}
	
	public static void adicionarVeiculo(Funcionario func,Veiculo VeiculoFuncionario){
		
	}
	
	public static void autenticarVeiculo(String placa){ //metodo retorna boolean temporariamente como void
		
	}
	
	public static void registrarSaida(){
		
	}
	
	
}
