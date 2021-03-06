package gestac.persistencia;

import gestac.modelo.funcionario.Funcionario;
import gestac.modelo.veiculos.Marca;
import gestac.modelo.veiculos.Modelo;
import gestac.modelo.veiculos.Veiculo;
import gestac.modelo.veiculos.VeiculoEmpresa;
import gestac.modelo.veiculos.VeiculoFuncionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VeiculoDAO {

	private static Connection conexao;

	public static Veiculo buscarVeiculoPelaPlaca(String placa) throws Exception {
		conexao = FabricaDeConexao.obterConexao();
		String sql = "";
		Veiculo v = null;
		try {
			sql = "SELECT * FROM VEICULOS WHERE PLACA = ?";
			PreparedStatement stat = conexao.prepareStatement(sql);
			stat.setString(1, placa);
			stat.execute();
			ResultSet rs = stat.getResultSet();
			if (rs.next()) {
				String placas = rs.getString("placa");
				int idModelo = rs.getInt("modelo");
				String cor = rs.getString("cor");
				String tipo = rs.getString("tipo");
				if (tipo.equals("F")) {
					v = new VeiculoFuncionario();
					Funcionario func = new Funcionario();
					// TODO - OBTER O FUNCION�RIO ASSOCIADO AO VE�CULO
					((VeiculoFuncionario) v).setFuncionario(func);
				}
				v.setPlaca(placas);
				v.setModelo(obterModeloPeloID(idModelo));
				v.setCor(cor);
			} else {
				throw new Exception("Ve�culo n�o encontrado.");
			}
			stat.close();
			conexao.close();
		} catch (SQLException se) {
			System.out.println("N�o foi poss�vel executar o comando " + sql
					+ ". ERRO: " + se.getMessage());
		}
		return v;
	}

	private static Modelo obterModeloPeloID(int idModelo) throws Exception {
		conexao = FabricaDeConexao.obterConexao();
		String sql = "";
		Modelo modelo = null;
		try {
			sql = "SELECT * FROM MODELOS WHERE ID = ?";
			PreparedStatement stat = conexao.prepareStatement(sql);
			stat.setInt(1, idModelo);
			stat.execute();
			ResultSet rs = stat.getResultSet();
			if (rs.next()) {
				String nome = rs.getString("nome");
				modelo = new Modelo();
				modelo.setNome(nome);
				int idMarca = rs.getInt("marca");
				modelo.setMarca(obterMarcapeloID(idMarca));
			} else {
				throw new Exception(
						"Modelo n�o encontrado para o id informado.");
			}
			stat.close();
			conexao.close();
		} catch (SQLException se) {
			System.out.println("N�o foi poss�vel executar o comando " + sql
					+ ". ERRO: " + se.getMessage());
		}
		return modelo;
	}

	private static Marca obterMarcapeloID(int idMarca) throws Exception {
		conexao = FabricaDeConexao.obterConexao();
		String sql = "";
		Marca marca = null;
		try {
			sql = "SELECT * FROM MARCAS WHERE ID = ?";
			PreparedStatement stat = conexao.prepareStatement(sql);
			stat.setInt(1, idMarca);
			stat.execute();
			ResultSet rs = stat.getResultSet();
			if (rs.next()) {
				String nome = rs.getString("nome");
				marca = new Marca();
				marca.setNome(nome);
			} else {
				throw new Exception("Marca n�o encontrada para o id informado.");
			}
			stat.close();
			conexao.close();
		} catch (SQLException se) {
			System.out.println("N�o foi poss�vel executar o comando " + sql
					+ ". ERRO: " + se.getMessage());
		}
		return marca;
	}

	public static Marca buscarMarcaPeloNomeModelo(String modelo)
			throws Exception {
		conexao = FabricaDeConexao.obterConexao();
		String sql = "";
		Marca marca = null;
		try {
			sql = "SELECT * FROM MODELOS WHERE NOME = ?";
			PreparedStatement stat = conexao.prepareStatement(sql);
			stat.setString(1, modelo);
			stat.execute();
			ResultSet rs = stat.getResultSet();
			if (rs.next()) {
				int idMarca = rs.getInt("marca");
				marca = obterMarcapeloID(idMarca);
			} else {
				throw new Exception(
						"Marca n�o encontrada para o modelo informado.");
			}
			stat.close();
			conexao.close();
		} catch (SQLException se) {
			System.out.println("N�o foi poss�vel executar o comando " + sql
					+ ". ERRO: " + se.getMessage());
		}
		return marca;
	}

	/**
	 * Registra um ve�culo para um funcion�rio
	 * 
	 * @param veiculo
	 * @param func
	 */
	public static void registrarVeiculoFuncionario(VeiculoFuncionario veiculo,
			Funcionario func) {
		// TODO criar o ve�culo na tabela de ve�culos
		// TODO criar a associa��o entre o id do ve�culo e o id do funcion�rio
		// na tabela funcionarioveiculos

	}

	public static void registrarVeiculoEmpresa(VeiculoEmpresa veiculo) {
		// TODO criar o ve�culo na tabela de ve�culos, neste caso n�o h�
		// associa��o com a tabela de funcion�rios

	}

}
