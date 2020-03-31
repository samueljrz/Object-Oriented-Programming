package Class;

import java.util.Scanner;
import CRUD.CarroCRUD;
import CRUD.ClienteCRUD;
import CRUD.AlocacaoCRUD;

public class Principal {
	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) throws ClassNotFoundException {
		int op;
		boolean ver = true;
		while(ver) {
			menu();
            op = Integer.parseInt(teclado.nextLine());
            switch (op) {
			case 0:
				System.out.println("Saindo do sistema");
				ver = false;
				break;
			
			case 1:
				menuCarro();
				op = Integer.parseInt(teclado.nextLine());
	            CarroCRUD.executar(op);
				break;
			
			case 2:
				menuCliente();
				op = Integer.parseInt(teclado.nextLine());
	            ClienteCRUD.executar(op);
				break;
				
			case 3:
				menuRegistro();
				op = Integer.parseInt(teclado.nextLine());
	            AlocacaoCRUD.executar(op);
				break;

			default:
				break;
			}
		}
		
	}
	
    private static void menu(){
        System.out.println("Selecione uma opção:");
        System.out.println("1. Carro");
        System.out.println("2. Cliente");
        System.out.println("3. Registros");
        System.out.println("0. Sair");
    }

    private static void menuCarro() {
        System.out.println("Digite a opção para começar");
        System.out.println("1. Inserir Carro");
        System.out.println("2. Atualizar Carro");
        System.out.println("3. Listar todos os Carros");
        System.out.println("4. Buscar Carro por placa");
        System.out.println("5. Deletar");
        System.out.println("0. Voltar");
    }
    private static void menuCliente() {
        System.out.println("Digite a opção para começar");
        System.out.println("1. Inserir Cliente");
        System.out.println("2. Atualizar Cliente");
        System.out.println("3. Listar todos os Clientes");
        System.out.println("4. Buscar Cliente por cpf");
        System.out.println("5. Deletar");
        System.out.println("9. Voltar");
    }
    private static void menuRegistro() {
        System.out.println("Digite a opção para começar");
        System.out.println("1. Inserir Registro");
        System.out.println("2. Atualizar Registro");
        System.out.println("3. Listar todos os Registros");
        System.out.println("4. Buscar registro por data");
        System.out.println("5. Deletar");
        System.out.println("9. Voltar");
    }

}
