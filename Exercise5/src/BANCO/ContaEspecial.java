package BANCO;

public class ContaEspecial extends Conta {
	private double limite;

	public ContaEspecial() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContaEspecial(double saldo, int numero, int agencia, double taxaJuros) {
		super(saldo, numero, agencia, taxaJuros);
		// TODO Auto-generated constructor stub
	}

	public void aplicarJuros() {
		if(saldo < 0) {
			saldo += (saldo*taxaJuros)/100;
			if(saldo < limite) {
				super.aplicarJuros();
			}
		}
	}
	
	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}
}
