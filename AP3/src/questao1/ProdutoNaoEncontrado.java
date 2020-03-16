package questao1;

@SuppressWarnings("serial")
public class ProdutoNaoEncontrado extends Exception{
	
	private int codigoProduto;
	
	public ProdutoNaoEncontrado(int codigoProduto) {
		super("O produto de codigo " + codigoProduto + " nao foi encontrado no sistema");
	}
	
	public int getcodigoProduto() {
		return this.codigoProduto;
	}
}
