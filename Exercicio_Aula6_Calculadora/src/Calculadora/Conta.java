package Calculadora;

import java.util.Scanner;

public class Conta {
		
	int integrantes;
	double total;
	double vcada;
	
	public void GerenciaConta() { //metodo que cria uma conta, metodo da conta
		
		Calculadora[] vcalculos;
		int i=1;
		double totalconta;
		
		while(i!=0){
			
				Scanner si = new Scanner(System.in); 	                 
	            System.out.println("Digite a quantidade de pessoas: ou 0 para terminar\n");	            
	            
		        i = Integer.parseInt(si.nextLine());		        
		            
	            this.integrantes=i;
	            
	            if(i==0){
	            	System.out.println("\tFinalizando o programa...\n");
	            	si.close();    
	                break;
	            }	                      
	            else {
	            	
	            	Scanner sctot= new Scanner(System.in);
	 	            System.out.println("Digite o total da conta:\n");
	 	            
		 	        totalconta=sctot.nextFloat();
		 	        
	 	            this.total=totalconta;
	 	            this.vcada=total/integrantes;
	            	
	            	System.out.println("\tExecutando ...");
	            	vcalculos=setPreencheUsuarios(integrantes);
	            	ExibeValorParcitipantes(vcalculos,integrantes);
	            	sctot.close();            	
	            	
	            }
	            si.close();    
		}
			
	}
	
	Calculadora[] setPreencheUsuarios(int qtdint) {
		

		int i;
		Calculadora[] vcalculos = new Calculadora[qtdint];
		String nome;           
		Scanner sc = new Scanner(System.in);     
				
		for (i=0;i<qtdint;i++) {
			
			 System.out.println("Digite o nome da pessoa"+(i+1)+":\n");
			 nome=sc.nextLine();
			 
			 Calculadora calculo = new Calculadora(nome,getVCada());
			 vcalculos[i]=calculo; //salvo as instancias de usuario na lista
						
			 
		}		
		
		sc.close();
		return vcalculos;				
	}
	
	private void ExibeValorParcitipantes(Calculadora[] vcalculos, int integrantes) {
		  
		for (Calculadora calc: vcalculos) {
			calc.ImprimeValor();	
		}
	}

	public int getIntegrantes() {
		return this.integrantes;
	}

	public void setIntegrantes(int integrantes) {
		this.integrantes = integrantes;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getVCada() {
		return vcada;
	}

	public void setCada(double Vcada) {
		this.vcada = Vcada;
	}
	
	
 	 	
}
