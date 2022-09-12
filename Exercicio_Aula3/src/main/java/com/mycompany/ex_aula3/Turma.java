/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ex_aula3;


/**
 *
 * @author Pedro PC
 */
public class Turma {
    
    private String codigo;
    private String nome;
    private String professor;
    private String turno;
    private String disciplina;
   
    //private List<Aluno> lalunos = new ArrayList<>();
    
    
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
    
    
    public Turma(String codigo, String nome,String professor, String turno, String disciplina){
        
        this.codigo=codigo;
        this.nome=nome;
        this.professor=professor;
        this.turno=turno;
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

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
    
    
    
}
