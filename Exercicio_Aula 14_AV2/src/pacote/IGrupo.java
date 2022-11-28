package pacote;

import java.util.ArrayList;

public interface IGrupo {
	
	
	public char getNomeGrupo();
	public void setNomeGrupo(char nomeGrupo);
	public ArrayList<Selecao> getvSelecoesGrupo();
	public void setvSelecoesGrupo(ArrayList<Selecao> vGrupo);
	public void exibeGrupo();
	public Confronto setConfrontoCompleto(String data, String hora, Selecao selecao1, Selecao selecao2, String local, String placar);
	public Confronto getCft1();
	public void setCft1(Confronto cft1);
	public Confronto getCft2();
	public void setCft2(Confronto cft2) ;
	public Confronto getCft3();
	public void setCft3(Confronto cft3);
	public Confronto getCft4();
	public void setCft4(Confronto cft4);
	public Confronto getCft5();
	public void setCft5(Confronto cft5);
	public Confronto getCft6();
	public void setCft6(Confronto cft6);
	
	public int buscaSelecaoNomeGrupo(String s, ArrayList <Selecao> vselecoes);
	public int preencheConfrontosGrupo(String vEstadios[]) ;
	public int buscaGrupo(String input,ArrayList <Grupo> vg);
	public void exibeConfrontosGrupo();
}
