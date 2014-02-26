package gestac.persistencia;

import gestac.modelo.funcionario.Funcionario;
import gestac.modelo.veiculos.Marca;
import gestac.modelo.veiculos.Modelo;
import gestac.modelo.veiculos.Veiculo;
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
					// TODO - OBTER O FUNCIONÁRIO ASSOCIADO AO VEÍCULO
					((VeiculoFuncionario) v).setFuncionario(func);
				}
				v.setPlaca(placas);
				v.setModelo(obterModeloPeloID(idModelo));
				v.setCor(cor);
			} else {
				throw new Exception("Veículo não encontrado.");
			}
			stat.close();
			conexao.close();
		} catch (SQLException se) {
			System.out.println("Não foi possível executar o comando " + sql
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
				throw new Exception("Modelo não encontrado.");
			}
			stat.close();
			conexao.close();
		} catch (SQLException se) {
			System.out.println("Não foi possível executar o comando " + sql
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
				throw new Exception("Modelo não encontrado.");
			}
			stat.close();
			conexao.close();
		} catch (SQLException se) {
			System.out.println("Não foi possível executar o comando " + sql
					+ ". ERRO: " + se.getMessage());
		}
		return marca;
	}

}
