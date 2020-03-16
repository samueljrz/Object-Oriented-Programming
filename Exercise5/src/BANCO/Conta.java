package BANCO;

public abstract class Conta {
	protected double saldo;
	protected int numero;
	protected int agencia;
	protected double taxaJuros;
	
	public Conta() {
		this.saldo = 0;
		this.numero = 0;
		this.agencia = 0;
		this.taxaJuros = 0;
	}
	
	public Conta(double saldo, int numero, int agencia, double taxaJuros) {
		super();
		this.saldo = saldo;
		this.numero = numero;
		this.agencia = agencia;
		this.taxaJuros = taxaJuros;
	}
	
	public void sacar(double valor) {
		saldo -= valor;
	}
	
	public void depositar(double valor) {
		saldo += valor;
	}

	public void aplicarJuros() {
		saldo -= 25;
	}
	
	public double getSaldo() {
		return saldo;
	}

	public double getTaxaJuros() {
		return taxaJuros;
	}

	public void setTaxaJuros(double taxaJuros) {
		this.taxaJuros = taxaJuros;
	}
}
