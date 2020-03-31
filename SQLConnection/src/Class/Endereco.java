package Class;

public class Endereco {

	private String Logradouro;
	private int Numero;
	private String Complemento;
	private String Bairro;
	private String UF;
	
	public Endereco(String logradouro, int numero, String complemento, String bairro, String uF) {
		super();
		Logradouro = logradouro;
		Numero = numero;
		Complemento = complemento;
		Bairro = bairro;
		UF = uF;
	}
	
	public Endereco() {
		
	}

	public String getLogradouro() {
		return Logradouro;
	}

	public void setLogradouro(String logradouro) {
		Logradouro = logradouro;
	}

	public int getNumero() {
		return Numero;
	}

	public void setNumero(int numero) {
		Numero = numero;
	}

	public String getComplemento() {
		return Complemento;
	}

	public void setComplemento(String complemento) {
		Complemento = complemento;
	}

	public String getBairro() {
		return Bairro;
	}

	public void setBairro(String bairro) {
		Bairro = bairro;
	}

	public String getUF() {
		return UF;
	}

	public void setUF(String uF) {
		UF = uF;
	}
	
}
