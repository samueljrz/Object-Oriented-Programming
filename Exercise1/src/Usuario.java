
public class Usuario {
	static int idx = 1;
	
	int id;
	String nome;
	String sobrenome;
	int idade;
	String cargo;
	double salario;
	
	Usuario()	{
		id = idx;
		idx++;
	}
	
	public void promover(double x)	{
		salario += salario*(x / 100);	
	}
}
