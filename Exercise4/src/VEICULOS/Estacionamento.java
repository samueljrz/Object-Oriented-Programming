package VEICULOS;

import java.util.ArrayList;

public class Estacionamento {
	ArrayList<Veiculos> veiculos = new ArrayList<Veiculos>();
	
	public ArrayList<Veiculos> getListaVeiculos() {
		return veiculos;
	}

	
	public void adicionarVeiculo(Veiculos veiculoss) {
		veiculos.add(veiculoss);
	}
	
	public void retirarVeiculo(String idd) {
		for(int i=0; i<veiculos.size(); i++) {
			if(veiculos.get(i).getId().equals(idd)) {
				this.veiculos.remove(i);
			}
		}
	}
	
	public void passear(String id, double dist) {
		boolean ver = false;
		int s = 0;
		
		for(int i=0; i<veiculos.size(); i++) {
			if(veiculos.get(i).getId().equals(id)) {
				ver = true;
				s = i;
				break;
			}
		}
		
		if(ver) {
		this.veiculos.get(s).consumirCombustivel(dist);
		}
	}
	
}
