package questao1;

public class Principal {

	public static void main(String[] args) {
		BDProduto bdproduto = new BDProduto();
		itemPedido IT;
		
		PratoPrincipal P = new Feijoada(30, 5);
		Bebida B = new Refrigerante(15, 3, "Guarana", "Kuat");
		Tiragosto T = new Torresmo(25, 4, "Farofa");
		Sobremesa S = new Sorvete(50, 2, "Chocolate");
		
		bdproduto.adicionarProduto(P);
		bdproduto.adicionarProduto(B);
		bdproduto.adicionarProduto(T);
		bdproduto.adicionarProduto(S);
		
		Pedido pedido = new Pedido();
		BDPedido bdpedido = new BDPedido();
		
		System.out.println(bdproduto.toString());
		IT = new itemPedido(P, 7);
		pedido.adicionarItemPedido(IT);

		System.out.println(bdproduto.toString());
		IT = new itemPedido(B, 9);
		pedido.adicionarItemPedido(IT);
		
		System.out.println(bdproduto.toString());
		IT = new itemPedido(T, 5);
		pedido.adicionarItemPedido(IT);
		
		System.out.println(bdproduto.toString());
		IT = new itemPedido(S, 15);
		pedido.adicionarItemPedido(IT);
		
		System.out.println("Valor total do pedido: " + pedido.obterValorTotalPedido()); 
		bdpedido.adicionarPedido(pedido);
		
		try {
			bdproduto.ProcurarProduto(8);
		} catch (ProdutoNaoEncontrado msg) {
			System.out.println(msg.getMessage());
		}
		
		Gerenciavel gerente = new ControleGerencial();
		try {
			pedido = bdpedido.ProcurarPedido(1);
			System.out.println("Cancelamento pedido 1: "+ Pedido.getCodigoPedido() + ": " + pedido.isCancelado());
			
			gerente.cancelarPedido(pedido);
			System.out.println("Cancelamento pedido 1: "+ Pedido.getCodigoPedido() + ": " + pedido.isCancelado());
		} catch (PedidoNaoEncontrado e) {
			System.out.println(e.getMessage());
		}
	}

}
