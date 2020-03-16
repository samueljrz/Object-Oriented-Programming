package questao1;

import java.util.ArrayList;

public class BDPedido {

	private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();

	public void adicionarPedido(Pedido x) {
		this.pedidos.add(x);
	}
	
	public Pedido  ProcurarPedido(int codigoPedido) throws PedidoNaoEncontrado{
		for (Pedido pedido : pedidos) {
			if(Pedido.getCodigoPedido() == codigoPedido)
				return pedido;
		}
		throw new PedidoNaoEncontrado(codigoPedido);
	}
		@Override
		public String toString() {
			return "BDPedido [pedidos =" + pedidos + "]";
		}
		
}
