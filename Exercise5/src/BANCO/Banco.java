package BANCO;

import java.util.ArrayList;

public class Banco {
	ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	public void adicionarCliente(Cliente c) {
		clientes.add(c);
	}
	
	public boolean auditoria() {
		double total = 0;
		for (Cliente cliente : clientes) {
			total = cliente.getSaldoTotal();
		}
		if(total > 5000) {
			return true;
		}
		return false;
	}
}
