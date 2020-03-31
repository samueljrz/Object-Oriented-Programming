package Class;

public class Cliente {
	
	private String Nome;
	private String Cpf;
	private String Cnh;
	private String Endereco;
	
	public Cliente(String nome, String cpf, String cnh, String endereco) {
		super();
		Nome = nome;
		Cpf = cpf;
		Cnh = cnh;
		Endereco = endereco;
	}
	
	public Cliente() {
		
	}
	
	@Override
	public String toString() {
		return "Cliente [Nome=" + Nome +", Cpf=" + Cpf + ", Cnh=" + Cnh + ", Endereco=" + Endereco + "]";
	}

	public boolean alugarCarro() {
		return true;
	}
	
	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCpf() {
		return Cpf;
	}

	public void setCpf(String cpf) {
		Cpf = cpf;
	}

	public String getCnh() {
		return Cnh;
	}

	public void setCnh(String cnh) {
		Cnh = cnh;
	}

	public String getEndereco() {
		return Endereco;
	}

	public void setEndereco(String endereco) {
		Endereco = endereco;
	}

}
