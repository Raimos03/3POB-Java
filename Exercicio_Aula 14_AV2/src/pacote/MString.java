package pacote;


import java.util.List;
import java.util.ArrayList;

public class MString implements IMString{
	
	public String sstring;
	
	public String getString() {
		return sstring;
	}
	
	public MString getObject() {
		
		return this;
	}
	
	public void setString(String string) {
		this.sstring = string;
	}


	public int  contaCaractere( char c) {
		
		int qtd=0;
		
		for(int i=0;i< this.sstring.length();i++) {
			
			if(this.sstring.charAt(i)==c) {
				qtd++;
			}
		}
		
		return qtd;
	}
	
	
	public int EncontraStringVetor(  String[] vetor ,String s) {
		
		for (int i=0;i<vetor.length;i++) {
					
					//System.out.println("Estadio:"+vetor[i]);
					if(vetor[i].contentEquals(s)) {
						
						return i;
					}
		}
		
		return 0;
	}
	
	public int validaString() {
		
		
		int i;
		char c;
		String s=this.getString();
			
		
		for (i=0;i<this.getString().length();i++) {
			
			c=s.charAt(i);
			
			if (c=='1'|c=='2'|c=='3'|c=='4'|c=='5'|c=='6'|c=='7'|c=='8'|c=='9') {
			
				return -1;
			}
			if (c=='*'|c=='-'|c=='.'|c=='@'|c=='#'|c=='!'|c=='`'|c=='~'|c=='('|c==')'|c=='}'|c=='{'|c=='['|c==']'|c==':'|c==';'|c==','|c=='"'|c=='.'|c=='<'|c=='>'|c=='/'|c=='?'|c=='\\') {
				
				return -1;
			}
		
			
		}
	
		return 1;
	}
	
	public int validaStringData() {
		
		
		int i;
		char c;
		String s=this.getString();
		
		int vcaractere, vregex1,vregex2;
		vcaractere=vregex1=vregex2=0;	
		
		for (i=0;i<this.getString().length();i++) { // teste1
			
			c=s.charAt(i);
			
			if (c=='*'|c=='-'|c=='.'|c=='@'|c=='#'|c=='!'|c=='`'|c=='~'|c=='('|c==')'|c=='}'|c=='{'|c=='['|c==']'|c==':'|c==';'|c==','|c=='"'|c=='.'|c=='<'|c=='>'|c=='?'|c=='\\') {
				
				return -1;
			}
					
		}
		
		vcaractere=1;
		//teste 2
		
		if (s.matches("[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}")) {
			
			vregex1=1;
		}
		else if (s.matches("[0-9]{1,2}/[0-9]{1,2}")) {
			vregex2=1;
		}
		
		else {
			
			return -1;
		}
		
		
		if (vcaractere ==1 && (vregex1==1||vregex2==1)) {
			return 1;
		}
	
		return -1;
	}
	
	public String formataStringData() {
		
		String s = this.getString(); //2/5
		int qtdcaractere= this.contaCaractere('/');
		
		String p1 ="";
		String np1="";
		String p2= "";
		String np2="";
		String p3= "";
		
		String split[] = s.split("/");
		
		if (qtdcaractere==1) {
			
			
			p1=split[0];
			p2=split[1];
			
			if(Integer.parseInt(p1)<10) {	
				np1="0"+p1;
			}else {
				
				np1=p1;
			}
			if(Integer.parseInt(p2)<10) {
				np2="0"+p2;
			}
			else {
				np2=p2;
			}
			
			s=np1+"/"+np2;
		}
		else if (qtdcaractere==2) {
			
			
			p1=split[0];
			p2=split[1];
			p3=split[2];
			
			if(Integer.parseInt(p1)<10) {	
				np1="0"+p1;
			}
			if(Integer.parseInt(p2)<10) {
				np2="0"+p2;
			}
			
			s=np1+"/"+np2+"/"+p3;
			
		}
		
		else {
			return "";
		}
		
		
		
		if(!s.contains("2022")&& qtdcaractere==1) {
			s+="/2022";
		}
						
		return s;
	}
	
	public String Captalize(String s) {
		
		
		//s=s.toLowerCase();	
		
		String temp="";
		String parte2;
			
		temp+=s.charAt(0);
		
		temp=temp.toUpperCase();
		
	
		parte2=s.substring(1);
		parte2=parte2.toLowerCase();
		parte2=temp+parte2;
		
		s=parte2;
		
		return s;
		
	}
	
	public String validaNomeSelecao() {
		
		
			int qtdMaiuscula=0;
			int i=0;
			int posMaiuscula=0;
			char aux;
			int validacao=0;
			MString n= new MString();
			int espaco=0;
			
			
			
			String s = this.getString();	
			n.setString(s);
		
			// ** validacao de formato com numeros e etc 
					
		
			if (s=="") { // se a string for vazia
				return "";
			}
			
			else { // se nao, valida formato
				
				validacao = n.validaString();
				
			}
						
			if (validacao==-1) {
				return "";
			}
			
			else { // formato validado. So possui letras
								
				for (i=0;i<s.length();i++) {
					
					aux=s.charAt(i);
					
					if(aux==' ') {
						espaco++;
					}
					
					else if (aux=='A'|| aux=='E' ||aux=='I' || aux == 'O' || aux== 'U'|| aux== 'B'|| aux== 'C'|| aux== 'D'|| aux== 'F'|| aux== 'G'|| aux== 'H'|| aux== 'K'|| aux== 'L'|| aux== 'M'|| aux== 'N'|| aux== 'P'|| aux== 'Q'|| aux== 'R'|| aux== 'S'|| aux== 'T'|| aux== 'V'|| aux== 'X'|| aux== 'Y'|| aux== 'Z') {
						
						qtdMaiuscula++;
						posMaiuscula=i;
					}
					if (qtdMaiuscula >1) {					
						
						s=s.toLowerCase(); // passo tudo para minuscula							
						break;
					}
				}
				
				if (posMaiuscula==1 && qtdMaiuscula==1) {
					
					return s;
				}	
				
				else {
					
					if(espaco==1) {				
						// arabia Saudita
						// capitalize
											
						String p1 ="";
						String p2= "";
												
						String split[] = s.split(" ");
						
						p1=Captalize(split[0]);
						p2=Captalize(split[1]);
							
						s=p1+" "+p2;
						
					}
					
					else if (espaco==2) {
						// capitalize
					
						String p1 ="";
						String p2= "";
						String p3= "";
												
						String split[] = s.split(" ");
						
						p1=Captalize(split[0]);
						
						if (s.contains("de")|| s.contains("DE")||s.contains("DO")||s.contains("do")) {
							
							p2=split[1];
							p2.toLowerCase();
						}
						else {
							p2=Captalize(split[1]);
							
						}
						
						p3=Captalize(split[2]);
							
						s=p1+" "+p2+" "+p3;
						
						
					}		
					
					else {
					

						String p1 =Captalize(s);
						s=p1;
					}
					
				}	
				
				return s;
						
			}		
	}
	
	
	public String validaNomeGrupo() {
		
		char aux;
		int validacao=0;
		MString n= new MString();
		
		
		
		String s = this.getString();	
		n.setString(s);
	
		
		// ** validacao de formato com numeros e etc 
		if (s=="") { // se a string for vazia
			return "";
		}
		
		else { // se nao, valida formato
			
			validacao = n.validaString();
			
		}
		
					
		if (validacao==-1) {
			return "";
		}
		
		else { // formato validado. So possui letras
							
				
			aux=s.charAt(0);			
			s=s.toLowerCase(); // passo tudo para minuscula										
	
			String temp="";				
			temp+=s.charAt(0);			
			temp=temp.toUpperCase();	
			
			return temp;
					
		}		
}
	
	
	
	public MString() {
		
	}
}
