package pacote;

import java.util.Calendar;
import java.util.ArrayList;


import java.text.DateFormat;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Confronto implements IConfronto {
	
	private Selecao Selecao1;
	private Selecao Selecao2;
	private int golsSelecao1;
	private int golsSelecao2;
	
	private String placar;
	private String local;
	
	private Calendar dataEhora = Calendar.getInstance();
	
	
	public Selecao getSelecao1() {
		return Selecao1;
	}

	public void setSelecao1(Selecao selecao1) {
		this.Selecao1 = selecao1;
	}

	public void setSelecao2(Selecao selecao2) {
		this.Selecao2 = selecao2;
	}
	
	public Selecao getSelecao2() {
		return Selecao2;
	}

	public int getGolsSelecao1() {
		return golsSelecao1;
	}
	
	public void setGolsSelecao1(int gols) {
		
		golsSelecao1=gols;
		return ;
	}
	
	public int getGolsSelecao2() {
		return golsSelecao2;
	}
	
	public void setGolsSelecao2(int gols) {
		
		golsSelecao2=gols;
		return ;
	}
	
	public String getPlacar() {
		return placar;
	}

	public void setPlacar(String splacar) { // <3 x 2>
		
		if(splacar.length()!=5) {
			
			System.out.println("Placar no formato invalido/n Insira:<n1 x n2>/n");
		}
		else {
			
			this.golsSelecao1 = Character.getNumericValue(splacar.charAt(0)) ;
			this.golsSelecao2 = Character.getNumericValue(splacar.charAt(4)) ;
		}
		
		this.placar = splacar;
	}
	

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}
	
	public Calendar getDataHora_Calendar() {
		return dataEhora;
	}

	public void setDataHora_Calendar(Calendar dataHora) {
		this.dataEhora = dataHora;
	}
	
	
	// Tratando data e hora
	
	
	public void setData(String sdata) { //  <12/05/2022>
		
		if(!sdata.contains("2022")) {
			sdata+="/2022";
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
		String dateInString = sdata.replace("/","-");
		
		
		Date date = null;
		
		try {
			
			date = sdf.parse(dateInString);
			
		} 
		
		catch (ParseException e) {
			
			System.out.printf("Erro de criacao da data/n");
			e.printStackTrace();
		}
		
		dataEhora.setTime(date);
		
	}
	
	public String getData() { //retorna String
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return  ""+sdf.format(this.getDataHora_Calendar().getTime());
	}
	
	public void setHora(String shora) { //<13:25>
		
		MString stemp = new MString();
		stemp.sstring=shora;
		
		int qtdcaractere=stemp.contaCaractere(':');
		String[] split= shora.split(":");
		
		
		if(qtdcaractere==0 || split.length==1) {
			
			
			this.dataEhora.set(Calendar.HOUR_OF_DAY,Integer.parseInt(split[0]));
		}
		
		else if ((qtdcaractere==1 || qtdcaractere==2)&& split.length>1){
			
			//System.out.println(split);
			
			this.dataEhora.set(Calendar.HOUR_OF_DAY,Integer.parseInt(split[0])); //ver
			this.dataEhora.set(Calendar.MINUTE,Integer.parseInt(split[1])); //ver
			
			//dataEhora.set(Calendar.HOUR_OF_DAY,17);
			//dataEhora.set(Calendar.MINUTE,50);
		}
	
		else {
			
			System.out.println("Erro no formato da hora. \n. Insira no formato: <HH:mm:ss> ou <HH:mm> \n");
		}
		
		return;
		
	}
	
	public String getHora() { //retorna String
		
		//""+dataEhora.HOUR_OF_DAY+":"+dataEhora.MINUTE
		
		return  (dataEhora.getTime().getHours()<10?"0":"")+""+dataEhora.getTime().getHours()+":"+ (dataEhora.getTime().getMinutes()<10?"0":"") +dataEhora.getTime().getMinutes();
	}
	

	public String get_Data_Hora() {
		
		String s ="";
		String s2="";
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		s+= (String)(dataEhora.getTime().getHours()<10?"0":"")+""+dataEhora.getTime().getHours()+":"+ (dataEhora.getTime().getMinutes()<10?"0":"") +dataEhora.getTime().getMinutes();
		s2+=(String)(sdf.format(dataEhora.getTime()));
		
		return "Data: " +s2+"\n"+"Hora: "+s+"\n";
	}
	
	public int validaData(String s) {
		// Data no formato dd/mm/yyyy
		// nao trata SQL injection
		
							
			
		if (s.matches("[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}")==false) {
				
				return 0;
		}
				
		return 1;
		
			
	}
	
	public int validaHora(String s) { //**** ver validacao correta
		// Hora no formato <HH:MM> ou <HH> ou <HH:MM:SS>
			
		
		if(s.length()<1) {
					
			return 0;
		}
		
		if(s.length()<3) {
				
			if(s.matches("^[0-9]{1,2}:")) {
				
				return 0;
			}
					
		}
	
		if(s.length()<6) {
			
			if(s.matches("[^0-9]{1,2}:[^0-9]{1,2}") || s.matches("[^0-9]{1,2}:[0-9]{1,2}")|| s.matches("[0-9]{1,2}:[^0-9]{1,2}") ) {
				
				return 0;
			}
					
		}
			
		return 1;
	
	}
	
	
	public int inputDataHora(Scanner sc) {
		
		
		int conf_dataHora=0;
		String tempData;
		String tempHora;
		
		while(conf_dataHora==0) {
			
			System.out.println("Digite a data do confronto no formato: <dia/mes/ano> <dd/mm/yyyy  \n");
			
			tempData= sc.nextLine();
	    	sc.nextLine();    	
	    	
			if(!tempData.contains("2022")) {
							
				tempData+="/2022";
						}
	    	
	    	if(validaData(tempData)==1) {
	    		// Data validada
	    			    		
	    		
	    		System.out.println("Digite a hora do confronto no formato: <HH:MM> ou <HH> ou <HH:MM:SS> 24h \n");
				tempHora= sc.nextLine();
		    	sc.nextLine();
		    	
		    	if(validaHora(tempHora)==1) {
		    		// Hora validada
		    		
		    		
		    		System.out.printf("-- Data: %s \n",tempData);
		    		System.out.printf("-- Hora: %s\n", tempHora);
		    		
		    		
		    		System.out.println("-- Deseja confirmar a insercao da Data e Hora?\n 1 - Sim \n 0 - Nao\n");
		    		conf_dataHora = sc.nextInt();
			        sc.nextLine();	
			        
			        if(conf_dataHora==1) {
			        	
			        	this.setData(tempData);
			    		this.setHora(tempHora);
			    		
			        }
		    		
		    		
		    	}
		    	else {
		    		
		    		System.out.println("Hora invalida. Digite a hora no formato: <HH:MM> ou <HH> ou <HH:MM:SS> 24h \n");
		    		
		    	}
	    		
	    	}
	    	
	    	else {
	    		
	    		System.out.println("Data invalida. Digite a data  no formato: <dia/mes/ano> <dd/mm/yyyy> \n");
	    		conf_dataHora=0;
	    	}			
		}

    	
		
    	
		return 1;
	}
	
	
	public int buscaSelecaoNomeGrupo(String s, ArrayList <Selecao> vselecoes) {
		
		for(int i=0;i<vselecoes.size();i++) {
			
			if (s.compareTo(vselecoes.get(i).getNome())==0) {
				return i;
			}
			
		}
		
		return -1;
	}
	
	public int preencheConfronto(String vestadio[], ArrayList <Selecao> grupo, int ordem) {
		
		Scanner sc_opcao = new Scanner(System.in);
		
		int opcaoEstadio=-1;
		
		String inputNomeSelecao1;
		String inputNomeSelecao2;
		
		
		int conf=0;
		int confEstadio=0;
		int resultadoBusca1=-20;
		int resultadoBusca2=-20;
		
		
		System.out.printf("-- CONFRONTO DE NUMERO %d NO GRUPO -- \n",ordem);
		while(conf==0) { // validacao das selecoes
			
			System.out.println("-- Digite o nome da selecao 1 do CONFRONTO -- \n");
			inputNomeSelecao1= sc_opcao.nextLine();
        	sc_opcao.nextLine();
        	
        	
        	resultadoBusca1=buscaSelecaoNomeGrupo(inputNomeSelecao1, grupo);
        	
        	if (resultadoBusca1!=-1 ) { // encotrou a selecao 1
        		
        		this.setSelecao1(grupo.get(resultadoBusca1)); //seto a selecao 1
        		
        		
        		System.out.println("-- Selecao 1 cadastrada com sucesso -- \n");
        		
        		System.out.println("-- Digite o nome da selecao 2 -- \n");
        		inputNomeSelecao2= sc_opcao.nextLine();
            	sc_opcao.nextLine();
            	
            	
            	resultadoBusca2=buscaSelecaoNomeGrupo(inputNomeSelecao2, grupo);
    			
    			if(resultadoBusca2!=-1) {
    				
    				this.setSelecao2(grupo.get(resultadoBusca2)); //seto a selecao 1
    				System.out.println("-- Selecao 2 cadastrada com sucesso -- \n");
    				
    			}
    			
    			
    			else {
    				
    				System.out.printf("-- O nome digitado da selecao 2 nao corresponde a uma selecao valida.\n Tente Novamente -- \n");
    			}
        		
        	}
        	else {
        		
        		System.out.printf("-- O nome digitado da selecao 1 nao corresponde a uma selecao valida.\n -- Tente Novamente -- \n");
    			
        	}
        	
        	
			if	(resultadoBusca1!=-1 && resultadoBusca2!=-1) {
				System.out.println("-- Deseja confirmar a insercao?\n 1 - Sim \n 0 - Nao\n");
				conf = sc_opcao.nextInt();
		        sc_opcao.nextLine();		        
			}
			
			else {
				conf=0;
			}
			
		}
		
		
		while(confEstadio==0) { //validacao do estadio
			
			
			MenuStadio menuEstadio= new MenuStadio();
			opcaoEstadio= menuEstadio.getOpcao(sc_opcao, vestadio);
			int resultadoBuscaEstadio=-20;
			
			
			if(opcaoEstadio>-1 && opcaoEstadio<10) {
				
				resultadoBuscaEstadio=opcaoEstadio-1;
				if(resultadoBuscaEstadio!=-1) {
					
					
					
					System.out.printf("--> Estadio : %s -- \n",vestadio[resultadoBuscaEstadio]);
					
					System.out.println("-- Deseja confirmar a insercao do Estadio?\n 1 - Sim \n 0 - Nao\n");
					confEstadio = sc_opcao.nextInt();
			        sc_opcao.nextLine();		
			        
			        if (confEstadio==1) {
			        	
			        	this.setLocal(vestadio[resultadoBuscaEstadio]);
						System.out.println("-- Estadio cadastrado com sucesso. -- \n");
			        }
					
				}
				else {
					
					System.out.println("-- Estadio nao encontrado, tente novamente. -- \n");
					confEstadio=0;
				}
				
			}
			else {
				System.out.println("-- Opcao invalida. Tente Novamente -- \n");
				
			}
				
		}
		
		
		//insercao de data e hora
		
		int conf_dataHora=0;
		
		while(conf_dataHora==0) {
			
			int resultadoValidacaoDH=inputDataHora(sc_opcao);
			
			if(resultadoValidacaoDH==1) {
				
				// tudo ok e validado, insere
				
				conf_dataHora=1;
			}
			
			else {
				
				System.out.println("-- Erro na insercao de data e hora. Tente novamente -- \n");
				conf_dataHora=0;
			}
			
			
		}
		
		
		
		//System.out.println(opcaoEstadio);
		
		//sc_opcao.close();
		
		return 1;
	}
	
		
	public Confronto() {		
			
		}
	
	
	public Confronto(String data, String hora, Selecao selecao1, Selecao selecao2, String local, String placar) {
		
		if(selecao1==null) {
			
			selecao1=new Selecao();
			selecao1.setNome("INDEFINIDO");
		}
		if(selecao2==null) {
					
			selecao2=new Selecao();
			selecao2.setNome("INDEFINIDO");
				}
		if (placar.isEmpty()) {
			placar ="- x -";
		}
		
		this.setData(data);
		this.setHora(hora);
		this.setSelecao1(selecao1);
		this.setSelecao2(selecao2);
		this.setLocal(local);
		this.setPlacar(placar);
		
	}
	
	public int getDiaConfronto(){
		
		return this.getDataHora_Calendar().getTime().getDate();
	}
	
	public int mesmaDataDia(Calendar cal) {
		
		if(cal.getTime().getDate() != this.getDataHora_Calendar().getTime().getDate()) {
			return 0;
		}
				
		return 1;
	}
	
	public void exibeConfronto() {
		
		String n1="";
		String n2="";
		
		
		if (this.getGolsSelecao1()!=-1) {
			
			n1=String.valueOf(golsSelecao1);
			n2=String.valueOf(golsSelecao2);
		}
		
		System.out.printf(">> Confronto:   %s %s X  %s %s \n", this.getSelecao1().getNome(),n1,n2,this.getSelecao2().getNome());	
		//System.out.printf(" Placar:           %s \n", this.getPlacar());
		System.out.printf("\t Local: %s \n", this.getLocal());
		System.out.printf("\t Data: %s \n\t Hora: %s \n\n", this.getData(),this.getHora());
	}
}
