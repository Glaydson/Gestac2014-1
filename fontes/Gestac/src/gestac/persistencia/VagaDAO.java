package gestac.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import gestac.modelo.vaga.TipoVaga;

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
			System.out.println("Não foi possível executar o comando " + sql
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
			System.out.println("Não foi possível executar o comando " + sql
					+ ". ERRO: " + se.getMessage());
		}
	}

}
