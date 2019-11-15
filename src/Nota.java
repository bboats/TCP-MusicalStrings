package tcp_tf;

public class Nota {
	private int tempo;
	private char valor;
	private int step = 10; //valor para incrementar/decrementar
	
	public Nota(char valor) {
		this.valor = valor;
		this.tempo = 100;
	}
	
	public Nota(char valor,int tempo) {
		this.valor = valor;
		this.tempo = tempo;
	}
	
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}
	
	public int getTempo() {
		return this.tempo;
	}
	
	public void increaseTempo() {
		this.tempo += step;
	}
	
	public void decreaseTempo() {
		this.tempo -= step;
	}
	
	public void setValor(char valor) {
		this.valor = valor;
	}
	
	public char getValor() {
		return this.valor;
	}
}
