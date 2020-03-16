package BANCO;

import java.util.ArrayList;

public class Cliente {
	private String nome;
	private long cpf;
	ArrayList<Conta> contas = new ArrayList<Conta>(3);
	
	public Cliente() {
		this.nome = null;
		this.cpf = 0;
	}
	
	public Cliente(String nome, long cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public boolean setContaCorrente(Conta c) {
		if(contas.get(1) != null) {
			contas.add(1, c);
			return true;
		}
		return false;
	}
	
	public boolean setContaPoupanca(Conta c) {
		if(contas.get(2) != null) {
			contas.add(2, c);
			return true;
		}
		return false;
	}
	
	public boolean setContaEspecial(Conta c) {
		if(contas.get(3) != null) {
			contas.add(3, c);
			return true;
		}
		return false;
	}
	
	public double getSaldoTotal() {
		double saldot = 0;
		for (Conta conta : contas) {
			if(conta != null) {
				saldot += conta.getSaldo();
			}
		}
		return saldot;
	}
}
