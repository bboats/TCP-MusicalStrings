package tcp_tf;

public class Oitava {
	private int valor;
	private int step = 10; //valor para incremento/decremento
	private boolean isMajor;
	
	public Oitava(int valor) {
		this.valor = valor;
		this.isMajor = false;
	}
	
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public int getValor() {
		return this.valor;
	}
	
	public void increaseOitava() {
		this.valor += step;
	}
	
	public void decreaseOitava() {
		this.valor -= step;
	}
	
	public void makeMajor() {
		this.isMajor = true;
	}
	
	public void makeMinor() {
		this.isMajor = false;
	}
	
	public boolean isMajor(){
		return this.isMajor;
	}
	
}
