package Class;

public class CupomFiscal {
	
	private String Data;
	private Cliente Cliente;
	private Double Valor;
	private Carro Carro;
	private int QtdDias;
	
	public CupomFiscal(String data, Cliente cliente, Double valor, Carro carro, int qtdDias) {
		super();
		Data = data;
		Cliente = cliente;
		Valor = valor;
		Carro = carro;
		QtdDias = qtdDias;
	}
	
	@Override
	public String toString() {
		return "CupomFiscal [Data=" + Data +", Valor=" + Valor + ", QtdDias=" + QtdDias + "]";
	}

	public CupomFiscal() {
		
	}
	
	public String getData() {
		return Data;
	}

	public void setData(String data) {
		Data = data;
	}

	public Cliente getCliente() {
		return Cliente;
	}

	public void setCliente(Cliente cliente) {
		Cliente = cliente;
	}

	public Double getValor() {
		return Valor;
	}

	public void setValor(Double valor) {
		Valor = valor;
	}

	public Carro getCarro() {
		return Carro;
	}

	public void setCarro(Carro carro) {
		Carro = carro;
	}

	public int getQtdDias() {
		return QtdDias;
	}

	public void setQtdDias(int qtdDias) {
		QtdDias = qtdDias;
	}
	
}
