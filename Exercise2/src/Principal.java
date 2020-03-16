import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		int x=1, i, aux, j, auxid;
		Moedas[] arrayMoedas = new Moedas[20];
		boolean verificador = true;
		String ver, anof, porigem, descfca, descfco;
		double vorigem, vdolar, auxd, auxdd;
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Deseja adicionar uma moeda a coleção? S ou N");
		ver = in.nextLine();
		if(ver.equals("S") || ver.equals("s")) {
			verificador = true;
		}else
			verificador = false;
		
		while(verificador)	{
			System.out.println("Qual ano de fabricação da moeda? :");
			anof = in.nextLine();
			System.out.println("Qual valor de origem da moeda? :");
			vorigem = in.nextDouble();
			in.nextLine();
			System.out.println("Qual valor em dolar da moeda? :");
			vdolar = in.nextDouble();
			in.nextLine();
			System.out.println("Qual país de origem da moeda? :");
			porigem = in.nextLine();
			System.out.println("Descrição da face cara da moeda :");
			descfca = in.nextLine();
			System.out.println("Descrição da face coroa da moeda :");
			descfco = in.nextLine();
			
			arrayMoedas[x] = new Moedas(anof, vorigem, vdolar, porigem, descfca, descfco);
			x++;
			
			System.out.println("Deseja adicionar outra moeda a coleção? S ou N");
			ver = in.nextLine();
			if(ver.equals("S") || ver.equals("s")) {
				verificador = true;
			}else
				verificador = false;
		}
		
		for(i=1; i<=x; i++)	{
			System.out.println("Deseja converter o valor de alguma moeda? S ou N");
			ver = in.nextLine();
			if(ver.equals("S") || ver.equals("s")) {
				System.out.println("Qual ID da moeda que deseja converter o valor? :");
				aux = in.nextInt();
				in.nextLine();
				System.out.println("Qual a cotação do dolar? :");
				auxd = in.nextDouble();
				in.nextLine();
				for(j=1; j<=x; j++)	{
					auxid = arrayMoedas[j].getId();
					if(auxid == aux)	{
						auxdd = arrayMoedas[j].getVdolar();
						System.out.println(arrayMoedas[j].convertervalor(auxd, auxdd));
						break;
					}
				}
			}else
				break;
		}

		in.close();
	}

}
