package pacote;

import java.util.ArrayList;
import java.util.Scanner;

public class Grupo implements IGrupo{
	
	private char nomeGrupo;
	private ArrayList<Selecao> vSelecoesGrupo = new ArrayList<>(); //vetor de selecoes
	
	private Confronto cft1;
	private Confronto cft2;
	private Confronto cft3;
	private Confronto cft4;
	private Confronto cft5;
	private Confronto cft6;
	
	
	public char getNomeGrupo() {
		return nomeGrupo;
	}
	public void setNomeGrupo(char nomeGrupo) {
		this.nomeGrupo = nomeGrupo;
	}
	public ArrayList<Selecao> getvSelecoesGrupo() {
		return vSelecoesGrupo;
	}
	public void setvSelecoesGrupo(ArrayList<Selecao> vGrupo) {
		this.vSelecoesGrupo = vGrupo;
	}
	
	
	public Grupo() {
		
	}
	public Grupo(char nomegrupo, Selecao a,Selecao b, Selecao c, Selecao d) {
		
		this.nomeGrupo=nomegrupo;
		vSelecoesGrupo.add(a);
		vSelecoesGrupo.add(b);
		vSelecoesGrupo.add(c);
		vSelecoesGrupo.add(d);
	}
	
	public void exibeGrupo() {
		
		int i=0;
		System.out.println("-- Grupo "+ this.nomeGrupo +" --\n");
		
		if (vSelecoesGrupo.size()==0) {
			
			System.out.println(" - - Grupo Vazio - -");
		}
		else {
			
			
			for(i=0;i<vSelecoesGrupo.size();i++) {
				Selecao temp= vSelecoesGrupo.get(i);
				System.out.printf("\t %s \n",temp.getNome());
			}
			
			System.out.printf("\n");
		}
		
	}
	
	
	// Getters e Setters dos confrontos
	
	public Confronto setConfrontoCompleto(String data, String hora, Selecao selecao1, Selecao selecao2, String local, String placar) {
		
		Confronto newcft= new Confronto( data, hora, selecao1,  selecao2,  local,  placar);
		return newcft;
	}
	
	public Confronto getCft1() {
		return cft1;
	}
	public void setCft1(Confronto cft1) {
		
		this.cft1 = cft1;
	}
	public Confronto getCft2() {
		return cft2;
	}
	public void setCft2(Confronto cft2) {
		this.cft2 = cft2;
	}
	public Confronto getCft3() {
		return cft3;
	}
	public void setCft3(Confronto cft3) {
		this.cft3 = cft3;
	}
	public Confronto getCft4() {
		return cft4;
	}
	public void setCft4(Confronto cft4) {
		this.cft4 = cft4;
	}
	public Confronto getCft5() {
		return cft5;
	}
	public void setCft5(Confronto cft5) {
		this.cft5 = cft5;
	}
	public Confronto getCft6() {
		return cft6;
	}
	public void setCft6(Confronto cft6) {
		this.cft6 = cft6;
	}
	
	
	public int buscaSelecaoNomeGrupo(String s, ArrayList <Selecao> vselecoes) {
			
			for(int i=0;i<vselecoes.size();i++) {
				
				if (s.compareTo(vselecoes.get(i).getNome())==0) {
					return i;
				}			
			}
			
			return -1;
		}
	
	public int preencheConfrontosGrupo(String vEstadios[]) { // Preenche manualmente os confrontos
			
		int contPreenchidos=0;
		
		this.cft1 = new Confronto();
		this.cft2 = new Confronto();
		this.cft3 = new Confronto();
		this.cft4 = new Confronto();
		this.cft5 = new Confronto();
		this.cft6 = new Confronto();
		
		
		
		if(this.cft1.preencheConfronto(vEstadios, this.getvSelecoesGrupo(),1)==1) {
			//System.out.println(this.cft1.get_Data_Hora());
			cft1.exibeConfronto();
			contPreenchidos++;
		};
		if (this.cft2.preencheConfronto(vEstadios,this.getvSelecoesGrupo(),2)==1) {
			System.out.println(this.cft2.get_Data_Hora());
			cft2.exibeConfronto();
			contPreenchidos++;
		};	
		
		if(this.cft3.preencheConfronto(vEstadios,this.getvSelecoesGrupo(),3)==1) {
			contPreenchidos++;
		};
		if(this.cft4.preencheConfronto(vEstadios,this.getvSelecoesGrupo(),4)==1) {
			contPreenchidos++;
		};
		if(this.cft5.preencheConfronto(vEstadios,this.getvSelecoesGrupo(),5)==1) {
			contPreenchidos++;
		};
		if(this.cft6.preencheConfronto(vEstadios,this.getvSelecoesGrupo(),6)==1) {
			contPreenchidos++;
		};	
		
		if(contPreenchidos==6) { // todos foram preenchidos e confirmados
			return 1;
		}
		
		return 0;
	}
	
	public int buscaGrupo(String input,ArrayList <Grupo> vg) {
		
		int i=0;
		for (i=0;i<vg.size();i++) {
			
			Grupo gtemp=vg.get(i);
			
			if( gtemp.getNomeGrupo() == input.charAt(0)) {
				
				return i;
			}
		}
		
		return -1;
	}
	
	public void exibeConfrontosGrupo() {
		
		System.out.printf("\t --- Confrontos do grupo - %c --- \n\n",this.getNomeGrupo());
		
		this.cft1.exibeConfronto();
		this.cft2.exibeConfronto();
		this.cft3.exibeConfronto();
		this.cft4.exibeConfronto();
		this.cft5.exibeConfronto();
		this.cft6.exibeConfronto();
		
	}
		
}
