package BANCO;

public class ContaPoupanca extends Conta {

	public ContaPoupanca() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContaPoupanca(double saldo, int numero, int agencia, double taxaJuros) {
		super(saldo, numero, agencia, taxaJuros);
		// TODO Auto-generated constructor stub
	}
	
	public void aplicarJuros() {
			saldo += (saldo*taxaJuros)/100;
	}
}
