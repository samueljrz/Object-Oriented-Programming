package questao1;

public class Torresmo extends Tiragosto{

	private String acompanhamento;

	public Torresmo(double valorUnitario, int codigoProduto, String acompanhamento) {
		super(valorUnitario, codigoProduto);
		this.acompanhamento = acompanhamento;
	}

	@Override
	public double obterValorUnitario() {
		return valorUnitario;
	}

	public String getAcompanhamento() {
		return acompanhamento;
	}

	public void setAcompanhamento(String acompanhamento) {
		this.acompanhamento = acompanhamento;
	}
	
}
