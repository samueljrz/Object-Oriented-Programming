package questao1;

public class Refrigerante extends Bebida{
	
	private String sabor;
	private String marca;
	
	public Refrigerante(double valorUnitario, int codigoProduto, String sabor, String marca) {
		super(valorUnitario, codigoProduto);
		this.sabor = sabor;
		this.marca = marca;
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

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
}
