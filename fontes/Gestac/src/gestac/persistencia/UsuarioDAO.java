package gestac.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import gestac.modelo.usuario.TipoUsuario;

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
				// Isto pode ser buscado via consulta à tabela Tipousuario, mas
				// deixei assim para simplificar.
				tipoUsuario = TipoUsuario.obterTipoPeloID(tipo);
			} else {
				throw new Exception("Login não encontrado.");
			}
			stat.close();
			conexao.close();
		} catch (SQLException se) {
			System.out.println("Não foi possível executar o comando " + sql
					+ ". ERRO: " + se.getMessage());
		}
		return tipoUsuario;
	}

}
