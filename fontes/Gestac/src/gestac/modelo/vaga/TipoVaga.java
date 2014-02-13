package gestac.modelo.vaga;

public enum TipoVaga {

	DEFICIENTE(1), EMPRESA(2), FUNCIONARIO(3);
	private final int tipoVaga;

	TipoVaga(int tipo) {
		tipoVaga = tipo;
	}

	public int getTipo() {
		return tipoVaga;
	}
	
	

}
