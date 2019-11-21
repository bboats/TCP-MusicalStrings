package tcp_tf;

import java.util.List;

import org.jfugue.player.Player;


public class Melodia {

	private String input;
	private String jfugueString;
	private Instrumento instrumentoAtual;
	private Bpm bpm; //bpm ta sendo inutil no momento
	private Volume volume;
	private Timbre timbre; //timbre n existe?
	private List<Nota> notas; //como nao temos input de tempo definidos, "nota" eh inutil tb
	
	public static final int DEFAULT_BPM = 120;
	public static final int DEFAULT_INSTRUMENT = 0;
	
	public Melodia(String input) {
		this.input = input;
		
		//inicializa os defaults
		this.bpm = new Bpm(DEFAULT_BPM);
		this.volume = new Volume();
		this.instrumentoAtual = new Instrumento(DEFAULT_INSTRUMENT);
		
		this.jfugueString = ":CON(7,31)";
		this.createJfugueString();
	}
	
	private void createJfugueString() {
		char lastChar = ' '; //pseudo magic null
		for(int i=0; i<this.input.length(); i++) {
			char currentChar = this.input.charAt(i);
			
			switch(currentChar) {
			case 'A':
				this.jfugueString += " A";
				break;
			case 'B':
				this.jfugueString += " B";
				break;
			case 'C':
				this.jfugueString += " C";
				break;
			case 'D':
				this.jfugueString += " D";
				break;
			case 'E':
				this.jfugueString += " E";
				break;
			case 'F':
				this.jfugueString += " F";
				break;
			case 'G':
				this.jfugueString += " G";
				break;
			case ' ':
				this.volume.increaseVolume();
				this.jfugueString += " :CON(7, " + String.valueOf(this.volume.getValor()) + ')';
				break;
			case '!':
				this.instrumentoAtual.setTipo(114);
				this.jfugueString += " I" + String.valueOf(instrumentoAtual.getTipo());
				break;
			case 'o':
			case 'O':
			case 'i':
			case 'I':
			case 'u':
			case 'U':
				this.instrumentoAtual.setTipo(7);
				this.jfugueString += " I" + String.valueOf(instrumentoAtual.getTipo());
				break;
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				this.instrumentoAtual.setTipo(this.instrumentoAtual.getTipo() + (int)currentChar - 48);
				this.jfugueString += " I" + String.valueOf(instrumentoAtual.getTipo());
				break;
			case '?':
			case '.':
				this.instrumentoAtual.setDefaultOitava();
				this.volume.setValorDefault();
				this.jfugueString += " :CON(7, " + String.valueOf(this.volume.getValor()) + ')';
				break;
			case '\n':
			case '\r':
				this.instrumentoAtual.setTipo(15);
				this.jfugueString += " I" + String.valueOf(instrumentoAtual.getTipo());
				break;
			case ';':
				this.instrumentoAtual.setTipo(76);
				this.jfugueString += " I" + String.valueOf(instrumentoAtual.getTipo());
				break;
			case ',':
				this.instrumentoAtual.setTipo(20);
				this.jfugueString += " I" + String.valueOf(instrumentoAtual.getTipo());
				break;
			default:
				//repete ultimo caractere caso seja nota, senao adiciona uma pausa
				if (lastChar <= 'G' && lastChar >= 'A')
					this.jfugueString += " " + lastChar;
				else
					this.jfugueString += " R";
			}
		lastChar = this.input.charAt(i); //registra ultimo caractere lido
		}
	}
	
	
	public String getJfugueString() {
		return this.jfugueString;
	}
	
	public void playMelodia() {
		Player player = new Player();
		player.play(this.jfugueString);
	}
	
	public static void main(String args[]) {
		//Melody example
		/*Melodia teste = new Melodia("CDE CDE CDE");
		teste.playMelodia();
		//Save file example
		//Exportador_Midi exp = new Exportador_Midi();
		//exp.salva_Midi(teste.getJfugueString());
		*/
	}

}
