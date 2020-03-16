import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		int carrox;
		double dias;
		Carro c1 = new Carro("AAA1111", "GOL BOLINHA", 45.5);
		Carro c2 = new Carro("AAA1111", "OPALA 1988", 37.5);
		Carro c3 = new Carro("CCC3333", "RANGE ROVER EVOQUE", 350.0);
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Escolha o Carro que Deseja Alugar\n");
		System.out.println("1 - " + c1.paraString());
		System.out.println("2 - " + c2.paraString());
		System.out.println("3 - " + c3.paraString());
		
		System.out.println("Informe pelo numero qual carro é desejado alugar\n");
		carrox = in.nextInt();
		in.nextLine();
		System.out.println("Informe quantos dias é desejado passar com o carro\n");
		dias = in.nextDouble();
		in.nextLine();
		
		switch(carrox) {
			case 1:
				RegistroAluguel r1 = new RegistroAluguel(c1, c1.ValAluguel(dias));
				System.out.println(r1.paraString());
				break;
			case 2:
				RegistroAluguel r2 = new RegistroAluguel(c2, c2.ValAluguel(dias));
				System.out.println(r2.paraString());
				break;
			case 3:
				RegistroAluguel r3 = new RegistroAluguel(c3, c3.ValAluguel(dias));
				System.out.println(r3.paraString());
				break;
		}
		in.close();
		if(c1.equals(c2)) {
			System.out.println("Eles são iguais\n");
		}
	}

}
