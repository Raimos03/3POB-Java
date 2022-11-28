package pacote;

public class Selecao implements ISelecao {
	
	private String nome;
	private String nomeTecnico;
	private char grupo;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomeTecnico() {
		return nomeTecnico;
	}
	public void setNomeTecnico(String nomeTecnico) {
		this.nomeTecnico = nomeTecnico;
	}
	public char getGrupo() {
		return grupo;
	}
	public void setGrupo(char grupo) {
		this.grupo = grupo;
	}
	
	public Selecao(String nome, String nomeTecnico, char grupo) {	
		this.nome=nome;
		this.nomeTecnico=nomeTecnico;
		this.grupo=grupo;
	}
	public Selecao() {
		
	}
	
	public String exibeSelecao() {
					
		return String.valueOf("Nome: "+this.getNome()+"\nTecnico: "+String.valueOf(this.getNomeTecnico()+"\nGrupo: "+String.valueOf(this.getGrupo()+"\n")));
	}
	
	
}
