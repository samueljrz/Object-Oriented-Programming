import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		ArrayList<Pagavel> p = new ArrayList<Pagavel> ();
		
		Pagavel trab;
		trab = new TrabalhadorAssalariado("Samuel", "Junior", "1245678910", 20000);
		p.add(trab);
		trab = new TrabalhadorHorista("Ian", "Mateus", "10987654321", 160, 99);
		p.add(trab);
		trab = new Cobranca(200);
		p.add(trab);
		
		for (Pagavel pagavel : p) {
			System.out.println("Valor: " + pagavel.getValorPagamento());
		}

	}

}
