package questao1;

public class Sorvete extends Sobremesa{

	private String sabor;

	public Sorvete(double valorUnitario, int codigoProduto, String sabor) {
		super(valorUnitario, codigoProduto);
		this.sabor = sabor;
	}

	@Override
	public double obterValorUnitario() {
		return valorUnitario;
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}
	
}
