package gestac.modelo.veiculos;

import gestac.modelo.usuario.ControleUsuario;
import gestac.modelo.usuario.TipoUsuario;
import gestac.modelo.vaga.ControleVagas;
import gestac.persistencia.VeiculoDAO;

public class ControleVeiculos {

	public static void registrarEntrada(String placa) throws Exception {
		Veiculo v = VeiculoDAO.buscarVeiculoPelaPlaca(placa);
		ControleVagas.ocuparVaga(v);
		
	}
	
	public static Veiculo obterVeiculoInclusao(String login) throws Exception{
		TipoUsuario tipoUsuario = ControleUsuario.obterTipoUsuario(login);
		if (tipoUsuario==TipoUsuario.GESTOR){
			VeiculoEmpresa ve = new VeiculoEmpresa();
			return ve; //n�o entendemos o que significa <<create>> CreateMessage(); vf:Veiculo Funcionario <<Entity>>>
		}
		else {
			VeiculoFuncionario vf = new VeiculoFuncionario();
			return vf;
		}
	}

}
