/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.ex_aula3;

/**
 *
 * @author Pedro PC
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex_aula3 {
    
    public int cadastraAluno(){
        
        
        
        return 1;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        Disciplina disciplina = new Disciplina();
        disciplina.setCodigo("15423");
        disciplina.setPeriodo(3);
        disciplina.setNome("Pedro Henrique Lima da Silva");
        
        Disciplina disciplina2 = new Disciplina("144563","Rafael Gomes dos Santos",5);
        
        
        System.out.println(" Disciplina 1 \n");
        System.out.println(" Codigo: "+ disciplina.getCodigo());
        System.out.println(" Periodo: "+ disciplina.getPeriodo());
        System.out.println(" Nome: "+ disciplina.getNome());
        
        System.out.println(" Disciplina 2 \n");
        System.out.println(" Codigo: "+ disciplina2.getCodigo());
        System.out.println(" Periodo: "+ disciplina2.getPeriodo());
        System.out.println(" Nome: "+ disciplina2.getNome());
        
        
        List<Aluno> lAluno = new ArrayList<Aluno>();
        List<Professor> lProfessor = new ArrayList<Professor>();
        List<Turma> lTurma = new ArrayList<Turma>();
        
        
        int i=1;
        while(i!=0){
            
            Scanner sc = new Scanner(System.in);
                    
            System.out.println("Digite o comando:");
            System.out.println("\t-1 para cadastrar aluno:");
            System.out.println("\t-2 para cadastrar professor:");
            System.out.println("\t-3 para cadastrar turma:");
            System.out.println("\t-4 para cadastrar disciplina:");
            System.out.println("\t-5 para Exibir alunos:");
            System.out.println("\t-6 para Exibir professores:");
            System.out.println("\t-7 para Exibir turmas:");
            System.out.println("\t-8 para Exibir disciplina:");
            
            System.out.println("\t-0 para terminar:");
            
            i = sc.nextInt();
            
            if(i==0){
                break;
            }
            
            else if(i==1){
                
                System.out.println("----- Cadastrar Aluno: ----- \n");
                System.out.println("\tDigite o nome:");
                String nome= sc.nextLine();
                System.out.println("\tDigite a matricula:");
                String matricula=sc.nextLine();
                System.out.println("\tDigite o periodo:");
                int periodo=sc.nextInt();
                
                Aluno naluno= new Aluno(matricula,nome,periodo);
                
                lAluno.add(naluno); // add na lista de alunos
                
            }
            
            else if(i==2){
                System.out.println("Cadastrar Professor:");
                
            }
            else if(i==3){
                
                 System.out.println("Cadastrar turma:");
            }
            else if(i==4){ // i=4
                
                 System.out.println("Cadastrar Disciplina:");
            }
            else if(i==5){ // i=4
                
                 System.out.println("Cadastrar Disciplina:");
            }
            else if(i==6){ // i=4
                
                 System.out.println("Cadastrar Disciplina:");
            }
            else if(i==7){ // i=4
                
                 System.out.println("Cadastrar Disciplina:");
            }
            else if(i==8){ // i=4
                
                 System.out.println("Cadastrar Disciplina:");
            }
        }
        
    }
}
