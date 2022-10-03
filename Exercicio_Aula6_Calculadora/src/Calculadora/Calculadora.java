package Calculadora;

public class  Calculadora {
	
	private Pessoa pessoa;
	private double tributo=0.15 ; // o ideal ser um arquivo de configuracao para carregar esses valores
	private double taxa= 0.05;
	private double valor;
	
	public Calculadora(String nome, double valor) { //construtor

		this.pessoa= new Pessoa(nome);
		this.valor=valor;
	}
	
	public double CalculaValor() {
		return valor* (1+tributo+taxa);	
	}
	
	public void ImprimeValor() {
		System.out.println("Valor de - "+ pessoa.getNome()+ " = "+ CalculaValor());
		return;
	}
	
	public void setValor(double valor) {
		this.valor=valor;
	}
	
	public double getValor() {
		return this.valor;
	}
}
	
