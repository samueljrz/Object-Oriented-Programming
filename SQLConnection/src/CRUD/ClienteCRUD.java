package CRUD;

import java.util.List;
import java.util.Scanner;

import Class.Cliente;
import DAO.ClienteDAO;

public class ClienteCRUD {

	private static Scanner teclado = new Scanner(System.in);
    private static ClienteDAO dao = new ClienteDAO();

    public static void executar(int op) throws ClassNotFoundException {
        switch (op) {
            case 1:
            	inserir();
                break;
            case 2:
                atualizar();
                break;
            case 3:
                listar();
                break;
            case 4:
                System.out.println("Digite o cpf");
                buscarPorCpf(teclado.nextLine());
                break;
            case 5:
                deletar();
                break;
        }
    }

    private static void inserir() throws ClassNotFoundException {
        Cliente c = new Cliente();
        System.out.println("Nome: ");
        c.setNome(teclado.nextLine());
        System.out.println("Cpf: ");
        c.setCpf(teclado.nextLine()); 
        System.out.println("Cnh: ");
        c.setCnh(teclado.nextLine());
        System.out.println("Endereco: ");
        c.setEndereco(teclado.nextLine());
        dao.save(c);
    }

    private static void atualizar() throws ClassNotFoundException {
        System.out.println("Selecione um dos clientes abaixo");
        List<Cliente> clienteList = listar();
        Cliente c = clienteList.get(Integer.parseInt(teclado.nextLine()));
        System.out.println("O que voce deseja alterar? :");
        System.out.println("1. Nome");
        System.out.println("2. Cpf");
        System.out.println("3. Cnh");
        System.out.println("4. Endereço");
        System.out.println("0. Sair");
        String z;
        z = teclado.nextLine();
        switch (z) {
		case "1":
			System.out.println("Digite novo nome: ");
			String nome = teclado.nextLine();
			c.setNome(nome);
			dao.update(c);
			break;

		case "2":
			System.out.println("Digite novo cpf: ");
			String cpf = teclado.nextLine();
			c.setCpf(cpf);
			dao.update(c);
			break;
		
		case "3":
			System.out.println("Digite novo cnh: ");
			String cnh = teclado.nextLine();
			c.setCnh(cnh);
			dao.update(c);
			break;
		
		case "4":
			System.out.println("Digite novo endereco: ");
			String endereco = teclado.nextLine();
			c.setEndereco(endereco);
			dao.update(c);
		
		case "0":
			break;

		default:
			break;
		}
    }

    static List<Cliente> listar() throws ClassNotFoundException {
        List<Cliente> clienteList = dao.selectAll();
        for (int i = 0; i < clienteList.size(); i++) {
            Cliente c = clienteList.get(i);
            System.out.println("[" + i + "] " + c.getNome() + " " + c.getCpf() + " "+ c.getCnh() + " " + c.getEndereco());
        }
        return clienteList;
    }

    private static void buscarPorCpf(String cpf) throws ClassNotFoundException {
        List<Cliente> clienteList = dao.searchByCpf(cpf);
        for (int i = 0; i < clienteList.size(); i++) {
            Cliente c = clienteList.get(i);
            System.out.println("[" + i + "] " + c.getNome() + " " + c.getCpf() + " "+ c.getCnh() + " " + c.getEndereco());
        }
    }

    public static void deletar() throws ClassNotFoundException {
        System.out.println("Selecione um dos clientes abaixo para deletar");
        List<Cliente> clienteList = listar();
        int index = Integer.parseInt(teclado.nextLine());
        System.out.println("Tem certeza? S/N");
        String op = teclado.nextLine();
        if (op.startsWith("s") || op.startsWith("s")) {
            dao.delete(clienteList.get(index));
        }
    }
}
