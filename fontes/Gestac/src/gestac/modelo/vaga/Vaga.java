package gestac.modelo.vaga;

public class Vaga {

	private int numero;
	private boolean livre;
	private TipoVaga tipo;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean isLivre() {
		return livre;
	}

	public void setLivre(boolean livre) {
		this.livre = livre;
	}

	public TipoVaga getTipo() {
		return tipo;
	}

	public void setTipo(TipoVaga tipo) {
		this.tipo = tipo;
	}

}
