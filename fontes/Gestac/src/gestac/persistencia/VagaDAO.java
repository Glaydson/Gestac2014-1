package gestac.persistencia;

import gestac.modelo.vaga.TipoVaga;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VagaDAO {

	private static Connection conexao;

	public static void adicionarVagas(int qtde, TipoVaga tipo) {

		conexao = FabricaDeConexao.obterConexao();
		String sql = "";
		try {
			sql = "INSERT INTO VAGAS (LIVRE, TIPOVAGA) VALUES (?,?)";
			PreparedStatement stat = conexao.prepareStatement(sql);
			conexao.setAutoCommit(false);
			for (int i = 1; i <= qtde; i++) {
				stat.clearParameters();
				stat.setInt(1, 0);
				stat.setInt(2, tipo.getTipo());
				stat.addBatch();
			}
			stat.executeBatch();
			conexao.commit();
			stat.close();
			conexao.close();
		} catch (SQLException se) {
			System.out.println("N�o foi poss�vel executar o comando " + sql
					+ ". ERRO: " + se.getMessage());
		}

	}

	public static void excluirVagas(int qtde, TipoVaga tipo) {
		conexao = FabricaDeConexao.obterConexao();
		String sql = "";
		try {
			sql = "DELETE FROM VAGAS WHERE TIPOVAGA = ? LIMIT ?";
			PreparedStatement stat = conexao.prepareStatement(sql);
			stat.setInt(1, tipo.getTipo());
			stat.setInt(2, qtde);
			stat.execute();
			stat.close();
			conexao.close();
		} catch (SQLException se) {
			System.out.println("N�o foi poss�vel executar o comando " + sql
					+ ". ERRO: " + se.getMessage());
		}
	}

	public static void ocuparVaga(TipoVaga tipo) throws Exception {
		
		conexao = FabricaDeConexao.obterConexao();
		String sql = "";
		int numero = 0;
		try {
			// Obt�m uma vaga livre do tipo desejado
			sql = "SELECT MIN(NUMERO) FROM VAGAS WHERE TIPOVAGA = ? AND LIVRE = 0";
			PreparedStatement stat = conexao.prepareStatement(sql);
			stat.setInt(1, tipo.getTipo());
			stat.execute();
			ResultSet rs = stat.getResultSet();
			if (rs.next()) {
				numero = rs.getInt("numero");
			} else {
				throw new Exception("N�o foi encontrada vaga dispon�vel do tipo desejado.");
			}
		
			// Ocupa a vaga do n�mero localizado
			sql = "INSERT INTO VAGAS (LIVRE) VALUES (1) WHERE NUMERO = ?";
			stat = conexao.prepareStatement(sql);
			stat.setInt(1, numero);
			stat.execute();
			stat.close();
			conexao.close();
		} catch (SQLException se) {
			System.out.println("N�o foi poss�vel executar o comando " + sql
					+ ". ERRO: " + se.getMessage());
		}
	}

}
