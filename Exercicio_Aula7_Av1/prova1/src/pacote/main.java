package pacote;

import java.util.ArrayList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println("--- Menu ----\n");
		int id;
		String CodBarras;
		String Sku;
		String nome;
		String descricao;
		String categoria;
		double preco;
		double peso;
		String fabricante;
		
		
		int i=1;
        while(i!=0){
            
            Scanner sc = new Scanner(System.in);
                    
            System.out.println("\t-1 para inserir produto:\n");
            System.out.println("\t-2 para alterar produto:\n");
            System.out.println("\t-3 para excluir produto:\n");
            System.out.println("\t-4 para listar um produto:\n");
            System.out.println("\t-5 para listar todos os produtos:\n");
            System.out.println("\t-0 para terminar:");
            
            i = sc.nextInt();
            
            if(i==0){
                break;
            }
            
            else if(i==1){
                
                System.out.println("-----inserir produto: ----- \n");
                
                System.out.println("\tDigite o ID:");
                id=sc.nextInt();
                
                System.out.println("\tDigite o Codigo de Barras:\n");
                CodBarras=sc.nextLine();
                
                System.out.println("\tDigite o SKU:\n");
                Sku=sc.nextLine();
                
                System.out.println("\tDigite o Nome:\n");
                nome=sc.nextLine();
                
                System.out.println("\tDigite a Descricao\n:");
                descricao=sc.nextLine();
                
                System.out.println("\tDigite a Categoria:\n");
                categoria=sc.nextLine();
                
                System.out.println("\tDigite o Fabricante:\n");
                fabricante=sc.nextLine();
                
                System.out.println("\tDigite o preco:\n");
                preco= sc.nextDouble();
                
                System.out.println("\tDigite o peso:\n");
                peso=sc.nextDouble();
                
                
                //Produto novoproduto=new Produto(id,cod);
                
//                Aluno naluno= new Aluno(matricula,nome,periodo);
//                
//                lAluno.add(naluno); // add na lista de alunos
                
            }
            
            else if(i==2){
                System.out.println("alterar produto\n");
                
            }
            else if(i==3){
                
            		System.out.println("excluir produto\n");
            	
            	
//            		Aluno aluno1= new Aluno("14521","Maria",3);
//            		Aluno aluno2= new Aluno("11452","Rubens",5);
//                 
//            		Aluno aluno3= new Aluno("125452","Marcelo",8);
//            		Aluno aluno4= new Aluno("125010","Felipe",2);
//            		
//            		//ArrayList<Aluno> alunos = new ArrayList<Aluno>();
//            		
//            		ArrayList<Aluno> alunos = new ArrayList<>();
//            		
//            		alunos.add(aluno1);
//            		alunos.add(aluno2);
//                 
//            		Turma turma1 = new Turma("3POB","PROGRAMACAO","Andre","manha",disciplina,alunos);
//            		
//            		ArrayList<Aluno> alunos2 = new ArrayList<>();
//            		
//            		alunos2.add(aluno3);
//            		alunos2.add(aluno4);
//            		
//            		Turma turma2 = new Turma("3ESD","eSTRUTURA","fERLIM","noite",disciplina2,alunos2);
//            		
//            		turma1.imprimeTurma();
//            		turma2.imprimeTurma();
            }
            else if(i==4){ // i=4
                
                 System.out.println("listar um produto");
            }
            else if(i==5){ // i=4
                
                 System.out.println("listar todos os produtos");
            }
                       
            sc.close();
        }

	}
	
	


}
