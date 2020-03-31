package CRUD;

import Class.Carro;
import DAO.CarroDAO;


import java.util.List;
import java.util.Scanner;

public class CarroCRUD {

	private static Scanner teclado = new Scanner(System.in);
    private static CarroDAO dao = new CarroDAO();

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
                System.out.println("Digite a placa do carro");
                buscarPorPlaca(teclado.nextLine());
                break;
            case 5:
                deletar();
                break;
        }
    }

    private static void inserir() throws ClassNotFoundException {
        Carro c = new Carro();
        String s;
        Double d;
        System.out.println("Fabricante: ");
        s = teclado.nextLine();
        c.setFabricante(s);
        System.out.println("Placa: ");
        s = teclado.nextLine();
        c.setPlaca(s);
        System.out.println("Modelo: ");
        s = teclado.nextLine();
        c.setModelo(s);
        System.out.println("Valor da Diaria: ");
        d = teclado.nextDouble();
        c.setValDiaria(d);
        dao.save(c);
    }

    private static void atualizar() throws ClassNotFoundException {
        System.out.println("Selecione um dos carros abaixo");
        List<Carro> carroList = listar();
        Carro c = carroList.get(Integer.parseInt(teclado.nextLine()));
        System.out.println("O que voce deseja alterar? :");
        System.out.println("1. Fabricante");
        System.out.println("2. Modelo");
        System.out.println("3. Placa");
        System.out.println("4. Valor da Diaria");
        System.out.println("5. Status de Manutenção");
        System.out.println("0. Sair");
        String z;
        z = teclado.nextLine();
        switch (z) {
		case "1":
			System.out.println("Digite novo fabricante: ");
			String fabricante;
			fabricante = teclado.nextLine();
			c.setFabricante(fabricante);
			dao.update(c);
			break;

		case "2":
			System.out.println("Digite novo modelo: ");
			String modelo = teclado.nextLine();
			c.setModelo(modelo);
			dao.update(c);
			break;
			
		case "3":
			System.out.println("Digite novo placa: ");
			String placa = teclado.nextLine();
			c.setPlaca(placa);
			dao.update(c);
			break;
		
		case "4":
			System.out.println("Digite novo valor diaria: ");
			double val = teclado.nextDouble();
			c.setValDiaria(val);
			dao.update(c);
			break;
		
		case "5":
			if(c.getStatus()) {
				c.setStatus(false);
			}else {
				c.setStatus(true);
			}
			dao.update(c);
			break;
		
		case "0":
			break;
		
		default:
			break;
		}
    }

    public static List<Carro> listar() throws ClassNotFoundException {
        List<Carro> carroList = dao.selectAll();
        for (int i = 0; i < carroList.size(); i++) {
            Carro c = carroList.get(i);
            System.out.println("[" + i + "] " + c.getFabricante() + " " + c.getModelo() + " "+ c.getPlaca() + " " + c.getValDiaria() + " " + c.getStatus());
        }
        return carroList;
    }

    private static void buscarPorPlaca(String placa) throws ClassNotFoundException {
        List<Carro> carroList = dao.searchByPlaca(placa);
        for (int i = 0; i < carroList.size(); i++) {
            Carro c = carroList.get(i);
            System.out.println("[" + i + "] " + c.getFabricante() + " " + c.getModelo() + " "+ c.getPlaca() + " " + c.getValDiaria() + " " + c.getStatus());
        }
    }

    public static void deletar() throws ClassNotFoundException {
        System.out.println("Selecione um dos carros abaixo para deletar");
        List<Carro> carroList = listar();
        int index = Integer.parseInt(teclado.nextLine());
        System.out.println("Tem certeza? S/N");
        String op = teclado.nextLine();
        if (op.startsWith("s") || op.startsWith("s")) {
            dao.delete(carroList.get(index));
        }
    }

}
