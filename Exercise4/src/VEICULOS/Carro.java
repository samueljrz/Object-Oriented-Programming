package VEICULOS;

public class Carro extends Terrestre{

	public Carro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Carro(String id, double combustivel, double consumo) {
		super(id, combustivel, consumo);
		// TODO Auto-generated constructor stub
	}
	
	public boolean consumirCombustivel(double distancia) {
		double dist;
		dist = distancia / 10;
		if(combustivel >= dist) {
			combustivel -= dist;
			return true;
		}else
			return false;
	}
	
}
