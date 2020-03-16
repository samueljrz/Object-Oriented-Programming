
public class TrabalhadorAssalariado extends Trabalhador {
	
	private double salario;

	public TrabalhadorAssalariado(String nome, String sobrenome, String cpf, double salario) {
		super(nome, sobrenome, cpf);
		this.salario = salario;
	}
	
 	public double getValorPagamento() {
		return salario;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
}
