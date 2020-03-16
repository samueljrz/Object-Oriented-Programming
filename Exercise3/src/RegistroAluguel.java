
public class RegistroAluguel {
	private Carro CarroAlugado;
	private double ValAluguel;
	
	public RegistroAluguel(Carro carroAlugado, double valAluguel) {
		super();
		this.CarroAlugado = carroAlugado;
		this.ValAluguel = valAluguel;
	}

	public String paraString() {
		String s;
		s = (CarroAlugado.paraString() + "Valor do Aluguel: " + this.ValAluguel + "\n");
		return s;
	}
	
	public Carro getCarroAlugado() {
		return CarroAlugado;
	}

	public void setCarroAlugado(Carro carroAlugado) {
		CarroAlugado = carroAlugado;
	}

	public double getValAluguel() {
		return ValAluguel;
	}

	public void setValAluguel(double valAluguel) {
		ValAluguel = valAluguel;
	}	
	
}