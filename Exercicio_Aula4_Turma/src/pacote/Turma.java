/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pacote;

import java.util.ArrayList;


/**
 *
 * @author Pedro PC
 */
public class Turma {
    
    private String codigo;
    private String nome;
    private String professor;
    private String turno;
    private Disciplina disciplina;
    private ArrayList<Aluno> alunos;
   
   
    public String getCodigo(){
        
        return codigo;
    }
    
    public void setCodigo(String codigo){
        
        this.codigo=codigo;
    }
    
    public String getNome(){
        
        return nome;
    }
    
    public void setNome(String nome){
      
        this.nome=nome;
    }
    
    
    public Turma(String codigo, String nome,String professor, String turno, Disciplina disciplina, ArrayList<Aluno> lalunos){
        
    	super(); //para usar outra classe
    	// chamo para poder acessar as partes da classe pai
    	// metodos de OBJECT para metodos genericos
    	
        this.codigo=codigo; // quando o nome nao for igual nao precisa usar o .this
        this.nome=nome;
        this.professor=professor;
        this.turno=turno;
        this.alunos=lalunos;
        this.disciplina=disciplina;
        
    }
    
    public Turma(){
        
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
    
    public void setAlunos(ArrayList<Aluno> alunos) {
    	this.alunos=alunos;
    }
    
    public ArrayList<Aluno> getAlunos() {
    	return alunos;
    }
    
    public void imprimeTurma() {
    	
    	System.out.println("----Imprimindo Turma----\n");
    	System.out.println("\t Codigo:"+ getCodigo()+"\t Nome:"+ getNome()+ "\t Professor:"+getProfessor()+
    			"\t Disciplina:"+ getDisciplina().getNome());
    	
    	int i;
    	for (i=0;i<2;i++) { // pegando o tamanho do array
    		
    		System.out.printf("Aluno: %d - %s \n", i+1, ((Aluno) getAlunos().get(i)).getNome());
    		
    	}
    }
    
}
