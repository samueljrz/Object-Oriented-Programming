package VEICULOS;

public class AviaoBimotor extends Aereo{

	public AviaoBimotor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AviaoBimotor(String id, double combustivel, double consumo) {
		super(id, combustivel, consumo);
		// TODO Auto-generated constructor stub
	}
	
	public boolean consumirCombustivel(double distancia) {
		double dist;
		dist = distancia / 30;
		if(combustivel >= dist) {
			combustivel -= dist;
			return true;
		}else
			return false;
	}
	
}
