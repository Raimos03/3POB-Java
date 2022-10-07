package pacote;

import java.util.Scanner;

public class Menutroca {

	public int opcaoTroca(Scanner sc) {
		
		System.out.println("\t-- Digite 1 para alterar o Id:\n");
		System.out.println("\t-- Digite 2 para alterar o Nome:\n");
        System.out.println("\t-- Digite 3 para alterar o Codigo de barras:\n");
        System.out.println("\t-- Digite 4 para alterar o SKU:\n");
        System.out.println("\t-- Digite 5 para alterar o Descricao:\n");
        System.out.println("\t-- Digite 6 para alterar o Categoria:\n");
        System.out.println("\t-- Digite 7 para alterar o Preco:\n");
        System.out.println("\t-- Digite 8 para alterar o Peso:\n");
        System.out.println("\t-- Digite 9 para alterar o Fabricante:\n");
           
 
        int i = sc.nextInt();
        sc.nextLine();
		
		return i;
	}
	
	
	
}
