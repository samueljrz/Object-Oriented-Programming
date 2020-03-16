
public abstract class Trabalhador implements Pagavel {
	
	protected String nome;
	protected String sobrenome;
	protected String cpf;
	
	public Trabalhador() {
		this.nome = null;
		this.sobrenome = null;
		this.cpf = null;
	}
	
	public Trabalhador(String nome, String sobrenome, String cpf) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
	}

}
