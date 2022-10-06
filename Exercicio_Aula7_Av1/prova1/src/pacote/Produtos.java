package pacote;

import java.util.ArrayList;


public class Produtos { // e um estoque
	
	
	private String nomeEstoque;
	private String categoriaEstoque;
	private int qtdEstoque=0;
	private ArrayList<Produto> Vetprodutos;
	
	
	public void InsereEstoque(Produto novoProduto) {
		
		Vetprodutos.add(novoProduto);
		qtdEstoque++;
		
	}
	
	
	public String getNomeEstoque() {
		return nomeEstoque;
	}

	public void setNomeEstoque(String nomeEstoque) {
		this.nomeEstoque = nomeEstoque;
	}

	public String getCategoriaEstoque() {
		return categoriaEstoque;
	}

	public void setCategoriaEstoque(String categoriaEstoque) {
		this.categoriaEstoque = categoriaEstoque;
	}
	
	public int getQtdEstoque() {
		
		return this.qtdEstoque;
		
	}

	public  Produtos(){
		
	}
	
	public  Produtos(String estoque, String categoria) {
		
		nomeEstoque=estoque;
		categoriaEstoque=categoria;
		
	}
	
	void ExibeEstoque() {
		
		
		int i ;
		int qtdprod=getQtdEstoque();
		System.out.println("--- \tExibindo Estoques -----:\n");
		for(i=0;i<qtdprod;i++) {
			
			Produto prod= Vetprodutos.get(i);
			System.out.printf("Produto: ID Estq: %d ->\n\t %d - %s - %s - %s - %s - %s - %f - %f - %s\n",i+1,prod.getId(),prod.getCodBarras(),prod.getSku(),prod.getNome(),prod.getDescricao(),prod.getCategoria(),prod.getPreco(),prod.getPeso(),prod.getFabricante());
		}
		
	}
	
	
}
