package questao1;

@SuppressWarnings("serial")
public class PedidoNaoEncontrado extends Exception{
	
	private int codigoProduto;
	
	public PedidoNaoEncontrado(int codigoProduto) {
		super("O pedido de codigo " + codigoProduto + " nao foi encontrado no sistema");
	}
	
	public int getcodigoProduto() {
		return this.codigoProduto;
	}
}
