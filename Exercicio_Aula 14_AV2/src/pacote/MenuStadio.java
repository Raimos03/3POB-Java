package pacote;
import java.util.Scanner;

public class MenuStadio { // apenas utilizado para preenchimento manual
		
		public int getOpcao(Scanner sc, String vStadio[]){
			
			
			System.out.println("\t - Digite a opcao do Estadio desejado:  \n");
			
			int tam= vStadio.length;
			
			for(int i=0;i<tam;i++) {
				
				System.out.printf("\t- %d - %s \n",i+1,vStadio[i]);
				
			}
			      
	        System.out.println("\t- 0 -  Para terminar:\n");
	             
	        
	        int i = sc.nextInt();
	        sc.nextLine();
			
	        
			return i;
					
		}
	
}
