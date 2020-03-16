
public class Moedas {
	static int idd = 1;
	
	private int id;
	private String anof;
	private double vorigem;
	private double vdolar;
	private String porigem;
	private String descfca;
	private String descfco;
	
	public Moedas(String anof, double vorigem, double vdolar, String porigem, String descfca, String descfco) {
		super();
		this.anof = anof;
		this.vorigem = vorigem;
		this.vdolar = vdolar;
		this.porigem = porigem;
		this.descfca = descfca;
		this.descfco = descfco;
		id = idd;
		idd++;
	}

	public double convertervalor(double cot, double vd) {
		return cot*vd;
	}	
	
	public int getId() {
		return id;
	}
	
	public String getAnof() {
		return anof;
	}

	public void setAnof(String anof) {
		this.anof = anof;
	}

	public double getVorigem() {
		return vorigem;
	}

	public void setVorigem(double vorigem) {
		this.vorigem = vorigem;
	}

	public double getVdolar() {
		return vdolar;
	}

	public void setVdolar(double vdolar) {
		this.vdolar = vdolar;
	}

	public String getPorigem() {
		return porigem;
	}

	public void setPorigem(String porigem) {
		this.porigem = porigem;
	}

	public String getDescfca() {
		return descfca;
	}

	public void setDescfe(String descfca) {
		this.descfca = descfca;
	}

	public String getDescfco() {
		return descfco;
	}

	public void setDescfco(String descfco) {
		this.descfco = descfco;
	}
	
		
	
}
