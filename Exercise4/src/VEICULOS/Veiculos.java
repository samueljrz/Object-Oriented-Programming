package VEICULOS;

public abstract class Veiculos {
	protected String id;
	protected double combustivel;
	protected double consumo;
	
	Veiculos() {
		this.combustivel = 0;
		this.consumo = 0;
	}

	public Veiculos(String id, double combustivel, double consumo) {
		super();
		this.id = id;
		this.combustivel = combustivel;
		this.consumo = consumo;
	}

	public abstract boolean consumirCombustivel(double distancia);
	
	public double abastecer(double qtdCombustivel) {
		return combustivel += qtdCombustivel;
	}
	
	public String getId() {
		return id;
	}
	
	public double getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(double combustivel) {
		this.combustivel = combustivel;
	}
	
}
