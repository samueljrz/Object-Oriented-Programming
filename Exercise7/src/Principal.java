import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		boolean ver = true;
		int controle, opc, var;
		ControleRemoto c = new Televisao(42);
		
		Scanner n = new Scanner(System.in);
		
		while(ver) {
			System.out.println("Deseja acessar o controle? 1-SIM, 2-NAO :");
			controle = n.nextInt();
			if(controle == 2) {
				break;
			}else {
				System.out.println("Qual a opção desejada? 1-LIGAR, 2-DESLIGAR, 3-AUMENTARV, 4-DIMINUIRV, 5-MUDARC :");
				opc = n.nextInt();
				switch(opc) {
					case 1:
						c.ligar();
						break;
					case 2:
						c.desligar();
						break;
					case 3:
						System.out.println("Qual valor do volume desejado?: ");
						var = n.nextInt();
						try {
							c.aumentarVolume(var);
						} catch (VolumeInvalido e) {
							System.out.println(e.getMessage());
						}
						break;
					case 4:
						System.out.println("Qual valor do volume desejado?: ");
						var = n.nextInt();
						try {
							c.diminuirVolume(var);
						} catch (VolumeInvalido e) {
							System.out.println(e.getMessage());
						}
						break;
					case 5:
						System.out.println("Qual canal desejado?: ");
						var = n.nextInt();
						try {
							c.mudarCanal(var);
						} catch (CanalNaoEncontrado e) {
							System.out.println(e.getMessage());
						}
						break;
				}
			}
		}
		n.close();
	}
}
