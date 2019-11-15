package tcp_tf;

public class Bpm {
	private int valor;
	private int step = 10; // valor de incremento/decremento
	
	public Bpm(int valor) {
		this.valor = valor;
	}
	
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public int getValor() {
		return this.valor;
	}
	
	public void increaseBpm() {
		this.valor += this.step;
	}
	
	public void decreaseBpm() {
		this.valor -= this.step;
	}	
}
