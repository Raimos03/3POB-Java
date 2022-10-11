package pacote;

import java.util.ArrayList;
import java.util.Scanner;

public class Produtos { // e um estoque
		
	private String nomeEstoque;
	private String categoriaEstoque;
	private int qtdEstoque=0;
	private ArrayList<Produto> Vetprodutos = new ArrayList<>();
	
	
	public void InsereEstoque(Produto novoProduto) {
		
		Vetprodutos.add(novoProduto);
		qtdEstoque++;
	}
	
	public int BuscaProdutoNome(String bnome) {
		
		//procura produto por nome
			
		int i;
		for(i=0;i<Vetprodutos.size();i++) {		
			if(bnome.equals(Vetprodutos.get(i).getNome())) {			
				return i; // retorna endereco do item no vetor
			}
		}		
		return -1;
	}
	
	public int BuscaProdutoID(int bid) {
		
		//procura produto por id
		
		int i;
		for(i=0;i<Vetprodutos.size();i++) {		
			if(Vetprodutos.get(i).getId()==bid) {			
				return i; // retorna endereco do item no vetor
			}
		}		
		return -1;
	}
	
	public int BuscaProdutoSku(String bsku) {
		//procura produto por nome
			
		int i;
		for(i=0;i<Vetprodutos.size();i++) {		
			if(bsku.equals(Vetprodutos.get(i).getSku())) {			
				return i; // retorna endereco do item no vetor
			}
		}			
		return -1;
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
	
	public Produto getProdutoEstoque(int ind) {
		
		return (Produto) Vetprodutos.get(ind);
	}
	
	public String stringHeaderEstoque() {
		
		String h = new String();
		h=h+String.valueOf(this.getNomeEstoque())+","+String.valueOf(this.getCategoriaEstoque())+","+String.valueOf(this.getQtdEstoque());
		
		return h;
	}

	public  Produtos(){
		
	}
	
	
	public  Produtos(String estoque, String categoria) {
		 
		nomeEstoque=estoque;
		categoriaEstoque=categoria;
		
	}
	public void ExibeProduto(int res) {
			
			Produto bprod= Vetprodutos.get(res);
			
			int i;
			System.out.println("\t --- Exibindo Produto -----:\n");
			
			for(i=0;i<9;i++) {				
				System.out.printf("\tId: %d \n\tNome: %s \n\tCodigo de Barras: %s \n\tCodigo Sku: %s \n\tCodigo Descricao: %s \n\tCodigo Categoria: %s \n\tPreco: %.3f \n\tPeso: %.3f \n\tFabricante: %s\n ------ \n",bprod.getId(),bprod.getNome(),bprod.getCodBarras(),bprod.getSku(),bprod.getDescricao(),bprod.getCategoria(),bprod.getPreco(),bprod.getPeso(),bprod.getFabricante());
			}
			
		}
	
	public void ExibeEstoque() {
		
		
		int i ;
		int qtdprod=getQtdEstoque();
		System.out.println("\t --- Exibindo Estoque -----:\n");
		System.out.printf("\t --- Nome: %s -- Categoria: %s -- Quantidade de Itens: %d ---:\n",getNomeEstoque(),getCategoriaEstoque(),getQtdEstoque());
		for(i=0;i<qtdprod;i++) {		
			Produto prod= Vetprodutos.get(i);
			System.out.printf("Produto: ID Estq: %d ->\n %d - %s - %s - %s - %s - %s - %.3f - %.3f - %s\n",i+1,prod.getId(),prod.getCodBarras(),prod.getSku(),prod.getNome(),prod.getDescricao(),prod.getCategoria(),prod.getPreco(),prod.getPeso(),prod.getFabricante());
		}
		
		System.out.printf("\n");
	}
	public int ExcluiProduto(int ind){
		
		if(Vetprodutos.remove(Vetprodutos.get(ind))) {					
			return 1;
		}		
		return -1;
	}
	
	public int AlteraProduto(int ind,int opcao, Scanner sc) {
		
		Produto prod = Vetprodutos.get(ind);
		
		if (opcao==1) { // ID
			
			 System.out.printf("Digite o novo ID\n");
			 int ID = sc.nextInt();
		     sc.nextLine();
		     
		     prod.setId(ID);	     
		     return 1;
		}
		else if (opcao ==2) { // Nome
			System.out.printf("Digite o novo NOME\n");
			String nome = sc.next();
			
		    sc.nextLine();
		    prod.setNome(nome);	    
			
			return 1;
		}
		else if (opcao==3) { // Cod Barras
			
			System.out.printf("Digite o novo Codigo de Barras\n");
			String codbarras = sc.next();
		    sc.nextLine();
		    prod.setCodBarras(codbarras);	
			return 1;
		}
		else if (opcao ==4) { // Sku
			System.out.printf("Digite o novo SKU\n");
			String sku = sc.next();
		    sc.nextLine();
		    prod.setSku(sku);	
			return 1;
			
		}
		else if (opcao ==5) { // Descricao
			
			System.out.printf("Digite a nova Descricao\n");
			String desc = sc.next();
		    sc.nextLine();
		    prod.setDescricao(desc);	
			
			return 1;
		}
		else if (opcao==6) { // Categoria
			System.out.printf("Digite a nova Categoria\n");
			String cat = sc.next();
		    sc.nextLine();
		    prod.setCategoria(cat);	
			
			return 1;
		}
		else if (opcao ==7) { // Preco
			System.out.printf("Digite o novo Preco\n");
			Double preco = sc.nextDouble();
		    sc.nextLine();
		    prod.setPreco(preco);	
			return 1;			
			
		} 
		else if (opcao==8) { // Peso
			System.out.printf("Digite o novo Peso\n");
			Double peso = sc.nextDouble();
		    sc.nextLine();
		    prod.setPeso(peso);	
			return 1;			
		}
		else if (opcao ==9) { // Fabricante 
			System.out.printf("Digite o novo Fabricante\n");
			String fab = sc.next();
		    sc.nextLine();
		    prod.setFabricante(fab);	
			return 1;					
		}
		else {
			System.out.println("\t-- Opcao nao encontrada:\n");
			return 0;	
		}
		
	}	
	
}
