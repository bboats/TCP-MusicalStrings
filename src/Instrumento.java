package tcp_tf;

import java.io.File;
import java.util.Scanner;

public class Instrumento {
	private int tipo; //indice do instrumento no array padrao MIDI
	private int qtd_Oitavas,Oitava; //valores relacionados a oitavas
	private String nome; //nome semantico do instrumento
	private String instrumentsArray[]; // array padrao de nomes semanticos MIDI
	
	private void initializeinstrumentsArray() {
		try {
			//le o arquivo inteiro como uma grande string
			Scanner leitor = new Scanner(new File("instrumentsList"));
			String content = leitor.useDelimiter("\\Z").next();
			
			//separa em um array utilizando o \n como delimitador
			this.instrumentsArray = content.split("\\r?\\n"); //newline em UNIX e Windows
	
			//fecha o scanner
			leitor.close();
		}
		catch (Exception e) {
			System.err.format("Excecao ocorreu ao ler instrumentsList");
		    e.printStackTrace();
		}
	}	
	
	//checa se instrumento esta na lista, caso esteja retorna o indice, senao retorna 0
	private int isInstrumentInArray(String nome) {
		//testa se esse nome esta presente na lista de instrumentos disponiveis
				Boolean existe = false;
				int indexInstrumento;
				for(indexInstrumento=1; indexInstrumento<129; indexInstrumento++) {
					if(nome.equals(instrumentsArray[indexInstrumento])) {
						existe = true;
						break;
					}
				}
				
				//retorna erro caso instrumento nao esteja presente na lista
				if (existe)
					return indexInstrumento;
				else 
					return 0;		
	}
	
	//construtor com dado tipo
	public Instrumento(int tipo) {
		initializeinstrumentsArray();
		this.tipo = tipo;
		this.nome = instrumentsArray[tipo];
		//lidar com oitavas
	}
	
	//construtor com dado nome
	public Instrumento(String nome) throws Exception {
		
		initializeinstrumentsArray();
		int indiceInstrumento = isInstrumentInArray(nome);
		
		//caso o instrumento esteja presente no array, inicializa o objeto corretamente
		if(indiceInstrumento != 0) {
			this.tipo = indiceInstrumento;
			this.nome = nome;
		}	
		//caso contrario informa o usuario de que esse instrumento nao existe e retorna
		else
			throw new Exception("Instrumento "+ nome + " nao presente na biblioteca");
	}
	
	public void setTipo(int tipo) {
		this.tipo = tipo;
		this.nome = instrumentsArray[tipo];
	}
	
	
	//atualiza todos parâmetros
	int getTipo() {
		return this.tipo;
	}
	
	void setNome(String nome) throws Exception {
		int indiceInstrumento = isInstrumentInArray(nome);
		
		//caso o instrumento esteja presente no array, inicializa o objeto corretamente
		if(indiceInstrumento != 0) {
			this.tipo = indiceInstrumento;
			this.nome = nome;
		}	
		//caso contrario informa o usuario de que esse instrumento nao existe e retorna
		else
			throw new Exception("Instrumento "+ nome + " nao presente na biblioteca");
	}
	
	 //atualiza todos  parâmetros
	String getNome() {
		return this.nome;
	}
	
	int getQtd_Oitavas() {
		return this.qtd_Oitavas;
	}
	int getOitava() {
		return this.Oitava;
	}
	
	//debug? sla pode ser util depois eu so queria ver se o arquivo tava sendo lido direito
	public void displayInstrumentsArray() {
		System.out.println("Avaiable Instruments:");
		//itera string por string do array, colocando ela em "temp" a cada iteracao
		for(String temp : this.instrumentsArray)
			System.out.println(temp);
	}
	
	public static void main(String args[]) {
		try {
			//da pra usar uma string ou um numero e ele inicializa mt top
			Instrumento classe = new Instrumento("Gunshot");
			classe.displayInstrumentsArray();
		}
		catch (Exception e) {
			System.out.println("pq q deu erro para de ser burro seu corno: " + e);
			e.printStackTrace();
		}		
	}

}
