package CRUD;


import java.util.List;
import java.util.Scanner;

import Class.Alocacao;
import Class.Carro;
import Class.Cliente;
import CRUD.ClienteCRUD;
import CRUD.CarroCRUD;
import DAO.AlocacaoDAO;

public class AlocacaoCRUD {

	private static Scanner teclado = new Scanner(System.in);
	private static AlocacaoDAO dao = new AlocacaoDAO();

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
	                System.out.println("Digite a data da locação");
	                buscarPorData(teclado.nextLine());
	                break;
	            case 5:
	                deletar();
	                break;
	        }
	    }

	    private static void inserir() throws ClassNotFoundException {
	        Alocacao a = new Alocacao();
	        System.out.println("Selecione o cliente: ");
	        List<Cliente> clienteList = ClienteCRUD.listar();
	        a.setCliente(clienteList.get(Integer.parseInt(teclado.nextLine())));
	        System.out.println("Selecione o carro: ");
	        List<Carro> carroList = CarroCRUD.listar();
	        a.setCarro(carroList.get(Integer.parseInt(teclado.nextLine())));
	        System.out.println("Data da retirada do carro: ");
	        a.setDataInicio(teclado.nextLine());
	        System.out.println("Data da entrega do carro: ");
	        a.setDataFim(teclado.nextLine());
	        a.setValTotal();
	        //a.gerarCupomFiscal();
	        dao.save(a);
	    }

	    private static void atualizar() throws ClassNotFoundException {
	        System.out.println("Selecione um das locações abaixo");
	        List<Alocacao> alocacaoList = listar();
	        Alocacao a = alocacaoList.get(Integer.parseInt(teclado.nextLine()));
	        System.out.println("O que voce deseja alterar? :");
	        System.out.println("1. Cliente");
	        System.out.println("2. Carro");
	        System.out.println("3. Data Inicio");
	        System.out.println("4. Data Fim");
	        System.out.println("0. Sair");
	        String z;
	        z = teclado.nextLine();
	        switch (z) {
			case "1":
				System.out.println("Selecione novo cliente: ");
				List<Cliente> clienteList = ClienteCRUD.listar();
		        a.setCliente(clienteList.get(Integer.parseInt(teclado.nextLine())));
				dao.update(a);
				break;

			case "2":
				System.out.println("Selecione novo carro: ");
				List<Carro> carroList = CarroCRUD.listar();
		        a.setCarro(carroList.get(Integer.parseInt(teclado.nextLine())));
				dao.update(a);
				break;
			
			case "3":
				System.out.println("Digite nova data inicio: ");
				String dataini = teclado.nextLine();
				a.setDataInicio(dataini);
				dao.update(a);
				break;
			
			case "4":
				System.out.println("Digite nova data fim: ");
				String datafim = teclado.nextLine();
				a.setDataFim(datafim);
				dao.update(a);
				break;
			
			case "0":
				break;
			
			default:
				break;
			}
	    }

	    private static List<Alocacao> listar() throws ClassNotFoundException {
	        List<Alocacao> alocacaoList = dao.selectAll();
	        for (int i = 0; i < alocacaoList.size(); i++) {
	            Alocacao a = alocacaoList.get(i);
	            System.out.println("[" + i + "] " + a.getCliente() + " " + a.getCarro() + " "+ a.getDataInicio() + " " + a.getDataFim() + " " + a.getValTotal() + a.gerarCupomFiscal());
	        }
	        return alocacaoList;
	    }

	    private static void buscarPorData(String data) throws ClassNotFoundException {
	        List<Alocacao> alocacaoList = dao.searchByData(data);
	        for (int i = 0; i < alocacaoList.size(); i++) {
	            Alocacao a = alocacaoList.get(i);
	            System.out.println("[" + i + "] " + a.getCliente() + " " + a.getCarro() + " "+ a.getDataInicio() + " " + a.getDataFim() + " " + a.getValTotal() + a.gerarCupomFiscal());
	        }
	    }

	    public static void deletar() throws ClassNotFoundException {
	        System.out.println("Selecione uma das locacoes abaixo para deletar");
	        List<Alocacao> alocacaoList = listar();
	        int index = Integer.parseInt(teclado.nextLine());
	        System.out.println("Tem certeza? S/N");
	        String op = teclado.nextLine();
	        if (op.startsWith("s") || op.startsWith("s")) {
	            dao.delete(alocacaoList.get(index));
	        }
	    }


}
