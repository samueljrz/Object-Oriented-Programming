package VEICULOS;

import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		ArrayList<Veiculos> veiculos = new ArrayList<Veiculos>();
		Veiculos v;
		Estacionamento parking = new Estacionamento();
		
		v = new Carro("1",175, 10);
		veiculos.add(v);
		v = new Moto("2", 50, 20);
		veiculos.add(v);
		v = new AviaoJato("3", 160, 50);
		veiculos.add(v);
		v = new Navio("4", 170, 30);
		veiculos.add(v);

		for(int i = 0; i < veiculos.size(); i++) parking.adicionarVeiculo(veiculos.get(i));
		
		
	}

}
