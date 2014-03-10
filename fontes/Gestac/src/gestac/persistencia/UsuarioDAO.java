package gestac.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import gestac.modelo.funcionario.Funcionario;
import gestac.modelo.usuario.ControleUsuario;
import gestac.modelo.usuario.TipoUsuario;
import gestac.modelo.veiculos.VeiculoFuncionario;

public class UsuarioDAO {

	private static Connection conexao;

	public static TipoUsuario obterTipoUsuario(String login) throws Exception {

		TipoUsuario tipoUsuario = null;

		conexao = FabricaDeConexao.obterConexao();
		String sql = "";
		try {
			sql = "SELECT * FROM USUARIOS WHERE LOGIN = ?";
			PreparedStatement stat = conexao.prepareStatement(sql);
			stat.setString(1, login);
			stat.execute();
			ResultSet rs = stat.getResultSet();
			if (rs.next()) {
				int tipo = rs.getInt("tipousuario");
				// Isto pode ser buscado via consulta � tabela Tipousuario, mas
				// deixei assim para simplificar.
				tipoUsuario = TipoUsuario.obterTipoPeloID(tipo);
			} else {
				throw new Exception("Login n�o encontrado.");
			}
			stat.close();
			conexao.close();
		} catch (SQLException se) {
			System.out.println("N�o foi poss�vel executar o comando " + sql
					+ ". ERRO: " + se.getMessage());
		}
		return tipoUsuario;
	}

	public static int obterIdUsuario(String login) throws Exception {
		conexao = FabricaDeConexao.obterConexao();
		String sql = "";
		int id = 0;
		try {
			sql = "SELECT ID FROM USUARIOS WHERE LOGIN = ?";
			PreparedStatement stat = conexao.prepareStatement(sql);
			stat.setString(1, login);
			stat.execute();
			ResultSet rs = stat.getResultSet();
			if (rs.next()) {
				id = rs.getInt("ID");
			} else {
				throw new Exception(
						"N�o foi encontrado usu�rio com o login informado.");
			}
			stat.close();
			conexao.close();
		} catch (SQLException se) {
			System.out.println("N�o foi poss�vel executar o comando " + sql
					+ ". ERRO: " + se.getMessage());
		}
		return id;
	}

}
