package gestac.modelo.veiculos;

import gestac.modelo.movimentacao.Movimentacao;

import java.util.List;

public class Veiculo {

	private String placa;
	private Modelo modelo;
	private String cor;
	private List<Movimentacao> movimentacoes;

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public void adicionarMovimentacao(Movimentacao mov) {
		this.movimentacoes.add(mov);
	}

}
