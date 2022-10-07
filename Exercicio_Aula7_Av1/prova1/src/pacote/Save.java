package pacote;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Save {
		
	
	public int SalvaArquivo(Produtos estoque) {
		
		
		String dir=System.getProperty("user.dir").concat("\\src\\");
				
		File arquivo = new File(dir,"database.txt");
		
		try {
			arquivo.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		EscreveArquivo(arquivo,estoque);	
		
		if (VerificaSalvo(arquivo)>0) {		
			return 1;
		}

		//System.out.println(arquivo);
		//System.out.println(dir);	
		return -1;
	}
	
	private void EscreveArquivo(File arquivo,Produtos estoque) {
		
		
		FileWriter fw = null;
		try {
			fw = new FileWriter(arquivo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BufferedWriter bw = new BufferedWriter(fw);
		
		int i=0;
		int max= estoque.getQtdEstoque();
		
		String header= estoque.stringHeaderEstoque();
		
		
		try {
			bw.write(header);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			bw.newLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for(i=0;i<max;i++) {
			
			Produto p= estoque.getProdutoEstoque(i);
			String sp= p.stringProduto();
			
			//System.out.println(sp);
			
			try {
				bw.write(sp);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				bw.newLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
			
		
		//fechando o buffer do arquivo
		try {
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public int VerificaSalvo(File arquivo) {
		
		if(arquivo.exists()) {
			
			return 1;
		}
		return -1;
	}
	
	public Save() {
		
		
	}
	

}
