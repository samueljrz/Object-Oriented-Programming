
public class Televisao implements ControleRemoto {

	private int tamanho;
	private int canal;
	private int volume;
	private boolean ligada;
	
	public Televisao(int tamanho) {
		super();
		this.tamanho = tamanho;
		this.canal = 0;
		this.volume = 0;
		this.ligada = false;
	}

	public void ligar() {
		this.ligada = true;
	}
	
	public void desligar() {
		this.ligada = false;
	}
	
	public void mudarCanal(int canal) {
		if((canal < 0) || (canal > 99)) {
			throw new CanalNaoEncontrado("Canal invalido: " + canal);
		}else {
			this.canal = canal;
		}
	}
	
	public void aumentarVolume(int valor) {
		if(valor < 0 || valor > 99) {
			throw new VolumeInvalido("Volume invalido: " + valor);
		}else {
			this.volume = valor;
		}
	}
	
	public void diminuirVolume(int valor) {
		if(valor < 0 || valor > 99) {
			throw new VolumeInvalido("Volume invalido: " + valor);
		}else {
			this.volume = valor;
		}
	}
	
	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public int getCanal() {
		return canal;
	}

	public void setCanal(int canal) {
		this.canal = canal;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public boolean isLigada() {
		return ligada;
	}

	public void setLigada(boolean ligada) {
		this.ligada = ligada;
	}
	
}
