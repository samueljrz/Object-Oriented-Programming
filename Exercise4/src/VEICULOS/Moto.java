package VEICULOS;

public class Moto extends Terrestre{

	public Moto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Moto(String id, double combustivel, double consumo) {
		super(id, combustivel, consumo);
		// TODO Auto-generated constructor stub
	}
	
	public boolean consumirCombustivel(double distancia) {
		double dist;
		dist = distancia / 20;
		if(combustivel >= dist) {
			combustivel -= dist;
			return true;
		}else
			return false;
	}
	
}
