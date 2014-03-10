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
			// n�o entendemos o que significa <<create>> CreateMessage();
			// vf:Veiculo Funcionario <<Entity>>>
			//
			// R - O estere�tipo <<create>> significa exatamente o que vcs
			// fizeram, a cria��o de uma nova inst�ncia da classe
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
	 * Registra um ve�culo para o funcion�rio com o login indicado.
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
				// Adiciona o ve�culo
				func.getVeiculos().add(veiculo);
				// O passo anterior adiciona apenas em mem�ria, � preciso adicionar no BD
				VeiculoDAO.registrarVeiculoFuncionario((VeiculoFuncionario) veiculo, func);
				
			} else {
				throw new Exception("N�mero m�ximo de ve�culos por funcion�rio excedido");
			}
		} else {
			VeiculoDAO.registrarVeiculoEmpresa((VeiculoEmpresa) veiculo);
		}

	}

	private static void validar(Veiculo veiculo) throws Exception {
		// Verifica se os dados do ve�culo est�o preenchidos
		List<String> erros = new ArrayList<String>();
		if (veiculo.getCor().equals(BRANCO)) {
			erros.add("� obrigat�rio informar a cor do ve�culo");
		}
		if (veiculo.getModelo() == null) {
			erros.add("� obrigat�rio informar o modelo do ve�culo");
		}
		if (veiculo.getPlaca().equals(BRANCO)) {
			erros.add("� obrigat�rio informar a placa do ve�culo");
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
