package questao1;

public class ControleGerencial implements Gerenciavel{

	@Override
	public void cancelarPedido(Pedido x) {
		x.cancelarPedido();
		
	}
	
}
