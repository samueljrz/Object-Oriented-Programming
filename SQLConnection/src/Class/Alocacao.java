package Class;

public class Alocacao {

	private Cliente Cliente;
	private Carro Carro;
	private String DataInicio;
	private String DataFim;
	private double ValTotal;
	private CupomFiscal CP;
	
	public Alocacao(Cliente cliente, Carro carro, String dataInicio, String dataFim) {
		super();
		Cliente = cliente;
		Carro = carro;
		DataInicio = dataInicio;
		DataFim = dataFim;
		ValTotal = totalDias()*Carro.getValDiaria();
	}
	
	public Alocacao() {
		
	}
	
	public CupomFiscal gerarCupomFiscal() {
		CupomFiscal cpm = new CupomFiscal(DataInicio, Cliente, ValTotal, Carro, totalDias());
		CP = cpm;
		return cpm;
		
	}
	
	public int totalDias() {
		String diai, diaf, mesi, mesf;
		diai = DataInicio.substring(1, 2);
		diaf = DataFim.substring(1, 2);
		mesi = DataInicio.substring(4, 5);
		mesf = DataFim.substring(4, 5);
		int total = (1*(Integer.parseInt(diaf)-(Integer.parseInt(diai)))) + (30*(Integer.parseInt(mesf)-(Integer.parseInt(mesi))));
		return total;
	}

	public Cliente getCliente() {
		return Cliente;
	}

	public void setCliente(Cliente cliente) {
		Cliente = cliente;
	}

	public Carro getCarro() {
		return Carro;
	}

	public void setCarro(Carro carro) {
		Carro = carro;
	}

	public String getDataInicio() {
		return DataInicio;
	}

	public void setDataInicio(String dataInicio) {
		DataInicio = dataInicio;
	}

	public String getDataFim() {
		return DataFim;
	}

	public void setDataFim(String dataFim) {
		DataFim = dataFim;
	}

	public double getValTotal() {
		return ValTotal;
	}

	public void setValTotal() {
		ValTotal = (double)totalDias()*Carro.getValDiaria();
	}
	
	public CupomFiscal getCupomFiscal() {
		return CP;
	}

	public void setCupomFiscal(CupomFiscal CupomFiscal) {
		CP = CupomFiscal;
	}
	
}
