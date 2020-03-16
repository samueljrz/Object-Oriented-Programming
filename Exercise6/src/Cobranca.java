
public class Cobranca implements Pagavel {

	private double valor;
	
	public Cobranca() {
		this.valor = 0;
	}
	
	public Cobranca(double valor) {
		super();
		this.valor = valor;
	}

	@Override
	public double getValorPagamento() {
		return valor;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
