package Class;

public class Modelo {

	private String Nome;
	private String Versao;
	private int Ano;
	
	public Modelo(String nome, String versao, int ano) {
		super();
		Nome = nome;
		Versao = versao;
		Ano = ano;
	}
	
	public Modelo() {
		
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getVersao() {
		return Versao;
	}

	public void setVersao(String versao) {
		Versao = versao;
	}

	public int getAno() {
		return Ano;
	}

	public void setAno(int ano) {
		Ano = ano;
	}
	
}
