package pacote;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Calendar;
import java.util.InputMismatchException;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;


public class Main {
	
	public static Grupo buscaSelecaoGrupo (ArrayList <Grupo> vGrupos, String inputNSelecao) {
				
		for (Grupo g :vGrupos) { // achei o grupo que no qual pertence a selecao
					
					if (g.buscaSelecaoNomeGrupo(inputNSelecao, g.getvSelecoesGrupo())!= -1) {				
						return g;
					}
		}
		
		return null;
	}
	
	public static int preencheGrupo(ArrayList <Grupo> vGrupos ,String vEstadios[]) {
		
		int confirmacao=0;
		
		System.out.println("\t --- PREENCHENDO GRUPOS ---\n");
		
		for (int i=0;i<vGrupos.size();i++) {
			
			Grupo tempGrupo= vGrupos.get(i);		
			System.out.printf("\t <-- Grupo %c --> \n\n",tempGrupo.getNomeGrupo());	
			confirmacao+=tempGrupo.preencheConfrontosGrupo(vEstadios);														
		}
				
		if(confirmacao !=8) { // confirmando a insercao de todos os grupos sem erro
			
			System.out.println("\t --- Erro no preenchimento dos GRUPOS ---\n");
			return 0;
		}
		
		return 1;
	}
	
	public static void ExibeCalendarioJogos(ArrayList <Grupo> vGrupos) {
		// Exibe em ordem os jogos
		
		Calendar corrente = vGrupos.get(0).getCft1().getDataHora_Calendar(); // corrente e a primeira ocorrencia
		int ultimoIndice =vGrupos.size()-1;
		int ultimoConfronto=  vGrupos.get(ultimoIndice).getCft6().getDataHora_Calendar().getTime().getDate();
		
		int diaCorrente; // pega o dia
		
		//add(Calendar.DAY_OF_MOUTH,+1)
		
		//System.out.println(((Object)vGrupos.get(0).getCft1().getDataHora_Calendar().DAY_OF_MONTH).getClass().getSimpleName());
		
		
		for(int i=0;i<vGrupos.size();i++) { // Exibe em ordem os jogos por data
			
			Grupo g=vGrupos.get(i);
			diaCorrente=corrente.getTime().getDate(); 
			
			if (diaCorrente==g.getCft1().getDiaConfronto()) {			
				g.getCft1().exibeConfronto();
			}			
			if (diaCorrente==g.getCft2().getDiaConfronto()) {						
							g.getCft2().exibeConfronto();
			}		
			if (diaCorrente==g.getCft3().getDiaConfronto()) {			
				g.getCft3().exibeConfronto();
			}
			if (diaCorrente==g.getCft4().getDiaConfronto()) {						
							g.getCft4().exibeConfronto();
			}
			if (diaCorrente==g.getCft5().getDiaConfronto()) {			
				g.getCft5().exibeConfronto();
			}
			if (diaCorrente==g.getCft6().getDiaConfronto()) {			
				g.getCft6().exibeConfronto();
			}

			// condicao de parada do for
			
			if (i==ultimoIndice) {			
				i=0;
				corrente.add(Calendar.DAY_OF_MONTH, +1);
			}
			
			if (diaCorrente == ultimoConfronto) {				
				break;
			}
					
		}
		
		
	}
	
	public static void ExibeCalendarioSelecao(ArrayList <Grupo> vGrupos, String inputSelecao) {
		
		Grupo grupoSelecao=null;
		grupoSelecao = buscaSelecaoGrupo(vGrupos,inputSelecao);
		
		if (grupoSelecao==null) {
			System.out.println("\t *** A selecao nao esta em algum grupo. *** \nConfira a digitacao e tente novamente\n");
			return;
		}
		else { // existindo a selecao
			
			
			if((grupoSelecao.getCft1().getSelecao1().getNome().compareTo(inputSelecao)==0) || (grupoSelecao.getCft1().getSelecao2().getNome().compareTo(inputSelecao)==0)) {
				
				grupoSelecao.getCft1().exibeConfronto();
			}
			
			if ((grupoSelecao.getCft2().getSelecao1().getNome().compareTo(inputSelecao)==0) || (grupoSelecao.getCft2().getSelecao2().getNome().compareTo(inputSelecao)==0)) {
							
				grupoSelecao.getCft2().exibeConfronto();
			}
			
			if ((grupoSelecao.getCft3().getSelecao1().getNome().compareTo(inputSelecao)==0) || (grupoSelecao.getCft3().getSelecao2().getNome().compareTo(inputSelecao)==0)) {
				
				grupoSelecao.getCft3().exibeConfronto();
			}
			
			if ((grupoSelecao.getCft4().getSelecao1().getNome().compareTo(inputSelecao)==0) || (grupoSelecao.getCft4().getSelecao2().getNome().compareTo(inputSelecao)==0)) {
				
				grupoSelecao.getCft4().exibeConfronto();
			}
			
			if ((grupoSelecao.getCft5().getSelecao1().getNome().compareTo(inputSelecao)==0) || (grupoSelecao.getCft5().getSelecao2().getNome().compareTo(inputSelecao)==0)) {
							
				grupoSelecao.getCft5().exibeConfronto();
			}
			
			else {
				
				grupoSelecao.getCft6().exibeConfronto();
			}
		}
		
		
	}

	public static Grupo BuscaGrupoInput(ArrayList <Grupo> vGrupos, String inputGrupo) {
		
	
		Grupo gTemp = new Grupo();
		int busca =gTemp.buscaGrupo(inputGrupo,vGrupos);
		
		if(busca!=-1) {

			// Busca por grupo mencontra grupo 
			
			gTemp=vGrupos.get(busca);
			return gTemp;
			    			
		}
		else {
			
			System.out.println("-- Grupo nao encontrado. Digite novamente. --");
			
		}
    		    	            			
	
		return null;
		
	}
	
	public static void ExibeConfrontoSelecoes(String nselecao1, String nselecao2, ArrayList <Grupo> vGrupos){
		
			
		Grupo grupoSelecao1=null;
		Grupo grupoSelecao2=null;
		
		grupoSelecao1 = buscaSelecaoGrupo(vGrupos, nselecao1);
		
		
		if (grupoSelecao1==null) { // procuro no segundo caso 1 seja null
			
			grupoSelecao2 = buscaSelecaoGrupo(vGrupos, nselecao2);
		}
	
		
		if (grupoSelecao1==null && grupoSelecao2==null) {
			System.out.println("\t *** As selecoes nao estao em algum grupo. *** \nConfira a digitacao e tente novamente\n");
			return;
		}
		else { // existindo as selecoes ou pelo menos uma
			
			if (grupoSelecao1==null) {
				grupoSelecao1= grupoSelecao2;
			}
			
				
			// verificando confrontos. Tenho um grupo
			
				
			if((grupoSelecao1.getCft1().getSelecao1().getNome().compareTo(nselecao1)==0) && (grupoSelecao1.getCft1().getSelecao2().getNome().compareTo(nselecao2)==0)){
				
				grupoSelecao1.getCft1().exibeConfronto();
			}
			
			else if ((grupoSelecao1.getCft1().getSelecao1().getNome().compareTo(nselecao2)==0) && (grupoSelecao1.getCft1().getSelecao2().getNome().compareTo(nselecao1)==0)){
				
				grupoSelecao1.getCft1().exibeConfronto();
			}
					
				
			else if((grupoSelecao1.getCft2().getSelecao1().getNome().compareTo(nselecao1)==0) && (grupoSelecao1.getCft2().getSelecao2().getNome().compareTo(nselecao2)==0)){
				
				grupoSelecao1.getCft2().exibeConfronto();
			}
			
			else if((grupoSelecao1.getCft2().getSelecao1().getNome().compareTo(nselecao2)==0) && (grupoSelecao1.getCft2().getSelecao2().getNome().compareTo(nselecao1)==0)){
				
				grupoSelecao1.getCft2().exibeConfronto();
			}
		
								
			else if((grupoSelecao1.getCft3().getSelecao1().getNome().compareTo(nselecao1)==0) && (grupoSelecao1.getCft3().getSelecao2().getNome().compareTo(nselecao2)==0)){
				
				grupoSelecao1.getCft3().exibeConfronto();
			}
			
			else if((grupoSelecao1.getCft3().getSelecao1().getNome().compareTo(nselecao2)==0) && (grupoSelecao1.getCft3().getSelecao2().getNome().compareTo(nselecao1)==0)){
				
				grupoSelecao1.getCft3().exibeConfronto();
			}
						
			
			else if((grupoSelecao1.getCft4().getSelecao1().getNome().compareTo(nselecao1)==0) && (grupoSelecao1.getCft4().getSelecao2().getNome().compareTo(nselecao2)==0)){
				
				grupoSelecao1.getCft4().exibeConfronto();
			}
			
			else if((grupoSelecao1.getCft4().getSelecao1().getNome().compareTo(nselecao2)==0) && (grupoSelecao1.getCft4().getSelecao2().getNome().compareTo(nselecao1)==0)){
				
				grupoSelecao1.getCft4().exibeConfronto();
			}
			
			
			else if((grupoSelecao1.getCft5().getSelecao1().getNome().compareTo(nselecao1)==0) && (grupoSelecao1.getCft5().getSelecao2().getNome().compareTo(nselecao2)==0)){
				
				grupoSelecao1.getCft5().exibeConfronto();
			}
			
			else if((grupoSelecao1.getCft5().getSelecao1().getNome().compareTo(nselecao2)==0) && (grupoSelecao1.getCft5().getSelecao2().getNome().compareTo(nselecao1)==0)){
				
				grupoSelecao1.getCft5().exibeConfronto();
			}

								
			else if((grupoSelecao1.getCft6().getSelecao1().getNome().compareTo(nselecao1)==0) && (grupoSelecao1.getCft6().getSelecao2().getNome().compareTo(nselecao2)==0)){
				
				grupoSelecao1.getCft6().exibeConfronto();
			}
			
			else if((grupoSelecao1.getCft6().getSelecao1().getNome().compareTo(nselecao2)==0) && (grupoSelecao1.getCft6().getSelecao2().getNome().compareTo(nselecao1)==0)){
				
				grupoSelecao1.getCft6().exibeConfronto();
			}
					
			
			else {
				
				System.out.println("\t *** O CONFRONTO NAO EXISTE *** ");
				
				}
		}
	
			return ;
		}
	
	public static void ExibeConfrontoSelecaoData(String nselecao1, String inputdata, ArrayList <Grupo> vGrupos) {
		
		Grupo grupoSelecao1=null;	
		grupoSelecao1 = buscaSelecaoGrupo(vGrupos, nselecao1); // encontro o grupo da selecao
		int conf=0;
		
		if (grupoSelecao1==null) {
			System.out.println("\t *** A selecao nao esta em algum grupo.***\n\t *** Confira a digitacao e tente novamente ***\n");
			return;
		}
		
		else { // existindo a selecao
		// verificando confrontos. Tenho um grupo
//			System.out.println(grupoSelecao1.getCft6().getData());
//			System.out.println(grupoSelecao1.getCft6().getDataHora_Calendar().DAY_OF_MONTH);
//			System.out.println(grupoSelecao1.getCft6().getDataHora_Calendar().MONTH);
			
			if(grupoSelecao1.getCft1().getData().compareTo(inputdata)==0){
				
				if ((grupoSelecao1.getCft1().getSelecao1().getNome().compareTo(nselecao1)==0) || (grupoSelecao1.getCft1().getSelecao2().getNome().compareTo(nselecao1)==0)) {
					
					grupoSelecao1.getCft1().exibeConfronto();
					conf++;
				}
			}
			
			if(grupoSelecao1.getCft2().getData().compareTo(inputdata)==0){		
				
				if ((grupoSelecao1.getCft2().getSelecao1().getNome().compareTo(nselecao1)==0) || (grupoSelecao1.getCft2().getSelecao2().getNome().compareTo(nselecao1)==0)) {
									
					grupoSelecao1.getCft2().exibeConfronto();
					conf++;
				}
			}
			//else if((grupoSelecao1.getCft3().getSelecao1().getNome().compareTo(nselecao1)==0) && (grupoSelecao1.getCft3().getSelecao2().getNome().compareTo(nselecao1)==0))
							
			if(grupoSelecao1.getCft3().getData().compareTo(inputdata)==0){			
				if ((grupoSelecao1.getCft3().getSelecao1().getNome().compareTo(nselecao1)==0) || (grupoSelecao1.getCft3().getSelecao2().getNome().compareTo(nselecao1)==0)) {
									
					grupoSelecao1.getCft3().exibeConfronto();
					conf++;
				}
			}
	
			if(grupoSelecao1.getCft4().getData().compareTo(inputdata)==0){			
				if ((grupoSelecao1.getCft4().getSelecao1().getNome().compareTo(nselecao1)==0) || (grupoSelecao1.getCft4().getSelecao2().getNome().compareTo(nselecao1)==0)) {
					
					grupoSelecao1.getCft4().exibeConfronto();
					conf++;
				}
			}
				
			if(grupoSelecao1.getCft5().getData().compareTo(inputdata)==0){	
				if ((grupoSelecao1.getCft5().getSelecao1().getNome().compareTo(nselecao1)==0) || (grupoSelecao1.getCft5().getSelecao2().getNome().compareTo(nselecao1)==0)) {
					
					grupoSelecao1.getCft5().exibeConfronto();
					conf++;
				}	
			}
											
			if(grupoSelecao1.getCft6().getData().compareTo(inputdata)==0){		
				if ((grupoSelecao1.getCft6().getSelecao1().getNome().compareTo(nselecao1)==0) || (grupoSelecao1.getCft6().getSelecao2().getNome().compareTo(nselecao1)==0)) {
					
					grupoSelecao1.getCft6().exibeConfronto();
					conf++;
				}
			}
								
			if (conf==0) {
				
				System.out.println("\t *** O CONFRONTO NAO EXISTE. Confira a data e o nome da selecao. ***\n");
				
				}
		}
	
		return ;
		
	}
	
	public static void main(String[] args) {

//		Confronto c1 = new Confronto();
//		
//		c1.setData("23/11/2022");
//		c1.setHora("07");
//		
//		System.out.println(c1.getData());
//		System.out.println(c1.getHora());
//		
//		System.out.println(c1.get_Data_Hora());
//		System.out.println(c1.getDataHora_Calendar());
		
		//ArrayList<String> vEstadios = new ArrayList<>();
		
		String vEstadios[] = {"Estadio Al Bayt","Estadio Al Thumama","Estadio Internacional Khalifa","Estadio Ahmad bin Ali","Estadio Nacional de Lusail","Estadio 974","Estadio Cidade da Educacao","Estadio Nacional de Lusail","Estadio Al Janoub"};
		// criei este vetor para preencher manualmente os estadios caso precise
		
		
		Selecao equador= new Selecao("Equador","Gustavo Julio Alfaro",'A'); // Equador
		Selecao catar= new Selecao("Catar","Felix Sanchez Bas",'A'); // Catar
		Selecao senegal= new Selecao("Senegal","Aliou Cisse",'A'); // Senegal
		Selecao holanda= new Selecao("Holanda","Louis van Gaal",'A'); // Holanda
		
		Selecao inglaterra= new Selecao("Inglaterra","Gareth Southgate",'B'); // Inglaterra
		Selecao ira= new Selecao("Ira","Carlos Queiroz",'B'); // Ira
		Selecao estadosUnidos= new Selecao("Estados Unidos","Gregg Berhalter",'B'); // Estados Unidos
		Selecao paisDeGales= new Selecao("Pais de Gales","Rob Page",'B'); // Pais de Gales
		
		Selecao argentina= new Selecao("Argentina","Lionel Scaloni",'C'); // Argentina
		Selecao arabiaSaudita= new Selecao("Arabia Saudita","Herve Renard",'C'); // Arabia Saudita
		Selecao mexico= new Selecao("Mexico","Gerardo Martino",'C'); // Mexico
		Selecao polonia= new Selecao("Polonia","Czesław Michniewicz",'C'); // Polonia
		
		
		Selecao franca= new Selecao("Franca","Didier Deschamps",'D'); // Franca
		Selecao australia= new Selecao("Australia","Graham Arnold",'D'); // Australia
		Selecao dinamarca= new Selecao("Dinamarca","Kasper Hjulmand",'D'); // Dinamarca
		Selecao tunisia= new Selecao("Tunisia","Jalel Kadri",'D'); // Tunisia
		
		
		Selecao espanha= new Selecao("Espanha","Luis Enrique",'E'); // Espanha
		Selecao costaRica= new Selecao("Costa Rica","Luis Fernando Suárez",'E'); // Costa Rica
		Selecao alemanha= new Selecao("Alemanha","Hans-Dieter Flick",'E'); // Alemanha
		Selecao japao= new Selecao("Japao","Hajime Moriyasu",'E'); // Japao
		
		
		Selecao belgica= new Selecao("Belgica","Roberto Martínez",'F'); // Belgica
		Selecao canada= new Selecao("Canada","John Herdman",'F'); // Canada
		Selecao marrocos= new Selecao("Marrocos","Walid Regragui",'F'); // Marrocos
		Selecao croacia= new Selecao("Croacia","Zlatko Dalić",'F'); // Croacia
		
	
		Selecao brasil= new Selecao("Brasil","Titi",'G'); // Brasil
		Selecao servia= new Selecao("Servia","Dragan Stojković",'G'); // Servia
		Selecao suica= new Selecao("Suica","Murat Yakın",'G'); // Suica
		Selecao camaroes= new Selecao("Camaroes","Rigobert Song",'G'); // Camaroes
		
		
		Selecao portugal= new Selecao("Portugal","Fernando Santos",'F'); // Portugal
		Selecao gana= new Selecao("Gana","Otto Addo",'F'); // Gana
		Selecao uruguai= new Selecao("Uruguai","Diego Alonso",'F'); // Uruguai
		Selecao coreiaDoSul= new Selecao("Coreia Do Sul","Paulo Jorge Gomes Bento",'F'); // Coreia do Sul
			
		//System.out.println(brasil.exibeSelecao());
					
		Grupo a= new Grupo('A',catar,equador,senegal,holanda);		
		Grupo b= new Grupo('B',inglaterra,ira,estadosUnidos,paisDeGales);
		Grupo c= new Grupo('C',argentina,arabiaSaudita,mexico,polonia);
		Grupo d= new Grupo('D',franca,australia,dinamarca,tunisia);
		Grupo e= new Grupo('E',espanha,costaRica,alemanha,japao);
		Grupo f= new Grupo('F',belgica,canada,marrocos,croacia);
		Grupo g= new Grupo('G',brasil,servia,suica,camaroes);
		Grupo h = new Grupo('H',portugal,gana,uruguai,coreiaDoSul);
		
		ArrayList <Grupo> vGrupos = new ArrayList<Grupo>();
		vGrupos.add(a);vGrupos.add(b);vGrupos.add(c);vGrupos.add(d);vGrupos.add(e);vGrupos.add(f);vGrupos.add(g);vGrupos.add(h);
		
		
		//preencheGrupo(vGrupos,vEstadios); // Funcao para preencher manualmente os jogos e confrontos de cada grupo
		
		a.setCft1(a.setConfrontoCompleto("20/11","13",catar,equador,"Estadio Al Bayt","0 x 2"));
		a.setCft2(a.setConfrontoCompleto("21/11","13",senegal,holanda,"Estadio Al Thumama","0 x 2"));
		a.setCft3(a.setConfrontoCompleto("25/11","10",catar,senegal,"Estadio Al Thumama","1 x 3"));
		a.setCft4(a.setConfrontoCompleto("25/11","13",holanda,equador,"Estadio Internacional Khalifa","1 x 1"));
		a.setCft5(a.setConfrontoCompleto("29/11","12",holanda,catar,"Estadio Al Bayt",""));
		a.setCft6(a.setConfrontoCompleto("29/11","12",equador,senegal,"Estadio Internacional Khalifa",""));
		
		b.setCft1(b.setConfrontoCompleto("21/11","10",inglaterra,ira,"Estadio Internacional Khalifa","6 x 2"));
		b.setCft2(b.setConfrontoCompleto("21/11","16",estadosUnidos,paisDeGales,"Estadio Ahmad bin Ali","1 x 1"));
		b.setCft3(b.setConfrontoCompleto("25/11","07",paisDeGales,ira,"Estadio Al Thumama","0 x 2"));
		b.setCft4(b.setConfrontoCompleto("25/11","16",inglaterra,estadosUnidos,"Estadio Al Bayt","0 x 0"));
		b.setCft5(b.setConfrontoCompleto("29/11","16",paisDeGales,inglaterra,"Estadio Ahmad bin Ali",""));
		b.setCft6(b.setConfrontoCompleto("29/11","16",ira,estadosUnidos,"Estadio Al Thumama",""));
		
		c.setCft1(c.setConfrontoCompleto("22/11","7",argentina,arabiaSaudita,"Estadio Nacional de Lusail","1 x 2"));
		c.setCft2(c.setConfrontoCompleto("22/11","13",mexico,polonia,"Estadio 974","0 x 0"));
		c.setCft3(c.setConfrontoCompleto("26/11","10",polonia,arabiaSaudita,"Estadio Cidade da Educacao","2 x 0"));
		c.setCft4(c.setConfrontoCompleto("26/11","16",argentina,mexico,"Estadio Nacional de Lusail","2 x 0"));
		c.setCft5(c.setConfrontoCompleto("30/11","16",arabiaSaudita,mexico,"Estadio Nacional de Lusail",""));
		c.setCft6(c.setConfrontoCompleto("30/11","16",polonia,argentina,"Estadio 974",""));
		
		d.setCft1(d.setConfrontoCompleto("22/11","10",dinamarca,tunisia,"Estadio Cidade da Educacao","0 x 0"));
		d.setCft2(d.setConfrontoCompleto("22/11","16",franca,australia,"Estadio Al Janoub","4 x 1"));
		d.setCft3(d.setConfrontoCompleto("26/11","07",tunisia,australia,"Estadio Al Janoub","0 x 1"));
		d.setCft4(d.setConfrontoCompleto("26/11","13",franca,dinamarca,"Estadio 974","2 x 1"));
		d.setCft5(d.setConfrontoCompleto("30/11","12",tunisia,franca,"Estadio Cidade da Educacao",""));
		d.setCft6(d.setConfrontoCompleto("30/11","12",australia,dinamarca,"Estadio Al Janoub",""));
		
		e.setCft1(e.setConfrontoCompleto("23/11","10",alemanha,japao,"Estadio Internacional Khalifa","1 x 2"));
		e.setCft2(e.setConfrontoCompleto("23/11","13",espanha, costaRica,"Estadio Al Thumama","7 x 0"));
		e.setCft3(e.setConfrontoCompleto("27/11","07",japao,costaRica,"Estadio Ahmad bin Ali","0 x 1"));
		e.setCft4(e.setConfrontoCompleto("27/11","16",espanha,alemanha,"Estadio Al Bayt","1 x 1"));
		e.setCft5(e.setConfrontoCompleto("01/12","16",japao,espanha,"Estadio Internacional Khalifa",""));
		e.setCft6(e.setConfrontoCompleto("01/12","16",costaRica,alemanha,"Estadio Al Bayt",""));
		
		
		f.setCft1(f.setConfrontoCompleto("23/11","7",marrocos,croacia,"Estadio Al Bayt","0 x 0"));
		f.setCft2(f.setConfrontoCompleto("23/11","16",belgica, canada,"Estadio Ahmad bin Ali","1 x 0"));
		f.setCft3(f.setConfrontoCompleto("27/11","10",belgica,marrocos,"Estadio Al Thumama","0 x 2"));
		f.setCft4(f.setConfrontoCompleto("27/11","13",croacia,canada,"Estadio Internacional Khalifa","4 x 1"));
		f.setCft5(f.setConfrontoCompleto("01/12","12",croacia,belgica,"Estadio Ahmad bin Ali",""));
		f.setCft6(f.setConfrontoCompleto("01/12","12",canada,marrocos,"Estadio Al Thumama",""));
		
			
		g.setCft1(g.setConfrontoCompleto("24/11","7",suica,camaroes,"Estadio Al Janoub","1 x 0"));
		g.setCft2(g.setConfrontoCompleto("24/11","16",brasil, servia,"Estadio Nacional de Lusail","2 x 0"));
		g.setCft3(g.setConfrontoCompleto("28/11","7",camaroes,servia,"Estadio Al Janoub",""));
		g.setCft4(g.setConfrontoCompleto("28/11","13",brasil,suica,"Estadio 974",""));
		g.setCft5(g.setConfrontoCompleto("02/12","16",camaroes,brasil,"Estadio Nacional de Lusail",""));
		g.setCft6(g.setConfrontoCompleto("02/12","16",servia,suica,"Estadio 974",""));
		
		
		h.setCft1(h.setConfrontoCompleto("24/11","7",uruguai,coreiaDoSul,"Estadio Cidade da Educacao","0 x 0"));
		h.setCft2(h.setConfrontoCompleto("24/11","13",portugal, gana,"Estadio 974","3 x 2"));
		h.setCft3(h.setConfrontoCompleto("28/11","7",coreiaDoSul,gana,"Estadio Cidade da Educacao",""));
		h.setCft4(h.setConfrontoCompleto("28/11","13",portugal,uruguai,"Estadio Nacional de Lusail",""));
		h.setCft5(h.setConfrontoCompleto("02/12","16",coreiaDoSul,portugal,"Estadio Cidade da Educacao",""));
		h.setCft6(h.setConfrontoCompleto("02/12","16",gana,uruguai,"Estadio Al Janoub",""));
			
		
//		a.exibeConfrontosGrupo();	
//		a.exibeGrupo();	
		
		Scanner sc = new Scanner(System.in);
		int opcao=-1;
	     
		
	    while(opcao!=0){	    	 
    	  		    	 
	    	 System.out.println("\t ___ Menu ___");
	    	 System.out.println("\t 1 - Exibir o calendario dos jogos e jogos ocorridos.");
	    	 System.out.println("\t 2 - Exibir o calendario dos jogos e jogos ocorridos de uma selecao solicitada.");
	    	 System.out.println("\t 3 - Exibir os jogos ocorridos de um grupo.");
	    	 System.out.println("\t 4 - Informar o resultado de um jogo.");
	    	 System.out.println("\t 0 - Finalizar o programa.");
	    	 	    	 
	    	 
	    	 try {
		    	 opcao=sc.nextInt();
		    	 sc.nextLine();
	    	 }
	    	 
			catch  (InputMismatchException e1){
				 
				
				
				System.out.println("*** Por favor digite um numero ***"); 
				break;
				
			}
	    	 
	    	 if (opcao>=0 && opcao<5) {
	    		 
	    		 switch(opcao) {
	    		 
	    		 	case -1:
		            	
		            	System.out.println("\t --- Erro de Entrada ---");            		            	      	            	
		                break;
	    	 	
		            case 1:
		            	
		            	System.out.println("\t --- JOGOS OCORRIDOS EM ORDEM ---");            	
		            	ExibeCalendarioJogos(vGrupos);          	            	
		                break;
		            
		            case 2:
		            	
		            	System.out.println("\t --- EXIBE JOGOS DE UMA SELECAO ---");   
		            	System.out.println("-- Digite o nome da selecao desejada: --");
		            	
		            	String inputNselecao= sc.nextLine();
		            	sc.nextLine();	
		            	
		            	
		            	MString valida= new MString();
		            	valida.setString(inputNselecao);
		            	
		            	inputNselecao=valida.validaNomeSelecao();
		            	
		            	if(!inputNselecao.isEmpty()) {
		            		
		            		System.out.printf(">> -- Selecao: %s \n",inputNselecao);
		            		ExibeCalendarioSelecao(vGrupos,inputNselecao);      
		            		
		            	}
		            	else {
		            		
		            		System.out.println("-- Entrada para NOME DA SELECAO INVALIDA. Digite apenas letras. --");
		            	}
		            			            		            		        	
		            	break;
		            	
	            	case 3: 
	            		            	
		            	System.out.println("\t --- EXIBINDO JOGOS OCORRIDOS DE UM GRUPO ---");            	
		            	System.out.println("-- Digite do grupo desejado: --");
		            	
		            			            	
		            	String inputGrupo= sc.nextLine();
		            	sc.nextLine();	
		            	
		            	
		            	MString validaG= new MString();
		            	validaG.setString(inputGrupo);
		            	
		            	
		            	inputGrupo=validaG.validaNomeGrupo();
		            	
		            	if(!inputGrupo.isEmpty()) { // se nao for vazia -> se nao contem erro de input
		            		
			            	Grupo gTemp=BuscaGrupoInput(vGrupos, inputGrupo);
			            	
			            	if(gTemp!=null) {
			            		
			            		System.out.printf(">> -- Grupo: %s \n",inputGrupo);
								gTemp.exibeConfrontosGrupo();			            			            		
			            	}
		            	}
		            	
		            	else {
		            		
		            		System.out.println("-- Entrada para NOME DO GRUPO INVALIDA. Digite apenas letras. --");
		            	}
		            	
		                break;	
             		                
		            	
	            	case 4: //BUSCA POR JOGO
			            	
	            			int opcao_jogo=-1;
	            			// Usuario digita a data e o nome da selecao
	            			// Digite os nomes das duas equipes 
	            		
			            	System.out.println("\t ---  Informar o resultado de um jogo.) ---\n"); 
			            	
			            	System.out.println("\t 1 -  Procurar por selecoes "); 
			            	System.out.println("\t 2 -  Procurar por selecao e data. ");
			            	System.out.println("\t 0 -  Cancelar ");
			            	
	            	
			            	try {
			            		
			            		opcao_jogo=sc.nextInt();
			    		    	 sc.nextLine();
			    		    	 
			    		    	 
			    		    	switch (opcao_jogo) {
			    		    		
			    		    				    		    		
				    		    	case 0:
				    		    		
				    		    		System.out.println("*** Cancelando ***");
				    		    		break;
				    		    	
				    		    	case 1:
				    		    		System.out.println("\t --- BUSCANDO JOGOS POR NOMES DE SELECAO ---");
				    		    		
				    		    		String inputNselecao1;
				    		    		String inputNselecao2;
				    		    		
				    		    		System.out.println("--  Digite o nome da selecao 1 --");
				    		    		inputNselecao1= sc.nextLine();
						            	sc.nextLine();					
						            	System.out.println("--  Digite o nome da selecao 2 --");
						            	inputNselecao2= sc.nextLine();
						            	sc.nextLine();
						            	
						            						            	
						            	
						            	MString minput1 = new MString();
						            	MString minput2 = new MString();
						            						            	
						            	minput1.setString(inputNselecao1);						            	
						            	inputNselecao1=minput1.validaNomeSelecao();
						            	
						            	minput2.setString(inputNselecao2);						            	
						            	inputNselecao2=minput2.validaNomeSelecao();
						            	
						            	
						            	if(!inputNselecao1.isEmpty() && !inputNselecao2.isEmpty()) {
						            		
						            		System.out.printf(">> -- Selecao1: %s \n",inputNselecao1);
						            		System.out.printf(">> -- Selecao2: %s \n\n",inputNselecao2);   
						            		
						            		ExibeConfrontoSelecoes(inputNselecao1, inputNselecao2,vGrupos);
						            		
						            		
						            	}
						            	
						            	else { // erro de validacao dos nomes
						            		
						            		System.out.println("-- Entrada para NOME DA SELECAO INVALIDA. Digite apenas letras. --");
						            	}
				    		    		
				    		    		break;
				    		    		
 		    		
				    		    	case 2:			 
				    		    		System.out.println("\t --- BUSCANDO JOGOS POR NOME E DATA ---");
				    		    		
				    		    		
				    		    		String inputNselecaoND;
				    		    		String inputDataJogo;
				    		    		//Confronto cf= new Confronto();
				    		    		
				    		    		
				    		    		System.out.println("--  Digite o nome da selecao 1 --");
				    		    		inputNselecaoND= sc.nextLine();
						            	sc.nextLine();	
						            	            					
						            	
						            	System.out.println("--  Digite a data do confronto. Utilize o formato DD/MM/YYYY ou dd/mm--");
						            	inputDataJogo= sc.nextLine();
						            	sc.nextLine();	
						            	
						            	
						            	MString nomeMs = new MString();
						            	MString dataMs = new MString();
						            						            	
						            	nomeMs.setString(inputNselecaoND);						            	
						            	inputNselecaoND=nomeMs.validaNomeSelecao();
						            	
						            	
						            	dataMs.setString(inputDataJogo);
						            	
						            	
						            	int validaData=dataMs.validaStringData(); // verifico se os digitos da data sao validos
						            	
						            	inputDataJogo= dataMs.formataStringData();
						        
				    		    		
						            	if (validaData==1  &&  !inputNselecaoND.isEmpty()) { // apenas numeros e barra
						            		
						            		//localiza por data e nome 						            		
						            		//cf.setData(inputDataJogo);
						            		
						            		//if (cf.validaData(cf.getData())==1)
						            		
						            			
					            			System.out.printf(">> -- Selecao1: %s \n",inputNselecaoND);
						            		System.out.printf(">> -- Data: %s \n\n",inputDataJogo );   //cf.getData()
					            			
						            		ExibeConfrontoSelecaoData(inputNselecaoND, inputDataJogo, vGrupos);
						            		
						            		
//						            		else {
//						            			
//						            			System.out.println("-- ERRO NA ENTRADA DOS DADOS DE DATA. Utilize dd/mm/yyyy ou dd/mm /");
//						            		}
//						            		
						            		
						            	}
						            	
						            	else {
						            		
						            		System.out.println("-- ERRO NA ENTRADA DOS DADOS.");
						            		System.out.println("-- Entrada para DATA DO CONFRONTO INVALIDA. Digite apenas numeros e < / >");
						            		System.out.println("-- OU entrada para NOME DA SELECAO INVALIDA. Digite LETRAS sem TIL OU ACENTOS /\n\n");
						            	}
				    		    		
				    		    		break;
				    		    		
				    		    		
				    		    	default:
				    		    		
				    		    		System.out.println("-- Entrada OPCAO DE BUSCA INVALIDA. Digite apenas numeros de 0 a 2. --");
				    		    		break;
			    		    		
			    		    	}
			    		    	 			   					       
					            	
			    	    	 } // fim try
			    	    	 
			    			catch  (InputMismatchException e2){

			    				System.out.println("*** Por favor digite numeros no menu de BUSCA POR JOGO ***"); 
			    				break;
			    				
			    			}
			            	           	
			            	
			            	break;
			            				            	
		            	
		            case 0:
		            	
		            	System.out.println("\t --- FINALIZANDO O PROGRAMA ---");
		            	break;	
		
		            default :	            	
			            
		            	System.out.println("*** Opcao Invalida ***\n");
		     	        break;    
	    		 }	    		 
	    		 
	    	 }
	    	 
	    	 else {
	    		 
	    		 System.out.println("*** Opcao Invalida. Digite uma opcao de 0 a 4. ***\n");
	    		 
	    	 }	    	 
	 
	     }
	     
	}
	    
}