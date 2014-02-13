package gestac.modelo.usuario;

import gestac.persistencia.UsuarioDAO;

public class ControleUsuario {
	
	public static TipoUsuario obterTipoUsuario(String login) throws Exception {
		
		return UsuarioDAO.obterTipoUsuario(login);
		
	}

}
