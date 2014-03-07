package gestac.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * F�brica de conex�es para evitar a duplica��o do c�digo para obter uma conex�o
 * ao BD
 * 
 * @author glaydson
 * 
 */
public class FabricaDeConexao {

	public static Connection obterConexao() {
		String stringDeConexao = "jdbc:mysql://localhost/gestac";
		String usuario = "root";
		String senha = "123456";

		Connection conexao = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexao = DriverManager.getConnection(stringDeConexao, usuario,
					senha);
		} catch (SQLException e) {
			System.out.println("N�o p�de conectar ao Banco de dados");
		} catch (ClassNotFoundException e) {
			System.out.println("N�o p�de carregar o driver JDBC");
		}
		return conexao;
	}
}