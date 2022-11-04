/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pacote;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Pedro PC
 */
public class Professor implements IProfessor {
    
    private String id;
    private String nome;
    private String disciplina;
    private ArrayList<Disciplina> LDisciplinasProfessor = new ArrayList<>(); 

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
    
    public void AssociaProfessorDisciplina(Professor nprofessor, List<Disciplina> lDisciplina) {
    	/*List<Disciplina>*/
    	
    	
    	int i;
    	for (i=0;i<lDisciplina.size();i++){
    	
    		if(lDisciplina.get(i).getCodigo().equals(nprofessor.disciplina)) {
    			Disciplina newdisc = (Disciplina) lDisciplina.get(i);
    			LDisciplinasProfessor.add(newdisc);
    		}
  			
    	}	
    	
    }
    
    public void ExibeProfessor() {
    	
    	System.out.println("EXIBINDO PROFESSOR\n");
    	
    	System.out.printf("ID: %s\n", this.id);
    	System.out.printf("Nome: %s\n", this.nome);
    	System.out.printf("Ultima Disciplina: %s\n", this.disciplina);
    	
    	int i=0;
    	
    	System.out.printf("Leciona as disciplinas: \n");
    	while(i<this.LDisciplinasProfessor.size()) {  			
    		LDisciplinasProfessor.get(i).ExibeDisciplina();
    		i++;
    	}
    	
    	return;
    }
    
    public Professor(){
    	return;
    }
    
    
    public Professor(String id, String nome,String disciplina){ 
        this.id=id;
        this.nome=nome;
        this.disciplina=disciplina;    
        
        return;
    }

    
   
    
}
