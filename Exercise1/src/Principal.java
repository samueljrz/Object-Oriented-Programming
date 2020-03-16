import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		int i, idd;
		double x;
		Usuario[] arrayUsuarios = new Usuario[5];
		String t;
		
		Scanner in = new Scanner(System.in);
		
		for(i=1; i<=5; i++) {
			arrayUsuarios[i] = new Usuario();
			
			System.out.printf("Digite o nome do Usuario %d:", i);
			arrayUsuarios[i].nome = in.nextLine();
			System.out.printf("Digite o sobrenome do Usuario %d:", i);
			arrayUsuarios[i].sobrenome = in.nextLine();
			System.out.printf("Digite a idade do Usuario %d:", i);
			arrayUsuarios[i].idade = in.nextInt();
			in.nextLine();
			System.out.printf("Digite o cargo do Usuario %d:", i);
			arrayUsuarios[i].cargo = in.nextLine();
			System.out.printf("Digite o salário do Usuario %d:", i);
			arrayUsuarios[i].salario = in.nextDouble();
			in.nextLine();
			
			System.out.println("Deseja adicionar outro Usuario? S ou N:");
			t = in.nextLine();
			
			if(t.equals("N") || t.equals("n"))	{
				break;
			}else
				continue;
		}
		
		System.out.println("Deseja aumentar o salario de algum Usuario? S ou N:");
		t = in.nextLine();
		if(t.equals("S") || t.equals("s"))	{
			for(i=1; i<=5; i++)	{
				System.out.println("Digite o id do Usuario que deseja aumentar o salario:");
				idd = in.nextInt();
				in.nextLine();
				System.out.printf("Digite quantos % sera o aumento do Usuario %d:", idd);
				x = in.nextDouble();
				in.nextLine();
				arrayUsuarios[idd].promover(x);
				System.out.println("Deseja promover outro Usuario? S ou N:");
				t = in.nextLine();
				
				if(t.equals("N") || t.equals("n"))	{
					break;
				}else
					continue;
				
			}
		}
		in.close();
	}
}
