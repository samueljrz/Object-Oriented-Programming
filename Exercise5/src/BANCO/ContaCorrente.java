package BANCO;

public class ContaCorrente extends Conta {
	private double imposto;

	public ContaCorrente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContaCorrente(double saldo, int numero, int agencia, double taxaJuros) {
		super(saldo, numero, agencia, taxaJuros);
		// TODO Auto-generated constructor stub
	}
	
	public void aplicarJuros() {
		super.aplicarJuros();
		if(saldo < 0) {
			saldo += (saldo*taxaJuros)/100;
		}
	}
	
	public void aplicarImposto() {
		saldo -= (imposto*saldo)/100;
	} 
	
	public void aplicarImposto(double taxa) {
		saldo -= (taxa*saldo)/100;
	}
}
