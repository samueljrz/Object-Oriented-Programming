package Class;

public class Carro {
	
	private String Fabricante;
	private String Placa;
	private double ValDiaria;
	private boolean Status;
	private String Modelo;
	
	public Carro(String fabricante, String modelo, String placa, double valDiaria, boolean status) {
		super();
		Fabricante = fabricante;
		Modelo = modelo;
		Placa = placa;
		ValDiaria = valDiaria;
		Status = true;
	}
	
	@Override
	public String toString() {
		return "Carro [Fabricante=" + Fabricante +", Placa=" + Placa + ", Modelo=" + Modelo + ", ValDiaria=" + ValDiaria + "]";
	}
	
	public Carro() {
		Status = true;
	}
	
	public void manutencaoON() {
		Status = false;
	}
	
	public void manutencaoOFF() {
		Status = true																																																																																																																									;
	}
	
	public String getFabricante() {
		return Fabricante;
	}
																															
	public void setFabricante(String fabricante) {
		Fabricante = fabricante;
	}

	public String getModelo() {																												
		return Modelo;
	}

	public void setModelo(String modelo) {
		Modelo = modelo;
	}

	public String getPlaca() {
		return Placa;
	}

	public void setPlaca(String placa) {
		Placa = placa;
	}

	public double getValDiaria() {
		return ValDiaria;
	}

	public void setValDiaria(double valDiaria) {
		ValDiaria = valDiaria;
	}

	public boolean getStatus() {
		return Status;
	}

	public void setStatus(boolean status) {
		Status = status;
	}
	
}
