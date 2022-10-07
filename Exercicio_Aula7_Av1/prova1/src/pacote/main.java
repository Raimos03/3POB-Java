package pacote;


import java.util.Scanner;

public class main {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println("--- Menu ----\n");
		int id;
		String codBarras;
		String sku;
		String nome;
		String descricao;
		String categoria;
		double preco;
		double peso;
		String fabricante;
		Produtos estoque = new Produtos();
		int opcaobusca;
		
		 // tentei fazer com while mas dava erro na segunda execucao
        int i=1;
        Scanner sc = new Scanner(System.in);
        
        while(i!=0){
        	
			Menu menu= new Menu();
			int opcao = menu.getOpcao(sc);
			
			switch(opcao) {
	                   
	            case 0:
	            	
	            	i=0;
	                break;
	            
	            case 1:
	            	  		
		                System.out.printf("-----inserir produto: ----- \n");
		                
		                System.out.println("\tDigite o ID:");
		                id=sc.nextInt();
		                sc.nextLine();
		                
		                System.out.println("\tDigite o Codigo de Barras:");
		                codBarras=sc.next();
		                sc.nextLine();
		                
		                System.out.println("\tDigite o SKU:");
		                sku=sc.next();
		                sc.nextLine();
		                
		                
		                System.out.println("\tDigite o Nome:");
		                nome=sc.next();
		                sc.nextLine();
		                
		                sc.nextLine();
		                System.out.println("\tDigite a Descricao:");
		                descricao=sc.nextLine();
		                sc.nextLine();
		                
		                System.out.println("\tDigite a Categoria:");
		                categoria=sc.next();
		                sc.nextLine();
		                
		                System.out.println("\tDigite o Fabricante:");
		                fabricante=sc.next();
		                sc.nextLine();
		                
		                System.out.println("\tDigite o preco:");
		                preco= sc.nextDouble();
		                sc.nextLine();
		                
		                System.out.println("\tDigite o peso:");
		                peso=sc.nextDouble();
		                
		                sc.nextLine();
		                
		                
		                Produto novoproduto = new Produto(id,codBarras,sku,nome,descricao,categoria,preco,peso,fabricante);
		                if (estoque.getQtdEstoque()==0) {
		                	
		                	estoque = new Produtos("Estoque1","Categoria1");
		                	estoque.InsereEstoque(novoproduto);
		                }
		                else {         	
		                	 estoque.InsereEstoque(novoproduto);
		                }
					         
		                break;     
	                
	            case 2:
	            	Menutroca menutroca= new Menutroca();
	            	
	                System.out.println("-- Alterar produto --\n");
	                System.out.println("\t-- Digite 1 para buscar por Nome --\n");
	                System.out.println("\t-- Digite 2 para buscar por ID --\n");
	                System.out.println("\t-- Digite 3 para buscar por SKU --\n");
	                
	                opcaobusca=sc.nextInt();
	                sc.nextLine();
	                
	                int resultado,opcaotroca;
	                
	                if(opcaobusca==1) { //busca 1
	                	
	                	System.out.println("\t-- Digite o Nome --\n");
	                	String bnome= sc.nextLine();
	                	sc.nextLine();
	                	
	                	resultado = estoque.BuscaProdutoNome(bnome);
	                	if (resultado <0) {
	                		System.out.println("\t-- Produto nao encontrado --\n");
	                	}
	                	else { // encontrou
	                		
	                		
	                		opcaotroca=menutroca.opcaoTroca(sc);
	                		
	                		
	                		if(estoque.AlteraProduto(resultado,opcaotroca,sc)==1) {
	                			
	                			System.out.println("\t-- Produto alterado com sucesso  --\n");
	                		}
	                		else {
	                			
	                			System.out.println("\t-- Erro na alteracao do NOME do produto  --\n");
	                		}
	                		
	                	}
	                	
	                	estoque.ExibeProduto(resultado);
	                }
	                else if (opcaobusca==2) { //busca 2
	                	
	                	System.out.println("\t-- Digite o ID --\n");
	                	int bid= sc.nextInt();
	                	sc.nextLine();
	                	
	                	resultado = estoque.BuscaProdutoID(bid);
	                	if (resultado <0) {
	                		System.out.println("\t-- Produto nao encontrado --\n");
	                	}
	                	else { //encontrou
	                		
	                		opcaotroca=menutroca.opcaoTroca(sc);
	                		
	                		
	                		if(estoque.AlteraProduto(resultado,opcaotroca,sc)==1) {
	                			
	                			System.out.println("\t-- Produto alterado com sucesso  --\n");
	                		}
	                		else {
	                			
	                			System.out.println("\t-- Erro na alteracao do ID do produto  --\n");
	                		}
	                	}
	                	
	                	estoque.ExibeProduto(resultado);
	                	
	                }
	                else if (opcaobusca==3) { //busca 3
	                	
	                	System.out.println("\t-- Digite o SKU --\n");
	                	String bSku= sc.nextLine();
	                	sc.nextLine();
	                	
	                	resultado = estoque.BuscaProdutoSku(bSku);
	                	if (resultado <0) {
	                		System.out.println("\t-- Produto nao encontrado --\n");
	                	}
	                	else {// encontrou
	                		
	                		
	                		opcaotroca=menutroca.opcaoTroca(sc);
	                		
	                		
	                		if(estoque.AlteraProduto(resultado,opcaotroca,sc)==1) {
	                			
	                			System.out.println("\t-- Produto alterado com sucesso  --\n");
	                		}
	                		else {
	                			
	                			System.out.println("\t-- Erro na alteracao do SKU do produto  --\n");
	                		}
	                			                	       		
	                		
	                	}
	                	
	                	estoque.ExibeProduto(resultado);
	                	
	                }
	                
	                else {
	                	
	                	System.out.println("\t--Opcao invalida, voltando ao menu --\n");
	                }
	                               
	                break;
	            
	                
	            case 3: // ------------ EXCLUSAO -----------------
	            		            	
	            	
	            	System.out.println("-- Excluir produto --\n");
	            	System.out.println("\t-- Digite 1 para EXCLUSAO por Nome --\n");
	            	
	            	
	            	opcaobusca=sc.nextInt();
	                sc.nextLine();
	                
	                
	                if(opcaobusca==1) { //busca 1
	                	System.out.println("\t-- Digite o Nome: --\n");
	                	
	                	String bnome= sc.nextLine();
	                	sc.nextLine();
	                	
	                	resultado = estoque.BuscaProdutoNome(bnome);
	                	if (resultado <0) {
	                		System.out.println("\t-- Produto nao encontrado --\n");
	                	}
	                	else { // encontrou
	                		                		        		
	                		if(estoque.ExcluiProduto(resultado)==1) {   			
	                			
	                			System.out.println("\t-- Produto excluido com sucesso  --\n");
	                		}
	                		else {
	                			
	                			System.out.println("\t-- Erro na EXLCUSAO do produto  --\n");
	                			}
	                		               		
	                		
	                		}
	                	                	
	                }
	                	
	               else {
	                	System.out.println("\t-- Opcao nao cadastrada  --\n");
	                	
	                }
        
	              break;

	              
	            case 4 : // i=4
	                
	                System.out.println("--- Listando um produto ---");
	                System.out.println("\t-- Digite 1 para buscar por Nome --\n");
	                
	                opcaobusca=sc.nextInt();
	                sc.nextLine();
	                
	                if(opcaobusca==1) { //busca 1 por nome
	                	System.out.println("\t-- Digite o Nome: --\n");
	                	
	                	String bnome= sc.nextLine();
	                	sc.nextLine();
	                	
	                	resultado = estoque.BuscaProdutoNome(bnome);
	                	if (resultado <0) {
	                		System.out.println("\t-- Produto nao encontrado --\n");
	                	}
	                	else { // encontrou
	                		                		        		
	                		
	                		estoque.ExibeProduto(resultado);
	                			                		
	                	}
	                	
	                }
	                	
	               else {
	                	System.out.println("\t-- Opcao nao cadastrada  --\n");
	                	
	                }
       
	                break;
	                 
	                 
	            case 5: 
	            	
	            	System.out.println("--- Listando todo o estoque ---\n");
	                estoque.ExibeEstoque();
	                break;
	                
	                
	                 
	            case 6: // ---------- SALVANDO EM ARQUIVO ----------
	            	
	            	
	            	System.out.println("--- Salvando o estoque no arquivo ---\n");
	          
	            	
	            	Save savefile= new Save();
	            	
	            	
	            	if (savefile.SalvaArquivo(estoque)>0) {
	            		
	            		System.out.println("--- Salvando .. ---\n");
	            		System.out.println("--- Salvando ..... ---\n");
	            		System.out.println("--- Salvando ........... ---\n");
	            		System.out.println("--- Arquivo salvo com sucesso  ---\n");
	            	}
	            	else {
	            			
	            		System.out.println("--- Erro ao salvar o arquivo. Tente novamente ---\n");	
	            			
	            		}
	                break;   
	                
	                 
	            default :	            	
	            
	            	System.out.println("Opcao Invalida/n");
	     	        break;    
				}
						
			
        }// fim do while
	}
	
}



