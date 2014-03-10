package gestac.persistencia;

import gestac.modelo.funcionario.Funcionario;
import gestac.modelo.usuario.ControleUsuario;
import gestac.modelo.veiculos.Veiculo;
import gestac.modelo.veiculos.VeiculoFuncionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FuncionarioDAO {

	private static Connection conexao;

	public static void obterVeiculo(int matricula) {
		// Era pra retornar a List<VeiculoFuncionario> mas nao sabemos como
		// fazer isso,
		// Entao coloquei como void para nao dar erro.
		// by:Ronni

	}

	public static void registrar(Funcionario func) {

	}

	/**
	 * Retorna um funcion�rio a partir de seu login
	 * 
	 * @param login
	 * @return
	 * @throws Exception
	 */
	public static Funcionario obterFuncionario(String login) throws Exception {
		conexao = FabricaDeConexao.obterConexao();
		String sql = "";
		Funcionario f = null;
		try {
			// Primeiro, obt�m o id do usu�rio a partir do seu login
			int idUsuario = ControleUsuario.obterIdUsuario(login);
			// Em seguida, verifica se existe o funcion�rio com o id informado
			sql = "SELECT * FROM FUNCIONARIOS WHERE IDUSUARIO = ?";
			PreparedStatement stat = conexao.prepareStatement(sql);
			stat.setInt(1, idUsuario);
			stat.execute();
			ResultSet rs = stat.getResultSet();
			if (rs.next()) {
				f = new Funcionario();
				f.setMatricula(rs.getInt("MATRICULA"));
				f.setNome(rs.getString("NOME"));
				f.setDeficiente(rs.getBoolean("DEFICIENTE"));
				// Obt�m os ve�culos do funcion�rio, caso existam
				List<Veiculo> veiculos = obterVeiculosFuncionario(f
						.getMatricula());
				f.setVeiculos(veiculos);
			} else {
				throw new Exception(
						"N�o foi encontrado funcion�rio para o login informado.");
			}
			stat.close();
			conexao.close();
		} catch (SQLException se) {
			System.out.println("N�o foi poss�vel executar o comando " + sql
					+ ". ERRO: " + se.getMessage());
		}
		return f;
	}

	private static List<Veiculo> obterVeiculosFuncionario(int matricula) {
		// TODO Auto-generated method stub - buscar os ve�culos do funcion�rio
		// na tabela funcionarioveiculos
		return null;
	}

	public static void adicionarVeiculo(Funcionario func, VeiculoFuncionario v) {

	}

}
