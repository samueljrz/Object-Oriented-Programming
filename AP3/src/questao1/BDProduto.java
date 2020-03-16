package questao1;

import java.util.ArrayList;

public class BDProduto {

	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	
	public Produto  ProcurarProduto(int codigoProduto) throws ProdutoNaoEncontrado{
		for (Produto produto : produtos) {
			if(produto.getCodigoProduto() == codigoProduto)
				return produto;
		}
		throw new ProdutoNaoEncontrado(codigoProduto);
	}
	
	public void adicionarProduto(Produto x){
		this.produtos.add(x);
	}
	
	public void  retirarProduto(int codigoProduto) {
		Produto p = null;
		try {
			p = ProcurarProduto(codigoProduto);
		} catch (ProdutoNaoEncontrado msg) {
			System.out.println(msg.getMessage());
		}
		this.produtos.remove(p);
	}

	@Override
	public String toString() {
		return "Produtos [produtos =" + produtos + "]";
	}
	
}