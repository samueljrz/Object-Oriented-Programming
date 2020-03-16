package questao1;

public abstract class Produto {
	
	protected double valorUnitario;
	protected int codigoProduto;
	
	public Produto(double valorUnitario, int codigoProduto) {
		super();
		this.valorUnitario = valorUnitario;
		this.codigoProduto = codigoProduto;
	}
	
	public abstract double obterValorUnitario();

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public int getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(int codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	
	
}
