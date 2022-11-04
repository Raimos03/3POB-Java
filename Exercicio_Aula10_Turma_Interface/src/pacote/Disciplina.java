/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pacote;

/**
 *
 * @author Pedro PC
 */
public class Disciplina implements IDisciplina {
    
    private String codigo;
    private String nome;
    private int periodo;

    public void setCodigo(String id) {
        this.codigo = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }
   

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getPeriodo() {
        return periodo;
    }
    
    /*public Disciplina BuscaDisciplina(String bdisciplina) {
    	
    		
    	int i =0;
    	
    	for (i=0;i<ldisciplina.len) {
    		
    		
    	}
    	
    	
    	return 
    }*/
    
    public void ExibeDisciplina() {
    	
    	System.out.printf("Codigo: %s -", this.getCodigo());
    	System.out.printf("Periodo: %s /n", this.getPeriodo());
    	
    }
    
    public Disciplina(String codigo, String nome, int periodo){
        
        this.codigo=codigo;
        this.nome=nome;
        this.periodo=periodo;
    
    }
    
    public Disciplina (){
       
    }
    
}
