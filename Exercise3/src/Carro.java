
public class Carro {
	private String Placa;
	private String Modelo;
	private double ValDiaria;
	
	public Carro(String placa, String modelo, double valDiaria) {
		super();
		this.Placa = placa;
		this.Modelo = modelo;
		this.ValDiaria = valDiaria;
	}

	public double ValAluguel(double qtddias) {
		return (qtddias*ValDiaria);
	}
	
	public boolean equals(Carro carro) {
		return this.Placa.equals(carro.Placa);
	}
	
	public String paraString() {
		String s;
		s = ("Placa: " + this.Placa + "\n" + "Modelo: " + this.Modelo + "\n" + "Valor da Diaria: " + this.ValDiaria + "\n\n");
		return s;
	}
	
	public String getPlaca() {
		return Placa;
	}

	public void setPlaca(String placa) {
		Placa = placa;
	}

	public String getModelo() {
		return Modelo;
	}

	public void setModelo(String modelo) {
		Modelo = modelo;
	}

	public double getValDiaria() {
		return ValDiaria;
	}

	public void setValDiaria(double valDiaria) {
		ValDiaria = valDiaria;
	}
	
	
}
