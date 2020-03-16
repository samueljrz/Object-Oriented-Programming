package questao1;

import java.util.ArrayList;

public class Pedido {

	private static int codigoPedido=0;
	private ArrayList<itemPedido> itensPedidos = new ArrayList<itemPedido>();
	private boolean cancelado = false;
	
	public Pedido() {
		super();
		codigoPedido++;
	}
	
	public void adicionarItemPedido(itemPedido x) {
		this.itensPedidos.add(x);
	}
	
	public double obterValorTotalPedido() {
		double total = 0;
		for (itemPedido itemPedido : itensPedidos) {
			total += itemPedido.obterValorItem();
		}
		
		return total;
	}
	
	public void cancelarPedido() {
		this.cancelado = true;
	}

	public boolean isCancelado() {
		return cancelado;
	}

	public static int getCodigoPedido() {
		return codigoPedido;
	}
	
}
