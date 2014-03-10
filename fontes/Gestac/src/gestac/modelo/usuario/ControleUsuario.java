package gestac.modelo.usuario;

import gestac.persistencia.UsuarioDAO;

public class ControleUsuario {
	
	public static TipoUsuario obterTipoUsuario(String login) throws Exception {
		
		return UsuarioDAO.obterTipoUsuario(login);
		
	}

	/**
	 * Obt�m o id de um usu�rio a partir de seu login
	 * @param login
	 * @return
	 * @throws Exception 
	 */
	public static int obterIdUsuario(String login) throws Exception {
		return UsuarioDAO.obterIdUsuario(login);
	}

}
