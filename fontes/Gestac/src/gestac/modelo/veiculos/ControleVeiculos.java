package gestac.modelo.veiculos;

import java.util.ArrayList;
import java.util.List;

import gestac.modelo.funcionario.ControleFuncionario;
import gestac.modelo.funcionario.Funcionario;
import gestac.modelo.usuario.ControleUsuario;
import gestac.modelo.usuario.TipoUsuario;
import gestac.modelo.vaga.ControleVagas;
import gestac.persistencia.VeiculoDAO;

public class ControleVeiculos {

	private static final String BRANCO = "";

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

	public static Marca buscarMarcaPeloNomeModelo(String modelo)
			throws Exception {
		return VeiculoDAO.buscarMarcaPeloNomeModelo(modelo);
	}

	/**
	 * Registra um veículo para o funcionário com o login indicado.
	 * 
	 * @param veiculo
	 * @param login
	 * @throws Exception
	 */
	public static void registrarVeiculo(Veiculo veiculo, String login)
			throws Exception {

		validar(veiculo);
		if (veiculo instanceof VeiculoFuncionario) {
			Funcionario func = ControleFuncionario.obterFuncionario(login);
			if (func.getVeiculos().size() < 2) {
				// Adiciona o veículo
				func.getVeiculos().add(veiculo);
				// O passo anterior adiciona apenas em memória, é preciso adicionar no BD
				VeiculoDAO.registrarVeiculoFuncionario((VeiculoFuncionario) veiculo, func);
				
			} else {
				throw new Exception("Número máximo de veículos por funcionário excedido");
			}
		} else {
			VeiculoDAO.registrarVeiculoEmpresa((VeiculoEmpresa) veiculo);
		}

	}

	private static void validar(Veiculo veiculo) throws Exception {
		// Verifica se os dados do veículo estão preenchidos
		List<String> erros = new ArrayList<String>();
		if (veiculo.getCor().equals(BRANCO)) {
			erros.add("É obrigatório informar a cor do veículo");
		}
		if (veiculo.getModelo() == null) {
			erros.add("É obrigatório informar o modelo do veículo");
		}
		if (veiculo.getPlaca().equals(BRANCO)) {
			erros.add("É obrigatório informar a placa do veículo");
		}
		if (erros.size() != 0) {
			throw new Exception(erros.toString());
		}
	}

	public static void adicionarMovimentacao() {

	}

	public static void adicionarVeiculo(Funcionario func,
			Veiculo VeiculoFuncionario) {

	}

	public static void autenticarVeiculo(String placa) { // metodo retorna
															// boolean
															// temporariamente
															// como void

	}

	public static void registrarSaida() {

	}

}
