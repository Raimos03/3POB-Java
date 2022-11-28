package pacote;

public interface IMString {
	
	public String getString();
	public MString getObject();
	public void setString(String string);
	public int  contaCaractere( char c);
	public int EncontraStringVetor(  String[] vetor ,String s);
	public int validaString();
	public int validaStringData();
	public String formataStringData();
	public String validaNomeSelecao();
	public String validaNomeGrupo();
	public String Captalize(String s);

}
