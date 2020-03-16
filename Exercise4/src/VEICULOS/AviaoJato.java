package VEICULOS;

public class AviaoJato extends Aereo{

	public AviaoJato() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AviaoJato(String id, double combustivel, double consumo) {
		super(id, combustivel, consumo);
		// TODO Auto-generated constructor stub
	}
	
	public boolean consumirCombustivel(double distancia) {
		double dist;
		dist = distancia / 50;
		if(combustivel >= dist) {
			combustivel -= dist;
			return true;
		}else
			return false;
	}
	
}
