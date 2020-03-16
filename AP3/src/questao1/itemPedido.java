package questao1;

public class itemPedido {

	private Produto produto;
	private int quantidade;

	public itemPedido(Produto produto, int quantidade) {
		super();
		this.produto = produto;
		this.quantidade = quantidade;
	}

	public double obterValorItem() {
		return (produto.obterValorUnitario() * quantidade);
	}
	
}
