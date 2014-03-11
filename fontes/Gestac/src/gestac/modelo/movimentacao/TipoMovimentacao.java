package gestac.modelo.movimentacao;

public enum TipoMovimentacao {

	ENTRADA(1), SAÍDA(2);
	private final int tipoMovimentacao;

	private TipoMovimentacao(int tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public int getTipoMovimentacao() {
		return tipoMovimentacao;
	}

}
