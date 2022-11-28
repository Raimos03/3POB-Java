package pacote;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public interface IConfronto {

	
	public Selecao getSelecao1();
	public void setSelecao1(Selecao selecao1);
	public void setSelecao2(Selecao selecao2);
	public Selecao getSelecao2();
	public int getGolsSelecao1();
	public void setGolsSelecao1(int gols);
	public int getGolsSelecao2();
	
	public void setGolsSelecao2(int gols);
	public String getPlacar();
	public void setPlacar(String splacar);
	
	public String getLocal();
	public void setLocal(String local) ;
	public Calendar getDataHora_Calendar();
	public void setDataHora_Calendar(Calendar dataHora);
	public void setData(String sdata);
	public String getData();
	public void setHora(String shora);
	public String getHora();
	public String get_Data_Hora();
	public int validaData(String s);
	public int validaHora(String s);
	public int inputDataHora(Scanner sc);
	public int buscaSelecaoNomeGrupo(String s, ArrayList <Selecao> vselecoes);
	public int preencheConfronto(String vestadio[], ArrayList <Selecao> grupo, int ordem) ;
	public int getDiaConfronto();
	public int mesmaDataDia(Calendar cal);
	public void exibeConfronto();
}
