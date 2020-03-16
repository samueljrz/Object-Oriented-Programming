
public class TrabalhadorHorista extends Trabalhador {
	
	private int horasTrabalhadasMes;
	private double valorHora;
	
	public TrabalhadorHorista(String nome, String sobrenome, String cpf, int horasTrabalhadasMes, double valorHora) {
		super(nome, sobrenome, cpf);
		this.horasTrabalhadasMes = horasTrabalhadasMes;
		this.valorHora = valorHora;
	}
	
	public double getValorPagamento() {
		return (horasTrabalhadasMes*valorHora);
	}
	
	public double getHorasTrabalhadasMes() {
		return horasTrabalhadasMes;
	}
	
	public void setHorasTrabalhadasMes(int horasTrabalhadasMes) {
		this.horasTrabalhadasMes = horasTrabalhadasMes;
	}
	
	public double getValorHora() {
		return valorHora;
	}
	
	public void setValorHora(int valorHora) {
		this.valorHora = valorHora;
	}
	
}
