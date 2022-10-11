package pacote;

import java.util.Scanner;

public class Menu {
	
	public int getOpcao(Scanner sc){
		
        System.out.println("\t-1 para inserir produto:");
        System.out.println("\t-2 para alterar produto:");
        System.out.println("\t-3 para excluir produto:");
        System.out.println("\t-4 para listar um produto:");
        System.out.println("\t-5 para listar todos os produtos:");
        System.out.println("\t-6 para salvar todos os produtos em um arquivo:");
        System.out.println("\t-0 para terminar:\n");
             
        
        int i = sc.nextInt();
        sc.nextLine();
		
		return i;
		
		
	}
}
