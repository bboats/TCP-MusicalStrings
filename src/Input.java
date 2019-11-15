package tcp_tf;

//****************************************************
//valor de linhas eh privado precisa de metodo getter*
//****************************************************

import java.util.Scanner; //classe tratadora de inputs padrao java
import java.util.List; //Classe da estrutura de dados lista
import java.util.ArrayList; //Classe auxiliar para listas
import java.io.FileReader; // Classe que le arquivos externos
import java.io.BufferedReader; // Classe que auxilia na eficiencia de leitores de arquivos

//para testar features, serao deletados quando movidos pra suas devidas classes
//import java.awt.Desktop;
//import java.awt.event.*;
import org.jfugue.player.Player;
/*
 * import java.io.File; //classe File
 * File backupFile sera adicionado quando a interface existir e ser possivel 
 * detectar Keypresses atraves de eventos
 */
public class Input {
	private List<String> valor = new ArrayList<String>();		//valor referente à biblioteca de instrumentos
	Scanner input = new Scanner(System.in); //objeto que importa o input do usuario
	//****************
	// File backupFile;
	//****************

	private List<String> readFile(String filename)
	{
	  List<String> linhas = new ArrayList<String>();
	  try
	  {
		//BufferedReader é usado para aumentar a eficiencia da leitura do arquivo
		//Utilizando de um buffer para diminuir o custo de cada leitura feita
	    BufferedReader reader = new BufferedReader(new FileReader(filename));
	    String line;
	    while ((line = reader.readLine()) != null)
	    {
	    	linhas.add(line);
	    }
	    reader.close();
	    return linhas;
	  }
	  catch (Exception e)
	  {
	    System.err.format("Excecao ocorreu ao tentar ler '%s'.", filename);
	    e.printStackTrace();
	    return null;
	  }
	}
	
	public Input(){
		//por enquanto so le uma linha do input do usuario
		//sera alterado quando a interface existir e este input vir de uma textbox
		this.getLine(); 
	}
	
	public Input(String filename){
		//lista cada linha e as coloca em valor
		valor = this.readFile(filename);
	}
		
	//atualmente só pega todo o input como uma string devido a falta de UI
	public void getLine() {
		this.valor.add(this.input.nextLine());
	}
	
	/*
	 * 
	 * 
	 *  Adicionar getValor e pa
	 * 
	 * 
	 */
	
	public static void main(String args[]) {
		//File test
		//Input classe = new Input("arqinput");
		//Input classe = new Input();
		//System.out.println("bota algo ae");
		//classe.getLine();
		//System.out.println(classe.valor);
		Player player = new Player();
		player.play("C C G G A A G");

	}
			

}
