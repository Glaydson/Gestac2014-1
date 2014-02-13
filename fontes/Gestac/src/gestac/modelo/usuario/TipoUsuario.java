package gestac.modelo.usuario;

public enum TipoUsuario {

	ADMINISTRATIVO(1), FUNCIONÁRIO(2), GESTOR(3);
	private final int tipoUsuario;

	TipoUsuario(int tipo) {
		tipoUsuario = tipo;
	}

	public int getTipo() {
		return tipoUsuario;
	}

	public static TipoUsuario obterTipoPeloID(int tipo) {
		TipoUsuario tipoUsuario = null;
		switch (tipo) {
		case 1:
			tipoUsuario = TipoUsuario.ADMINISTRATIVO;
			break;
		case 2:
			tipoUsuario = TipoUsuario.FUNCIONÁRIO;
			break;
		case 3:
			tipoUsuario = TipoUsuario.GESTOR;
			break;
		default:
			break;
		}
		return tipoUsuario;
	}

}
