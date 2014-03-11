package gestac.modelo.movimentacao;

import gestac.modelo.veiculos.Veiculo;
import gestac.persistencia.MovimentacaoDAO;

public class ControleMovimentacoes {

	public static Movimentacao registrarEntrada(Veiculo v) {
		Movimentacao mov = new Movimentacao();
		mov.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		MovimentacaoDAO.registrarMovimentacao(mov);
		return mov;
		
	}

}
