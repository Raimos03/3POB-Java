package pacote;

public class Produto {
	
	private int id;
	private String CodBarras;
	private String Sku;
	private String nome;
	private String descricao;
	private String categoria;
	private double preco;
	private double peso;
	private String fabricante;
	 
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodBarras() {
		return CodBarras;
	}

	public void setCodBarras(String codBarras) {
		CodBarras = codBarras;
	}

	public String getSku() {
		return Sku;
	}

	public void setSku(String sku) {
		Sku = sku;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getFabricante() {
		return fabricante;
	}
 
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	
	public String stringProduto() {
		
		String s= new String();
		s=s+String.valueOf(this.getId())+","+String.valueOf(this.getNome())+","+String.valueOf(this.getCodBarras())+","+String.valueOf(this.getSku())+","+String.valueOf(this.getDescricao())+","+String.valueOf(this.getCategoria())+","+String.valueOf(this.getPreco())+","+String.valueOf(this.getPeso())+","+String.valueOf(this.getFabricante());
		
		return s;
	}
	
	public Produto(){
	}
	
	public Produto(int id, String codbarras,String sku, String nome,String descricao, String categoria, Double preco, Double peso, String fabricante){
	
		this.id=id;
		this.CodBarras=codbarras;
		this.Sku=sku;
		this.nome=nome;
		this.descricao=descricao;
		this.categoria=categoria;
		this.preco=preco;
		this.peso=peso;
		this.fabricante=fabricante;
		
	}
}
