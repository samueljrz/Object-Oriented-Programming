package BANCO;

public class Principal {

	public static void main(String[] args) {
		Banco b = new Banco();
		Cliente c1 = new Cliente("Samuel", 14002892222l);
		Cliente c2 = new Cliente("Ian", 83569962500l);
		Conta c;
		c = new ContaCorrente(400, 123, 2999, 10);
		c1.setContaCorrente(c);
		c = new ContaPoupanca(400, 1234, 2999, 10);
		c1.setContaPoupanca(c);
		c = new ContaEspecial(5000, 432, 2653, 20);
		c2.setContaEspecial(c);
		c = new ContaPoupanca(2510, 523, 2653, 5);
		c2.setContaPoupanca(c);
		
	 	System.out.println(c1.contas.get(1).taxaJuros);
	 	System.out.println(c1.contas.get(2).taxaJuros);
	 	System.out.println(c2.contas.get(3).taxaJuros);
	 	System.out.println(c2.contas.get(2).taxaJuros);
	 	System.out.println(c2.getSaldoTotal());
	 	System.out.println(c1.getSaldoTotal());
	 	c2.contas.get(1).aplicarJuros();
	 	c2.contas.get(2).aplicarJuros();
	 	c2.contas.get(3).aplicarJuros();
	 	c2.contas.get(2).aplicarJuros();
	 	System.out.println(c1.contas.get(1).taxaJuros);
	 	System.out.println(c1.contas.get(2).taxaJuros);
	 	System.out.println(c2.contas.get(3).taxaJuros);
	 	System.out.println(c2.contas.get(2).taxaJuros);
	 	System.out.println(c2.getSaldoTotal());
	 	System.out.println(c1.getSaldoTotal());
	 	if(b.auditoria()) {
	 		System.out.println("Passou na auditoria");
	 	}else {
	 		System.out.println("Não passou na auditoria");
	 	}
	 		
	}	

}
