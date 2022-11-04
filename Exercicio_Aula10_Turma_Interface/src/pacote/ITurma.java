package pacote;

import java.util.ArrayList;

public interface ITurma {
	
	public String getCodigo();
	public void setCodigo(String codigo);
	public String getNome();
	public void setNome(String nome);
	public String getProfessor();
	public void setProfessor(String professor);
	public String getTurno();
	public void setTurno(String turno);
	public Disciplina getDisciplina();
	public void setDisciplina(Disciplina disciplina);
	public void setAlunos(ArrayList<Aluno> alunos);
	public ArrayList<Aluno> getAlunos();
	public void imprimeTurma();
	
}
