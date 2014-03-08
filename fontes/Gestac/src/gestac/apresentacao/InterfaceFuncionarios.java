package gestac.apresentacao;

import gestac.modelo.funcionario.ControleFuncionario;
import gestac.modelo.funcionario.Funcionario;

public class InterfaceFuncionarios {
	
	public static void registrarFuncionario() {
		Funcionario func = new Funcionario();
	}
	
	public static void registrarFuncionario(Funcionario func) {
		ControleFuncionario.registrarFuncionario(func);
	}

}
