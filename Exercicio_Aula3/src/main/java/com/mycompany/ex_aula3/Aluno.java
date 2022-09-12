/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ex_aula3;

/**
 *
 * @author Pedro PC
 */
public class Aluno {
   
    private int periodo;
    private String nome;
    private String matricula;

   
    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
   
    public Aluno(String matricula, String nome, int periodo){
        
        this.matricula=matricula;
        this.nome=nome;
        this.periodo=periodo;
    }
    
    public Aluno(){
        
    }
    
}
